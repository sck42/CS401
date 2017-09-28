//Sai Konduru

public class World
{
	public static int[][][][][] creatWorld(int[][][][][] world)
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < 10; k++)
				{
					for(int s = 0; s < 10; s++)
					{
						for(int l = 0; l < 10; l++)
						{
							world[i][j][k][s][l] =(i + j + k + s + l) % 10;
						}
					}
				}
			}
		}
		
		return world; 
	}
	
	public static int getValue(int first, int second, int third, int forth, int fifth, int[][][][][] world)
	{
		return world[first][second][third][forth][fifth];
	}

}