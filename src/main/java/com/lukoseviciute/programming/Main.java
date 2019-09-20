package com.lukoseviciute.programming;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.AthleteDaoImpl;
import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.PrintDifferences;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll.CompareAllBuilder()
                .csvFile("assets/records.csv")
                .jsonFile("assets/records_tweaked.json")
                .xmlFile("assets/records_tweaked.xml")
                .build();

        PrintDifferences.printDiffs(comparator.compare());

        AthleteDaoImpl athleteGetter = null;

        try {
            athleteGetter = new AthleteDaoImpl();
            List<Athlete> dbAthletes = athleteGetter.getAllAthletes();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

