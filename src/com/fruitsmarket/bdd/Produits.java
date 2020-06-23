/**
 * 
 */
package com.fruitsmarket.bdd;

import java.util.*;

import com.fruitsmarket.beans.Products;

import java.sql.*;

/**
 * @author Nass
 * Objet qui repr�sente la connexion � la base de donn�es et �x�cute les requ�tes SQL pour nos produits
 */
public class Produits {
	
	private Connection connexion; 
	
	/*
	 * M�thode qui va permettre de faire des requ�te SQL dans la BDD et va cr�e un array produits
	 */
	public List<Products> recupererProduits() {
		List<Products> products = new ArrayList<Products>();
		Statement statement = null; 
		ResultSet resultat = null; 
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement(); 
			
			// Ex�cution de la requ�te 
			resultat = statement.executeQuery("SELECT id, nom_produits, prix, portions, type, images FROM products ORDER BY nom_produits"); 
			
			// r�cup�ration des donn�es
			while (resultat.next()) {
				// R�cup�re les entr�e 
				int id = resultat.getInt("id");
				String nomProduits = resultat.getString("nom_produits");
				String prix = resultat.getString("prix"); 
				String portions = resultat.getString("portions");
				String type = resultat.getString("type"); 
				String image = resultat.getString("images"); 
				
				// D�finissions du nom produits et du prix r�cup�rer dans la BDD 
				Products product = new Products(); 
				product.setId(id);
				product.setNomProduits(nomProduits);
				product.setPrix(prix);
				product.setPortions(portions);
				product.setType(type);
				product.setImages(image);
				
				// Ajout dans la liste 
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Erreur sur la requ�te SQL");
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
		
		return products; 
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
