//Sai Konduru

public class Lab13
{
	public static void main(String[] args)
	{
		try
		{
			Object obj = null; 
			obj.hashCode(); 
		}catch(NullPointerException ex)
		{
			System.out.println(ex.toString()); 
		}
		int a = 2;
		int b = 0; 
		int c = 0; 
		try{
			c = a/b; 
		}catch(ArithmeticException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			int[] d = new int[-3];
		}catch(NegativeArraySizeException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			int[] e = new int[3];
			for(int i = 0; i < e.length + 1; i++)
			{
				e[i] = 1; 
			}
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			Object x[] = new Integer[3];
			x[0] = "0"; 
		}catch(ArrayStoreException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			String s = "Hi"; 
			int m = Integer.parseInt(s);
		}catch(NumberFormatException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			throw (new NoogieException());
		}catch(NoogieException ex)
		{
			System.out.println(ex.toString()); 
		}
		
		try{
			throw (new CoogieException());
		}catch(CoogieException ex)
		{
			System.out.println(ex.toString()); 
		}
	}

}