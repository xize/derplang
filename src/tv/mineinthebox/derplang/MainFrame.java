package tv.mineinthebox.derplang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1523041262132767056L;

	public MainFrame(String title) {
		super(title);

		Container c = getContentPane();

		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		final JTextArea result = new JTextArea("output");
		result.setAutoscrolls(true);
		result.setRows(3);
		result.setBackground(new Color(0xe1e1e1));
		result.setSize(Frame.WIDTH, 200);
		result.setLineWrap(true);
		result.setEditable(false);
		final JTextArea usertype = new JTextArea("type here your text for conversion ;-)");
		usertype.setRows(3);
		usertype.setAutoscrolls(true);
		usertype.setSize(Frame.WIDTH, 200);
		usertype.setLineWrap(true);
		p1.add(result);
		p1.add(usertype);

		JPanel p2 = new JPanel();
		JButton convert = new JButton("convert");
		JButton reset = new JButton("reset");
		JButton copy = new JButton("copy");
		final JCheckBox check = new JCheckBox();
		final JLabel label = new JLabel("change order");
		p2.add(convert);
		p2.add(reset);
		p2.add(copy);
		p2.add(check);
		p2.add(label);

		JPanel p3 = new JPanel();
		JLabel label2 = new JLabel("© DerpLang " + Main.version + " made by Xeph0re from mitb.tv 2014 - 2015");
		label2.setForeground(new Color(0xacacac));
		p3.add(label2);

		c.setLayout(new BoxLayout(c, 1));
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.PAGE_END);
		c.add(p3);
		//pack();
		//setVisible(true);

		convert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(usertype.getText().isEmpty()) {
					result.setText("output");
					return;
				}
				String s = getDrunkMessageFrom(usertype.getText(), check.isSelected());
				result.setText(null);
				result.insert(s, 0);
			}

		});
		
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection select = new StringSelection(result.getText());
				clip.setContents(select, select);
			}
			
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(null);
				result.setText("output");
				usertype.setText(null);
			}

		});

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(check.isSelected()) {
					label.setForeground(new Color(0x005826));
				} else {
					label.setForeground(Color.BLACK);
				}
			}

		});

		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				check.setSelected(!check.isSelected());
				if(check.isSelected()) {
					label.setForeground(new Color(0x005826));
				} else {
					label.setForeground(Color.BLACK);
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
				label.setToolTipText("when toggled the ordering chance from Appl to pple.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setToolTipText(null);
			}

		});
	}

	/**
	 * @author xize
	 * @param message - converts a normal message in a derpish message :)
	 * @return String
	 */
	public String getDrunkMessageFrom(String message, boolean bol) {
		boolean posneg = bol;
		boolean isSpace = false;
		String newmsg = "";
		for(char chr : message.toCharArray()) {
			if(isLitteral(chr)) {
				if(posneg) {
					//don't add chr, only make sure the next char will be accepted.
					posneg = false;
				} else {
					newmsg += chr;
					posneg = true;
				}
			} else {
				if(isSpace) {
					if(!isSpace(chr)) {
						isSpace = false;
						newmsg += chr;
					}
				} else {
					if(isSpace(chr)) {
						isSpace = true;
						newmsg += chr;
					} else {
						newmsg += chr;
						isSpace = false;
					}
				}
			}
		}
		return newmsg;
	}

	private boolean isSpace(char chr) {
		switch(chr) {
		case ' ' : return true;
		default : return false;
		}
	}

	private boolean isLitteral(char chr) {
		switch(chr) {
		case 'a': return true; 
		case 'e': return true;
		case 'i': return true;
		case 'o': return true;
		case 'u': return true;
		case 'A': return true;
		case 'E': return true;
		case 'I': return true;
		case 'O': return true;
		case 'U': return true;
		default : return false; 
		}
	}
}
