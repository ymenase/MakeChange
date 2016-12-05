package makeChange;

import java.util.Scanner;

public class MakeChange2 {

	public static java.util.Scanner keyboard = new java.util.Scanner(System.in);

	public static float price = 0.0F;
	public static float payment = 0.0F;
	public static float change = 0.0F;

	public static void main(String[] args) {

		story();
	}

	public static void story() {
		intro();
		askHowMuch(keyboard);
		takePayment(keyboard);
		paymentType();
		givingChange(payment, price);
		restart(keyboard);
	}

	public static void intro() { // greeting the user with a sign
		System.out.println("***Welcome to the Store***");
	}

	public static void askHowMuch(Scanner keyboard) {
		System.out.println("How much does this item cost? ");
		price = keyboard.nextFloat();
		System.out.println("Looks like it costs $" + price);

	}

	public static void takePayment(Scanner keyboard) { // transaction
		System.out.println("Cashier: How much money are you giving me? ");
		payment = keyboard.nextFloat();
		System.out.println("Cashier: Thanks, you paid me $" + String.format("%.2f", payment) + ".");
		// format
	}

	public static void paymentType() {

		if (payment == price) {
			System.out.println("You provided exact change. Thanks! ");
			System.out.println("Have a great day! ");
		}
		if (payment > price) {
			System.out.println("I will be giving you change. Your change is $"
					+ Math.round((payment - price) * 100) / 100.0 + ".");

		}
		if (payment < price) {
			System.out.println("I need $" + Math.round((price - payment) * 100) / 100.0 + " more.");
		}

	}

//	public static float round(float change) {
//
//		change = (change + .005F) * 100;
//		change = (int) change;
//		change = change / 100;
//		return change;
//	}

	public static void givingChange(float payment, float price) {
		change = payment - price + 0.005f;
		int j = (int) change;
		float k = change - j;
//		System.out.println(j + k);

		if ((change / 100) >= 1) {
			System.out.println(((Math.floor(change / 100))) + " hundred dollar bill");
			change = (change % 100);
		}

		if ((change / 50) >= 1) {
			System.out.println(((Math.floor(change / 50))) + " fifty dollar bill");
			change = (change % 50);
		}
		if ((change / 20) >= 1) {
			System.out.println(((Math.floor(change / 20))) + " twenty dollar bill");
			change = (change % 20);
		}
		if ((change / 10) >= 1) {
			System.out.println(((Math.floor(change / 10))) + " ten dollar bill");
			change = (change % 10);
		}
		if ((change / 5) >= 1) {
			System.out.println(((Math.floor(change / 5))) + " five dollar bill");
			change = change % 5;
		}
		if ((change / 1) >= 1) {
			System.out.println(((Math.floor(change / 1))) + " one dollar bill");
			change = change % 1;
		}
		if ((change / .25) >= 1) {
			System.out.println(((Math.floor(change / .25))) + " quarter");
			change = change % .25F;
		}
		if ((change / .10) >= 1) {
			System.out.println(((Math.floor(change / .10))) + " dime");
			change = change % .10F;
		}
		if ((change / .05) >= 1) {
			System.out.println(((Math.floor(change / .05))) + " nickel");
			change = (change % .05F);
		}
		if ((change / .01) >= 1) {
			System.out.println(((Math.floor(change / .01))) + " penny");
			change = (change % .01F);
		}

	}

	public static void restart(Scanner keyboard) { // asking if user wants to
													// start again
		System.out.println("Would you like to make another purchase? Y/N");
		char choice = keyboard.next().charAt(0);
		switch (choice) {
		case 'Y':
		case 'y':
			story(); // restart
			break;
		case 'N':
		case 'n':
			System.out.println("Thank you for your purchase!"); 
																
			break;

		}
	}
}