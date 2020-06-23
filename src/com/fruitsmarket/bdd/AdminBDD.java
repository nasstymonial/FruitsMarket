/**
 * 
 */
package com.fruitsmarket.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fruitsmarket.beans.Products;

/**
 * @author Nass
 * Classe qui concerne les requêtes sur l'interface admin de notre site 
 */
public class AdminBDD {
	private Connection connexion; 
	
	/*
	 * Méthode pour la page inscription
	 */
	public void insererProduits(Products produit) {
		loadDatabase(); 
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO products(nom_produits, prix, type, portions, images) VALUES(?, ?, ?, ?, ?);"); 
			
			preparedStatement.setString(1, produit.getNomProduits());
			preparedStatement.setString(2, produit.getPrix());
			preparedStatement.setString(3, produit.getType());
			preparedStatement.setString(4, produit.getPortions());
			preparedStatement.setString(5, produit.getImages());
			
			preparedStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println("ERREUR CHARGEMENT DU DRIVER");
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/fruitsmarket?useSSL=false&serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
