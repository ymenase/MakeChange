package makeChange;

import java.util.Scanner;

public class MakeChange3 { 
							
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
		round(price);
		givingChange(payment, price); 
		restart(keyboard);
	} 

	public static void intro() { 
		System.out.println("***Welcome to the Convienence Store***");
	}

	public static void askHowMuch(Scanner keyboard) { 
		System.out.println("How much does this item cost? ");
		price = keyboard.nextFloat();
		System.out.println("Looks like it costs $" + price);

	}

	public static void takePayment(Scanner keyboard) { 
		System.out.println("Cashier: How much money are you giving me? ");
		payment = keyboard.nextFloat();
		System.out.println("Cashier: Thanks, you paid me $" + 
				String.format("%.2f", payment) + "."); 
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

	public static float round(float price) {

		price = (price + .005F) * 100;
		price = (int) price;
		price = price / 100;
		return price;
	}

	public static void givingChange(float payment, float price) { 
		change = payment - price;
		
		float denoms[] = { 100, 50, 20, 10, 5, 1, .50F, .25F, .10F, .05F, .01F };
		String bills[][] = {{ "Hundreds", "Fifties", "Twenties", "Tens", "Fives", "Ones", "Half Dollars", "Quarters",
				"Dimes", "Nickels", "Pennies" }, { "Hundred", "Fifty", "Twenty", "Ten", "Five", "One", "Half Dollar", "Quarter", "Dimes",
				"Nickel", "Penny" }};

		int counter = 0;
		for (int i = 0; i < denoms.length; i++) {
			int prev = i; 
			if (round(denoms[i]) <= round(change)) { 
				round(change -= denoms[i]);
				i--;
			}
			if (i != prev) {
				counter++;
			} else if (counter != 0) {
				if (counter > 1) {
					System.out.println(" > " + counter + " " + bills[0][i]);
				} else {
					System.out.println(" > " + counter + " " + bills[1][i]);
				}
				counter = 0; 
			}
		}
	}


	public static void restart(Scanner keyboard) { 
													
		System.out.println("Would you like to make another purchase? Y/N");
		char choice = keyboard.next().charAt(0);
		switch (choice) {
		case 'Y':
		case 'y':
			story(); 
			break;
		case 'N':
		case 'n':
			System.out.println("Thank you for your purchase!"); 
			break;

		}
	}
}