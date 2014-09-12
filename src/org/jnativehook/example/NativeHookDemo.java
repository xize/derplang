package org.jnativehook.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class NativeHookDemo extends JFrame implements ActionListener, ItemListener, NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener {

   private static final long serialVersionUID = 1865350670081087993L;
   private JMenu menuSubListeners;
   private JMenuItem menuItemQuit;
   private JMenuItem menuItemClear;
   private JCheckBoxMenuItem menuItemEnable;
   private JCheckBoxMenuItem menuItemKeyboardEvents;
   private JCheckBoxMenuItem menuItemButtonEvents;
   private JCheckBoxMenuItem menuItemMotionEvents;
   private JCheckBoxMenuItem menuItemWheelEvents;
   private JTextArea txtEventInfo;


   public NativeHookDemo() {
      this.setTitle("JNativeHook Demo");
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(2);
      this.setSize(600, 300);
      this.addWindowListener(this);
      JMenuBar var1 = new JMenuBar();
      JMenu var2 = new JMenu("File");
      var2.setMnemonic(70);
      var1.add(var2);
      this.menuItemQuit = new JMenuItem("Quit", 81);
      this.menuItemQuit.addActionListener(this);
      this.menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(115, 8));
      this.menuItemQuit.getAccessibleContext().setAccessibleDescription("Exit the program");
      var2.add(this.menuItemQuit);
      JMenu var3 = new JMenu("View");
      var3.setMnemonic(86);
      var1.add(var3);
      this.menuItemClear = new JMenuItem("Clear", 67);
      this.menuItemClear.addActionListener(this);
      this.menuItemClear.setAccelerator(KeyStroke.getKeyStroke(67, 3));
      this.menuItemClear.getAccessibleContext().setAccessibleDescription("Clear the screen");
      var3.add(this.menuItemClear);
      var3.addSeparator();
      this.menuItemEnable = new JCheckBoxMenuItem("Enable Native Hook");
      this.menuItemEnable.addItemListener(this);
      this.menuItemEnable.setMnemonic(72);
      this.menuItemEnable.setAccelerator(KeyStroke.getKeyStroke(72, 3));
      var3.add(this.menuItemEnable);
      this.menuSubListeners = new JMenu("Listeners");
      this.menuSubListeners.setMnemonic(76);
      var3.add(this.menuSubListeners);
      this.menuItemKeyboardEvents = new JCheckBoxMenuItem("Keyboard Events");
      this.menuItemKeyboardEvents.addItemListener(this);
      this.menuItemKeyboardEvents.setMnemonic(75);
      this.menuItemKeyboardEvents.setAccelerator(KeyStroke.getKeyStroke(75, 3));
      this.menuSubListeners.add(this.menuItemKeyboardEvents);
      this.menuItemButtonEvents = new JCheckBoxMenuItem("Button Events");
      this.menuItemButtonEvents.addItemListener(this);
      this.menuItemButtonEvents.setMnemonic(66);
      this.menuItemButtonEvents.setAccelerator(KeyStroke.getKeyStroke(66, 3));
      this.menuSubListeners.add(this.menuItemButtonEvents);
      this.menuItemMotionEvents = new JCheckBoxMenuItem("Motion Events");
      this.menuItemMotionEvents.addItemListener(this);
      this.menuItemMotionEvents.setMnemonic(77);
      this.menuItemMotionEvents.setAccelerator(KeyStroke.getKeyStroke(77, 3));
      this.menuSubListeners.add(this.menuItemMotionEvents);
      this.menuItemWheelEvents = new JCheckBoxMenuItem("Wheel Events");
      this.menuItemWheelEvents.addItemListener(this);
      this.menuItemWheelEvents.setMnemonic(87);
      this.menuItemWheelEvents.setAccelerator(KeyStroke.getKeyStroke(87, 3));
      this.menuSubListeners.add(this.menuItemWheelEvents);
      this.setJMenuBar(var1);
      this.txtEventInfo = new JTextArea();
      this.txtEventInfo.setEditable(false);
      this.txtEventInfo.setBackground(new Color(255, 255, 255));
      this.txtEventInfo.setForeground(new Color(0, 0, 0));
      this.txtEventInfo.setText("");
      JScrollPane var4 = new JScrollPane(this.txtEventInfo);
      var4.setPreferredSize(new Dimension(375, 125));
      this.add(var4, "Center");
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == this.menuItemQuit) {
         this.dispose();
      } else if(var1.getSource() == this.menuItemClear) {
         this.txtEventInfo.setText("");
      }

   }

   public void itemStateChanged(ItemEvent var1) {
      ItemSelectable var2 = var1.getItemSelectable();
      if(var2 == this.menuItemEnable) {
         if(var1.getStateChange() == 1) {
            try {
               GlobalScreen.registerNativeHook();
            } catch (NativeHookException var4) {
               this.txtEventInfo.append("\nError: " + var4.toString());
            }
         } else {
            GlobalScreen.unregisterNativeHook();
         }

         this.menuSubListeners.setEnabled(GlobalScreen.isNativeHookRegistered());
      } else if(var2 == this.menuItemKeyboardEvents) {
         if(var1.getStateChange() == 1) {
            GlobalScreen.getInstance().addNativeKeyListener(this);
         } else {
            GlobalScreen.getInstance().removeNativeKeyListener(this);
         }
      } else if(var2 == this.menuItemButtonEvents) {
         if(var1.getStateChange() == 1) {
            GlobalScreen.getInstance().addNativeMouseListener(this);
         } else {
            GlobalScreen.getInstance().removeNativeMouseListener(this);
         }
      } else if(var2 == this.menuItemMotionEvents) {
         if(var1.getStateChange() == 1) {
            GlobalScreen.getInstance().addNativeMouseMotionListener(this);
         } else {
            GlobalScreen.getInstance().removeNativeMouseMotionListener(this);
         }
      } else if(var2 == this.menuItemWheelEvents) {
         if(var1.getStateChange() == 1) {
            GlobalScreen.getInstance().addNativeMouseWheelListener(this);
         } else {
            GlobalScreen.getInstance().removeNativeMouseWheelListener(this);
         }
      }

   }

   public void nativeKeyPressed(NativeKeyEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeKeyReleased(NativeKeyEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeKeyTyped(NativeKeyEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMouseClicked(NativeMouseEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMousePressed(NativeMouseEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMouseReleased(NativeMouseEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMouseMoved(NativeMouseEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMouseDragged(NativeMouseEvent var1) {
      this.displayEventInfo(var1);
   }

   public void nativeMouseWheelMoved(NativeMouseWheelEvent var1) {
      this.displayEventInfo(var1);
   }

   private void displayEventInfo(final NativeInputEvent var1) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            NativeHookDemo.this.txtEventInfo.append("\n" + var1.paramString());

            try {
               if(NativeHookDemo.this.txtEventInfo.getLineCount() > 100) {
                  NativeHookDemo.this.txtEventInfo.replaceRange("", 0, NativeHookDemo.this.txtEventInfo.getLineEndOffset(NativeHookDemo.this.txtEventInfo.getLineCount() - 1 - 100));
               }

               NativeHookDemo.this.txtEventInfo.setCaretPosition(NativeHookDemo.this.txtEventInfo.getLineStartOffset(NativeHookDemo.this.txtEventInfo.getLineCount() - 1));
            } catch (BadLocationException var2) {
               NativeHookDemo.this.txtEventInfo.setCaretPosition(NativeHookDemo.this.txtEventInfo.getDocument().getLength());
            }

         }
      });
   }

   public void windowActivated(WindowEvent var1) {}

   public void windowClosing(WindowEvent var1) {}

   public void windowDeactivated(WindowEvent var1) {}

   public void windowDeiconified(WindowEvent var1) {}

   public void windowIconified(WindowEvent var1) {}

   public void windowOpened(WindowEvent var1) {
      this.requestFocusInWindow();
      this.menuItemEnable.setSelected(true);
      this.txtEventInfo.setText("Auto Repeat Rate: " + System.getProperty("jnativehook.autoRepeatRate"));
      this.txtEventInfo.append("\nAuto Repeat Delay: " + System.getProperty("jnativehook.autoRepeatDelay"));
      this.txtEventInfo.append("\nDouble Click Time: " + System.getProperty("jnativehook.multiClickInterval"));
      this.txtEventInfo.append("\nPointer Sensitivity: " + System.getProperty("jnativehook.pointerSensitivity"));
      this.txtEventInfo.append("\nPointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointerAccelerationMultiplier"));
      this.txtEventInfo.append("\nPointer Acceleration Threshold: " + System.getProperty("jnativehook.pointerAccelerationThreshold"));

      try {
         this.txtEventInfo.setCaretPosition(this.txtEventInfo.getLineStartOffset(this.txtEventInfo.getLineCount() - 1));
      } catch (BadLocationException var3) {
         this.txtEventInfo.setCaretPosition(this.txtEventInfo.getDocument().getLength());
      }

      this.menuItemKeyboardEvents.setSelected(true);
      this.menuItemButtonEvents.setSelected(true);
      this.menuItemMotionEvents.setSelected(true);
      this.menuItemWheelEvents.setSelected(true);
   }

   public void windowClosed(WindowEvent var1) {
      GlobalScreen.unregisterNativeHook();
      System.runFinalization();
      System.exit(0);
   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new NativeHookDemo();
         }
      });
   }
}
