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
    private CompareAll(CompareAllBuilder builder){
        csvRead = new CSVFileReader();
        jsonRead = new JSONFileReader();
        xmlRead = new XMLFileReader();
        csvAthleteList = csvRead.intoObjects(builder.csvFile);
        jsonAthleteList = jsonRead.intoObjects(builder.jsonFile);
        xmlAthleteList = xmlRead.intoObjects(builder.xmlFile);

    }
    
    public void compare(){
        DiffsArr = CompareHelper.checkForDifferences(csvAthleteList, jsonAthleteList, "JSON");
        DiffsArr.addAll(CompareHelper.checkForDifferences(csvAthleteList, xmlAthleteList, "XML"));
    }

    public List<Mismatch> getDiffsArr() {
        return DiffsArr;
    }

    public static class CompareAllBuilder{

        private String csvFile;
        private String jsonFile;
        private String xmlFile;

        public CompareAllBuilder(){

        }

        public CompareAllBuilder csvFile(String csvFile){
            this.csvFile = csvFile;
            return this;
        }

        public CompareAllBuilder jsonFile(String jsonFile){
            this.jsonFile = jsonFile;
            return this;
        }

        public CompareAllBuilder xmlFile(String xmlFile){
            this.xmlFile = xmlFile;
            return this;
        }

        public CompareAll build(){
            CompareAll comp = new CompareAll(this);
            return comp;
        }
    }

}
