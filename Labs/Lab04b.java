//Sai Konduru 


import java.util.Scanner;
public class Lab04b
{
	public static void main(String[] args)
	{
		System.out.println("Hierarchy Of Needs");
		System.out.println("5) Self-Actualization");
		System.out.println("4) Esteem");
		System.out.println("3) Love and Belonging");
		System.out.println("2) Safety");
		System.out.println("1) Physiological");
		System.out.print("Pick a need >");
		Scanner sc = new Scanner(System.in);
		int need = sc.nextInt();
		switch(need)
		{
			case 5:
			{
				System.out.println("Self-Actualization");
			}
			case 4:
			{
				System.out.println("Esteem");
			}
			case 3:
			{
				System.out.println("Love and Belonging");
			}
			case 2:
			{
				System.out.println("Safety");
			}
			case 1:
			{
				System.out.println("Physiological");
			}
		}
	}
}