package tv.mineinthebox.derplang;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tv.mineinthebox.derplang.listeners.CheckBoxActionEvent;
import tv.mineinthebox.derplang.listeners.ConvertActionEvent;
import tv.mineinthebox.derplang.listeners.CopyActionEvent;
import tv.mineinthebox.derplang.listeners.LabelBreezEvent;
import tv.mineinthebox.derplang.listeners.LabelCapsEvent;
import tv.mineinthebox.derplang.listeners.LabelDemonEvent;
import tv.mineinthebox.derplang.listeners.LabelLeetEvent;
import tv.mineinthebox.derplang.listeners.LabelOrderMouseEvent;
import tv.mineinthebox.derplang.listeners.ResetActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1523041262132767056L;

	public MainFrame(String title) {
		super(title);
		Container c = getContentPane();
		Gui gui = new Gui();
		JPanel textboxes = gui.generateTextBoxes();
		JPanel buttons = gui.generateButtons();
		JPanel moreoptions = gui.generateMoreOptions();
		JPanel brand = gui.generateBrandBox();
		c.setLayout(new BoxLayout(c, 1));
		c.add(textboxes, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.PAGE_END);
		c.add(moreoptions);
		c.add(brand);
		
		//initialize listeners
		gui.getOrderCheckBox().addActionListener(new CheckBoxActionEvent(gui));
		gui.getConvertButton().addActionListener(new ConvertActionEvent(gui));
		gui.getCopyButton().addActionListener(new CopyActionEvent(gui));
		gui.getOrderCheckBoxLabel().addMouseListener(new LabelOrderMouseEvent(gui));
		gui.getResetButton().addActionListener(new ResetActionEvent(gui));
		
		gui.getBreezahCheckBox().addActionListener(new CheckBoxActionEvent(gui));
		gui.getBreezahCheckBoxLabel().addMouseListener(new LabelBreezEvent(gui));
		
		gui.getLeetSpeakCheckBox().addActionListener(new CheckBoxActionEvent(gui));
		gui.getLeetSpeakCheckBoxLabel().addMouseListener(new LabelLeetEvent(gui));
		
		gui.getDemonTalkCheckBox().addActionListener(new CheckBoxActionEvent(gui));
		gui.getDemonTalkCheckBoxLabel().addMouseListener(new LabelDemonEvent(gui));
		
		gui.getCapsCheckBox().addActionListener(new CheckBoxActionEvent(gui));
		gui.getCapsCheckBoxLabel().addMouseListener(new LabelCapsEvent(gui));
	}
}
