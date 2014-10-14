package tv.mineinthebox.derplang.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	/**
	 * @author xize
	 * @param obj - simple serialize the object
	 * @return byte[]
	 * @throws IOException
	 */
	public byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		//GZIPOutputStream out = new GZIPOutputStream(stream);
		ObjectOutputStream objs = new ObjectOutputStream(stream);
		//compress the bytes.
		objs.writeObject(obj);
		return stream.toByteArray();
	}
	
	/**
	 * @author xize
	 * @param bytes - the object in bytes
	 * @return Object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream obj = new ObjectInputStream(in);
		return obj.readObject();
	}

}
