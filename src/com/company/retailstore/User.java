package com.company.retailstore;

import java.util.Date;

public abstract class User {
	protected String firstName;
	protected String lastName;
	protected Date customerStartDate;

	public User(String firstName, String lastName, Date customerStartDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerStartDate = customerStartDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public abstract double getDiscountPercentage();

	public Date getCustomerStartDate() {
		return customerStartDate;
	}

	public void setCustomerStartDate(Date customerStartDate) {
		this.customerStartDate = customerStartDate;
	}

}
