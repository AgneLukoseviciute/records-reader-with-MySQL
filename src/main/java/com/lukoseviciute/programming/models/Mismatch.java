package com.lukoseviciute.programming.models;

public class Mismatch {

    String athleteName;
    String attribute;
    String trueVal;
    String otherVal;
    String otherFile;

    public Mismatch(String name, String type, String val1, String val2, String fileType){
        this.athleteName = name;
        this.attribute = type;
        this.trueVal = val1;
        this.otherVal = val2;
        this.otherFile = fileType;
    }

    public Mismatch(){

    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getTrueVal() {
        return trueVal;
    }

    public String getOtherVal() {
        return otherVal;
    }

    public String getOtherFile() {
        return otherFile;
    }
}
