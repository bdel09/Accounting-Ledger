package com.pluralsight;
import java.time.format.DateTimeFormatter;
import java.util.*; //for the concatenation stuff
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
public class Transaction {
    LocalTime Time;
    LocalDate Date;
    private String Description, Vendor;
    //try privitizing the double too just to see what happens
    private double Amount;

    //making constructor; will make sense of above code retroactively
    Transaction(LocalDate Date, LocalTime Time, String Description, String Vendor, double Amount) {
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
    public LocalDate getDate() {
        return this.Date;
    }
    //Now we need a csv string method. Why? Because: using string methods and the datetimeformat failed big time!
    //we gotta homecook the csvstring method
    //since we using just one DateTimeFormatter went horribly, let's split:
    //What's the date? well, not fully sure why, but I think we can't use that "new" flag just because this is our very first time even
    //itroducing the LocalDate and its as a constructor(?)

    //Format
    //Just learned: the automatic formaf is YYYY/DD/MM and so the DMF is redundant
    String DF = date.tostring(Date);
    //A bit suprised it got upset wgen we tried to make the constructor "Date.."
    //oh right, because Date is a LocalTime. But Since .now() is static, we gotta create anotha var..
    LocalTime Current_Time = LocalTime.now();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");


    public String csv_string() {

        //0. Take note of the pattern:date|time|description|vendor|amount
        //1. Format our time and date
        String F_Date = date.format(this.Date);
        String F_Time = time.format(this.Time);
        //2.Combine the five attributes. I guess we'd first have to start with the latter three
        //We can use string methods, this time acting uon F_Date, F_Time and the rest
        //Concatenate? Yes, see below. We use StringBuilder (courtesy of GeeksforGeeks)
        //We also want to preserve the formatting. Were we to just envelop the double with quotation marks, it wouldn't b ecannonical
        //so, use String.valueOf(); it faciliates type conversion in the way we desire
        String c = String.join("|", F_Date, F_Time, getDescription(), getVendor(), String.valueOf(getAmount()));

        String finalString = c;
        //All well and good, but we must also insert a pipe between each field.
        //we could use the insert(int, String) method
        return finalString;

        }
    public loadTransactions() {
        history = ArrayList<Transaction>
        try {
        BufferedReader BR = new BufferedReader(FileReader(“transactions.csv”));
        while (line = readLine() != null {
            try {
            history.add(csv_line(line));
}
            catch (Exception e) {
}
        
       //The tougher part: appending the transaction into history
       //or is it? some array ootions: history.add(line);

}

}
}


    }



