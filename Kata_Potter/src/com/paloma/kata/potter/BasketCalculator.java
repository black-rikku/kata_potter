package com.paloma.kata.potter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasketCalculator {
	
	private final int BOOK_PRICE = 8;
	
	public int calculatePrice(List<String> books) {
		return books.size()*BOOK_PRICE;
	}
	
	public float calculatePriceWithDiscount(List<String> books) {
		Set<String> differentBooks = new HashSet<String>(books);
		int[] numRepeatBooks = getNumberOfRepeatedBooks(differentBooks, books);
		float precio = 0f;
		for(int i=books.size(); i>0; i--) {
			int cont = 0;
			for(int num : numRepeatBooks) {
				if (num >= i) {
					cont++;
				}
			}
			precio += cont * BOOK_PRICE * (1-aplicateDiscount(cont));
		}
		return precio;
	}
	
	public int[] getNumberOfRepeatedBooks(Set<String> differentBooks, List<String> books) {
		
		int repeatedBooks[] = new int[differentBooks.size()];
		int i = 0;
		
		for(String book : differentBooks) {
			repeatedBooks [i] = Collections.frequency(books, book);
			i++;
		}
		
		return repeatedBooks;
	}
	
	public float aplicateDiscount (int cont) {
		if (cont==0) { return 1f;}
		else if (cont==1) { return 0f;}
		else if (cont==2) {return 0.05f;}
		else if (cont==3) {return 0.10f;}
		else if (cont==4) {return 0.20f;}
		else {return 0.25f;}
	}
}
