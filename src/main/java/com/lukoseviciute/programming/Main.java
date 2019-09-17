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

        CompareAll comparator = new CompareAll.CompareAllBuilder()
                .csvFile("assets/records.csv")
                .jsonFile("assets/records_tweaked.json")
                .xmlFile("assets/records_tweaked.xml")
                .build();
        comparator.compare();//return mismatch list
        PrintDifferences.printDiffs(comparator.getDiffsArr());


        DBRetriever getDB = null;
        try {
            getDB = new DBRetriever();
            List<Athlete> atletai = getDB.getAthletes();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

