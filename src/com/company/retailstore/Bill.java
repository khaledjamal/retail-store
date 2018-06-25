package com.company.retailstore;

import java.util.List;

import com.company.retailstore.util.Log;

public class Bill {

	Log log = new Log("Bill");

	private final static int DISCOUNT_PER_HUNDRED_AMOUNT = 5;

	private User user;

	private ShoppingCart shoppingCart;

	public Bill(ShoppingCart cart) {
		this.shoppingCart = cart;
		this.user = shoppingCart.getUser();
	}

	public double computeGrossAmountForGroceries() {
		double result = 0;

		List<ShoppingCartEntry> entries = shoppingCart.getEntries();

		for (ShoppingCartEntry shoppingCartEntry : entries) {
			if (shoppingCartEntry.getProduct().getProductType().equals(ProductType.NON_GROCERIES))
				continue;

			double price = shoppingCartEntry.getTotalPrice();
			result += price;
		}

		return result;
	}

	public double computeGrossAmountForNonGroceries() {
		double result = 0;

		List<ShoppingCartEntry> entries = shoppingCart.getEntries();

		for (ShoppingCartEntry shoppingCartEntry : entries) {
			if (shoppingCartEntry.getProduct().getProductType().equals(ProductType.GROCERCIES))
				continue;

			double price = shoppingCartEntry.getTotalPrice();
			result += price;
		}

		return result;
	}

	public double computeNetPayableAmount() {
		log.log("computeNetPayableAmount: start");

		log.log("computeNetPayableAmount: user: " + user);

		double grossAmountForGroceries = computeGrossAmountForGroceries();
		log.log("computeNetPayableAmount: grossAmountForGroceries: " + grossAmountForGroceries);

		double grossAmountForNoneGroceries = computeGrossAmountForNonGroceries();
		log.log("computeNetPayableAmount: grossAmountForNoneGroceries: " + grossAmountForNoneGroceries);

		double discountPercentage = user.getDiscountPercentage();
		log.log("computeNetPayableAmount: discountPercentage: " + discountPercentage);

		double netAmountAfterApplyingPercentageDiscountForNoneGroceries = grossAmountForNoneGroceries
				- (grossAmountForNoneGroceries * discountPercentage);

		log.log("computeNetPayableAmount: netAmountAfterApplyingPercentageDiscountForNoneGroceries: "
				+ netAmountAfterApplyingPercentageDiscountForNoneGroceries);

		double additonalDiscount = computeAdditionalDiscountForEachOneHundredDollars();
		log.log("computeNetPayableAmount: discountForNonGroceries: " + additonalDiscount);

		double result = grossAmountForGroceries + netAmountAfterApplyingPercentageDiscountForNoneGroceries
				- additonalDiscount;
		log.log("computeNetPayableAmount: result: " + result);

		return result;
	}

	private double computeAdditionalDiscountForEachOneHundredDollars() {
		double grossAmountForNoneGroceries = computeGrossAmountForNonGroceries();
		double grossAmountForGroceries = computeGrossAmountForGroceries();
		double totalGrossAmount = grossAmountForNoneGroceries + grossAmountForGroceries;

		double discountForNonGroceries = ((int) totalGrossAmount / 100) * DISCOUNT_PER_HUNDRED_AMOUNT;
		return discountForNonGroceries;
	}

}
