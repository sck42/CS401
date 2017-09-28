//Sai Konduru

import java.util.Scanner;
import java.util.ArrayList; 
import java.util.*;
import java.io.*;
import java.io.IOException;
public class Assign4
{
	public static void main(String[] args) throws IOException
	{
		//Variables that deal with file input and outputs. 
		Scanner sc = new Scanner(System.in);
		File f = new File(args[0]);
		Scanner scn = new Scanner(f);
		Question q = new Question(); 
		String question = "";
		int numAnswer = 0;
		int answer = 0;
		int numTrys = 0;
		int numCorrect = 0;
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<String> quiz = new ArrayList<String>();
		
		//Variable that deal with user's guess.  
		int userGuess = 0;
		int numOfCorrect = 0; 
		int numWrong = 0; 
		
		//Counters
		int i = 0;
		int k = 0; 

		//Variables for easiest and hardest questions. 
		double percentage = 0.0; 
		double easiestQuestion = 0.0; 
		double hardestQuestion = 100.0; 
		String easyQuestion = "";
		String hardQuestion = "";
		int easyTrys = 0;
		int hardTrys = 0; 
		int easyCorrect = 0;
		int hardCorrect = 0; 
		
		System.out.println("Welcome to the Quiz Program! Good Luck!"); 
		System.out.println("");
		
		do
		{
			//Get the question from the file, store it and print it out for the user to see. 
			question = q.getQuestion(scn);
			questions.add(question); 
			System.out.println("Question " + i++);
			System.out.println(questions.get(k));
			k += 6 ;
			
			//Get the number of answers from the file and create an array of strings with the length of the number of answers. 
			//Store answers in the array.
			numAnswer = q.getNumAnswer(scn);
			String[] answers = new String[numAnswer];
			answers = q.getAnswers(scn, numAnswer);
			
			//Print out the multiple answers, 
			for(int j = 0; j < answers.length; j++)
			{
				System.out.println(j + ") " + answers[j]);
			}
			
			//Get the correct answer, number of trys and number of correct from the file.
			answer = q.answer(scn);
			numTrys = q.numTrys(scn);
			numCorrect = q.numCorrect(scn); 			
			
			//Check user's guess 
			System.out.print("Your Answer -> ");
			userGuess = sc.nextInt();
			while(userGuess >= numAnswer || userGuess < 0)
			{
				System.out.print("Your Answer -> ");
				userGuess = sc.nextInt();
			}
			
			//Store the correct answer, and the user's guess in the array list. 
			questions.add(Integer.toString(answer));
			questions.add(Integer.toString(userGuess));
			questions.add(Integer.toString(numAnswer)); 

			//Check the user's answer and increment appropriate variables. 
			if(userGuess == answer)
			{
				numTrys++;
				numOfCorrect++;
				numCorrect++; 
			}
			else 
			{
				numTrys++;
				numWrong++; 
			}
			
			//Store the number of trys and the number of times correct in the array list. 
			questions.add(Integer.toString(numTrys));
			questions.add(Integer.toString(numCorrect));
			
			//Store everything in a separate array list of type String. 
			quiz.add(question);
			quiz.add(Integer.toString(numAnswer));
			for(int b = 0; b < answers.length; b++)
			{
				quiz.add(answers[b]);
			}
			quiz.add(Integer.toString(answer));
			quiz.add(Integer.toString(numTrys));
			quiz.add(Integer.toString(numCorrect));
		
		} while(scn.hasNextLine());
		
		i=0; 
		System.out.println("Thank You for your answers.");
		System.out.println("Here are your Results.");
		System.out.println("");
		
		//Show the user the his answer and the correct answer for each question. 
		for(int m = 0; m < questions.size(); m++)
		{
			System.out.println("Quesiton: " + questions.get(m));
			System.out.println("Answer: " + questions.get(++m));
			System.out.println("Your Answer: " + questions.get(m + 1));
			if(questions.get(m).equals(questions.get(++m)))
			{
				System.out.println("Correct!!");
			}
			else
			{
				System.out.println("Wrong!!");
			}
			System.out.println("");
			m += 3; 
		}
		
		//Show user his grade. 
		System.out.println("Over Performance");
		System.out.println("             Right: " + numOfCorrect);
	    System.out.println("             Wrong: " + numWrong); 
		System.out.printf("             Percentage: %.2f" ,((double)(numOfCorrect)/(double)(numOfCorrect + numWrong)) * 100);
		System.out.println("%");
		System.out.println("");
		System.out.println("Here are some cumulative statistics: ");
		
		//Show user the statistics of each question. 
		for(int h = 0; h < questions.size(); h +=6)
		{
			System.out.println("Quesiton " + i++ + " : " + questions.get(h));
			numTrys = Integer.valueOf(questions.get(h+4));
			numCorrect = Integer.valueOf(questions.get(h+5));
			System.out.println("           Times Tried = " + numTrys);
			System.out.println("           Times Correct = " + numCorrect);
			percentage = ((double)numCorrect / (double)numTrys) * 100; 
			System.out.printf("           Percentage = %.2f" , percentage);
			System.out.println("%");
			System.out.println("");
			
			//Calculate and store the easiest and hardest questions with number of trys and correct. 
			if(percentage >= easiestQuestion)
			{
				easiestQuestion = percentage; 
				easyQuestion = questions.get(h);
				easyTrys = numTrys; 
				easyCorrect = numCorrect; 
			}
			else if(percentage <= hardestQuestion)
			{
				hardestQuestion = percentage; 
				hardQuestion = questions.get(h);
				hardTrys = numTrys; 
				hardCorrect = numCorrect; 
			}

		}
		
		//Print out for the user the easiest and hardest questions with the numbers for each. 
		System.out.println("Easiest Question:");
		System.out.println("Question: " + easyQuestion);
		System.out.println("          Times Tried: " + easyTrys);
		System.out.println("          Times Correct: " + easyCorrect);
		System.out.printf("          Percentage: %.2f" , easiestQuestion);
		System.out.println("%");
		System.out.println("Hardest Question:");
		System.out.println("Question: " + hardQuestion);
		System.out.println("          Times Tried: " + hardTrys);
		System.out.println("          Times Correct: " + hardCorrect);
		System.out.printf("          Percentage: %.2f" , hardestQuestion);
		System.out.println("%");
		
		//Re-enter everything back into the file. 
		PrintWriter out = new PrintWriter(f);
		for(int c = 0; c < quiz.size(); c++)
		{
			out.println(quiz.get(c)); 
		}
		out.close(); 
	}
	
}