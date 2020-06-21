/**
 * 
 */
package com.fruitsmarket.beans;

/**
 * @author Nass
 *
 */
public class Products {
	private int id; 
	private String nomProduits; 
	private double prix;
	private String type; 
	
	/*
	 * GETTERS ET SETTERS
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomProduits() {
		return nomProduits;
	}
	
	public void setNomProduits(String nomProduits) {
		this.nomProduits = nomProduits;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
