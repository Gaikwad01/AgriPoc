package com.example.agripoc.database.converter;


import android.text.TextUtils;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.rblfinserve.rvf.constant.AppConstant.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS2;

public class DateTimeConverter {
    static DateFormat df = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS2);
//    static DateFormat df = new SimpleDateFormat(AppConstant.DATE_FORMAT_YYYY_MM_DD);

    @TypeConverter
    public static Date toDate(String value) {
        try {
            if (!TextUtils.isEmpty(value)) {
                try {
                    return df.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            } else {
                return null;
            }
        }catch (Exception ex){
//            ex.printStackTrace();
            return null;
        }
    }
}
