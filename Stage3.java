package ChuckNorrisCipherEncoder;

import java.util.Scanner;

// this is working not quite right, so I moved to Stage3_1 
public class Stage3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String binary2;

		System.out.println("Input string:");
		String input = in.nextLine();
		System.out.println();

		System.out.println("The result:");

		for (int i = 0; i < input.length(); i++) {

			int j = input.charAt(i); // convert char to int (A -> 65)

			String binary = Integer.toBinaryString(j); // convert integer into String (65 -> "1000001")
			int s = Integer.parseInt(binary); // parse whole string into integer ("1000001" -> 1000001)

			binary2 = String.format("%07d", s); // adding 0 into start if needed (must be 7 bits)
//			System.out.println(input.charAt(i) + binary2); // print out "char = binary" (A = 1000001)
//			System.out.println(binary2); // print out "char = binary" (A = 1000001)

			char[] array = new char[7];

			for (int a = 0; a < 7; a++) {
				array[a] = binary2.charAt(a);
			}

			// first block check
			int checkIndex = 0;
			boolean isZero = false;
			boolean isOne = false;
			StringBuilder zeros = new StringBuilder("");

			for (int a = 0; a < 7; a++) {

				if (array[a] == '1') {
					if (a == 0) {
						zeros = zeros.append("0 0");
						isOne = true;
					} else

					if (array[a - 1] == '1') {
						zeros = zeros.append("0");
						isOne = true;
					} else

					if (a != 0) {
						zeros = zeros.append(" 0 0");
						isOne = true;
					} else

					{
						zeros = zeros.append(" ");
					}

				}

				if (array[a] == '0') {
					if (a == 0) {
						zeros = zeros.append("00 0");
						isOne = true;
					} else

					if (array[a - 1] == '0') {
						zeros = zeros.append("0");
						isOne = true;
					} else

					if (a != 0) {
						zeros = zeros.append(" 00 0");
						isOne = true;
					} else

					{
						zeros = zeros.append(" ");
					}

				}

			}
			System.out.print(zeros);

		}

	}
}
