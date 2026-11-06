package com.pluralsight;
import java.util.Scanner;
import java.io.*;


//Create a main class of strings[] args
public class HomeScreen {
    public void HomeScreen() {
        //Here we define deposit
        //create csv file        File Blankcsv = new File("Ledger.csv");
        Scanner Read = new Scanner(System.in);
        //Creating the Deposit
        //we have to factor
        String input = Read.nextLine();
        //if the input accepted is D, prompt for deposit and then add it to CSV
        try (FileWriter writer = new FileWriter("Ledger.csv")) {
            if (input.equals("D")) {
                System.out.println("Provide your latest Deposit");
                input = Read.nextLine();
                //How do we add this to file?



            }
        } catch (Exception e) {
            System.out.println("Error! Please select one of the options.");
        }
    }


    public void main(String[] args) {
        Scanner Read = new Scanner(System.in);
        System.out.println("Welcome to Your Accounting Ledger!");
        System.out.println("This Ledger offers the folorwing:");
        System.out.println("D - Add Deposit");
        System.out.println("P - Make Payment");
        System.out.println("L - Ledger");
        System.out.println("X - Exit");
        String input = Read.nextLine();
        //pass the scanner to our other classes via a constructor
        HomeScreen();
        //maybe we'll put all the Deposit, payment operations in there
    }







    }






