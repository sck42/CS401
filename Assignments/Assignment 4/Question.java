//Sai Konduru

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Question 
{
	//Get the question from the file and return it. 
	public String getQuestion(Scanner sc) throws IOException
	{
		return sc.nextLine(); 
	}
	
	//Get the number of answers from the file and return it. 
	public int getNumAnswer(Scanner sc)throws IOException
	{
		
		Integer numOfAnswer = Integer.valueOf(sc.nextLine());
		int numAnswer = numOfAnswer;
		return numAnswer;
	}
	
	//Get the answers and return an array with them. 
	public String[] getAnswers(Scanner sc, int size)throws IOException
	{
		
		String[] answers = new String[size];
		for(int i = 0; i< answers.length; i++)
		{
			answers[i] = sc.nextLine(); 
		}
		return answers;
	}
	
	//Get the correct answer and return it. 
	public int answer(Scanner sc)throws IOException
	{
		
		Integer answer = Integer.valueOf(sc.nextLine());
		int rightAnswer = answer;
		return rightAnswer; 
	}
	
	//Get the number of trys and return it. 
	public int numTrys(Scanner sc)throws IOException
	{
		
		Integer trys = Integer.valueOf(sc.nextLine());
		int numTrys = trys;
		return numTrys;
	}
	
	//Get the number of correct and return it. 
	public int numCorrect(Scanner sc)throws IOException
	{
		
		Integer numTrysRight = Integer.valueOf(sc.nextLine());
		int numCorrectTrys = numTrysRight;
		return numCorrectTrys;
	}
}