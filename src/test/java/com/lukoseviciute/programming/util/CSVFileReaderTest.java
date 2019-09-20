package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVFileReaderTest {

    @Test
    public void testIntoObjects(){
        String csvFile = "src/test/java/com/lukoseviciute/programming/util/test.csv";
        CSVFileReader read = new CSVFileReader();
        List<Athlete> athletes = read.intoObjects(csvFile);
        Assert.assertEquals(2, athletes.size());
    }

}