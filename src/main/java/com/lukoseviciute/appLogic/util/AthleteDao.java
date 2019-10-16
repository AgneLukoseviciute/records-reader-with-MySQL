package com.lukoseviciute.appLogic.util;

import com.lukoseviciute.appLogic.models.Athlete;

import java.sql.SQLException;
import java.util.List;

public interface AthleteDao {

    List<Athlete> getAllAthletes() throws SQLException;
}
