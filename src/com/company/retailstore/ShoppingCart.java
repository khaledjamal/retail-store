package com.company.retailstore;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<ShoppingCartEntry> entries;
	private User user;

	// public ShoppingCart() {
	// this.entries = new ArrayList<ShoppingCartEntry>();
	// }

	public ShoppingCart(User user) {
		this.user = user;
		this.entries = new ArrayList<ShoppingCartEntry>();
	}

	public void addToShoppingCart(Product product, int numberOfItems) {
		ShoppingCartEntry entry = new ShoppingCartEntry(product, numberOfItems);
		entries.add(entry);
	}

	public List<ShoppingCartEntry> getEntries() {
		return entries;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
