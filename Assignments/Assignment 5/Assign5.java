//Sai Konduru

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList; 

public class Assign5
{
	private static final int HEIGHT = 400;
	private static final int WIDTH = 800;
	private static JFrame _mainWindow = new JFrame("E-Vote Version 1.0");
	private static JPanel _logInPanel;
	private static JPanel _cast; 
	private static JButton _logIn; 
	private static JButton _castButton; 
	private static GridBagConstraints gbc = new GridBagConstraints();
	
	public static void main(String[] args) throws IOException
	{
		//ballots file 
		FileReader fr = new FileReader(); 
		String ballotFileTxt = args[0];
		File f = new File(ballotFileTxt + ".txt"); 
		Scanner sc = new Scanner(f);
		Ballot b = new Ballot();
		b.setBallotFile(ballotFileTxt); 
		//voters file 
		/* File fl = new File("voters.txt");
		Scanner scn = new Scanner(fl);  */
		
		ArrayList<String> votersFile = new ArrayList<String>(); 
		ArrayList<String> ballotFileSplit = new ArrayList<String>(); 
		ArrayList<String> ballotFile = new ArrayList<String>(); 
		ArrayList<String> individualBallotFile = new ArrayList<String>(); 
		
		ArrayList<PrintWriter> outBallots = new ArrayList<PrintWriter>();
		ArrayList<PrintWriter> outBallots2 = new ArrayList<PrintWriter>();
		ArrayList<File> ballotFiles = new ArrayList<File>(); 
		ArrayList<Scanner> ballotScanners = new ArrayList<Scanner>(); 
		String[] buttonNames; 
		
		//Read and add every line of Ballot file. 
		try
		{
			ballotFile = fr.doSomething(ballotFileTxt); 
		}catch(Exception ex)
		{
			fr.showErrorMessage(); 
		}
		//b.setBallotFile(ballotFile); 
		
		//voters file 		
		try 
		{
			votersFile= fr.doSomething("voters");
		}catch(Exception ex)
		{
			fr.showErrorMessage(); 
		}
		PrintWriter outVoters = new PrintWriter("TEMPTEMP.txt"); 
		//b.setVoterPrinter(outVoters); 
			
		//Read and add every line of Ballot file. 
		sc = new Scanner(f); 
		
		gbc.gridx = 0;
		gbc.gridy = 0; 
		
		JButton[] totalButtons; 
		int numBallots = Integer.parseInt(sc.nextLine());
		String ballot;
		String[] ballotArr = new String[numBallots * 3];
		JPanel[] panels = b.setJPanels(numBallots);
		JLabel[] msgs = new JLabel[panels.length];  
		JButton[] buttons = new JButton[panels.length];
		
		//Set JPanels. 
		for(int s = 0; s < panels.length; s++)
		{
			panels[s] = new JPanel(); 
			panels[s].setLayout(new GridBagLayout());
		}
		int m = 1; 
		int i = 0;
		
		do{
			ballot = b.getBallot(sc);
			ballotArr = ballot.split(":"); 
			buttonNames = new String[ballotArr[2].split(",").length]; 
			buttonNames = ballotArr[2].split(","); 
			buttons = b.setJButtons(buttonNames);
			
			//Add all components of ballot file into an ArrayList.
			for(int q = 0; q < ballotArr.length; q++) 
			{
				ballotFileSplit.add(ballotArr[q]); 
			}
			 
			//Set JButtons into position. 
			for(int j = 0; j < buttons.length; j++)
			{
				gbc.gridy = j + 1; 
				buttons[j].addActionListener(b.getButtonListeners()); 
				buttons[j].setEnabled(false); 
				panels[i].add(buttons[j], gbc); 
			}
			i++;
		}while(sc.hasNextLine()); 

		i = 0;
		//Create the ballot files 
		int l = 0; 
		while(i < Integer.parseInt(ballotFile.get(0)) && l < ballotFileSplit.size())
		{
			outBallots.add(new PrintWriter(ballotFileSplit.get(l) + ".txt"));
			buttonNames = ballotFileSplit.get(l+2).split(",");
			b.createFiles(outBallots.get(i), buttonNames); 
			outBallots.get(i).close(); 
			i++; 
			l+=3;
		}
		
		//Create and pass in and ArrayList of printwriters that write to a temp file. 
		/* for(int v = 0; v < Integer.parseInt(ballotFile.get(0)); v++)
		{
			outBallots2.add(new PrintWriter("TEMP" + v + ".txt")); 
		}
		b.setBallotPrinter(outBallots2); */
		
		i = 0; 
		//Set JLabels into position. 
		while(m < ballotFileSplit.size())
		{
			gbc.gridy = 0; 
			msgs[i] = new JLabel(ballotFileSplit.get(m));
			msgs[i].setFont(new Font("Times New Romen", Font.PLAIN, 15));
			panels[i].add(msgs[i], gbc); 
			m += 3; 
			i++; 
		}
		i = 0; 

		//Set up main window.
		_mainWindow.setSize(WIDTH, HEIGHT);
		_mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_mainWindow.setLayout(new GridLayout(1,numBallots + 2)); 
		
		//Add panels 
		for(int k = 0; k < panels.length; k++)
		{
			_mainWindow.add(panels[k]); 
		}
		
		//Create and set up the log in panel. 
		_logInPanel = new JPanel();
		_logInPanel.setLayout(new GridBagLayout()); 
		_logIn = new JButton("Log In"); 
		_logInPanel.add(_logIn, gbc); 
		
		//Create and set up the cast panel. 
		_cast = new JPanel();
		_cast.setLayout(new GridBagLayout()); 
		_castButton = new JButton("Cast You Vote");
		_cast.add(_castButton, gbc);
		_castButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Add Listeners to log in and cast buttons and disable cast button. 
		_logIn.addActionListener(b.getLogInListener());
		_castButton.addActionListener(b.getCastListener()); 
		_castButton.setEnabled(false); 
		b.setCast(_castButton); 
		b.setLogIn(_logIn); 
		
		//Add everything to window and set to true. 
		_mainWindow.add(_logInPanel);
		_mainWindow.add(_cast); 
		_mainWindow.pack(); 
		_mainWindow.setVisible(true); 
		

	}


}