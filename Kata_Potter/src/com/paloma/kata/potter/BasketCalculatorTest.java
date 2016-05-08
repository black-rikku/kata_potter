package com.paloma.kata.potter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
	private static final List<String> EMPTY_BASKET = new ArrayList<>();
	private static final String FIRST_BOOK = "The Sorcerer's Stone";
	private static final String SECOND_BOOK = "The Chamber of Secrets";
	private static final String THIRD_BOOK = "The Prisoner of Azkaban";
	private static final String FOURTH_BOOK = "The Goblet of Fire";
	private static final String FIFTH_BOOK = "The Order of the Phoenix";
	private static final int DELTA = 0;

	@Test
	public void shouldReturnZeroPriceForAnEmptyBasket() {
		BasketCalculator basketCalculator = new BasketCalculator();

		int amount = basketCalculator.calculatePrice(EMPTY_BASKET);

		assertEquals(0, amount);
	}

	@Test
	public void shouldReturnPriceWithoutDiscountForABasketWithOneBook() {
		BasketCalculator basketCalculator = new BasketCalculator();
		List<String> basket = givenBasketWithBooks(FIRST_BOOK);
		int amount = basketCalculator.calculatePrice(basket);

		assertEquals(8, amount);
	}

	@Test
	public void shouldReturnPriceWithoutDiscountForABasketWithTwoEqualBooks() {
		BasketCalculator basketCalculator = new BasketCalculator();
		List<String> basket = givenBasketWithBooks(SECOND_BOOK, SECOND_BOOK);
		int amount = basketCalculator.calculatePrice(basket);

		assertEquals(8 * 2, amount);
	}

	@Test
	public void shouldReturnPriceWithDiscountForABasketWithTwoDifferentBooks() {
		BasketCalculator basketCalculator = new BasketCalculator();
		List<String> basket = givenBasketWithBooks(FOURTH_BOOK, FIFTH_BOOK);
		float amount = basketCalculator.calculatePriceWithDiscount(basket);

		assertEquals(2 * 8 * 0.95f, amount, DELTA);
	}
	
	@Test
	public void shouldReturnPriceWithDiscountForABasketWithThreeBooksTwoDifferent() {
		BasketCalculator basketCalculator = new BasketCalculator();
		List<String> basket = givenBasketWithBooks(THIRD_BOOK, THIRD_BOOK, FIFTH_BOOK);
		float amount = basketCalculator.calculatePriceWithDiscount(basket);

		assertEquals((2 * 8 * 0.95f) + 8, amount, DELTA);
	}

	private List<String> givenBasketWithBooks(String... books) {
		List<String> basket = new ArrayList<>();
		if (books != null) {
			for (String book : books) {
				basket.add(book);
			}
		}
		return basket;
	}

}
