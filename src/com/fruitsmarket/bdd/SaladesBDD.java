package com.fruitsmarket.bdd;

import java.sql.*;
import java.util.*;

import com.fruitsmarket.beans.Products;

/**
 * @author Nass
 *
 */
public class SaladesBDD {
private Connection connexion; 
	
	/*
	 * Méthode qui va permettre de faire des requête SQL dans la BDD et va crée un array produits
	 */
	public List<Products> recupererSalades() {
		List<Products> productsSalades = new ArrayList<Products>();
		Statement statement = null; 
		ResultSet resultat = null; 
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement(); 
			
			// Exécution de la requête 
			resultat = statement.executeQuery("SELECT id, nom_produits, prix, portions, images FROM products WHERE type='salades' ORDER BY nom_produits"); 
			
			// récupération des données
			while (resultat.next()) {
				// Récupére les entrée 
				int id = resultat.getInt("id");
				String nomProduits = resultat.getString("nom_produits");
				String prix = resultat.getString("prix"); 
				String portions = resultat.getString("portions");
				String image = resultat.getString("images"); 
				
				// Définissions du nom produits et du prix récupérer dans la BDD 
				Products product = new Products(); 
				product.setId(id);
				product.setNomProduits(nomProduits);
				product.setPrix(prix);
				product.setPortions(portions);
				product.setImages(image);
				
				// Ajout dans la liste 
				productsSalades.add(product);
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
		
		return productsSalades; 
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
