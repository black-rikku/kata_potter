package com.paloma.kata.potter;

import java.util.List;

public class BasketCalculator {
	
	public int calculatePrice(List<String> books) {
		return books.size()*8;
	}
}
