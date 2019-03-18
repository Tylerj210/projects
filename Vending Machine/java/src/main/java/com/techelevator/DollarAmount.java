package com.techelevator;

public class DollarAmount {
	public int quarters = 0;
	public int dimes = 0;
	public int nickels = 0;
	public int pennies = 0;
	
	public DollarAmount(int amount) {
		amount = amount * 100;
	}
	
	
	public DollarAmount returnDollarAmount(DollarAmount dollarValue) {
		return dollarValue;
	}
	
	public String getChange(int amountInPennies) {
		while(amountInPennies >= 25) {
			amountInPennies -= 25;
			quarters ++;
		}
		
		while(amountInPennies >= 10) {
			amountInPennies -= 10;
			dimes ++;
			
		}
		
		while(amountInPennies >= 5) {
			amountInPennies -= 5;
			nickels ++;
		}
		while(amountInPennies > 0) {
			amountInPennies -= 1;
			pennies ++;
		}
		
		System.out.println("Your change is " + quarters + " quarters, " + dimes + 
						" dimes, " + nickels + " nickels, " + pennies + " pennies.");
		return quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.";
		
	}

}
