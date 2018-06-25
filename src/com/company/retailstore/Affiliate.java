package com.company.retailstore;

import java.util.Date;

public class Affiliate extends User {
	public Affiliate(String firstName, String lastName, Date customerStartDate) {
		super(firstName, lastName, customerStartDate);
	}

	private static final double DISCOUNT_PERCENTAGE = 0.10;

	@Override
	public double getDiscountPercentage() {
		return DISCOUNT_PERCENTAGE;
	}

	@Override
	public String toString() {
		return "Affliate [firstName=" + firstName + ", lastName=" + lastName + ", customerStartDate="
				+ customerStartDate + "]";
	}
}
