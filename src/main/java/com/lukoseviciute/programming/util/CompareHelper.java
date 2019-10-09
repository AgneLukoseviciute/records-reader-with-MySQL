package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class CompareHelper {

    /**
     * checkForDifferences takes two lists of Athletes, a source of truth and a list to be compared to the source of truth.
     *  It calls checkAllAttributes on the athletes and returns a list of Mismatch info.
     *
     * @param dbAthletes is a list of athletes from CSV file, it is the 'source of truth'
     * @param otherAthletes is a list of athletes from a different file
     * @param otherFileType is a String naming the type of the different file
     */

    public static List<Mismatch> checkForDifferences(List<Athlete> dbAthletes, List<Athlete> otherAthletes, String otherFileType){

        List<Mismatch> diffsInfo = new ArrayList<>();

        dbAthletes.stream()
                .filter(athlete -> !otherAthletes.contains(athlete))
                .forEach(athlete -> PrintDifferences.printEntryMissing(athlete.getName(), otherFileType));


        dbAthletes.stream()
                .filter(athlete -> otherAthletes.contains(athlete))
                .forEach(athlete -> {
                    Athlete otherAthlete = otherAthletes.get(otherAthletes.indexOf(athlete));
                    diffsInfo.addAll(checkAllAttributes(athlete, otherAthlete, otherFileType));
                });

        return diffsInfo;
    }

    /**
     * checkAllAttributes calls the methods for checking each attribute. If the call returns false (meaning there is a
     *  difference), and checkAllAttributes adds a Mismatch object describing the difference to a List of Mismatches.
     *
     * @param csvAthlete is an Athlete object retrieved from the source of truth CSV
     * @param otherAthlete is an Athlete object retrieved from a different file
     * @return this method returns the list of Mismatches that it created and added the differences to.
     */
    public static List<Mismatch> checkAllAttributes(Athlete csvAthlete, Athlete otherAthlete, String checkedFileType) {
        List<Mismatch> diffs = new ArrayList<>();

        if (!checkRank(csvAthlete, otherAthlete)){
            diffs.add(new Mismatch
                    (csvAthlete.getName(), "Rank", Integer.toString(csvAthlete.getRank()), Integer.toString(otherAthlete.getRank()), checkedFileType));
        }
        if (!checkMark(csvAthlete, otherAthlete)){
            diffs.add(new Mismatch
                    (csvAthlete.getName(), "Mark", csvAthlete.getMark(), otherAthlete.getMark(), checkedFileType));
        }
        if (!checkDate(csvAthlete, otherAthlete)){
            diffs.add(new Mismatch
                    (csvAthlete.getName(), "Date", csvAthlete.getDate(), otherAthlete.getDate(), checkedFileType));
        }
        if (!checkLocation(csvAthlete, otherAthlete)){
            diffs.add(new Mismatch
                    (csvAthlete.getName(), "Location", csvAthlete.getLocation(), otherAthlete.getLocation(), checkedFileType));
        }

        return diffs;

    }


    public static boolean checkRank(Athlete csvAthlete, Athlete otherAthlete) {
        return (csvAthlete.getRank() == otherAthlete.getRank());
    }

    public static boolean checkMark(Athlete csvAthlete, Athlete otherAthlete){
        return (csvAthlete.getMark().equals(otherAthlete.getMark()));
    }


    public static boolean checkDate(Athlete csvAthlete, Athlete otherAthlete) {
        return ((csvAthlete.getDate().equals(otherAthlete.getDate())));
    }

    public static boolean checkLocation(Athlete csvAthlete, Athlete otherAthlete) {
        return ((csvAthlete.getLocation().equals(otherAthlete.getLocation())));
    }

}
