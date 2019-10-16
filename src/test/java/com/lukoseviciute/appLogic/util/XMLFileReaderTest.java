package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class XMLFileReaderTest {

    @Test
    public void intoObjects() {
        String xmlFile = "src/test/java/com/lukoseviciute/appLogic/util/test.xml";
        XMLFileReader read = new XMLFileReader();
        List<Athlete> athletes = read.intoObjects(xmlFile);
        Assert.assertEquals(4, athletes.size());
    }
}