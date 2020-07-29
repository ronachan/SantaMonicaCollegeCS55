//Name: Rona Chan
//Title: Palindrome
//Course: CS 55
//Date: 02/06/17

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Palindrome
{
    private static String input;
    
    public static void main(String[] args) throws IOException
    {
        //instantiate scanner
        Scanner keyboard = new Scanner(System.in);

        //prompt the user for a word
        System.out.print("Please enter a word: ");
        input = keyboard.nextLine();

        //print out the user's word
        System.out.print("Your word: " +input);

        //inform the user whether or not their word is a palindrome
        if(isPalindrome(input))
        {
            System.out.println("\nYour input is a palindrome.");
        }
        else if(!(isPalindrome(input)))
        {
            System.out.println("\nYour input is not a palindrome.");
        }
    }

    //method returns T/F
    public static boolean isPalindrome(String in)
    {
        //a word with one letter is always a palindrome
        if(in.length() == 0 || in.length() == 1)
        {
            return true;
        }

        //compare the first letter with the last letter
        if(in.charAt(0) == in.charAt(in.length()-1))
        {
            return isPalindrome(in.substring(1, in.length() -1));
        }
        
        return false;
    }
}