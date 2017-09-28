//Sai Konduru

import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Assig2
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		//Counters 
		int roundsPlayed = 0; 
		int roundsWon = 0; 
		
		//User entered Variables 
		double money = 0.00; 
		int numberChoice = 0; 
		double bet = 0.00; 
		int playAgain = 0; 
		double winnings = 0.00; 
		
		int sum = 0; 

		//Objects and Strings. 
		String firstName = new String();
		String lastName = new String();
		String choice = new String();
		Player user = new Player(); 
		
		//Ask for user's name 
		//Create user file object
		System.out.println("Please enter your first name");
		firstName = sc.nextLine();
	    File f = new File(firstName + ".txt");
		
		//Check if the users file exists. 
		//If file exists read it.
		//If not write the file. 
		if(f.exists())	
		{
			Scanner scn = new Scanner(f);
			System.out.println("Welcome Back " + scn.nextLine() +"!");
			
			lastName = scn.nextLine();
			System.out.println("Last Name: " + lastName);

			Double money1  = Double.valueOf(scn.nextLine());
			money = money1; 
			System.out.printf("Initial Money: $%.2f \n", money);
			
			Integer roundsPlayed1 = Integer.valueOf(scn.nextLine());
			roundsPlayed = roundsPlayed1;
			System.out.println("Rounds played: " + roundsPlayed);
	
			Integer roundsWon1 = Integer.valueOf(scn.nextLine()); 
			roundsWon = roundsWon1; 
			System.out.println("Rounds won: " + roundsWon);
		}	
		else
		{
			user.newPlayer(firstName);
			
			Scanner scn = new Scanner(f);
			firstName = scn.nextLine();
			lastName = scn.nextLine();
			
			Double money1  = Double.valueOf(scn.nextLine());
			money = money1; 
		}
		
		
		//Ask user if they want to play and store response.
		System.out.println("Would you like to play a round? (1->y / 2->n)"); 
		playAgain = sc.nextInt(); 
		
		//Keep looping until the user doesn't want to play or the user has no more money. 
		while(playAgain == 1 && money != 0)
		{
			//Ask user for a bet. 
			System.out.println("How much woud you like to bet?");
			System.out.print("$");
			bet = sc.nextDouble(); 
			
			//Check to see that bet is less than the money that user has. 
			while(bet > money || bet < 0)
			{
				System.out.println("How much woud you like to bet?");
				System.out.print("$");
				bet = sc.nextDouble(); 
			}
			
			//Ask user to select over, under, or seven. 
			System.out.println("1 -> Over, 2 -> Seven, or 3 -> Under?");
			numberChoice = sc.nextInt();
			
			//Store selected opition.
			if(numberChoice == 1 )
			{
				choice = "Over";
			}
			else if(numberChoice == 2)
			{
				choice = "Seven"; 
			}
			else if(numberChoice == 3)
			{
				choice = "Under"; 
			}
			
			//Run the Die class and store the sum returned. 
			sum = Die.dieRoll();
			
			//Check to see if the user won.
			//If they won run addMoney method and store in money and increment rounds played and rounds won. 
			//If they lose run subtractMoney method and store in money and increment rounds played. 
			if(sum < 7 && choice == "Under")
			{
				System.out.println("You have WON this round!"); 
				money = user.addMoney(money, bet);
				winnings += bet; 
				System.out.printf("You won $%.2f \n", bet);
				System.out.printf("Your updated amount is $%.2f \n", money); 
				roundsPlayed++;
				roundsWon++;
			}
			else if (sum == 7 && choice == "Seven")
			{
				System.out.println("You have WON this round!");
				money = user.addMoney(money, 4 * bet);
				winnings += 4*bet; 				
				System.out.printf("You won $%.2f \n",4*bet);
				System.out.printf("Your updated amount is $%.2f \n", money); 
				roundsPlayed++;
				roundsWon++;
			}
			else if (sum > 7 && choice == "Over")
			{
				System.out.println("You have WON this round!"); 
				money = user.addMoney(money, bet);
				winnings += bet; 
				System.out.printf("You won $%.2f \n", bet);
				System.out.printf("Your updated amount is $%.2f \n", money); 
				roundsPlayed++;
				roundsWon++;
			}
			else 
			{
				System.out.println("You have LOST this round!");
				money = user.subtractMoney(money, bet);	
				winnings -= bet; 
				System.out.printf("You lost $%.2f \n", bet);
				System.out.printf("Your updated amount is $%.2f \n", money); 
				roundsPlayed++;
			}
			
			//Keep looping until user says no. 
			System.out.println("Would you like to play a round? (1->y / 2->n)");
			playAgain = sc.nextInt(); 
		}
		
		//If user wants to quit, thank them and run the toString method.
		//Tell the user how much they earned or lost. 		
		if(playAgain == 2)
		{
			System.out.println("Thank You for playing Over and Under " + firstName);
			user.toString(firstName, lastName, money, roundsPlayed, roundsWon); 
			if(winnings > 0)
			{
				System.out.printf("You have earned $%.2f \n", winnings);
			}
			else if(winnings < 0)
			{
				System.out.printf("You have lost $%.2f \n", Math.abs(winnings));
			}
			
		}
		
		//If the user is out of money, tell them they are out of money and run the toString method. 
		//Tell the user how much they earned or lost. 
		if(money == 0)
		{
			System.out.println("Sorry you are out of money.");
			System.out.println("Thank You for playing Over and Under " + firstName);
			user.toString(firstName, lastName, money, roundsPlayed, roundsWon);
			if(winnings > 0)
			{
				System.out.printf("You have earned $%.2f \n", winnings);
			}
			else if(winnings < 0)
			{
				System.out.printf("You have lost $%.2f \n", Math.abs(winnings));
			}			
		}
	}
}