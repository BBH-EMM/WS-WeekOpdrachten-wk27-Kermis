package ProjectFacilitair;

import java.util.Scanner;

public final class UserInput {
	private static Scanner sc = new Scanner(System.in);
	
	UserInput(){
		//Constructor: for now nothing to do
		//class is designed to be used static
	}
	public static String getUserInputString(String message){
//		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	public static int getUserInputInt(String message){
//		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}
	public static char getUserInputChar(String message){
//		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine().toUpperCase().charAt(0);
	}
	public static void pressAnyKeyToContinue() { 
		System.out.println();
		System.out.println("Press [ENTER] key to continue...");
//		try
//		{
//			System.in.read();
//		}  
//		catch(Exception e)
//		{}  
		sc.nextLine();
	}
}
