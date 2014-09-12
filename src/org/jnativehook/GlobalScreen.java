package org.jnativehook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.event.EventListenerList;

import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.NativeSystem;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class GlobalScreen {

   private static final GlobalScreen instance = new GlobalScreen();
   private EventListenerList eventListeners = new EventListenerList();
   private ExecutorService eventExecutor;


   private GlobalScreen() {
      loadNativeLibrary();
   }

   protected void finalize() throws Throwable {
      if(isNativeHookRegistered()) {
         unloadNativeLibrary();
      }

      super.finalize();
   }

   public static GlobalScreen getInstance() {
      return instance;
   }

   public void addNativeKeyListener(NativeKeyListener var1) {
      if(var1 != null) {
         this.eventListeners.add(NativeKeyListener.class, var1);
      }

   }

   public void removeNativeKeyListener(NativeKeyListener var1) {
      if(var1 != null) {
         this.eventListeners.remove(NativeKeyListener.class, var1);
      }

   }

   public void addNativeMouseListener(NativeMouseListener var1) {
      if(var1 != null) {
         this.eventListeners.add(NativeMouseListener.class, var1);
      }

   }

   public void removeNativeMouseListener(NativeMouseListener var1) {
      if(var1 != null) {
         this.eventListeners.remove(NativeMouseListener.class, var1);
      }

   }

   public void addNativeMouseMotionListener(NativeMouseMotionListener var1) {
      if(var1 != null) {
         this.eventListeners.add(NativeMouseMotionListener.class, var1);
      }

   }

   public void removeNativeMouseMotionListener(NativeMouseMotionListener var1) {
      if(var1 != null) {
         this.eventListeners.remove(NativeMouseMotionListener.class, var1);
      }

   }

   public void addNativeMouseWheelListener(NativeMouseWheelListener var1) {
      if(var1 != null) {
         this.eventListeners.add(NativeMouseWheelListener.class, var1);
      }

   }

   public void removeNativeMouseWheelListener(NativeMouseWheelListener var1) {
      if(var1 != null) {
         this.eventListeners.remove(NativeMouseWheelListener.class, var1);
      }

   }

   public static native void registerNativeHook() throws NativeHookException;

   public static native void unregisterNativeHook();

   public static native boolean isNativeHookRegistered();

   public final void dispatchEvent(final NativeInputEvent var1) {
      this.eventExecutor.execute(new Runnable() {
         public void run() {
            if(var1 instanceof NativeKeyEvent) {
               GlobalScreen.this.processKeyEvent((NativeKeyEvent)var1);
            } else if(var1 instanceof NativeMouseWheelEvent) {
               GlobalScreen.this.processMouseWheelEvent((NativeMouseWheelEvent)var1);
            } else if(var1 instanceof NativeMouseEvent) {
               GlobalScreen.this.processMouseEvent((NativeMouseEvent)var1);
            }

         }
      });
   }

   protected void processKeyEvent(NativeKeyEvent var1) {
      int var2 = var1.getID();
      EventListener[] var3 = this.eventListeners.getListeners(NativeKeyListener.class);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         switch(var2) {
         case 2400:
            ((NativeKeyListener)var3[var4]).nativeKeyTyped(var1);
            break;
         case 2401:
            ((NativeKeyListener)var3[var4]).nativeKeyPressed(var1);
            break;
         case 2402:
            ((NativeKeyListener)var3[var4]).nativeKeyReleased(var1);
         }
      }

   }

   protected void processMouseEvent(NativeMouseEvent var1) {
      int var2 = var1.getID();
      EventListener[] var3;
      if(var2 != 2503 && var2 != 2504) {
         var3 = this.eventListeners.getListeners(NativeMouseListener.class);
      } else {
         var3 = this.eventListeners.getListeners(NativeMouseMotionListener.class);
      }

      for(int var4 = 0; var4 < var3.length; ++var4) {
         switch(var2) {
         case 2500:
            ((NativeMouseListener)var3[var4]).nativeMouseClicked(var1);
            break;
         case 2501:
            ((NativeMouseListener)var3[var4]).nativeMousePressed(var1);
            break;
         case 2502:
            ((NativeMouseListener)var3[var4]).nativeMouseReleased(var1);
            break;
         case 2503:
            ((NativeMouseMotionListener)var3[var4]).nativeMouseMoved(var1);
            break;
         case 2504:
            ((NativeMouseMotionListener)var3[var4]).nativeMouseDragged(var1);
         }
      }

   }

   protected void processMouseWheelEvent(NativeMouseWheelEvent var1) {
      EventListener[] var2 = this.eventListeners.getListeners(NativeMouseWheelListener.class);

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ((NativeMouseWheelListener)var2[var3]).nativeMouseWheelMoved(var1);
      }

   }

   protected void startEventDispatcher() {
      this.eventExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
         public Thread newThread(Runnable var1) {
            Thread var2 = new Thread(var1);
            var2.setName("JNativeHook Native Dispatch");
            return var2;
         }
      });
   }

   protected void stopEventDispatcher() {
      if(this.eventExecutor != null) {
         this.eventExecutor.shutdownNow();
         this.eventExecutor = null;
      }

   }

   @SuppressWarnings("resource")
protected static void loadNativeLibrary() {
      String var0 = "JNativeHook";

      try {
         System.loadLibrary(var0);
      } catch (UnsatisfiedLinkError var13) {
         try {
            String var2 = "/org/jnativehook/lib/" + NativeSystem.getFamily() + "/" + NativeSystem.getArchitecture() + "/";
            String var3 = System.mapLibraryName(var0);
            var3 = var3.replaceAll("\\.jnilib$", "\\.dylib");
            int var4 = var3.lastIndexOf(46);
            String var5 = var3.substring(0, var4) + '_';
            String var6 = var3.substring(var4);
            File var7 = File.createTempFile(var5, var6);
            FileOutputStream var8 = new FileOutputStream(var7);
            byte[] var9 = new byte[4096];
            InputStream var10 = GlobalScreen.class.getResourceAsStream(var2.toLowerCase() + var3);
            if(var10 == null) {
               throw new IOException("Unable to locate the native library.");
            }

            int var11;
            while((var11 = var10.read(var9)) != -1) {
               var8.write(var9, 0, var11);
            }

            var8.close();
            var10.close();
            var7.deleteOnExit();
            System.load(var7.getPath());
         } catch (IOException var12) {
            throw new RuntimeException(var12.getMessage());
         }
      }

   }

   protected static void unloadNativeLibrary() throws NativeHookException {
      unregisterNativeHook();
   }

}
