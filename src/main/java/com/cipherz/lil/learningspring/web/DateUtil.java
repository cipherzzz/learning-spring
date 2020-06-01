package com.cipherz.lil.learningspring.web;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class DateUtil {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd");
	
	public static Date createDateFromDateString(String dateString) {
		Date date = null;
		if(null != dateString) {
			try {
				date = DATE_FORMAT.parse(dateString);
			} catch(ParseException pe) {
				date = new Date();
			}
		} else {
			date = new Date();
		}
		
		return date;
	}
}