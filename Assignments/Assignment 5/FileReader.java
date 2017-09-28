//Sai Konduru
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;  
public class FileReader
{
	public static void showErrorMessage() 
	{
		System.out.println("Correct File Not Given");
		System.exit(1);
    }
	public static ArrayList<String> doSomething(String file) throws IOException
	{
		ArrayList<String> lineOfFile = new ArrayList<String>();
		File f = new File(file + ".txt"); 
		Scanner sc = new Scanner(f); 
		do
		{
			lineOfFile.add(sc.nextLine()); 
		}while(sc.hasNextLine()); 
		sc.close();
		return lineOfFile; 
	}
	public static ArrayList<PrintWriter> createBallotFiles(int numFiles) throws IOException
	{
		ArrayList<PrintWriter> outBallots = new ArrayList<PrintWriter>();
		for(int i = 0; i < numFiles; i++)
		{
			outBallots.add(new PrintWriter("TEMP" + i + ".txt")); 
		}
		return outBallots; 
	}
	public static PrintWriter createVoterFile() throws IOException
	{
		PrintWriter outVoter = new PrintWriter("TEMPTEMP.txt");
		return outVoter; 
	}
}