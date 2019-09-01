package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;

import java.util.ArrayList;
import java.util.List;

public abstract class CompareHelper {

    private static ArrayList<Mismatch> diffsInfo = new ArrayList<Mismatch>();

    public static void checkForDifferences(List<Athlete> csvAthletes, List<Athlete> otherAthletes, String otherFileType){

        int otherIndex = 0;

        for (int i = 0; i < csvAthletes.size() ; i++) {

            if (!csvAthletes.get(i).getName().equals(otherAthletes.get(otherIndex).getName())){
                PrintDifferences.printEntryMissing(csvAthletes.get(i).getName(), otherFileType);
            }
            else {
                checkAllAttributes(csvAthletes.get(i), otherAthletes.get(otherIndex));
                otherIndex++;
            }
        }

        PrintDifferences.printDiffs(diffsInfo, otherFileType);
    }

    public static void checkAllAttributes(Athlete csvAthlete, Athlete otherAthlete) {
        checkRank(csvAthlete, otherAthlete);
        checkMark(csvAthlete, otherAthlete);
        checkDate(csvAthlete, otherAthlete);
        checkLocation(csvAthlete, otherAthlete);
    }


    public static void checkRank(Athlete csvAthlete, Athlete otherAthlete) {
        if (csvAthlete.getRank() != otherAthlete.getRank()){
            Mismatch tweak = new Mismatch
                    (csvAthlete.getName(), "Rank", Integer.toString(csvAthlete.getRank()), Integer.toString(otherAthlete.getRank()));
            diffsInfo.add(tweak);
        }
        else
            return;
    }

    public static void checkMark(Athlete csvAthlete, Athlete otherAthlete) {
        if (!(csvAthlete.getMark().equals(otherAthlete.getMark()))) {
            Mismatch tweak = new Mismatch
                    (csvAthlete.getName(), "Mark", csvAthlete.getMark(), otherAthlete.getMark());
            diffsInfo.add(tweak);
        }
        else
            return;
    }

   //Names must match, otherwise unable to check for missing values
    /* public static void checkName(Athlete csvAthlete, Athlete otherAthlete) {
        if (!(csvAthlete.getName().equals(otherAthlete.getName()))) {
            Mismatch tweak = new Mismatch
                    (csvAthlete.getName(), "Name", csvAthlete.getName(), otherAthlete.getName());
            diffsInfo.add(tweak);
        }
        else
            return;
    }*/

    public static void checkDate(Athlete csvAthlete, Athlete otherAthlete) {
        if (!(csvAthlete.getDate().equals(otherAthlete.getDate()))) {
            Mismatch tweak = new Mismatch
                    (csvAthlete.getName(), "Date", csvAthlete.getDate(), otherAthlete.getDate());
            diffsInfo.add(tweak);
        }
        else
            return;
    }

    public static void checkLocation(Athlete csvAthlete, Athlete otherAthlete) {
        if (!(csvAthlete.getLocation().equals(otherAthlete.getLocation()))) {
            Mismatch tweak = new Mismatch
                    (csvAthlete.getName(), "Location", csvAthlete.getLocation(), otherAthlete.getLocation());
            diffsInfo.add(tweak);
        }
        else
            return;
    }
}
