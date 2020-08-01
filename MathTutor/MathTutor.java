//Name: Rona Chan
//Class: CS 55
//Term: Winter 2017
//Date: 01/16/17

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;


public class MathTutor
{
    private int number1, number2, total, answer;
    private Random rand;

    //private Scanner keyboard =  new Scanner(System.in);

    public void Addition()
    {
        Scanner keyboard =  new Scanner(System.in);
        rand = new Random();

        number1 = rand.nextInt(10);
        number2 = rand.nextInt(10);

        System.out.println("What is " +number1+ "+" +number2+ " ? ");
        answer = keyboard.nextInt();
        total = number1 + number2;
        if(answer == total)
            System.out.println("That is the correct answer.");
        else
            System.out.println("Sorry, that is incorrect.");
        
        


    }

    public void Subtraction()
    {
        Scanner keyboard =  new Scanner(System.in);
        rand = new Random();

        number1 = rand.nextInt(10);
        number2 = rand.nextInt(10);

        while(number2 > number1)
        {
            number1 = rand.nextInt(10);
            number2 = rand.nextInt(10);
        }
        System.out.println("What is " +number1+ "-" +number2+ " ? ");
        answer = keyboard.nextInt();
        total = number1 - number2;

        if(answer == total)
            System.out.println("That is the correct answer.");
        else
            System.out.println("Sorry, that is incorrect.");
        

    }

    public void Multiplication()
    {
        Scanner keyboard =  new Scanner(System.in);
        rand = new Random();

        number1 = rand.nextInt(10);
        number2 = rand.nextInt(10);

        System.out.println("What is " +number1+ "*" +number2+ " ? ");
        answer = keyboard.nextInt();
        total = number1 * number2;
        if(answer == total)
            System.out.println("That is the correct answer.");
        else
            System.out.println("Sorry, that is incorrect.");
        

    }

    public void Division()
    {
        Scanner keyboard =  new Scanner(System.in);
        rand = new Random();

        number1 = rand.nextInt(10);
        number2 = rand.nextInt(10);

        while(number2 == 0)
        {
            number2 = rand.nextInt(10);
        }
        System.out.println("What is " +number1+ "/" +number2+ " ? ");
        answer = keyboard.nextInt();
        total = number1/number2;
        if(answer == total)
            System.out.println("That is the correct answer.");
        else
            System.out.println("Sorry, that is incorrect.");
        
    }
    public static void main( String[] args ) throws IOException
    {
        MathTutor tutor = new MathTutor();
        
        Scanner keyboard =  new Scanner(System.in);

        System.out.println("Main Menu");
        System.out.println("1: Addition");
        System.out.println("2: Subtraction");
        System.out.println("3: Multiplication");
        System.out.println("4: Division");
        System.out.println("5: Exit");
        System.out.print("Enter a choice: ");
        int number = keyboard.nextInt();

        while(number != 5){
                if(number == 1)
                    tutor.Addition();
                else if (number == 2)
                    tutor.Subtraction();
                else if (number == 3)
                    tutor.Multiplication();
                else if (number == 4)
                    tutor.Division();
                else
                    System.out.println("Main Menu");
                    System.out.println("1: Addition");
                    System.out.println("2: Subtraction");
                    System.out.println("3: Multiplication");
                    System.out.println("4: Division");
                    System.out.println("5: Exit");
                    System.out.print("Enter a choice: ");
                    number = keyboard.nextInt();
        }
        
    }
}