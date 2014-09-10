package tv.mineinthebox.derplang.utils;


public class Util {

	/**
	 * @author xize
	 * @param message - converts a normal message in a derpish message :)
	 * @return String
	 */
	public static String getDrunkMessageFrom(String message, boolean bol) {
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

	/**
	 * @author xize
	 * @param message - sets it to breezah
	 * @param bol - boolean
	 * @return String
	 */
	public static String toBreeza(String message, Boolean bol) {
		boolean posneg = bol;
		String newmsg = "";
		for(char chr : message.toCharArray()) {
			if(posneg) {
				newmsg += (""+chr).toUpperCase();
				posneg = false;
			} else {
				newmsg += (""+chr).toLowerCase();
				posneg = true;
			}
		}
		return newmsg;
	}
	
	/**
	 * @author xize
	 * @param returns the demon lang
	 * @param s - the message
	 * @return String
	 */
	public static String toDemon(String s) {
		String message = "";
		char[] chrs = s.toCharArray();
		for(int i = (chrs.length-1); i > -1; i--) {
			message += chrs[i];
		}
		return message;
	}
	
	/**
	 * @author xize
	 * @param s - the message
	 * @return convert the message into l33t
	 */
	public static String toLeet(String s) {
		String msg = "";
		for(char chr : s.toCharArray()) {
			msg += ""+convertToLeet(chr);
		}
		return msg;
	}

	private static boolean isSpace(char chr) {
		switch(chr) {
		case ' ' : return true;
		default : return false;
		}
	}

	private static boolean isLitteral(char chr) {
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

	private static char convertToLeet(char chr) {
		switch(chr) {
		case 'a': return '4';
		case 'e': return '3';
		case 'i': return '1';
		case 'o': return '0';
		case 'u': return 'u';
		case 'A': return '4';
		case 'E': return '3';
		case 'I': return '1';
		case 'O': return '0';
		case 'U': return 'U';
		default: return chr;
		}
	}

}
