package ChuckNorrisCipherEncoder;

import java.util.Scanner;

public class Stage4 {

	public static void main(String[] args) {
		System.out.println("Input encoded string:");
		StringBuilder binaryMessage = new StringBuilder();

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

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

		System.out.println("The result:");

		// splitting whole binary message to 7-char blocks
		String[] results = binaryMessage.toString().split("(?<=\\G.{" + 7 + "})");

		// converting blocks to chars ant printing them
		for (String r : results) {
			char c = (char) Integer.parseInt(r, 2);
			System.out.print(c);

		}

	}

}
