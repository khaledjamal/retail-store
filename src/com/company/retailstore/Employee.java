package com.company.retailstore;

import java.util.Date;

public class Employee extends User {
	public Employee(String firstName, String lastName, Date customerStartDate) {
		super(firstName, lastName, customerStartDate);
	}

	private static final double DISCOUNT_PERCENTAGE = 0.30;

	@Override
	public double getDiscountPercentage() {
		return DISCOUNT_PERCENTAGE;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", customerStartDate="
				+ customerStartDate + "]";
	}
}
