//Name: Rona Chan
//Class: CS 55
//Term: Winter 2017
//Date: 01/16/17

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class ShiftArray {
    public static void main(String[] args) throws IOException {
        
        //user input scanner
        Scanner keyboard = new Scanner(System.in);
        
        //prompt the user
        System.out.println("Enter the number of slots needed in the array: ");
        
        //user enters slots in the array
        int slots = keyboard.nextInt();
        
        //create an array with the number of slots the user requests
        int[] shift = new int[slots];

        //random numbers in each slot
        for (int i = 0; i < slots; i++) {
            shift[i] = (int) (Math.random() * (100) + 1);
        }
        
        //prints array
        System.out.println(Arrays.toString(shift));
        System.out.println("Which direction would you like to shift the array? R/L ");
        keyboard.nextLine();
        String direction = keyboard.nextLine().toString().substring(0);
        char ch = direction.charAt(0);
        
        if(ch == 'l' || ch == 'L') {
            //call shift left method
            System.out.println("How many times would you like to shift it? ");
            int times = keyboard.nextInt();
            for(int i = 0; i < times; i++) {
                shift = shiftLeft(shift);
            }
            System.out.println(Arrays.toString(shift));
        }
        
        else if(ch == 'r' || ch == 'R') {
            //call shift right method
            System.out.println("How many times would you like to shift it? ");
            int times = keyboard.nextInt();
            for(int i = 0; i < times; i++) {
                shift = shiftRight(shift);
            }
            System.out.println(Arrays.toString(shift));
        }
        else {
                System.out.println("Sorry that is an invalid option.");
        }
    }

    //shift the array 1 index left
    public static int[] shiftLeft(int[] shift) {
        if (shift.length <= 1) {
            return shift;
        }
        int start = shift[0];
        System.arraycopy(shift, 1, shift, 0, shift.length - 1);
        shift[shift.length - 1] = start;
        return shift;

    }
    
    //shift the array 1 index right
    public static int[] shiftRight(int[] shift) {
        if (shift.length <= 1) {
            return shift;
        }
        int last = shift[shift.length - 1];
        System.arraycopy(shift, 0, shift, 1, shift.length - 1);
        shift[0] = last;
        return shift;

    }

    /*
     * public int[] shiftRight(int[] shift) { if(shift.length <= 1) { return
     * shift; } int start = shift[0]; System.arraycopy(shift, 1, shift, 0,
     * shift.length - 1); shift[shift.length - ] }
     */
}
