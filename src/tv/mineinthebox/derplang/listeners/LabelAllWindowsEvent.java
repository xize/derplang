package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tv.mineinthebox.derplang.Gui;

public class LabelAllWindowsEvent implements MouseListener {
	
	private final Gui gui;
	
	public LabelAllWindowsEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.getAllWindowsCheckBox().setSelected(!gui.getAllWindowsCheckBox().isSelected());
		if(gui.getAllWindowsCheckBox().isSelected()) {
			gui.getAllWindowsLabel().setForeground(new Color(0x005826));
		} else {
			gui.getAllWindowsLabel().setForeground(Color.BLACK);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		gui.getAllWindowsLabel().setToolTipText("when toggled you can type in every window, however this is still a experimental feature");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gui.getAllWindowsLabel().setToolTipText(null);
	}

}
