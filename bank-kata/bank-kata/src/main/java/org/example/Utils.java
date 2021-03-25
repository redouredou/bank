package org.example;

import java.text.DateFormat;
import java.util.Date;

public class Utils {

    public static String getFormattedDate(Date date){
        return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
    }

}
