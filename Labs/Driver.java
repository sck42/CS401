//Sai Konduru 

import java.util.Random;
import java.util.Scanner; 

public class Driver 
{
	public static void main(String [] args)
	{
		Random r = new Random();
		boolean doContinue = true; 
		Scanner sc = new Scanner(System.in);
		int rollCount = 0; 
		while(doContinue)
		{
			
			System.out.println("How many times do you want to roll the dice?");
			rollCount = sc.nextInt();
			Dice.diceRoll(rollCount, r);
			System.out.println("Would you like to continue? 1->Y/ 2->N ");
			if(sc.nextInt() == 1)
				doContinue = true; 
			else 
				doContinue = false;
		}
	}
}