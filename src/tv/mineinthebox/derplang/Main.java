package tv.mineinthebox.derplang;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	public final static String version = "0.4a";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				JFrame frame = new MainFrame("DerpLang " + version + " - written by Xeph0re");
				frame.setSize(400, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				Image img = null;
				try {
					img = ImageIO.read(this.getClass().getResource("resources/Trollface.png"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setIconImage(img);
			}
		});
	}
}
