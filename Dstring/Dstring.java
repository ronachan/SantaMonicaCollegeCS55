import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;


public class Dstring
{
    
    public static void main(String[] args)
    {
        //instantiate scanner
        Scanner keyboard = new Scanner(System.in);

        //declare variables
        String input, firstHalf, secondHalf;
        boolean even;

        //Prompt user for a sentence
        System.out.println("Please enter a sentence: ");
        input = keyboard.nextLine();

        
        //Check to see if the sentence is even or odd
        if(input.length() % 2 ==0)
            even = true;
        else
            even = false;

        //Print outputs according to even or odd
        if(even == true)
        {
            firstHalf = input.substring(0,input.length()/2);
            secondHalf = input.substring(input.length()-(input.length()/2));

            System.out.println("Input: " +input + "\nOutput: " +firstHalf + "\n\t" +secondHalf);
        }
        else if(even == false)
        {
            firstHalf = input.substring(0,(input.length()/2)+1);
            secondHalf = input.substring(input.length()-(input.length()/2));
            
            System.out.println("Input: " +input + "\nOutput: " +firstHalf + "\n\t" +secondHalf);
        }

        


    }
}