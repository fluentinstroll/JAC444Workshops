package w3task1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowTriangle {

	static Scanner input = new Scanner(System.in);
	public static boolean loop = false;
	public static double s1;
	public static double s2;
	public static double s3;
	public static String colour;
	public static String choice;
	public static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {
		System.out.println("Testing the creation of a triangle...");
		loop = true;
		do {
			try {
				System.out.print("Please enter side 1: ");
				s1 = input.nextDouble();
				System.out.print("side 2: ");
				s2 = input.nextDouble();
				System.out.print("side 3: ");
				s3 = input.nextDouble();
				loop = false;
			} catch (InputMismatchException e) {
				System.out.println(
						"You have entered something that is not a double integer. Please enter a double integer that can be used as a side of the triangle.");
				input.nextLine();
			}
		} while (loop);

		loop = true;
		do {
			try {
				System.out.print("Triangle colour: ");
				colour = input.next();
				loop = false;
			} catch (InputMismatchException e) {
				System.out.println(
						"You have entered something that is not a String. Please enter a string indicating the colour of the triangle.");
				input.nextLine();
			}
		} while (loop);

		boolean filled = false;
		loop = true;
		do {
			System.out.print("Is the triangle filled(y/n)? ");
			choice = input.next();
			if (choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes")) {
				filled = true;
				loop = false;
			} else if (choice.equals("n") || choice.equals("N") || choice.equals("No") || choice.equals("no")) {
				filled = false;
				loop = false;
			} else {
				System.out.println("Please enter either y or n for your answer");
				input.nextLine();
			}
		} while (loop);

		Triangle t1 = null;
		t1 = new Triangle(s1, s2, s3, colour, filled);

		System.out.println(t1.toString());
		System.out.println("Triangle color: " + t1.getColor());
		System.out.println("Triangle filled: " + t1.isFilled());
		System.out.println("Area: " + df.format(t1.getArea()));
		System.out.println("Perimeter: " + t1.getPerimeter());
	}

}
