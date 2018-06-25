package com.company.retailstore.util;

import java.util.Date;

public class DateUtil {

	public static long getNumberOfDaysBetween(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();

		long result = (endTime - startTime) / (1000 * 60 * 60 * 24);

		return result;
	}
}
