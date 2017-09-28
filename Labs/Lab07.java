//Sai Konduru

import java.util.Random;
import java.util.Arrays;
public class Lab07
{
	private static int season = 1; 
	private static int numItems = 0;
	private static int rutabagas = 0; 
	
	public static void main(String args [])
	{
		int[] martinGarden = new int[5];
		int[] panglossGarden = new int[5];
		int counter = 0; 
		int martinIndex = 0;
		int panglossIndex = 0; 
		
		while(season <= 40)
		{
			//Get rutabagas and keep track of seasons.
			seasonSim();
			season++;

			//Martin's Garden
			if(martinGarden.length < numItems)
			{
				martinGarden = resizeMartin(martinGarden);
				if(rutabagas > 2 )
				{
					martinGarden = resizeMartin(martinGarden);
				}
				while(counter > 0)
				{
					if(martinIndex < martinGarden.length)
					{
						martinGarden[martinIndex] = rutabagas;
					}
					martinIndex++; 
					counter--;
				}
				
				if(rutabagas > 0)
				{
					while(martinIndex != numItems)
					{
						if(martinIndex < martinGarden.length)
						{
							martinGarden[martinIndex] = rutabagas;
						}
						martinIndex++; 
						counter--; 
					}
				}
			}
			else 
			{
				counter = rutabagas;
				if(rutabagas > 0)
				{
					while(martinIndex != numItems)
					{
						if(martinIndex< martinGarden.length)
						{
							martinGarden[martinIndex] = rutabagas;
						}
						martinIndex++; 
						counter--; 
					}
				}
			}
		//	System.out.println(index);
			//Pangloss's Garden 
			if(panglossGarden.length < numItems)
			{
				
				counter = rutabagas;
				panglossGarden = resizePangloss(panglossGarden);
				
				while(counter > 0)
				{
					if(panglossIndex < panglossGarden.length)
					{
						panglossGarden[panglossIndex] = rutabagas;
					}
					panglossIndex++; 
					counter--;
				}
				
				if(rutabagas > 0)
				{
					while(panglossIndex != numItems)
					{
						if(panglossIndex < panglossGarden.length)
						{
							panglossGarden[panglossIndex] = rutabagas;
						}
						panglossIndex++; 
						counter--; 
					}
				}
			}
			else 
			{
				counter = rutabagas;
				if(rutabagas > 0)
				{
					while(panglossIndex != numItems)
					{
						if(panglossIndex < panglossGarden.length)
						{
							panglossGarden[panglossIndex] = rutabagas;
						}
						panglossIndex++; 
						counter--; 
					}
				}	
			}
		}
		
		System.out.println("Martin's final garden");
		printArray(martinGarden, numItems);
		
		System.out.println("Pangloss's final garden");
		printArray(panglossGarden, numItems);
		
	}

	public static void seasonSim()
	{
		Random r = new Random();
		
		rutabagas = r.nextInt(5); 
		numItems += rutabagas;
		
		System.out.println("Season: " + season + ", " + rutabagas + " rutabagas");
	}
	
	public static int[] resizePangloss(int[] oldArray) 
	{
		int oldLength = oldArray.length;
		int newLength = 0;
		newLength = oldLength * 2;
		System.out.println("Resized Pangloss's Garden to " + newLength);
		
		int [] toReturn = new int[newLength];
		
		for (int j = 0; j < oldLength; j++) 
		{
			toReturn[j] = oldArray[j];
		}
		
		return toReturn;
    }
	
	public static int[] resizeMartin(int[] oldArray)
	{
		int newLength = 0;
		newLength = oldArray.length + 2; 
		System.out.println("Resized Martin's Garden to " + newLength);
		
		int[] toReturn = new int[newLength];
		
		for (int j = 0; j < oldArray.length; j++) 
		{
			toReturn[j] = oldArray[j];
		}
		
		return toReturn;
	}
	
	public static void printArray(int[] arr, int numitems) 
	{
		System.out.print("[ ");
		for (int j = 0; j < (arr.length - 1); j++) 
		{
			if (j >= numitems) 
			{
				System.out.print("***, ");
			}
			else 
			{
				System.out.print(arr[j] + ", ");
			}
		}
		
		if ((arr.length -1) >= numitems) 
		{
			System.out.println("*** ]");
		} 
		else 
		{
			System.out.println(arr[arr.length - 1] + " ]");
		}
    }

}