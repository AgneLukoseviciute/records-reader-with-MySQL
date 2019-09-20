package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JSONFileReaderTest {

    @Test
    public void intoObjects() {
        String jsonFile = "src/test/java/com/lukoseviciute/programming/util/test.json";
        JSONFileReader read = new JSONFileReader();
        List<Athlete> athletes = read.intoObjects(jsonFile);
        Assert.assertEquals(4, athletes.size());
    }
}