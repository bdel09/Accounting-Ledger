package com.pluralsight;
import java.time.format.DateTimeFormatter;
import java.util.*; //for the concatenation stuff
import java.util.Scanner;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
public class Transaction {
    LocalTime Date, Time;
    String Description, Vendor;
    //try privitizing the double too just to see what happens
    public double Amount;

    //making constructor; will make sense of above code retroactively
    Transaction(LocalTime Date, LocalTime Time, String Description, String Vendor, double Amount) {
        this.Date = Date;
        this.Time = Time;
        this.Description = Description;
        this.Vendor = Vendor;
        this.Amount = Amount;
    }
    //make the getters: public
    public String getDescription() {
        return this.Description;
    }
    public String getVendor() {
        return this.Vendor;
    }
    public double getAmount() {
        return this.Amount;
    }
    public LocalTime getTime() {
        return this.Time;
    }
    public LocalTime getDate() {
        return this.Date;
    }
    //Now we need a csv string method. Why? Because: using string methods and the datetimeformat failed big time!
    //we gotta homecook the csvstring method
    //since we using just one DateTimeFormatter went horribly, let's split:
    //What's the date? well, not fully sure why, but I think we can't use that "new" flag just because this is our very first time even
    //itroducing the LocalDate and its as a constructor(?)
    LocalDate dateFormatter = LocalDate.now();
    //Format
    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //A bit suprised it got upset wgen we tried to make the constructor "Date.."
    //oh right, because Date is a LocalTime. But Since .now() is static, we gotta create anotha var..
    LocalTime Current_Time = LocalTime.now();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:MM:SS");


    public String csv_string() {

        //0. Take note of the pattern:date|time|description|vendor|amount
        //1. Format our time and date
        String F_Date = date.format(dateFormatter);
        String F_Time = time.format(Current_Time);
        //2.Combine the five attributes. I guess we'd first have to start with the latter three
        //We can use string methods, this time acting uon F_Date, F_Time and the rest
        //Concatenate? Yes, see below. We use StringBuilder (courtesy of GeeksforGeeks)
        StringBuilder c = new StringBuilder();
        c.append(F_Date);
        c.append(F_Time);
        c.append(getDescription());
        c.append(getVendor());
        c.append(getAmount());
        String Final = c.toString();
        return Final;

        }


    }



