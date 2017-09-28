//Sai Konduru 

import java.util.Random;

public class Dice
{
	public static void diceRoll(int rollCount, Random r)
	{
		int[] counters = new int[13];
		int temp = rollCount;
		while(rollCount != 0)
		{
			int firstDie = r.nextInt(6) + 1;
			int secondDie = r.nextInt(6)+ 1;
			counters[firstDie + secondDie] += 1;
			rollCount--;
		}
		
		for(int i = 0; i < counters.length; i++)
		{
			if(counters[i] != 0)
				System.out.println("The probability of the sum " + i + " is " + counters[i] + "/" + temp + ".");
		}
	}
}