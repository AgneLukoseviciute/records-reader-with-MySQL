package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompareAll {

    private CSVFileReader csvRead;
    private JSONFileReader jsonRead;
    private XMLFileReader xmlRead;
    private List<Athlete> csvAthleteList;
    private List<Athlete> jsonAthleteList;
    private List<Athlete> xmlAthleteList;

    private List<Athlete> dbAthletes;

    private List<Mismatch> DiffsArr = new ArrayList<>();

    //TODO: dependency injection?
    private CompareAll(CompareAllBuilder builder){
        csvRead = new CSVFileReader();
        jsonRead = new JSONFileReader();
        xmlRead = new XMLFileReader();
        csvAthleteList = csvRead.intoObjects(builder.csvFile);
        jsonAthleteList = jsonRead.intoObjects(builder.jsonFile);
        xmlAthleteList = xmlRead.intoObjects(builder.xmlFile);

        AthleteDaoImpl dbInfo = new AthleteDaoImpl();
        try {
            dbAthletes = dbInfo.getAllAthletes();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: should return the list of mismatches. 
    public void compare(){
        DiffsArr = CompareHelper.checkForDifferences(dbAthletes, csvAthleteList, "CSV");
        DiffsArr.addAll(CompareHelper.checkForDifferences(dbAthletes, jsonAthleteList, "JSON"));
        DiffsArr.addAll(CompareHelper.checkForDifferences(dbAthletes, xmlAthleteList, "XML"));

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
