package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class CompareHelper {



    //return diffsInfo

    /**
     *
     * @param csvAthletes
     * @param otherAthletes
     * @param otherFileType
     */
    public static List<Mismatch> checkForDifferences(List<Athlete> csvAthletes, List<Athlete> otherAthletes, String otherFileType){

        int otherIndex = 0;

        List<Mismatch> diffsInfo = new ArrayList<>();

        for (int i = 0; i < csvAthletes.size() ; i++) {

            if (!csvAthletes.get(i).getName().equals(otherAthletes.get(otherIndex).getName())){
                PrintDifferences.printEntryMissing(csvAthletes.get(i).getName(), otherFileType);
                diffsInfo.add(new Mismatch(csvAthletes.get(i).getName(), "not found", null, null));
            }
            else {
                diffsInfo.addAll(checkAllAttributes(csvAthletes.get(i), otherAthletes.get(otherIndex)));
                otherIndex++;
            }
        }

        //csvAthletes.forEach(i -> )
        return diffsInfo;
    }

    public static List<Mismatch> checkAllAttributes(Athlete csvAthlete, Athlete otherAthlete) {
        List<Mismatch> klaidos = new ArrayList<>();

        if (!checkRank(csvAthlete, otherAthlete)){
            klaidos.add(new Mismatch
                    (csvAthlete.getName(), "Rank", Integer.toString(csvAthlete.getRank()), Integer.toString(otherAthlete.getRank())));
        }
        if (!checkMark(csvAthlete, otherAthlete)){
            klaidos.add(new Mismatch
                    (csvAthlete.getName(), "Mark", csvAthlete.getMark(), otherAthlete.getMark()));
        }
        if (!checkDate(csvAthlete, otherAthlete)){
            klaidos.add(new Mismatch
                    (csvAthlete.getName(), "Date", csvAthlete.getDate(), otherAthlete.getDate()));
        }
        if (!checkLocation(csvAthlete, otherAthlete)){
            klaidos.add(new Mismatch
                    (csvAthlete.getName(), "Location", csvAthlete.getLocation(), otherAthlete.getLocation()));
        }

        return klaidos;

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
