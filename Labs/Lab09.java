//Sai Konduru

import java.util.*;

public class Lab09 {

    /**
     * Helper method for printing out arrays.
     * @param int[] arr Array of integers to print
     */
	public static int _swaps = 0; 
    public static void printArray(int[] arr) 
	{
		System.out.print("[ ");
		for (int j=0; j < (arr.length - 1); j++) 
		{
			System.out.print(arr[j] + ", ");
		}
		
		if (arr.length > 0) 
		{
			System.out.print(arr[arr.length - 1]);
		}
		System.out.println(" ]");
			
    }

    /**
     * Swap two elements in an array
     * @param int[] arr - the array
     * @param int index1 - the index of first element to swap
     * @param int index2 - the index of the second element to swap
     */

    public static void swap(int[] arr, int index1, int index2) 
	{
		if (index1 == index2) 
		{
			//DO NOTHING
		} else 
		{
			int tmp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = tmp;
			_swaps++; 
		}
    }

    /**
     * Sort an array in ascending order using the Selection Sort algorithm
     * @param int[] arr - the array
     */
    
    public static void selectionSort(int[] arr) 
	{
		_swaps = 0; 
		if (arr.length < 2) 
		{
			return;
		}
		
		int minIndex = 0;
		int minVal = 0;

		for (int j = 0; j < (arr.length-1); j++) 
		{

			minIndex = j;
			minVal = arr[j];
			for(int k = j + 1; k < arr.length; k++) 
			{

				if (arr[k] < minVal)
				{
					minVal = arr[k];
					minIndex = k;
				}
			}
			swap(arr, j, minIndex); 
		}
		
		System.out.print("Selection Sort: ");
		printArray(arr); 
		System.out.println("Swaps: " + _swaps); 

    }

	public static void bubbleSort(int[] arr)
	{
		int bubbleSwaps = 0; 
		if(arr.length < 2)
		{
			return; 
		}
		
		for(int m = 0; m < 10000; m++)
		{
			for(int i = 0; i < arr.length - 1; i++)
			{
				if(arr[i] > arr[i+1])
				{
					swap(arr, i, i+1);
					bubbleSwaps++; 
				}
			}
		}
		
		System.out.print("Bubble Sort: ");
		printArray(arr); 
		System.out.println("Swaps: " + bubbleSwaps); 
	}
	
	public static int[][] deepCopy(int[][] arr)
	{
		int[][] arr2 = new int[arr.length][];
		
		for(int i = 0; i< arr.length; i++)
		{
			arr2[i] = new int[arr[i].length];
		}
		
		for(int j = 0; j < arr.length; j++)
		{
			for(int k = 0; k < arr[j].length; k++)
			{
				arr2[j][k] = arr[j][k]; 
			}
		}
		
		return arr2; 
	}
	
    public static void main(String[] args)
	{
		int[][] a1 = { {8, 9, 5, 6, 4, 3},
				   {9, 0, 14, 13, 10, 8, 2, 1, 17, 18, 19, 201, 220, 235, 2},
				   {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 },
				   {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 1},
				   {20, 18, 13, 12, 11, 9, 6, 5, 4, 3, 2, 1, -87, -900, -9, -909, -911, -80, -44, -32, -1000} };
				   
		int[][] a2 = deepCopy(a1); 
		
		for(int j = 0; j < a1.length; j++)
		{
			System.out.println("SubArray #" + j); 
			selectionSort(a1[j]);
			bubbleSort(a2[j]);
			System.out.println("");
		}
		
    }

    
}