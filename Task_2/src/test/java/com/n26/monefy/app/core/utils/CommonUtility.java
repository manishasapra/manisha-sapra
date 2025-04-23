package com.n26.monefy.app.core.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * This class is responsible for containing common utility for all tests
 */
public class CommonUtility {

    /**
     * This method is responsible for fetching the currect date to match with the income date
     * in tests
     *
     * @param locale
     * @return String
     */
    public String getCurrentDate(String locale) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM", new Locale(locale));
        return today.format(formatter);
    }
}
