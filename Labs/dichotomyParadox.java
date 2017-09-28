//Sai Konduru

public class dichotomyParadox
{
	public static void main(String[] args)
	{
		double parisDistance = 10.00;
		int i = 0; 
		
		//Loop until the division equals zero. 
		while(parisDistance != 0)
		{
			parisDistance /= 2; 
			i++; 
		}
		
		//Print number of steps. 
		System.out.println("It took " + i + " steps for the distance to equal zero.");
	}
}