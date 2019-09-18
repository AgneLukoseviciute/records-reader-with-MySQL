package com.lukoseviciute.programming;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.DBRetriever;
import com.lukoseviciute.programming.util.PrintDifferences;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll.CompareAllBuilder()
                .csvFile("assets/records.csv")
                .jsonFile("assets/records_tweaked.json")
                .xmlFile("assets/records_tweaked.xml")
                .build();

        comparator.compare();
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

