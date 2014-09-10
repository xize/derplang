package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tv.mineinthebox.derplang.Gui;

public class LabelLeetEvent implements MouseListener {
	
	private final Gui gui;
	
	public LabelLeetEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.getLeetSpeakCheckBox().setSelected(!gui.getLeetSpeakCheckBox().isSelected());
		if(gui.getLeetSpeakCheckBox().isSelected()) {
			gui.getLeetSpeakCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getLeetSpeakCheckBoxLabel().setForeground(Color.BLACK);
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
		gui.getLeetSpeakCheckBoxLabel().setToolTipText("when toggled you use the filter l33t based on the order filter");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gui.getLeetSpeakCheckBoxLabel().setToolTipText(null);
	}

}
