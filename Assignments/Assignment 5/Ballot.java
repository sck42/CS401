//Sai Konduru

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File; 

import java.nio.file.Path;
import java.nio.file.Paths; 
import java.nio.file.Files;
import java.nio.file.FileSystem;
import static java.nio.file.StandardCopyOption.*; 

public class Ballot
{
	private ArrayList<JButton> totalButtons = new ArrayList<JButton>(); 
	private ArrayList<String> ballotFile = new ArrayList<String>(); 
	private ArrayList<String> ballotStringSplit = new ArrayList<String>(); 
	private ArrayList<PrintWriter> outBallots = new ArrayList<PrintWriter>(); 
	private PrintWriter outVoters; 
	private String ballotFileTxt = ""; 
	private ArrayList<String> votersList = new ArrayList<String>();  
	private JButton _cast; 
	private JButton _logIn; 
	private String userID = "";
	
	//Read in and return the number of ballots from the ballots.txt file. 
 	public int getNumBallots(Scanner sc)
	{
		return Integer.valueOf(sc.nextLine()); 
	}
	
	//Read in and return a ballot from the ballots.txt file. 
	public String getBallot(Scanner sc)
	{
		return sc.nextLine(); 
	}
	
	//Set up JPanels. 
	public JPanel[] setJPanels(int numPanels)
	{
		JPanel[] panels = new JPanel[numPanels]; 
		return panels; 
	}
	
	//Set up JButtons. 
	public JButton[] setJButtons(String[] buttonNames)
	{
		JButton[] buttons = new JButton[buttonNames.length]; 
		for(int i = 0; i < buttonNames.length; i++)
		{
			buttons[i] = new JButton(buttonNames[i]);
			totalButtons.add(buttons[i]); 
		}
		return buttons;
	}

	//Set up the ballot file arraylist with everything found in the entered file. 
	/* public void setBallotFile(ArrayList<String> bFile)
	{
		for(int i = 0; i < bFile.size(); i++)
		{
			ballotFile.add(bFile.get(i)); 
		}
	} */
	public void setBallotFile(String file)
	{
		ballotFileTxt = file; 
	}
	//Get the cast button. 
	public void setCast(JButton cast)
	{
		_cast = cast;
	}
	
	//Get the log in button. 
	public void setLogIn(JButton logIn)
	{
		_logIn = logIn;
	}
	
	//Set up the ballot printers. 
	/* public void setBallotPrinter(ArrayList<PrintWriter> out)
	{
		for(int i = 0; i < out.size(); i++)
		{
			outBallots.add(new PrintWriter(out.get(i))); 
		}
	} */
	
	//Set up the voter printer. 
	/* public void setVoterPrinter(PrintWriter out)
	{
		outVoters = new PrintWriter(out); 
	} */
	
	//Create the files with only zeros as counters. 
	public void createFiles(PrintWriter out, String[] buttonNames)
	{
		for(int d = 0; d < buttonNames.length; d++)
		{
			out.println(buttonNames[d] + ":0"); 
		}		
	}
	
	//Get the action listener for the voting buttons. 
	public ActionListener getButtonListeners()
	{
		ActionListener buttonListener = new ButtonListener();
		return buttonListener; 
	}
	
	//Get the action listener for the Log In button. 
	public ActionListener getLogInListener()
	{ 
		ActionListener logInListener = new LogInListener();
		return logInListener; 
	}
	
