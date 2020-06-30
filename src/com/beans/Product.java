package com.beans;

import java.util.ArrayList;

/*
 * @author Nassim Kissi 
 * Classe représentant notre objet Produit
 */
public class Product {
	
	/*
	 * Propriété de notre objet 
	 */
	private int id;
	private String name;
	private double price;
	private String category;
	private String featured;
	private int stock; 
	private String image;
	
	
	/*
	 * GETTER & SETTER
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", featured="
				+ featured + ", image=" + image + "]";
	}
	public boolean check(ArrayList<String> cartlist, String id2) {
		for(String id : cartlist) {
			if(id.equals(id2))
				return true;
		}
		return false;
	}
	public ArrayList<String> remove(ArrayList<String> cartlist, String id) {
		for(String id1 : cartlist) {
			if(id1.equals(id1)) {
				cartlist.remove(id1);
				break;
			}
				
		}
		
		return cartlist;
	}
	
}






