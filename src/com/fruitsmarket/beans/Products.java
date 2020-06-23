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
	private String prix;
	private String type; 
	private String portions; 
	private String images; 
	

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
	
	public String getPrix() {
		return prix;
	}
	
	public void setPrix(String string) {
		this.prix = string;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getPortions() {
		return portions;
	}

	public void setPortions(String portions) {
		this.portions = portions;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
}
