
//Name: Rona Chan
//Class: CS 55
//Term: Winter 2017
//Date: 01/16/17

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class ArrayCountLetters 
{
	public static void main(String[] args) 
	{

		// lower case alphabet
		int[] lower = new int[25];

		// upper case alphabet
		int[] upper = new int[25];

		//
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a sentence: ");
		// line = sentence entered
		String line = keyboard.nextLine();

		int length = line.length();

		System.out.println("Sentence: " + line);

		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			int value = (int) ch;

			if (value >= 97 && value <= 122) {
				lower[ch - 'a']++;
			}
			// if(Character.isLowerCase(line.charAt(i)))
			// lowerCase++;
			// if(Character.isUpperCase(line.charAt(i)))
			// upperCase++;

		}

		for (int i = 0; i < line.length(); i++) {
			char up = line.charAt(i);
			int value = (int) up;

			if (value >= 65 && value <= 90) {
				upper[up - 'A']++;
			}

		}

		for (int i = 0; i < lower.length; i++) {
			char ch = (char) (i + 97);
			char up = (char) (i + 65);
			System.out.println(ch + " : " + lower[i] + "    " + up + " : " + upper[i]);

		}
	}
}