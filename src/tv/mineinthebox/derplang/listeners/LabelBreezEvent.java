package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tv.mineinthebox.derplang.Gui;

public class LabelBreezEvent implements MouseListener {
	
	private final Gui gui;
	
	public LabelBreezEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.getBreezahCheckBox().setSelected(!gui.getBreezahCheckBox().isSelected());
		if(gui.getBreezahCheckBox().isSelected()) {
			gui.getBreezahCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getBreezahCheckBoxLabel().setForeground(Color.BLACK);
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
		gui.getBreezahCheckBoxLabel().setToolTipText("when toggled you use the filter BrEeZaH based on the order filter");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gui.getBreezahCheckBoxLabel().setToolTipText(null);
		
	}

}
