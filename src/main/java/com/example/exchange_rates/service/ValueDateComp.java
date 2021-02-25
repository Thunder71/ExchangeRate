package com.example.exchange_rates.service;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ValueDateComp {

    public String getDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String date = s.format(new Date(cal.getTimeInMillis()));
        return date;
    }
}
