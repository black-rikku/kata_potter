package com.paloma.kata.potter;

import java.util.List;

public class BasketCalculator {
	
	private final int BOOK_PRICE = 8;
	
	public int calculatePrice(List<String> books) {
		return books.size()*BOOK_PRICE;
	}
	
	public float calculatePriceWithDiscount(List<String> books) {
		return books.size()*BOOK_PRICE*0.95f;
	}
}
