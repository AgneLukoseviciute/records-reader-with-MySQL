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

        if (builder.csvFile != null){
            csvAthleteList = csvRead.intoObjects(builder.csvFile);
        }
        if (builder.jsonFile != null){
            jsonAthleteList = jsonRead.intoObjects(builder.jsonFile);
        }
        if (builder.xmlFile != null){
            xmlAthleteList = xmlRead.intoObjects(builder.xmlFile);
        }


        AthleteDaoImpl dbInfo = new AthleteDaoImpl();
        try {
            dbAthletes = dbInfo.getAllAthletes();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Mismatch> compare(){
        if (this.csvAthleteList != null){
            DiffsArr = CompareHelper.checkForDifferences(dbAthletes, csvAthleteList, "CSV");
        }
        if (this.jsonAthleteList != null){
            DiffsArr.addAll(CompareHelper.checkForDifferences(dbAthletes, jsonAthleteList, "JSON"));
        }
        if (this.xmlAthleteList != null){
            DiffsArr.addAll(CompareHelper.checkForDifferences(dbAthletes, xmlAthleteList, "XML"));
        }

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
