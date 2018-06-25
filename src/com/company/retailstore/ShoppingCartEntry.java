package com.company.retailstore;

public class ShoppingCartEntry {
	private Product product;
	private int numberOfItems;

	public ShoppingCartEntry(Product product, int numberOfItems) {
		this.product = product;
		this.numberOfItems = numberOfItems;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getTotalPrice() {
		return product.getPrice() * numberOfItems;
	}

}
