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

    private List<Mismatch> jsonDiffs = new ArrayList<>();
    private List<Mismatch> xmlDiffs = new ArrayList<>();

    public CompareAll(String csvFile, String jsonFile, String xmlFile) {
        csvRead = new CSVFileReader();
        jsonRead = new JSONFileReader();
        xmlRead = new XMLFileReader();
        csvAthleteList = csvRead.intoObjects(csvFile);
        jsonAthleteList = jsonRead.intoObjects(jsonFile);
        xmlAthleteList = xmlRead.intoObjects(xmlFile);
    }

    public void compare(){
        jsonDiffs = CompareHelper.checkForDifferences(csvAthleteList, jsonAthleteList, "JSON");
        xmlDiffs = CompareHelper.checkForDifferences(csvAthleteList, xmlAthleteList, "XML");
    }

    public List<Mismatch> getJsonDiffs() {
        return jsonDiffs;
    }

    public List<Mismatch> getXmlDiffs() {
        return xmlDiffs;
    }
}
