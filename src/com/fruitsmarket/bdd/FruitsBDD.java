package com.fruitsmarket.bdd;

import java.util.*;

import com.fruitsmarket.beans.Products;

import java.sql.*;

/**
 * @author Nass
 * Objet qui représente la connexion à la base de données et éxécute les requêtes SQL pour nos produits
 */
public class FruitsBDD {
	
	private Connection connexion; 
	
	/*
	 * Méthode qui va permettre de faire des requête SQL dans la BDD et va crée un array produits
	 */
	public List<Products> recupererFruits() {
		List<Products> productsFruits = new ArrayList<Products>();
		Statement statement = null; 
		ResultSet resultat = null; 
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement(); 
			
			// Exécution de la requête 
			resultat = statement.executeQuery("SELECT id, nom_produits, prix FROM products WHERE type='fruits' ORDER BY nom_produits"); 
			
			// récupération des données
			while (resultat.next()) {
				// Récupére les entrée 
				int id = resultat.getInt("id");
				String nomProduits = resultat.getString("nom_produits");
				double prix = resultat.getDouble("prix"); 
				
				// Définissions du nom produits et du prix récupérer dans la BDD 
				Products product = new Products(); 
				product.setId(id);
				product.setNomProduits(nomProduits);
				product.setPrix(prix);
				
				// Ajout dans la liste 
				productsFruits.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Erreur sur la requête SQL");
		} finally {
			// fermeture de la connexion
			try {
				if(resultat != null) {
					resultat.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(connexion != null) {
					connexion.close();
				}
			} catch (SQLException ignore) {
				
			}
		}
		
		return productsFruits; 
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