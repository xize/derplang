package tv.mineinthebox.derplang.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tv.mineinthebox.derplang.Gui;

public class CheckBoxActionEvent implements ActionListener {

	private final Gui gui;
	
	public CheckBoxActionEvent(Gui gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//order
		if(gui.getOrderCheckBox().isSelected()) {
			gui.getOrderCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getOrderCheckBoxLabel().setForeground(Color.BLACK);
		}
		//breezah
		if(gui.getBreezahCheckBox().isSelected()) {
			gui.getBreezahCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getBreezahCheckBoxLabel().setForeground(Color.BLACK);
		}
		//caps
		if(gui.getCapsCheckBox().isSelected()) {
			gui.getCapsCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getCapsCheckBoxLabel().setForeground(Color.BLACK);
		}
		//demon
		if(gui.getDemonTalkCheckBox().isSelected()) {
			gui.getDemonTalkCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getDemonTalkCheckBoxLabel().setForeground(Color.BLACK);
		}
		//leet
		if(gui.getLeetSpeakCheckBox().isSelected()) {
			gui.getLeetSpeakCheckBoxLabel().setForeground(new Color(0x005826));
		} else {
			gui.getLeetSpeakCheckBoxLabel().setForeground(Color.BLACK);
		}
		if(gui.getAllWindowsCheckBox().isSelected()) {
			gui.getAllWindowsLabel().setForeground(new Color(0x005826));
		} else {
			gui.getAllWindowsLabel().setForeground(Color.BLACK);
		}
	}
}
