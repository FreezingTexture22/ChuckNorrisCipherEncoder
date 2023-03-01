package ChuckNorrisCipherEncoder;

import java.util.Scanner;

public class Stage2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Input string:");
		String input = in.nextLine();
		System.out.println();

		char[] array = new char[input.length()];

		System.out.println("The result:");

		for (int i = 0; i < input.length(); i++) {
			array[i] = input.charAt(i);
			int j = array[i];
			String binary = Integer.toBinaryString(j);
			int s = Integer.parseInt(binary);

			String binary2 = String.format(" = %07d", s);
			System.out.println(array[i] + binary2);

		}

	}
}
