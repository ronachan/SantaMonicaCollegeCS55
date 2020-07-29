import java.awt.*;
import java.util.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class StartWindow extends JFrame {
	
	boolean windowOpened = false;
	ImageIcon logoIcon = new ImageIcon(getClass().getResource("chiname.png"));
	ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
	Color lightBlue = new Color(217, 245, 251), lightPink = new Color(255, 223, 234);
	Font bold20 = new Font("cambri", Font.BOLD, 20), bold15 = new Font("cambri", Font.BOLD, 15);
	
	StartWindow(){
		//sets up window
		super("Connecting-US™");
		super.setIconImage(logoIcon.getImage());
		JTextArea area = new JTextArea("Welcome to Connecting-US™, press on any button to continue");
		JLabel label = new JLabel(logo);
		JPanel panel = new JPanel();
		JButton studyButton = new JButton("Study");
		JButton learnButton = new JButton("Learn");
		JButton infoButton = new JButton("Info");
		
		//window decoration
		area.setFont(bold15);
		studyButton.setFont(bold20);
		learnButton.setFont(bold20);
		infoButton.setFont(bold20);
		studyButton.setBackground(lightBlue);
		learnButton.setBackground(lightBlue);
		infoButton.setBackground(lightBlue);
		area.setBackground(lightPink);
		label.setToolTipText("Connecting-US™");
		studyButton.setToolTipText("Click here to study the states");
		learnButton.setToolTipText("Click here to quiz your knowledge");
		infoButton.setToolTipText("Click here for help");
		area.setToolTipText("Click on any button below");
		studyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		learnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		area.setEditable(false);
		panel.setLayout(new GridLayout(1,3));
		setLayout(null); //nullifies layout
		Insets insets = this.getInsets();
		label.setBounds(insets.left, insets.top, 500, 170);
		area.setBounds(insets.left, insets.top + 170, 500, 70);
		panel.setBounds(insets.left, insets.top + 240, 500, 50);
		panel.add(studyButton);panel.add(learnButton);panel.add(infoButton);
		
		//put together window
		add(label);add(area);add(panel);
		setVisible(true);
		setSize(500,320); //window size
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studyButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							SwingUtilities.invokeLater(new BrowserWindow());	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
		learnButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							new GameWindow();	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
		infoButton.addActionListener(
	    		new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(windowOpened == true){	//if-else statement only allows one window open at a time
							closeOpenedWindow();
						}else{
							new InfoWindow();	//window to open (if no other window is opened)
							windowOpened = true;
						}
					}
	    		}
	    	);
		playSound("C:\\Windows\\Media\\ding.wav");
	}
	
	//method to play sound
	public void playSound(String path){
		try
		  {
		  File f=new File(path);
		  AudioInputStream a=AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(f)));
		  AudioFormat audioFormat = a
		                   .getFormat();
		             DataLine.Info dataLineInfo = new DataLine.Info(
		                   Clip.class, audioFormat);
		             Clip clip = (Clip) AudioSystem
		                   .getLine(dataLineInfo);
		             clip.open(a);
		             clip.start();
		 }
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  System.out.println("exception caught ");
		 }
	}
	
	//Close Opened Window Method
	public void closeOpenedWindow(){
		System.out.println("Closing window");
	}
	//-----------------------------------------------//
	////////////////BROWSER INNER CLASS////////////////
	public class BrowserWindow implements Runnable {
	    private WebEngine webEngine;

	    public void loadURL(final String url) {
	        Platform.runLater(() -> {
	            webEngine.load(url);
	        });
	    }

	    @Override
	    public void run() {
	        // setup UI
	        JFrame frame = new JFrame();
	        frame.setTitle("Study The States");
	        frame.setIconImage(logoIcon.getImage());
	        JButton backButton = new JButton("Back");
	        backButton.setBackground(lightPink);
	        backButton.setToolTipText("Click to go back to the main menu");
	        backButton.setFont(bold15);
	        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        frame.setVisible(true);
	        frame.setPreferredSize(new Dimension(1024, 600));
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        backButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		frame.dispose();
					windowOpened = false;
					playSound("C:\\Windows\\Media\\recycle.wav");
	        	}
	        });
	        frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    	playSound("C:\\Windows\\Media\\recycle.wav");
			        windowOpened = false;
			    }
			});

	        JFXPanel jfxPanel = new JFXPanel();
	        frame.getContentPane().add(jfxPanel);
	        frame.pack();
	        frame.add(backButton, BorderLayout.SOUTH);
	        Platform.runLater(() -> {
	            WebView view = new WebView();
	            webEngine = view.getEngine();

	            jfxPanel.setScene(new Scene(view));
	        });

	        loadURL("file:///" + System.getProperty("user.home") + "/Desktop/Map/index.html");
	    }
	}
	//-----------------------------------------------//
	///////////////GAME INNER CLASS///////////////////
	public class GameWindow {
		
		int score = 0, questionNum = 0;
		int[] questionOrder = new int[5];
		String[] stateNames = new String[50], stateCapitals = new String[50];
		ImageIcon[] statePicture = new ImageIcon[50], resultsPicture = new ImageIcon[6];
		JFrame gameWin;	//window frame
		JLabel gameLabel;
		JTextArea gameTextArea;
		JTextField gameTextField;
		boolean gameInSession = true;
		
		
		public GameWindow(){
			questionOrder[0] = 42;
			questionOrder[1] = 8;
			questionOrder[2] = 2;
			questionOrder[3] = 46;
			questionOrder[4] = 4;
			//state names array
			stateNames[0] = "Alabama";stateNames[1] = "Alaska";stateNames[2] = "Arizona";stateNames[3] = "Arkansas";stateNames[4] = "California";stateNames[5] = "Colorado";stateNames[6] = "Connecticut";stateNames[7] = "Delaware";stateNames[8] = "Florida";stateNames[9] = "Georgia";
			stateNames[10] = "Hawaii";stateNames[11] = "Idaho";stateNames[12] = "Illinois";stateNames[13] = "Indiana";stateNames[14] = "Iowa";stateNames[15] = "Kansas";stateNames[16] = "Kentucky";stateNames[17] = "Louisiana";stateNames[18] = "Maine";stateNames[19] = "Maryland";
			stateNames[20] = "Massachusetts";stateNames[21] = "Michigan";stateNames[22] = "Minnesota";stateNames[23] = "Mississippi";stateNames[24] = "Missouri";stateNames[25] = "Montana";stateNames[26] = "Nebraska";stateNames[27] = "Nevada";stateNames[28] = "New Hampshire";stateNames[29] = "New Jersey";
			stateNames[30] = "New Mexico";stateNames[31] = "New York";stateNames[32] = "North Carolina";stateNames[33] = "North Dakota";stateNames[34] = "Ohio";stateNames[35] = "Oklahoma";stateNames[36] = "Oregon";stateNames[37] = "Pennsylvania";stateNames[38] = "Rhode Island";stateNames[39] = "South Carolina";
			stateNames[40] = "South Dakota";stateNames[41] = "Tennessee";stateNames[42] = "Texas";stateNames[43] = "Utah";stateNames[44] = "Vermont";stateNames[45] = "Virginia";stateNames[46] = "Washington";stateNames[47] = "West Virginia";stateNames[48] = "Wisconsin";stateNames[49] = "Wyoming";
			
			//state capitals
			stateCapitals[0] = "Montgomery";stateCapitals[1] = "Juneau";stateCapitals[2] = "Phoenix";stateCapitals[3] = "Little Rock";stateCapitals[4] = "Sacramento";stateCapitals[5] = "Denver";stateCapitals[6] = "Hartford";stateCapitals[7] = "Dover";stateCapitals[8] = "Tallahassee";stateCapitals[9] = "Atlanta";
			stateCapitals[10] = "Honolulu";stateCapitals[11] = "Boise";stateCapitals[12] = "Springfield";stateCapitals[13] = "Indianapolis";stateCapitals[14] = "Des Moines";stateCapitals[15] = "Topeka";stateCapitals[16] = "Frankfort";stateCapitals[17] = "Baton Rouge";stateCapitals[18] = "Augusta";stateCapitals[19] = "Annapolis";
			stateCapitals[20] = "Boston";stateCapitals[21] = "Lansing";stateCapitals[22] = "Saint Paul";stateCapitals[23] = "Jackson";stateCapitals[24] = "Jefferson City";stateCapitals[25] = "Helana";stateCapitals[26] = "Lincoln";stateCapitals[27] = "Carson City";stateCapitals[28] = "Concord";stateCapitals[29] = "Trenton";
			stateCapitals[30] = "Santa Fe";stateCapitals[31] = "Albany";stateCapitals[32] = "Raleigh";stateCapitals[33] = "Bismarck";stateCapitals[34] = "Columbus";stateCapitals[35] = "Oklahoma City";stateCapitals[36] = "Salem";stateCapitals[37] = "Harrisburg";stateCapitals[38] = "Providence";stateCapitals[39] = "Columbia";
			stateCapitals[40] = "Pierre";stateCapitals[41] = "Nashville";stateCapitals[42] = "Austin";stateCapitals[43] = "Salt Lake City";stateCapitals[44] = "Montpelier";stateCapitals[45] = "Richmond";stateCapitals[46] = "Olympia";stateCapitals[47] = "Charleston";stateCapitals[48] = "Madison";stateCapitals[49] = "Cheyenne";
			
			//state pictures
			statePicture[8] = new ImageIcon(getClass().getResource("florida.jpg"));
			statePicture[42] = new ImageIcon(getClass().getResource("texas.jpg"));
			statePicture[2] = new ImageIcon(getClass().getResource("arizona.jpg"));
			statePicture[46] = new ImageIcon(getClass().getResource("washington.jpg"));
			statePicture[4] = new ImageIcon(getClass().getResource("california.jpg"));
			
			//state results
			resultsPicture[0] = new ImageIcon(getClass().getResource("0.jpg"));
			resultsPicture[1] = new ImageIcon(getClass().getResource("20.jpg"));
			resultsPicture[2] = new ImageIcon(getClass().getResource("40.jpg"));
			resultsPicture[3] = new ImageIcon(getClass().getResource("60.jpg"));
			resultsPicture[4] = new ImageIcon(getClass().getResource("80.jpg"));
			resultsPicture[5] = new ImageIcon(getClass().getResource("100.jpg"));
			
			//sets up window
			gameWin = new JFrame("Type in the State Capitals");
			gameWin.setIconImage(logoIcon.getImage());
			gameLabel = new JLabel();
			gameTextArea = new JTextArea();
			JPanel inputPanel = new JPanel(new FlowLayout());
			JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
			JButton enter = new JButton("Enter");
			JButton exit = new JButton("Exit");
			gameTextField = new JTextField(20);
			Insets insets = gameWin.getInsets();
			gameLabel.setBounds(insets.left, insets.top, 510, 300);
			gameTextArea.setEditable(false);
			gameWin.setLayout(null); //nullifies layout
			gameTextArea.setBounds(insets.left, insets.top + 300, 510, 60);
			inputPanel.setBounds(insets.left, insets.top + 360, 510, 50);
			buttonsPanel.setBounds(insets.left, insets.top + 410, 510, 50);
			
			//colors/decoration
			gameTextArea.setBackground(lightBlue);
			inputPanel.setBackground(lightBlue);
			gameTextField.setBackground(lightPink);
			enter.setBackground(lightBlue);
			exit.setBackground(lightBlue);
			enter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			gameTextField.setToolTipText("Type in your answer");
			enter.setToolTipText("Click to enter in answer");
			exit.setToolTipText("Click to exit game");
			gameTextArea.setFont(bold20);
			gameTextField.setFont(bold20);
			enter.setFont(bold20); exit.setFont(bold20);
			
			//puts together window
			inputPanel.add(gameTextField);
			buttonsPanel.add(enter);buttonsPanel.add(exit);
			gameWin.add(gameLabel);gameWin.add(gameTextArea);gameWin.add(inputPanel);gameWin.add(buttonsPanel);
			gameWin.setSize(510, 490);
			gameWin.setResizable(false);
			gameWin.setVisible(true);
			gameTextField.requestFocusInWindow(); //must be invoked after window is visible
			gameWin.setLocationRelativeTo(null);
			gameWin.isAlwaysOnTop();
			gameWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//action listeners for buttons
			enter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//enter button event
					if(gameInSession == true){		//while still in game
						checkAnswer(gameTextField.getText());
						questionNum += 1;
						gameTextField.setText("");
						setNextQuestion(questionOrder[questionNum]);
					}else{							//if the game is over
						checkAnswer(gameTextField.getText()); //very last answer to check
						enter.setEnabled(false);
						gameTextField.setText("Results");
						gameTextField.setEditable(false);
						displayResults();
					}

				}
			});
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//exit button event
					playSound("C:\\Windows\\Media\\recycle.wav");
					windowOpened = false;
					gameWin.dispose();
				}
			});
			//lets program know that window was closed
			gameWin.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    	playSound("C:\\Windows\\Media\\recycle.wav");
			        windowOpened = false;
			    }
			});
			
			setNextQuestion(questionOrder[questionNum]); //sets up initial question and picture for user
		}
		
		//checks answer
		public void checkAnswer(String ans){
			if(ans.equals(stateCapitals[questionOrder[questionNum]])){
				systemMessage("Correct!");
				score += 1;
			}else{
				systemMessage("Wrong.");
			}
		}
		
		//method for changing window
		public void setNextQuestion(int stateNum){
			gameTextField.requestFocusInWindow();
			gameTextArea.setText(" What is the state capital of " + stateNames[stateNum] + "?");
			gameLabel.setIcon(statePicture[stateNum]);
			if(questionNum == 4){
				gameInSession = false;
			}
		}
		
		//method for randomizing state
		public int randomState(){ //state value from 0 - 49
			Random rand = new Random();
			int num = rand.nextInt(50);
			return num;
		}
		
		//displays results
		public void displayResults(){
			gameTextArea.setText("You've got " + score + "/5 correct.");
			gameLabel.setIcon(resultsPicture[score]);
			if(score == 5 || score == 4){		//80 or 100 percent will play sound
				playSound("C:\\Windows\\Media\\tada.wav");
			}
		}
		
		public void systemMessage(String s){
			System.out.println(s);
		}
		
	}

	
	//-----------------------------------------------//
	//////////////INFO INNER CLASS///////////////////
	public class InfoWindow { //Info
		
		//sample
		InfoWindow(){
			String info = new String("** Welcome to Connecting US! **\n The purpose of this game is to help you learn the states and capitals \nof the United States of America. \n________________________________________________________________\nClick the study button to go over all the states and learn a little extra \nabout them. \nAfter studying and going over all the states, feel free to click the learn \nbutton to be tested on the capitals of random states! You will be given \n5 states and your score will be out of 5 at the end of the game. \nWhen you are finished, exit out of the game and you're all set! \nTo play another game, simply click the learn button again. Enjoy!**");
			JFrame frame = new JFrame("How To Use");
			JTextArea infoArea = new JTextArea(info);
			JButton backButton = new JButton("Back");
			
			//decoration for info window
			backButton.setBackground(lightBlue);
			backButton.setFont(bold20);
			infoArea.setBackground(lightPink);
			infoArea.setFont(bold15);
			infoArea.setToolTipText("About Connecting-US™");
			backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			backButton.setToolTipText("Click here to go back to the main menu");
			
			//puts window together
			infoArea.setEditable(false);
			frame.add(infoArea);frame.add(backButton, BorderLayout.SOUTH);
			frame.setSize(500, 300);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.isAlwaysOnTop();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//exit button event
					playSound("C:\\Windows\\Media\\recycle.wav");
					windowOpened = false;
					frame.dispose();
				}
			});
			
			//lets program know that window was closed
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        windowOpened = false;
			        playSound("C:\\Windows\\Media\\recycle.wav");
			    }
			});
		}

	}
}
