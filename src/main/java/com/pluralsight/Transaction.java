package com.pluralsight;
import java.time.format.DateTimeFormatter;
import java.util.*; //for the concatenation stuff
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
public class Transaction {
    private LocalTime Time;
    private LocalDate Date;
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
    LocalDate dateFormatter = LocalDate.now();
    //Format

    //A bit suprised it got upset wgen we tried to make the constructor "Date.."
    //oh right, because Date is a LocalTime. But Since .now() is static, we gotta create anotha var..
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter DF = DateTimeFormatter.ofPattern("YYYY:MM:dd");


    public String csv_string(String line) {

        //0. Take note of the pattern:date|time|description|vendor|amount
        //1. Format our time and date

        String F_Date = DF.format(this.Date);
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

    public static Transaction csv_Line(String line) {
        String[] s = line.split("\\|");
        //parse the date into a localdate-type. Believe it or not, we can use date
        LocalDate date = LocalDate.parse(s[0]);
        //now time
        LocalTime time = LocalTime.parse(s[1]);
        //note that it's not flagged, as it's locally defined
        //Take description and vendor into the arraylist; uisng this same scheme
        String description = s[2];
        String Vendor = s[3];
        double Amount = Double.parseDouble(s[4]);
        //compiles with new; not sure why
        return new Transaction(date, time, description, Vendor, Amount);

    }
    public String logTransactions() {
        ArrayList<String> History =  new ArrayList<String>();

        try (BufferedReader BR = new BufferedReader(new FileReader("transactions.csv"))){
            String line = BR.readLine();
            while ((line) != null) {
                try {
                    History.add(csv_string(line));
                }
                catch (Exception e) {
                    break;
                }

            }

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    }



