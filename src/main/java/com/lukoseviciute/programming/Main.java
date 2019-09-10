package com.lukoseviciute.programming;

import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.PrintDifferences;

public class Main {

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
        comparator.compare();
        PrintDifferences.printDiffs(comparator.getJsonDiffs(), "JSON");
        PrintDifferences.printDiffs(comparator.getXmlDiffs(), "XML");
    }

}

