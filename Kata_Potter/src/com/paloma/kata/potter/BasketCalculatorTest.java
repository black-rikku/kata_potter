package com.paloma.kata.potter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
	private static final List<String> EMPTY_BASKET = new ArrayList<>();
	private static final String FIRST_BOOK = "The Sorcerer's Stone";
	private static final String SECOND_BOOK = "The Chamber of Secrets";
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
		  List <String> basket = givenBasketWithOneBook();
		  int amount = basketCalculator.calculatePrice(basket);

		  assertEquals(8, amount);
	  }
	  
	  private List<String> givenBasketWithOneBook() {
		    List<String> basket = new ArrayList<>();
		    basket.add(FIRST_BOOK);
		    return basket;
		  }
	  
	  @Test
	  public void shouldReturnPriceWithoutDiscountForABasketWithTwoEqualBooks() {
		  BasketCalculator basketCalculator = new BasketCalculator();
		  List <String> basket = givenBasketWithTwoEqualBooks();
		  int amount = basketCalculator.calculatePrice(basket);

		  assertEquals(8*2, amount);
	  }
	  
	  private List<String> givenBasketWithTwoEqualBooks() {
		    List<String> basket = new ArrayList<>();
		    basket.add(FIRST_BOOK);
		    basket.add(FIRST_BOOK);
		    return basket;
		  }
	  
	@Test
	  public void shouldReturnPriceWithDiscountForABasketWithTwoDiferentBooks() {
		  BasketCalculator basketCalculator = new BasketCalculator();
		  List <String> basket = givenBasketWithTwoDiferentBooks();
		  float amount = basketCalculator.calculatePriceWithDiscount(basket);

		  assertEquals(2*8*0.95f, amount, DELTA);
	  }
	  
	  private List<String> givenBasketWithTwoDiferentBooks() {
		    List<String> basket = new ArrayList<>();
		    basket.add(FIRST_BOOK);
		    basket.add(SECOND_BOOK);
		    return basket;
		  }
}
