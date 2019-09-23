package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.models.Mismatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CompareAllTest {

    //TODO: manipulate db?
    CompareAll testComparator = new CompareAll.CompareAllBuilder()
            .csvFile("src/test/java/com/lukoseviciute/programming/util/testCompare.csv")
            .jsonFile("src/test/java/com/lukoseviciute/programming/util/testCompare.json")
            .xmlFile("src/test/java/com/lukoseviciute/programming/util/testCompare.xml")
            .build();

    @Test
    public void testCompare(){
        List<Mismatch> mismatches = testComparator.compare();
        Assert.assertEquals(11, mismatches.size());
    }
}
