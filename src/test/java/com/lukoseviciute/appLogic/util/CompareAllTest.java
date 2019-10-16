package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Mismatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompareAllTest {

    //TODO: manipulate db?
    CompareAll testComparator = new CompareAll.CompareAllBuilder()
            .csvFile("src/test/java/com/lukoseviciute/appLogic/util/testCompare.csv")
            .jsonFile("src/test/java/com/lukoseviciute/appLogic/util/testCompare.json")
            .xmlFile("src/test/java/com/lukoseviciute/appLogic/util/testCompare.xml")
            .build();

    @Test
    public void testCompare(){
        List<Mismatch> mismatches = testComparator.compare();
        Assert.assertEquals(11, mismatches.size());
    }
}
