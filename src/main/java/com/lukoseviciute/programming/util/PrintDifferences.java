package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Mismatch;

import java.util.ArrayList;
import java.util.List;


public abstract class PrintDifferences {

    public static void printDiffs(List<Mismatch> arrayListOfDiffs){

        if (arrayListOfDiffs.isEmpty()){
            System.out.println("No differences found.");
        }
        else {
            Mismatch currDiff;
            for(int i = 0; i<arrayListOfDiffs.size(); i++){
                currDiff = arrayListOfDiffs.get(i);
                System.out.println("For athlete: " + currDiff.getAthleteName() + ", mismatch in " + currDiff.getAttribute() + ". DB value: " + currDiff.getTrueVal() + ", " + currDiff.getOtherFile() + " value: " + currDiff.getOtherVal());
            }
            System.out.println();
        }
    }

    public static void printEntryMissing(String athleteName, String wrongFileType){
        System.out.println("Missing entry for athlete: " + athleteName + " in " + wrongFileType + " file.");
    }
}
