//Sai Konduru

import java.util.Scanner; 
import java.util.*;
import java.io.*;
 
public class Lab06
{
	public static int babyCounter = 0;
	public static int childCounter = 0;
	public static int adultCounter = 0; 
	
	public static void main(String [] args ) throws IOException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("How big of a world? > ");
		int size = sc.nextInt(); 

		int choice = 0; 
		char[] world;
		world = generateUniverse(size); 
		System.out.println(world);
		
		System.out.println("1 -> Quit,2 -> Advance, 3-> Save");
		choice = sc.nextInt(); 
		System.out.println();
		
		while(choice != 1)
		{
			if(choice == 2)
			{
				world = advance(world);
			} 
			else if(choice == 3)
			{
				PrintWriter out = new PrintWriter("universe.txt"); 
				out.println(world);
				out.println("Babies: " + babyCounter);
				out.println("Children: " + childCounter);
				out.println("Adults: " + adultCounter);
				out.close();
			}
			
			System.out.println("1 -> Quit,2 -> Advance, 3-> Save");
			choice = sc.nextInt();
			System.out.println();			
		}

		System.out.println("Thank You!");
	}
	public static char[] generateUniverse(int size)
	{

		char[] universe = new char[size];
		
		for(int i = 0; i < universe.length; i++)
		{
			universe[i] = '.';
			universe[0] = '0';
			
			if(i % 5 == 0)
			{
				universe[i] = '^'; 
			}
			
			if(i % 7 == 0)
			{
				universe[i] = '0'; 
				babyCounter++;
			}
		}
		
		return universe;
	}
	
	public static char[] advance(char [] universe)
	{
		for(int i = 0; i < universe.length - 1; i++)
		{
			if(universe[i] == '0')
			{
				universe[i] = '1';
				childCounter++;
				babyCounter--; 
			} 
			else if(universe[i] == '1')
			{
				universe[i] = '2';
				childCounter--;
				adultCounter++;
			} 
			else if(universe[i] == '2')
			{
				if(universe[i + 1] == '^')
				{
					universe[i] = '.';
					universe[++i] = '0';
					adultCounter--;
					babyCounter++; 
				}
				else if(universe[i+1] == '.')
				{
					universe[i] = '.';
					universe[++i] = '2'; 
				}
					
				
			}
		}
		
		System.out.println(universe); 
		return universe;
	}
}