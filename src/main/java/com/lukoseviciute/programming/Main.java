package com.lukoseviciute.programming;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.DBRetriever;
import com.lukoseviciute.programming.util.GetConfigValues;
import com.lukoseviciute.programming.util.PrintDifferences;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //TODO: use builder design pattern.
        CompareAll comparator = new CompareAll("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
        comparator.compare();//return mismatch list
        PrintDifferences.printDiffs(comparator.getDiffsArr());


        DBRetriever getDB = null;
        try {
            getDB = new DBRetriever();
            List<Athlete> atletai = getDB.getAthletes();
            for (Athlete atlete : atletai) {
                System.out.println(atlete.getRank() + " " + atlete.getName() + " " + atlete.getMark() + " " + atlete.getDate() + " " + atlete.getLocation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

