package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JSONFileReaderTest {

    @Test
    public void intoObjects() {
        String jsonFile = "src/test/java/com/lukoseviciute/appLogic/util/test.json";
        JSONFileReader read = new JSONFileReader();
        List<Athlete> athletes = read.intoObjects(jsonFile);
        Assert.assertEquals(4, athletes.size());
    }
}