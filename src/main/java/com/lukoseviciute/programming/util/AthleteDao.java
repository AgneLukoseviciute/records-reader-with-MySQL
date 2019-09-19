package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;

import java.sql.SQLException;
import java.util.List;

public interface AthleteDao {

    List<Athlete> getAllAthletes() throws SQLException;
}
