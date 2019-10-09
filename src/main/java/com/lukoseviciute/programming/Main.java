package com.lukoseviciute.programming;

import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.PrintDifferences;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Main extends HttpServlet{

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll.CompareAllBuilder()
                .csvFile("assets/records.csv")
                .jsonFile("assets/records_tweaked.json")
                .xmlFile("assets/records_tweaked.xml")
                .build();

        PrintDifferences.printDiffs(comparator.compare());
    }

}

