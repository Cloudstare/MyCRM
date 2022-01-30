package com.feli.mycrm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public Date getDate(String newDate) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(newDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
