//Sai Konduru 

import java.util.Random;

public class Die
{
	public static int dieRoll()
	{
		//Create a random object. 
		Random r = new Random(); 
		
		//Roll a die twice and store their sum. 
		int firstRoll = r.nextInt(6) + 1;
		int secondRoll = r.nextInt(6)+ 1;
		int sum = firstRoll + secondRoll; 
		
		//Show user each roll and the sum. 
		System.out.println("Die1: " + firstRoll + " Die2: " + secondRoll + "-> Total: " + sum); 
		if(sum == 7)
		{
			System.out.println("...SEVEN...");
		}
		else if(sum > 7)
		{
			System.out.println("...OVER...");
		}
		else if (sum < 7)
		{
			System.out.println("...UNDER...");
		}
		return sum; 

	}
}