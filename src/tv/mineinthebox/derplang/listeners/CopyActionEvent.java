package tv.mineinthebox.derplang.listeners;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tv.mineinthebox.derplang.Gui;

public class CopyActionEvent implements ActionListener {

	private final Gui gui;
	
	public CopyActionEvent(Gui gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection select = new StringSelection(gui.getResultField().getText());
		clip.setContents(select, select);
	}

}
