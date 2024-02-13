package com.Cosmoslots.pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MDBScheduller {

	public static int incre = 0;

	public static String currentdatetime(int inc) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime newDateTime = currentDateTime.plusMinutes(inc);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedDatetime = newDateTime.format(formatter);
		System.out.println("New Date  (after adding 5 minutes): " + formattedDatetime);
		return formattedDatetime;
	}

	public static String adjustTime(String time) {
		if (time.length() < 4) {
			while (time.length() < 4) {
				time = "0" + time;
			}
		}
		return time;
	}

	public static int extractLastDigit(String input) {
		if (input.length() > 0 && Character.isDigit(input.charAt(input.length() - 1))) {
			return Character.getNumericValue(input.charAt(input.length() - 1));
		}
		return -1; // Return -1 for invalid input.
	}

	public static int lasttwo(String lasttw) {
		int lastTwoDigits = Integer.valueOf(lasttw) % 100;
		System.out.println("last two digfit - " + lastTwoDigits);
		return lastTwoDigits;

	}

//	public static int mapDigitToValue(int lastDigit) {
//		switch (lastDigit) {
//		case 1:
//			incre = 4;
//			return incre;
//		case 2:
//			incre = 3;
//			return incre;
//		case 3:
//			incre = 2;
//			return incre;
//		case 4:
//			incre = 1;
//			return incre;
//		case 6:
//			incre = 4;
//			return incre;
//		case 7:
//			incre = 3;
//			return incre;
//		case 8:
//			incre = 2;
//			return incre;
//		case 9:
//			incre = 1;
//			return incre;
//		default:
//			incre = 0;
//			return incre; // Return 0 for unrecognized digits.
//		}
//	}

	public static int addmoreTime(int lastDigit) {
		switch (lastDigit) {
		case 1:
			incre = 14;
			return incre;
		case 2:
			incre = 13;
			return incre;
		case 3:
			incre = 12;
			return incre;
		case 4:
			incre = 11;
			return incre;
		case 5:
			incre = 10;
			return incre;
		case 6:
			incre = 9;
			return incre;
		case 7:
			incre = 8;
			return incre;
		case 8:
			incre = 7;
			return incre;
		case 9:
			incre = 6;
			return incre;
		case 10:
			incre = 5;
			return incre;
		case 11:
			incre = 4;
			return incre;
		case 12:
			incre = 3;
			return incre;
		case 13:
			incre = 2;
			return incre;
		case 14:
			incre = 1;
			return incre;

		case 15:
			incre = 0;
			return incre;

		case 16:
			incre = 14;
			return incre;
		case 17:
			incre = 13;
			return incre;
		case 18:
			incre = 12;
			return incre;
		case 19:
			incre = 11;
			return incre;
		case 20:
			incre = 10;
			return incre;
		case 21:
			incre = 9;
			return incre;
		case 22:
			incre = 8;
			return incre;
		case 23:
			incre = 7;
			return incre;
		case 24:
			incre = 6;
			return incre;
		case 25:
			incre = 5;
			return incre;
		case 26:
			incre = 4;
			return incre;
		case 27:
			incre = 3;
			return incre;
		case 28:
			incre = 2;
			return incre;
		case 29:
			incre = 1;
			return incre;

		case 30:
			incre = 0;
			return incre;

		case 31:
			incre = 14;
			return incre;
		case 32:
			incre = 13;
			return incre;
		case 33:
			incre = 12;
			return incre;
		case 34:
			incre = 11;
			return incre;
		case 35:
			incre = 10;
			return incre;
		case 36:
			incre = 9;
			return incre;
		case 37:
			incre = 8;
			return incre;
		case 38:
			incre = 7;
			return incre;
		case 39:
			incre = 6;
			return incre;
		case 40:
			incre = 5;
			return incre;
		case 41:
			incre = 4;
			return incre;
		case 42:
			incre = 3;
			return incre;
		case 43:
			incre = 2;
			return incre;
		case 44:
			incre = 1;
			return incre;

		case 45:
			incre = 0;
			return incre;

		case 46:
			incre = 14;
			return incre;
		case 47:
			incre = 13;
			return incre;
		case 48:
			incre = 12;
			return incre;
		case 49:
			incre = 11;
			return incre;
		case 50:
			incre = 10;
			return incre;
		case 51:
			incre = 9;
			return incre;
		case 52:
			incre = 8;
			return incre;
		case 53:
			incre = 7;
			return incre;
		case 54:
			incre = 6;
			return incre;
		case 55:
			incre = 5;
			return incre;
		case 56:
			incre = 4;
			return incre;
		case 57:
			incre = 3;
			return incre;
		case 58:
			incre = 2;
			return incre;
		case 59:
			incre = 1;
			return incre;

		default:
			incre = 0;
			return incre; // Return 0 for unrecognized digits.
		}
	}

}
