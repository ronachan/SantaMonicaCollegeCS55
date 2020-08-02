//Name: Rona Chan
//Class: CS 55
//Term: Winter 2017
//Date: 01/16/17

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class InsuranceAge
{
    private double total = 0.0;
    private double rate;
    private int age;
    private final int start = 1000;

    
    public static void main(String[] args) throws IOException
    {
        InsuranceAge auto = new InsuranceAge();
        

        Scanner input = new Scanner(System.in);
        
        System.out.println("The program is supposed to determine the cost of automobile insurance premium for each family member, based on their ages.");
        System.out.println("Please enter your age: ");
        
        auto.age = input.nextInt();
        auto.Calculations();
        
        System.out.printf("The family member age " +auto.age +" years old will need to pay $%.2f" ,auto.total, " dollars for automobile insurance.");

    }
    

    public void Calculations()
    {
        
         if(age >= 16 && age <=19){
                rate = 0.15;
                total = start + (start * rate);
               
            }
            else if(age >= 20 && age <= 25){
                rate = .05;
                total = start + (start * rate);
                
            }
            else if (age > 25){
                rate = .10;
                total = start - (start * rate);
                
            }
            else
                System.out.println("No insurance.");

    }
    
    

}