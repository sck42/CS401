//Sai Konduru

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Player
{
	//Create the user's file
	//Ask the user for Last Name, and Initial money.
	//Write this info into the user's file along with rounds played and rounds won. 
	//Close the file. 
	public static void newPlayer(String name) throws IOException
	{
		int roundsPlayed = 0; 
		int roundsWon = 0;
		double money = 0; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome New Player!");
		
		PrintWriter out = new PrintWriter(name + ".txt");
		System.out.println("Please enter your information below");
		out.println(name);
		System.out.print("Last Name:");
		out.println(sc.next());
		
		//Check that money is a positive value. 
		System.out.print("Initial money: ");
		money = sc.nextDouble();
		
		while(money < 0)
		{
			System.out.print("Initial money: ");
			money = sc.nextDouble();
		}
		
		out.println(money);
		out.println(roundsPlayed);
		out.println(roundsWon);
		out.close();

	}
	
	//Take in the initial money and winnings and return their sum. 
	public static double addMoney(double initial, double winnings) 
	{
		return initial + winnings; 
	}
	//Take in the initial money and winnings and return their difference. 
	public static double subtractMoney(double initial, double losings) 
	{
		return initial - losings; 
	}
	public static void toString(String firstName, String lastName, double money, int roundsPlayed, int roundsWon) throws IOException 
	{
		//Open the user's file. 
		//Write the Last Name, money, rounds played and rounds won into the file. 
		//Close the file. 
		PrintWriter out = new PrintWriter(firstName + ".txt");
		out.println(firstName);
		out.println(lastName);
		out.println(money);
		out.println(roundsPlayed);
		out.println(roundsWon);
		out.close();
		
		//Print out the users name, amount of money in account, rounds played and rounds won. 
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.printf("Money: $%.2f \n", money);
		System.out.println("Rounds played: " + roundsPlayed);
		System.out.println("Rounds won: " + roundsWon);
	}
}