//Sai Konduru

import java.util.Scanner; 
public class CoogieException extends Exception
{
	int numCats = 0; 
	public CoogieException()
	{
		System.out.print("Please enter an int--> "); 
		Scanner sc = new Scanner(System.in);
		numCats = sc.nextInt(); 
		//System.out.println(numCats + " is too many cats!"); 
		
	}
	public String toString()
	{
		return (numCats + " is too many cats!"); 
	}
}