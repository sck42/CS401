//Sai Konduru

public class Scientist 
{
	public int[] move(int dimention, int numUnits, int[][][][][] world, int [] color)
	{
		
		if(numUnits >= 0)
		{
			color[dimention - 1] = numUnits; 
		}
		else if(numUnits < 0)
		{	
			color[dimention - 1] = 10 - (numUnits * -1); 
		}
		
		color[5] = World.getValue(color[0], color[1], color[2], color[3], color[4], world);

		return color; 
	}
}