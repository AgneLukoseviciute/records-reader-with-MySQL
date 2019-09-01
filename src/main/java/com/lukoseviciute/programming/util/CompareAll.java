package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import java.util.List;

public class CompareAll {

    private CSVFileReader csvRead;
    private JSONFileReader jsonRead;
    private XMLFileReader xmlRead;
    private List<Athlete> csvAthleteList;
    private List<Athlete> jsonAthleteList;
    private List<Athlete> xmlAthleteList;

    public CompareAll(String csvFile, String jsonFile, String xmlFile) {
        csvRead = new CSVFileReader();
        jsonRead = new JSONFileReader();
        xmlRead = new XMLFileReader();
        csvAthleteList = csvRead.intoObjects(csvFile);
        jsonAthleteList = jsonRead.intoObjects(jsonFile);
        xmlAthleteList = xmlRead.intoObjects(xmlFile);
    }

    public void compare(){
        CompareHelper.checkForDifferences(csvAthleteList, jsonAthleteList, "JSON");
        CompareHelper.checkForDifferences(csvAthleteList, xmlAthleteList, "XML");
    }

    public List<Athlete> getCsvAthleteList() {
        return csvAthleteList;
    }

    public List<Athlete> getJsonAthleteList() {
        return jsonAthleteList;
    }

    public List<Athlete> getXmlAthleteList() {
        return xmlAthleteList;
    }
}
