package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tv.mineinthebox.derplang.Gui;

public class LabelOrderMouseEvent implements MouseListener {

	private final Gui gui;
	
	public LabelOrderMouseEvent(Gui gui) {
		this.gui = gui;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		gui.getOrderCheckBox().setSelected(!gui.getOrderCheckBox().isSelected());
		if(gui.getOrderCheckBox().isSelected()) {
			gui.getOrderCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getOrderCheckBoxLabel().setForeground(Color.BLACK);
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
		gui.getOrderCheckBoxLabel().setToolTipText("when toggled the ordering chance from Appl to pple.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gui.getOrderCheckBoxLabel().setToolTipText(null);
	}

}
