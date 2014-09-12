package tv.mineinthebox.derplang;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui {
	
	private JTextArea result;
	private JTextArea usertype;
	private JButton convert;
	private JButton reset;
	private JButton copy;
	private JCheckBox check;
	private JCheckBox allwindows;
	private JLabel allwindowslab;
	private JLabel label;
	private JLabel brand;
	
	private JCheckBox breez;
	private JLabel breezlab;
	private JCheckBox l33t;
	private JLabel l33tlab;
	private JCheckBox demontalk;
	private JLabel demonlab;
	private JCheckBox caps;
	private JLabel capslab;
	
	/**
	 * @author xize
	 * @param creates the JPanel what makes the text areas
	 * @return JPanel
	 */
	public JPanel generateTextBoxes() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		this.result = new JTextArea("output");
		this.result.setAutoscrolls(true);
		this.result.setRows(3);
		this.result.setBackground(new Color(0xe1e1e1));
		this.result.setSize(Frame.WIDTH, 20);
		this.result.setLineWrap(true);
		this.result.setEditable(false);
		this.usertype = new JTextArea("type here your text for conversion ;-)");
		this.usertype.setRows(3);
		this.usertype.setAutoscrolls(true);
		this.usertype.setSize(Frame.WIDTH, 200);
		this.usertype.setLineWrap(true);
		p1.add(result);
		p1.add(usertype);
		return p1;
	}
	
	/**
	 * @author xize
	 * @param returns the JPanel what makes the buttons
	 * @return JPanel
	 */
	public JPanel generateButtons() {
		JPanel p2 = new JPanel();
		this.convert = new JButton("convert");
		this.reset = new JButton("reset");
		this.copy = new JButton("copy");
		this.check = new JCheckBox();
		this.label = new JLabel("change order");
		this.allwindows = new JCheckBox();
		this.allwindowslab = new JLabel("in all windows? (F6)");
		p2.add(convert);
		p2.add(reset);
		p2.add(copy);
		p2.add(check);
		p2.add(label);
		p2.add(allwindows);
		p2.add(allwindowslab);
		return p2;
	}
	
	/**
	 * @author xize
	 * @param returns the other checkboxes.
	 * @return JPanel
	 */
	public JPanel generateMoreOptions() {
		JPanel p = new JPanel();
		this.breez = new JCheckBox();
		this.breezlab = new JLabel("toggle bReEzAh");
		this.l33t = new JCheckBox();
		this.l33tlab = new JLabel("toggle l33t sp34k");
		this.demontalk = new JCheckBox();
		this.demonlab = new JLabel("toggle demon talk");
		this.caps = new JCheckBox();
		this.capslab = new JLabel("toggle caps");
		p.add(breez);
		p.add(breezlab);
		p.add(l33t);
		p.add(l33tlab);
		p.add(demontalk);
		p.add(demonlab);
		p.add(caps);
		p.add(capslab);
		return p;
	}
	
	/**
	 * @author xize
	 * @param returns the JPanel what returns the brand
	 * @return JPanel
	 */
	public JPanel generateBrandBox() {
		JPanel p3 = new JPanel();
		this.brand = new JLabel("© DerpLang " + Main.version + " made by Xeph0re from mitb.tv 2014 - 2015");
		this.brand.setForeground(new Color(0xacacac));
		p3.add(brand);
		return p3;
	}
	
	/**
	 * @author xize
	 * @param returns the result text area
	 * @return JTextArea
	 */
	public JTextArea getResultField() {
		return result;
	}
	
	/**
	 * @author xize
	 * @param returns the text area where the user types in
	 * @return JTextArea
	 */
	public JTextArea getUserField() {
		return usertype;
	}
	
	/**
	 * @author xize
	 * @param returns the convert button
	 * @return JPanel
	 */
	public JButton getConvertButton() {
		return convert;
	}
	
	/**
	 * @author xize
	 * @param returns the reset button
	 * @return JButton
	 */
	public JButton getResetButton()  {
		return reset;
	}
	
	/**
	 * @author xize
	 * @param returns the copy button
	 * @return JButton
	 */
	public JButton getCopyButton() {
		return copy;
	}
	
	/**
	 * @author xize
	 * @param returns the checkbox
	 * @return JCheckbox
	 */
	public JCheckBox getOrderCheckBox() {
		return check;
	}
	
	/**
	 * @author xize
	 * @param returns the checkbox label, allowing a user to interact with the label and checkbox.
	 * @return JLabel
	 */
	public JLabel getOrderCheckBoxLabel() {
		return label;
	}
	
	/**
	 * @author xize
	 * @param returns the breezah checkbox
	 * @return JCheckBox
	 */
	public JCheckBox getBreezahCheckBox() {
		return breez;
	}
	
	/**
	 * @author xize
	 * @param returns the breezah checkbox label
	 * @return JLabel
	 */
	public JLabel getBreezahCheckBoxLabel() {
		return breezlab;
	}
	
	/**
	 * @author xize
	 * @param returns the leet speak checkbox
	 * @return JChecBox
	 */
	public JCheckBox getLeetSpeakCheckBox() {
		return l33t;
	}
	
	/**
	 * @author xize
	 * @param returns the leet speak checkbox label
	 * @return JLabel
	 */
	public JLabel getLeetSpeakCheckBoxLabel() {
		return l33tlab;
	}
	
	/**
	 * @author xize
	 * @param returns the demon talk checkbox
	 * @return JCheckBox
	 */
	public JCheckBox getDemonTalkCheckBox() {
		return demontalk;
	}
	
	/**
	 * @author xize
	 * @param returns the demontalk checkbox label
	 * @return JLabel
	 */
	public JLabel getDemonTalkCheckBoxLabel() {
		return demonlab;
	}
	
	/**
	 * @author xize
	 * @param returns the JCheckbox for caps
	 * @return JCheckBox
	 */
	public JCheckBox getCapsCheckBox() {
		return caps;
	}
	
	/**
	 * @author xize
	 * @param returns the caps checkbox label
	 * @return JLabel
	 */
	public JLabel getCapsCheckBoxLabel() {
		return capslab;
	}
	
	/**
	 * @author xize
	 * @param returns the all windows checkbox
	 * @return JCheckBox
	 */
	public JCheckBox getAllWindowsCheckBox() {
		return allwindows;
	}
	
	/**
	 * @author xize
	 * @param returns the label for the all windows
	 * @return JLabel
	 */
	public JLabel getAllWindowsLabel() {
		return allwindowslab;
	}
}
