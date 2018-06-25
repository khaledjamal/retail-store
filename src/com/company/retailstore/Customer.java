package com.company.retailstore;

import java.util.Date;

import com.company.retailstore.util.DateUtil;

public class Customer extends User {
	public Customer(String firstName, String lastName, Date customerStartDate) {
		super(firstName, lastName, customerStartDate);
	}

	private static final double DISCOUNT_PERCENTAGE = 0.05;

	@Override
	public double getDiscountPercentage() {
		if (isCustomerForMoreThanTwoYears())
			return DISCOUNT_PERCENTAGE;
		else
			return 0.0;
	}

	private boolean isCustomerForMoreThanTwoYears() {
		Date todayDate = new Date();

		long numberOfDays = DateUtil.getNumberOfDaysBetween(customerStartDate, todayDate);

		boolean result = numberOfDays > minimumNumberOfDaysToGetDiscount();

		return result;
	}

	private int minimumNumberOfDaysToGetDiscount() {
		return 365 * 2;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerStartDate="
				+ customerStartDate + "]";
	}
}
