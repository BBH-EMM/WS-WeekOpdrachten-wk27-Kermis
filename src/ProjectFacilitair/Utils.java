package ProjectFacilitair;

public abstract class Utils {
	public static boolean blnDebugPrint = false;

	private static int indentLevel = 0;
	private static final int tabChars = 3; 

	public static int myRandom(int min, int max) {
		return (int) (Math.random() * ((max+1)-min)+min);
	}
	
	public static void myIndentPrintln(String message, int indentation, boolean blnPrint) {

		if (indentation<0) indentLevel += indentation;
		
		if (blnPrint) System.out.println(spacePad(indentLevel*tabChars) + message);
		
		if (indentation>0) indentLevel += indentation;
	}
	
	public static int getCurrentIndentationLevel() {
		return indentLevel * tabChars;
	}
	
	private static String spacePad(int n) {
	    return (n == 0 ? "" : String.format("%"+n+"s", " "));
	}

	public static String fixedString(int n, char fillChar) {
        char[] chars = new char[n];
        while (n>0) chars[--n] = fillChar;
        return new String(chars);
	}
	public static String leftpad(String text, int length) {
	    return String.format("%" + length + "." + length + "s", text);
	}
	public static String leftpad(String text, int length, char fillChar) {
		for (int i=text.length(); i<length; i++) {
			text = fillChar + text;
		}
	    return text;
	}
	public static String rightpad(String text, int length) {
	    return String.format("%-" + length + "." + length + "s", text);
	}
	public static String rightpad(String text, int length, char fillChar) {
		for (int i=text.length(); i<length; i++) {
			text += fillChar;
		}
	    return text;
	}
	
	public static void clearConsole(){
		clearConsole(99);
	}
	public static void clearConsole(int aantalRegels){
		for (int i=0; i<aantalRegels; i++){
			System.out.println();
		}
	}
	public static void waitSeconds(int aantalSeconden){
		try {
			Thread.sleep(aantalSeconden*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void debugPrint(String message) {
		if (blnDebugPrint) System.out.print(message);
	}
	public static void debugPrintln(String message) {
		if (blnDebugPrint) System.out.println(message);
	}
	public static void debugExit() {
		if (blnDebugPrint) System.exit(0);
	}
	public static void debugExit(boolean blnDebugPrint) {
		if (blnDebugPrint) System.exit(0);
	}
}


