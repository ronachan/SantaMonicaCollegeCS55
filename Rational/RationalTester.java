import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

// program to test Rational class
public class RationalTester extends JFrame
{
    //Declare fields for GUI components
	private JLabel question;
	private JTextArea display;
	private JScrollPane scroll;
	private JButton add, subtract, multiply, divide, clear, newQ;
	private Random rand;
	private int tempNum, tempDen;
	private Rational a[], b[];
	private int i;
	private int j = (int)(Math.random() * 9);
	

    public RationalTester() throws IOException
    {
		super("Math Question");

		//First Rational
		a = new Rational[10];
		for(i = 0; i < a.length; i++)
		{
			//create random numerators and denominators between 1-10
			tempNum = ((int)(Math.random() * 9) + 1);
			tempDen = ((int)(Math.random() * 9) + 1);

			//make a while loop to have the den greater than the num
			while(tempNum >= tempDen)
			{
				tempNum = ((int)(Math.random() * 9) + 1);
				tempDen = ((int)(Math.random() * 9) + 1);
			}

			//use the random numbers to make a rational
			a[i] = new Rational(tempNum, tempDen);
			
			//print out a[i] : Debug
			//System.out.println("a[i]: " +a[i]);
		}

		//Second Rational
		b = new Rational[10];
		for(i = 0; i < b.length; i++)
		{
			//create random numerators and denominators between 1-10
			tempNum = ((int)(Math.random() * 9) + 1);
			tempDen = ((int)(Math.random() * 9) + 1);

			//make a while loop to have the den greater than the num
			while(tempNum >= tempDen)
			{
				tempNum = ((int)(Math.random() * 9) + 1);
				tempDen = ((int)(Math.random() * 9) + 1);
			}

			//use the random numbers to make a rational
			b[i] = new Rational(tempNum, tempDen);

			//print out b[i] : Debug
			//System.out.println("b[i]: " +b[i]);
		}
		
		//create a new colors
		Color lightBlue = new Color(15, 175, 250);
		Color lavendar = new Color(125, 115, 220);

        //create main panel (basically my Container)
        JPanel mainPanel = new JPanel();
		mainPanel.setBackground(lightBlue);

		//create another panel specifically for buttons
		JPanel nButtonPanel = new JPanel();
		nButtonPanel.setBackground(lightBlue);

		JPanel sButtonPanel = new JPanel();
		sButtonPanel.setBackground(lightBlue);

		//create new components
		question = new JLabel( "Question: " +a[j]+ "   " +b[j]+ " = ");
		question.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		//add the main panel to JFrame
		this.add(mainPanel);
		
		//organize how the panel should appear
		mainPanel.add(question, BorderLayout.CENTER);
		mainPanel.add(nButtonPanel, BorderLayout.NORTH);
		mainPanel.add(sButtonPanel, BorderLayout.SOUTH);

		//create and customize buttons
		add = new JButton("+");
		add.setPreferredSize(new Dimension(50,20));
		add.addActionListener(new AddListener());

		subtract = new JButton("-");
		subtract.setPreferredSize(new Dimension(50,20));
		subtract.addActionListener(new SubtractListener());

		multiply = new JButton("*");
		multiply.setPreferredSize(new Dimension(50,20));
		multiply.addActionListener(new MultiplyListener());

		divide = new JButton("/");
		divide.setPreferredSize(new Dimension(50,20));
		divide.addActionListener(new DivideListener());

		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(75,20));
		clear.addActionListener(new ClearListener());

		newQ = new JButton("New Question");
		newQ.setPreferredSize(new Dimension(80,20));
		newQ.addActionListener(new NewQListener());

		//add buttons onto nButton panel (north)
		nButtonPanel.add(add);
		nButtonPanel.add(subtract);
		nButtonPanel.add(multiply);
		nButtonPanel.add(divide);

		//add buttons onto sButton panel (south)
		sButtonPanel.add(clear);
		sButtonPanel.add(newQ);

		//create a text area to display both a[] and b[]
		display = new JTextArea(15, 27);
		display.setFont(new Font("Times New Roman", Font.BOLD, 12));
		display.setBackground(lavendar);
		display.setText("Array A: " +Arrays.toString(a)+ "\n" + "Array B: " +Arrays.toString(b));

		//add scroll for displayArrays
		scroll = new JScrollPane(display);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.add(scroll, BorderLayout.CENTER);
    }

	//AddListener takes two random rationals and uses
	//the add method to calculate the sum
	private class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			//Display the addition question
			question.setText("Question: " +a[j]+ " + " +b[j]+ "=");

			//use the add method to get the correct answer
			Rational sum = a[j].add(b[j]);

			//shows answer in JTextArea
			display.setText("Answer: " +sum);
	
		}
	}

	//SubtractListener takes two random rationals and uses
	//the subtract method to calculate the difference
	private class SubtractListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			//Display the subtraction question
			question.setText("Question: " +a[j]+ " - " +b[j]+ "=");

			//use the subtract method to get the correct difference
			Rational diff = a[j].subtract(b[j]);

			//shows answer in JTextArea
			display.setText("Answer: " +diff);
			
		}
	}

	//MultiplyListener takes two random rationals and uses
	//the multiplication method to calculate the product
	private class MultiplyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			//Display the multiplication question
			question.setText("Question: " +a[j]+ " * " +b[j]+ "=");

			//use the multiplication method to get the correct product
			Rational product = a[j].multiplication(b[j]);

			//shows answer in JTextArea
			display.setText("Answer: " +product);
			
		}
	}

	//DivideListener takes two random rationals and uses
	//the division method to calculate the quotient
	private class DivideListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			//Display the division question
			question.setText("Question: " +a[j]+ " / " +b[j]+ "=");

			//use the division method to get the correct quotient
			Rational quotient = a[j].division(b[j]);

			//shows answer in JTextArea
			display.setText("Answer: " +quotient);
			
		}
	}

	//ClearListener clears the JTextArea and asks to user
	//to click the new question button for another question
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			//Prompts the user to click on the newQ button
			question.setText("Click new question");

			//clears the previous answers
			display.setText(" ");
			
		}
	}

	//newQListener displays a new question with two new rationals
	private class NewQListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//creates a new question with new random rationals
			j = (int)(Math.random() * 9);
			question.setText(" Question: " +a[j]+ "   " +b[j]+ " = " );
			
		}
	}

	public static void main(String[] args) throws IOException
	{
		RationalTester win = new RationalTester();
		win.setSize(370, 370);
		win.setVisible(true);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}