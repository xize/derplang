package tv.mineinthebox.derplang.listeners;

import java.awt.Color;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import tv.mineinthebox.derplang.Gui;
import tv.mineinthebox.derplang.KeyboardOuput;

public class NativeKeysEvent implements NativeKeyListener {

	private final KeyboardOuput keys = new KeyboardOuput();
	private final Gui gui;

	public NativeKeysEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(e.getKeyCode() == NativeKeyEvent.VK_F6) {
			if(gui.getAllWindowsCheckBox().isSelected()) {
				gui.getAllWindowsCheckBox().setSelected(false);
				gui.getAllWindowsLabel().setForeground(Color.BLACK);
			} else {
				gui.getAllWindowsCheckBox().setSelected(true);
				gui.getAllWindowsLabel().setForeground(new Color(0x005826));
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		if(gui.getAllWindowsCheckBox().isSelected()) {
			if(!isSpace(e.getKeyChar())) {
				if(isLitteral(e.getKeyChar())) {
					if(ignoreChar()) {
						keys.setKey("");
						keys.executeKeyboard();	
					}
				}
			}
		}
	}

	private boolean posneg = false;

	private boolean ignoreChar() {
		if(posneg) {
			posneg = false;
			return true;
		} else {
			posneg = true;
			return false;
		}
	}

	private boolean isSpace(char chr) {
		switch(chr) {
		case ' ' : return true;
		default : return false;
		}
	}

	private boolean isLitteral(char chr) {
		switch(chr) {
		case 'a': return true; 
		case 'e': return true;
		case 'i': return true;
		case 'o': return true;
		case 'u': return true;
		case 'A': return true;
		case 'E': return true;
		case 'I': return true;
		case 'O': return true;
		case 'U': return true;
		default : return false; 
		}
	}

}
