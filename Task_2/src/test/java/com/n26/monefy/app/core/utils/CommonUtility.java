package com.n26.monefy.app.core.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CommonUtility {

    public String getCurrentDate(String locale) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM", new Locale(locale));
        return today.format(formatter);
    }
}
