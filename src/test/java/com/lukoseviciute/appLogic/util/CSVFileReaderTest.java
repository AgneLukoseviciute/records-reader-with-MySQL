package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CSVFileReaderTest {

    @Test
    public void testIntoObjects(){
        String csvFile = "src/test/java/com/lukoseviciute/appLogic/util/test.csv";
        CSVFileReader read = new CSVFileReader();
        List<Athlete> athletes = read.intoObjects(csvFile);
        Assert.assertEquals(2, athletes.size());
    }

}