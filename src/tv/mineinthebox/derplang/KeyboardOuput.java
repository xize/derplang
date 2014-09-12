package tv.mineinthebox.derplang;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class KeyboardOuput {

	private String cmd;

	/**
	 * @author xize
	 * @param creates the internal vbs file with the key what was pressed and got replaced.
	 * @param key
	 */
	public void setKey(String key) {
		this.cmd = getCMD(key);
		writeFile();
	}
	
	/**
	 * @author xize
	 * @param executes keyboard changes.
	 */
	public void executeKeyboard() {
		try {
			Runtime.getRuntime().exec("wscript derplang/wscript.vbs");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getCMD(String key) {
		String header = "Set wshShell = wscript.CreateObject(\"WScript.Shell\")\n";
		String removekey = "wshShell.sendkeys \"{BACKSPACE}\"\n";
		String keys = "wshShell.sendkeys \"" + key + "\"\n";
		String stop = "Wscript.Quit 0";
		return (header+=removekey+=keys+=stop);	
	}

	private void writeFile() {
		try {
			File dir = new File("derplang");
			if(!dir.isDirectory()) {
				dir.mkdir();
			}
			FileWriter fw = new FileWriter("derplang/wscript.vbs");
			fw.write(cmd);
			fw.close();
		} catch(IOException e) {

		}
	}
}
