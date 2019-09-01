package com.lukoseviciute.programming;

import com.lukoseviciute.programming.util.CompareAll;

public class Main {

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
        comparator.compare();

    }

}

