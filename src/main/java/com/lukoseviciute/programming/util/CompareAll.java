package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;

import java.util.ArrayList;
import java.util.List;

public class CompareAll {

    private CSVFileReader csvRead;
    private JSONFileReader jsonRead;
    private XMLFileReader xmlRead;
    private List<Athlete> csvAthleteList;
    private List<Athlete> jsonAthleteList;
    private List<Athlete> xmlAthleteList;

    private List<Mismatch> DiffsArr = new ArrayList<>();

    //needs dependency injection?
    public CompareAll(String csvFile, String jsonFile, String xmlFile) {
        csvRead = new CSVFileReader();
        jsonRead = new JSONFileReader();
        xmlRead = new XMLFileReader();
        csvAthleteList = csvRead.intoObjects(csvFile);
        jsonAthleteList = jsonRead.intoObjects(jsonFile);
        xmlAthleteList = xmlRead.intoObjects(xmlFile);
    }

    public void compare(){
        DiffsArr = CompareHelper.checkForDifferences(csvAthleteList, jsonAthleteList, "JSON");
        DiffsArr.addAll(CompareHelper.checkForDifferences(csvAthleteList, xmlAthleteList, "XML"));
    }

    public List<Mismatch> getDiffsArr() {
        return DiffsArr;
    }

}
