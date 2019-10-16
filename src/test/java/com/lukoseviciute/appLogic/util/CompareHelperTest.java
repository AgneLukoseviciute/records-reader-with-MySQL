package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Athlete;
import com.lukoseviciute.appLogic.models.Mismatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CompareHelperTest {

    @Test
    public void testCheckForDifferences() {
        Athlete atletas1 = new Athlete(2, "60.48", "Agne", "Liepos 27", "Palanga");
        Athlete atletas2 = new Athlete(1, "60.49", "Justas", "Liepos 28", "Palanga");
        Athlete atletas11 = new Athlete(2, "60.48", "Agne", "Liepos 27", "Palanga");
        Athlete atletas22 = new Athlete(1, "72.50", "Justas", "Liepos 28", "Palanga");
        List<Athlete> sourceOfTruth = Arrays.asList(atletas1, atletas2);
        List<Athlete> otherRecords = Arrays.asList(atletas11, atletas22);
        List<Mismatch> mismatches = CompareHelper.checkForDifferences(sourceOfTruth, otherRecords, "csv");
        Assert.assertEquals(1, mismatches.size());
    }
}