package tv.mineinthebox.derplang.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tv.mineinthebox.derplang.Gui;

public class ResetActionEvent implements ActionListener {
	
	private final Gui gui;
	
	public ResetActionEvent(Gui gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.getResultField().setText(null);
		gui.getResultField().setText("output");
		gui.getUserField().setText(null);
	}

}
