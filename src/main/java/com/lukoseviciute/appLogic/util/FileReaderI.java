package com.lukoseviciute.appLogic.util;

import java.util.List;
import com.lukoseviciute.appLogic.models.Athlete;

public interface FileReaderI {
    List<Athlete> intoObjects(String fileStr);

}