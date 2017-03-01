package io;

import java.io.Serializable;

public class ShoppingCartItems implements Serializable{
	private double price;
	private int count;
	private String description;
	
	public ShoppingCartItems(double p, int c, String desc){
		price = p; count = c; description = desc;
	}
}