	//Get the action listener for the cast button. 
	public ActionListener getCastListener()
	{
		ActionListener castListener = new CastListener();
		return castListener; 
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Get the current button.
			//Check it's text color.
			//If it's red change it to black and vise versa. 
			JButton source = (JButton) e.getSource(); 
			if(source.getForeground() == Color.BLACK)
			{
				source.setForeground(Color.RED);
			}
			else 
			{
				source.setForeground(Color.BLACK);
			}
		}
	}
	
	class LogInListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource(); 
			JOptionPane logInWindow = new JOptionPane("Log In"); 
			logInWindow.createDialog("Input"); 
			logInWindow.setSize(400, 300);
			logInWindow.setLayout(new GridBagLayout());
			boolean found = false; 
			userID = logInWindow.showInputDialog("Please enter voter ID");
			userID.trim();

			String[] checkedVoters = new String[3]; 
			String[] individualVoters = new String[3];
			
			FileReader fr = new FileReader();
			//Read voters.txt and store everyline in an arrayList. 
			try
			{
				votersList = fr.doSomething("voters"); 
			}catch(Exception ex)
			{
				fr.showErrorMessage(); 
			}
			
			//Sweep through the List and look for user's ID.
			for(int i = 0; i < votersList.size(); i++)
			{
				checkedVoters = votersList.get(i).split(":"); 
				 
				if(checkedVoters[0].equals(userID))
				{
											
					found = true; 
					individualVoters = votersList.get(i).split(":"); 
				}
			}
			
			//If you can't find it then let the user know. 
			//If you find the ID check if they voted. If they didn't then ask them if they want to vote. 
			if(!found)
			{
				JOptionPane wrongID = new JOptionPane();
				wrongID.showMessageDialog(null, "Your ID Was Not Found!!", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(individualVoters[2].equals("false"))
				{
					JOptionPane voterAccepted = new JOptionPane(); 
					voterAccepted.showConfirmDialog(null, "Would you like to vote?", "Choose one", JOptionPane.YES_NO_OPTION); 
					for(int m = 0; m < totalButtons.size(); m++)
					{
						totalButtons.get(m).setEnabled(true); 
					}
					source.setEnabled(false);
					_cast.setEnabled(true);
				}
				else if(individualVoters[2].equals("true"))
				{
					JOptionPane voterNotAccepted = new JOptionPane();
					voterNotAccepted.showMessageDialog(null, individualVoters[1] + ",Your Already Voted", "Previously Voted", JOptionPane.ERROR_MESSAGE); 
				}
			}
			
			//Set login Window to true. 
			logInWindow.setVisible(true);
		}
	}
	
	class CastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane confirmWindow = new JOptionPane("Confirm Vote");
			ArrayList<String[]> individualBallotArray = new ArrayList<String[]>();
			String[] ballotFileSplit = new String[3]; 
			int counter = 0; 
			ArrayList<Integer> numButtons = new ArrayList<Integer>();
			ArrayList<String> buttonNames = new ArrayList<String>(); 
			ArrayList<String> individualBallotList = new ArrayList<String>(); 
			ArrayList<String> votersArrList2 = new ArrayList<String>(); 
			ArrayList<File> tempFiles = new ArrayList<File>(); 
			ArrayList<File> ballotFiles = new ArrayList<File>(); 
			//PrintWriter outVoters = new PrintWriter(); 
			FileReader fr = new FileReader(); 
			int m = 0;
			int p = 0; 
			if(confirmWindow.showConfirmDialog(null, "Confirm Vote?", "Choose one", JOptionPane.YES_NO_CANCEL_OPTION) == confirmWindow.YES_NO_OPTION)
			{
				JOptionPane thanksWindow = new JOptionPane("Thank You");
				thanksWindow.showMessageDialog(null, "Thank You for Voting", "Thank You", JOptionPane.INFORMATION_MESSAGE);
				//Read and add every line of Ballot file. 
				try
				{
					ballotFile = fr.doSomething(ballotFileTxt); 
				}catch(Exception ex)
				{
					fr.showErrorMessage(); 
				}
				
				int numBallots = Integer.parseInt(ballotFile.get(0)); 
				//Read and store information from all files. 
				//Start from one because zero holds numBallots. 
				for(int i = 1; i < ballotFile.size(); i++)
				{
					ballotFileSplit = ballotFile.get(i).split(":");
					try
					{
						individualBallotList = fr.doSomething(ballotFileSplit[0]); 
					}catch(Exception ex)
					{
						fr.showErrorMessage(); 
					}
					counter = individualBallotList.size(); 
					
					for(int j = 0; j < counter; j++)
					{
						individualBallotArray.add(individualBallotList.get(j).split(":")); 
						buttonNames.add(individualBallotArray.get(j)[0]);  
					}
					numButtons.add(counter);
				}
				//Calculate the counters. 
				for(int n = 0; n < totalButtons.size(); n++)
				{
					JButton button = totalButtons.get(n); 
					if(button.getForeground() == Color.RED)
					{ 
						for(int f = 0; f < individualBallotArray.size(); f++) 
						{
							if(button.getText().equals(individualBallotArray.get(f)[0]))
							{
								individualBallotArray.get(f)[1] = String.valueOf(Integer.parseInt(individualBallotArray.get(f)[1]) + 1); 
							}
						}
					}
				}
				//Create temp files. 
				try{
					outBallots = fr.createBallotFiles(Integer.parseInt(ballotFile.get(0))); 
				}catch(Exception ex)
				{
					fr.showErrorMessage(); 
				}
				
				
				//Write to temp files. 
				while(m < outBallots.size() && p < individualBallotArray.size())
				{
					for(int b = 0 + p; b < numButtons.get(m) + p; b++)
					{
						outBallots.get(m).print(individualBallotArray.get(b)[0]);
						outBallots.get(m).print(":"); 
						outBallots.get(m).print(individualBallotArray.get(b)[1]);
						outBallots.get(m).println(""); 
					}
					p = numButtons.get(m); 
					outBallots.get(m).close();
					m++;
				}
				
				//Delete and rename appropriate files. 
				int r = 1; 
				while(r < ballotFile.size())
				{
					ballotFiles.add(new File((ballotFile.get(r).split(":")[0]) + ".txt"));
					r++; 
				}
				for(int h = 0; h < ballotFiles.size(); h++) 
				{
					Path filePath2 = Paths.get((String) ballotFiles.get(h).getAbsolutePath());
					try {
						boolean success = Files.deleteIfExists(filePath2);
					} catch (Exception er) {
						fr.showErrorMessage(); 
					}
					tempFiles.add(new File("TEMP" + h + ".txt")); 
					tempFiles.get(h).renameTo(ballotFiles.get(h)); 
				}
				
				//Create temp file for voters. 
				try{
					outVoters = new PrintWriter(fr.createVoterFile());
				}catch(Exception ex)
				{
					fr.showErrorMessage(); 
				}
				  
				//Write to Voters temp file. 
				for(int y = 0; y < votersList.size(); y++) 
				{
					if(userID.equals(votersList.get(y).substring(0,4)))
					{
						votersArrList2.add(votersList.get(y).replaceAll("false", "true"));  
					}
					else
					{
						votersArrList2.add(votersList.get(y)); 
					}
					outVoters.println(votersArrList2.get(y)); 
				} 
				
				//Delete voters.txt file and rename TEMPTEMP.txt files. 
				outVoters.close();
				File f1 = new File("voters.txt");
				Path filePath = Paths.get((String) f1.getAbsolutePath());
				try {
					boolean success = Files.deleteIfExists(filePath);
				} catch (Exception er) {
					fr.showErrorMessage(); 
				}
				File f2 = new File("TEMPTEMP.txt");
				f2.renameTo(f1); 
				
				//Disable cast and vote buttons. 
				//Enable log in button.
				//Reset vote buttons. 
				_cast.setEnabled(false); 
				_logIn.setEnabled(true);
				for(int i = 0; i< totalButtons.size(); i++)
				{
					totalButtons.get(i).setForeground(Color.BLACK); 
					totalButtons.get(i).setEnabled(false); 
				}	
			}	
		}
	}
}