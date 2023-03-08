package ChuckNorrisCipherEncoder;

import java.util.Scanner;

public class Stage5 {

	public static void main(String[] args) {
		boolean exit = false;

		do {
			System.out.println("Please input operation (encode/decode/exit):");
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();

			switch (input) {
			case "encode" -> encode();
			case "decode" -> decode();
			case "exit" -> exit = true;

			default -> System.out.println("There is no '" + input + "' operation \n");

			}
		} while (!exit);

		System.out.println("Bye!");
	}

	public static void encode() {
		Scanner in = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		System.out.println("Input string:");
		String input = in.nextLine();

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
		System.out.println("Encoded string:");
		System.out.print(zeros);
		System.out.println();
		System.out.println();
	}

	public static void decode() {

		System.out.println("Input encoded string:");
		StringBuilder binaryMessage = new StringBuilder();

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

		/// check if input contains only zeroes and spaces
		boolean containsZerosAndSpaces = true;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '0' && input.charAt(i) != ' ') {
				containsZerosAndSpaces = false;
			}
		}

		/// check if first block of each sequence is not 0 or 00;
		boolean firstBlockIsZero = true;
		if (input.charAt(0) == '0' && input.charAt(1) == '0' && input.charAt(2) != ' ') {
			firstBlockIsZero = false;

		}

		// catching ArrayIndexOutOfBoundsException if number of blocks is odd;
		try {

			if (containsZerosAndSpaces && firstBlockIsZero) {
				// splitting by zeroes
				String[] parts = input.split(" ");

				// checking pair and converting to binary code
				for (int i = 0; i < parts.length; i += 2) {
					String part1 = parts[i];
					String part2 = parts[i + 1];

					// if 0 - then next block are `1`s, if 00 - then next block are `0`s
					if (part1.equals("0")) {
						for (int j = 0; j < part2.length(); j++) {
							binaryMessage = binaryMessage.append("1");

						}
					} else if (part1.equals("00")) {
						for (int j = 0; j < part2.length(); j++) {
							binaryMessage = binaryMessage.append("0");
						}
					}

				}

				/// check if length of the decoded binary string is not a multiple of 7.
				if (binaryMessage.length() % 7 == 0) {

					System.out.println("Decoded string:");

					// splitting whole binary message to 7-char blocks
					String[] results = binaryMessage.toString().split("(?<=\\G.{" + 7 + "})");

					// converting blocks to chars ant printing them
					for (String r : results) {
						char c = (char) Integer.parseInt(r, 2);
						System.out.print(c);

					}

					System.out.println();
					System.out.println();

				} else {
					System.out.println("Encoded string is not valid. \n");
				}

			} else {
				System.out.println("Encoded string is not valid. \n");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Encoded string is not valid. \n");
		}

	}

}
