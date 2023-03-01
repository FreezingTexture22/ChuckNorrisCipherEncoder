package ChuckNorrisCipherEncoder;

import java.util.Scanner;

public class Stage3_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		
		System.out.println("Input string:");
		String input = in.nextLine();
		System.out.println();
		
		System.out.println("The result:");

		///

		char[] c = input.toCharArray(); // convert input to temporary char array

		for (char c2 : c) {

			String s = Integer.toBinaryString(c2); // for each array element convert to String...
			int i = Integer.parseInt(s); // ...and parse it into Integer...
			String binary = String.format("%07d", i); // ...and format it to 7 bits (add zeroes int the beginning, if
														// needed) and to String ...

			sb = sb.append(binary); // append String `binary` to StringBuilder `sb`

		}

		// converting StringBuilder to String
		String s = sb.toString();

		// creating char array `binary` and populating it with elements from String `s`
		char[] binary = s.toCharArray();

		// ENCODING

		StringBuilder zeros = new StringBuilder("");

		for (int a = 0; a < binary.length; a++) {

			if (binary[a] == '1') {
				if (a == 0) {
					zeros = zeros.append("0 0");
				} else

				if (binary[a - 1] == '1') {
					zeros = zeros.append("0");
				} else

				if (a != 0) {
					zeros = zeros.append(" 0 0");
				}

			}

			if (binary[a] == '0') {
				if (a == 0) {
					zeros = zeros.append("00 0");
				} else

				if (binary[a - 1] == '0') {
					zeros = zeros.append("0");
				} else

				if (a != 0) {
					zeros = zeros.append(" 00 0");
				}

			}

		}
		System.out.print(zeros);

	}

}
