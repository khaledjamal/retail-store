package com.company.retailstore;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.company.retailstore.util.Log;

public class BillTest {

	Log log = new Log("BillTest");
	private final double DELTA = 0.00000001;

	@Before
	public void setup() {
	}

	@Test
	public void shouldApplyZeroDiscountForEmployeeWhenBuyingGrocerciesLessThan100() {
		// given
		Date customerStartDate = new Date();
		User user = new Employee("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForSodaBottle = 2.0;
		Product sodaBottle = new Product("soda-bottle", priceForSodaBottle, ProductType.GROCERCIES);
		int numberOfSodaBottlesPurchased = 5;
		shoppingCart.addToShoppingCart(sodaBottle, numberOfSodaBottlesPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		// there is no discount in this case because the product is of grocery type and
		// the amount of fill is less than 100 dollars.
		double discount = 0;
		double expectedAmount = priceForSodaBottle * numberOfSodaBottlesPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyPercentageDiscountForEmployeeWhenBuyingNoneGroceriesLessThan100() {
		// given
		Date customerStartDate = new Date();
		User user = new Employee("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForItem = 10.0;
		Product pen = new Product("pen", priceForItem, ProductType.NON_GROCERIES);
		int numberOfItemsPurchased = 5;
		shoppingCart.addToShoppingCart(pen, numberOfItemsPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		double discount = 15;
		double expectedAmount = priceForItem * numberOfItemsPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyPercentageDiscountPlusFiveDollarDiscountForEmployeeWhenBuyingNoneGroceriesEqualTo100() {
		// given
		Date customerStartDate = new Date();
		User user = new Employee("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForItem = 20.0;
		Product pen = new Product("pen", priceForItem, ProductType.NON_GROCERIES);
		int numberOfItemsPurchased = 5;
		shoppingCart.addToShoppingCart(pen, numberOfItemsPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		double discount = 30 + 5;
		double expectedAmount = priceForItem * numberOfItemsPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyZeroDiscountForAffiliateWhenBuyingGrocerciesLessThan100() {
		// given
		Date customerStartDate = new Date();
		User user = new Affiliate("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForSodaBottle = 2.0;
		Product sodaBottle = new Product("soda-bottle", priceForSodaBottle, ProductType.GROCERCIES);
		int numberOfSodaBottlesPurchased = 5;
		shoppingCart.addToShoppingCart(sodaBottle, numberOfSodaBottlesPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		// there is no discount in this case because the product is of grocery type and
		// the amount of fill is less than 100 dollars.
		double discount = 0;
		double expectedAmount = priceForSodaBottle * numberOfSodaBottlesPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyPercentageDiscountForAffiliateWhenBuyingNoneGroceriesLessThan100() {
		// given
		Date customerStartDate = new Date();
		User user = new Affiliate("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForItem = 10.0;
		Product pen = new Product("pen", priceForItem, ProductType.NON_GROCERIES);
		int numberOfItemsPurchased = 5;
		shoppingCart.addToShoppingCart(pen, numberOfItemsPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		double discount = 5;
		double expectedAmount = priceForItem * numberOfItemsPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyPercentageDiscountPlusFiveDollarDiscountForAffiliateWhenBuyingNoneGroceriesEqualTo100() {
		// given
		Date customerStartDate = new Date();
		User user = new Affiliate("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForItem = 20.0;
		Product pen = new Product("pen", priceForItem, ProductType.NON_GROCERIES);
		int numberOfItemsPurchased = 5;
		shoppingCart.addToShoppingCart(pen, numberOfItemsPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		double discount = 10 + 5;
		double expectedAmount = priceForItem * numberOfItemsPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

	@Test
	public void shouldApplyZeroDiscountForCustomerWhenBuyingGrocerciesLessThan100() {
		// given
		Date customerStartDate = new Date();
		User user = new Customer("John", "Doe", customerStartDate);
		ShoppingCart shoppingCart = new ShoppingCart(user);

		double priceForSodaBottle = 2.0;
		Product sodaBottle = new Product("soda-bottle", priceForSodaBottle, ProductType.GROCERCIES);
		int numberOfSodaBottlesPurchased = 5;
		shoppingCart.addToShoppingCart(sodaBottle, numberOfSodaBottlesPurchased);

		Bill bill = new Bill(shoppingCart);

		// when
		double netPayableAmount = bill.computeNetPayableAmount();

		// then
		// there is no discount in this case because the product is of grocery type and
		// the amount of fill is less than 100 dollars.
		double discount = 0;
		double expectedAmount = priceForSodaBottle * numberOfSodaBottlesPurchased - discount;

		log.log("expectedAmount: " + expectedAmount);
		log.log("netPayableAmount: " + netPayableAmount);

		// double delta = 0.000001;

		assertEquals("net payable amount calcualtion is not correct", netPayableAmount, expectedAmount, DELTA);
	}

}
