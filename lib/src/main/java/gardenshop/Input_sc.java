package gardenshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input_sc {

	static Scanner sc = new Scanner(System.in);

	public static String enterStr(String msgXuser) {
		String str = "";
		boolean isString = false;
		String regExpr = "^[0-9]+$";

		do {
			System.out.println(msgXuser);
			try {
				str = sc.nextLine();

				if(str.length() <= 1 || str.matches(regExpr) ) {
					throw new Exception();
				}
				isString = true;
			} catch(Exception e) {
				System.err.println("Format error: Do not enter only numbers or only a character");
			}
		} while(!isString);
		return str;
	}


	public static int enterInt(String msgXuser) {	
		int num = 0;
		boolean isInt = false;

		do {
			try {
				System.out.println(msgXuser);
				num = sc.nextInt();
				isInt = true;
			} catch(InputMismatchException e) {
				System.err.println("Format error: please enter a number");
			}
			sc.nextLine();
		} while(!isInt);
		return num;
	} 

	public static byte enterByte(String msgXuser) {
		byte bt = 0;
		boolean isByte = false;

		do {
			try {
				System.out.println(msgXuser);
				bt = sc.nextByte();
				isByte = true;
				return bt;
			} catch(InputMismatchException e) {
				System.err.println("Format error");
			}
			sc.nextLine();
		} while(!isByte);
		return bt;
	}

	public static double enterDouble(String msgXuser)  {
		double dbl = 0.0d;
		boolean isDouble = false;

		do {
			try {
				System.out.println(msgXuser);
				dbl = sc.nextDouble();
				isDouble = true;
			} catch(InputMismatchException e) {
				System.err.println("Format error: please enter a double (e.g. 3,4)");
			}
			sc.nextLine();
		} while(!isDouble);
		return dbl;
	}

//	public static boolean readYesNo(String msgXuser) throws Exception {
//		String entry = "";
//		char character = ' ';
//		boolean value = false;
//	
//		System.out.println(msgXuser);
//		entry = sc.nextLine();
//		character = entry.charAt(0);
//		if(character == 'y') {
//			value = true;
//		} else if(character == 'n') {
//			value = false;
//		} else {
//			throw new Exception();
//		}
//		return value;
//	}

	
	public static char readChar(String msgXuser) {
		String str = "";
		boolean isChar = false;
		char value = ' ';
		
		do {
			System.out.println(msgXuser);
			
			try {
				str = sc.nextLine();
				value = str.charAt(0);
				
				if(Character.isDigit(value) || str.length() != 1) {
					throw new Exception();
				}
				
				isChar = true;
			} catch(Exception e) {
				System.err.println("Format error: Write a character only");
			}
			
		} while(!isChar);
		
		return value;
	}
	
}
