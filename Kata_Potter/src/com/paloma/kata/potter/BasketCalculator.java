package com.paloma.kata.potter;

import java.util.List;

public class BasketCalculator {
	

	
	public int calculatePrice(List<String> books) {
        if (books.size()==1){
        	return 8;
        }else{return 0;}
	}
}
