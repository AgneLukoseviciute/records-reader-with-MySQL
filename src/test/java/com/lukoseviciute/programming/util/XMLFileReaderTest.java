package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class XMLFileReaderTest {

    @Test
    public void intoObjects() {
        String xmlFile = "src/test/java/com/lukoseviciute/programming/util/test.xml";
        XMLFileReader read = new XMLFileReader();
        List<Athlete> athletes = read.intoObjects(xmlFile);
        Assert.assertEquals(4, athletes.size());
    }
}