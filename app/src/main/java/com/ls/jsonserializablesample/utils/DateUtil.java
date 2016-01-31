package com.ls.jsonserializablesample.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    // example: 1 hour ago
    public static String getRelevantDate(long millis) {
        return String.valueOf(DateUtils.getRelativeTimeSpanString(millis));
    }

    public static String getTime(@NonNull Context context, long millis) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

        if (DateFormat.is24HourFormat(context)) {
            format.applyPattern("kk:mm");
        }
        return format.format(new Date(millis));
    }

    public static String getDate(long millis) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        return format.format(new Date(millis));
    }

    public static String getDateShort(long millis) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM", Locale.getDefault());
        return format.format(new Date(millis));
    }

    public static String getFullDate(long millis) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return format.format(new Date(millis));
    }

    public static String getDateInWeek(long millis) {
        SimpleDateFormat format = new SimpleDateFormat("EEEE", Locale.getDefault());
        return format.format(new Date(millis));
    }

    public static String getTimezoneName(long millis) {
        SimpleDateFormat format = new SimpleDateFormat("zzzz", Locale.getDefault());
        return format.format(new Date(millis));
    }
}
