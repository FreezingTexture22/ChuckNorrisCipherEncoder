package ChuckNorrisCipherEncoder;

import java.util.Scanner;

public class Stage1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input string:");
		String input = in.nextLine();
		System.out.println();
		
		char[] array = new char[input.length()];
		
		for(int i = 0; i < input.length(); i++) {
			array[i] = input.charAt(i);
			System.out.print(array[i] + " ");
		}
		
		
		
	}
}
