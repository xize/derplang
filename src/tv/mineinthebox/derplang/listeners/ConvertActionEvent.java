package tv.mineinthebox.derplang.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tv.mineinthebox.derplang.Gui;
import tv.mineinthebox.derplang.utils.Util;

public class ConvertActionEvent implements ActionListener {

	private final Gui gui;
	
	public ConvertActionEvent(Gui gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gui.getUserField().getText().isEmpty()) {
			gui.getResultField().setText("output");
			return;
		}
		String s = Util.getDrunkMessageFrom(gui.getUserField().getText(), gui.getOrderCheckBox().isSelected());	
		if(gui.getBreezahCheckBox().isSelected()) {
			s = Util.toBreeza(s, gui.getOrderCheckBox().isSelected());
		}
		if(gui.getLeetSpeakCheckBox().isSelected()) {
			s = Util.toLeet(s);
		}
		if(gui.getDemonTalkCheckBox().isSelected()) {
			s = Util.toDemon(s);
		}
		if(gui.getCapsCheckBox().isSelected()) {
			s = s.toUpperCase();
		}
		gui.getResultField().setText(null);
		gui.getResultField().insert(s, 0);
	}

}
