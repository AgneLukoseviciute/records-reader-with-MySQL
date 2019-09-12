package com.lukoseviciute.programming;

import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.PrintDifferences;

public class Main {

    public static void main(String[] args) {

        //builder design pattern.
        CompareAll comparator = new CompareAll("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
        comparator.compare();//return mismatch list
        PrintDifferences.printDiffs(comparator.getDiffsArr());
    }

}

