//Sai Konduru

import java.util.Scanner;
public class Lab08
{
	public static void main(String[] args)
	{
		Scientist s = new Scientist();
		int[][][][][] world = new int[10][10][10][10][10];
		int[] color = new int[6];
		String _color = new String(); 
		int dimension = 0;
		int numUnits = 0; 
		world = World.creatWorld(world);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a dimension (1,2,3,4,5).");
		dimension = sc.nextInt();
		System.out.println("Number of units?");
		numUnits = sc.nextInt();
		
		while(dimension > 0)
		{
			color = s.move(dimension, numUnits, world, color);
		
			System.out.print("Location: [");
			for(int i = 0; i< color.length; i++)
			{
				if(i < 5)
				{
					System.out.print(color[i] + ",");
				}
				else
				{
					if(color[5] == 1)
					{
						_color = "Lime";
					}
					else if(color[5] == 2)
					{
						_color = "Cerulean";
					}
					else if(color[5] == 3)
					{
						_color = "Goldenrod";
					}
					else 
					{
						_color = "Black";
					}
					System.out.println("] = " + _color); 
				}
			}
			
			System.out.println("Please enter a dimension (1,2,3,4,5).");
			dimension = sc.nextInt();
			if(dimension > 0)
			{
				System.out.println("Number of units?");
				numUnits = sc.nextInt();
			}
			else 
			{
				System.out.println("The Scientist quit.");
			}
			
		}
	}
}