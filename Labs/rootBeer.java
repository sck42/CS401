//Sai Konduru

import java.util.Scanner;

public class rootBeer
{
	public static void main(String[] args)
	{
		System.out.print("Enter the number of Root Beers on the wall -> ");
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt())
		{
			System.out.println("Please enter an integer.");
			System.out.print("Enter the number of Root Beers on the wall -> ");
			sc = new Scanner(System.in);
		}
		
		int numRootBeer = sc.nextInt();
		
		while(numRootBeer < 0 || numRootBeer > 100)
		{
			System.out.println("Please enter a value between 0 and 99.");
			System.out.print("Enter the number of Root Beers on the wall -> ");
			numRootBeer = sc.nextInt();
		}
		
		for(int j = numRootBeer; j > 0 ; j--)
		{
			for(int i = numRootBeer; i > 0; i--)
			{
				System.out.print("R");
			
			}
			numRootBeer--;
			System.out.println("");
			
		}
		
		System.out.println("NO MORE BOTTLES OF ROOT BEER ON THE WALL!");
	}
}