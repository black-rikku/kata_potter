package com.paloma.kata.potter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
	private static final List<String> EMPTY_BASKET = new ArrayList<>();
	private static final String FIRST_BOOK = "Philosofal stone";

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
}
