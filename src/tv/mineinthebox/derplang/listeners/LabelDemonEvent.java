package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tv.mineinthebox.derplang.Gui;

public class LabelDemonEvent implements MouseListener {
	
	private final Gui gui;
	
	public LabelDemonEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.getDemonTalkCheckBox().setSelected(!gui.getDemonTalkCheckBox().isSelected());
		if(gui.getDemonTalkCheckBox().isSelected()) {
			gui.getDemonTalkCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getDemonTalkCheckBoxLabel().setForeground(Color.BLACK);
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
		gui.getDemonTalkCheckBoxLabel().setToolTipText("when toggled you use the filter demon based on the order filter, this convert to mirror");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gui.getDemonTalkCheckBoxLabel().setToolTipText(null);
	}

}
