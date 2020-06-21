/**
 * 
 */
package com.fruitsmarket.bdd;

import java.sql.*;

import com.fruitsmarket.beans.Utilisateur;

/**
 * @author Nass
 * Objet qui représente la connexion à la base de données et éxécute les requêtes SQL pour les clients 
 */
public class Client {
	
	private Connection connexion; 
	
	public void creerUtilisateur(Utilisateur utilisateur) {
		loadDatabase(); 
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO users(type, nom_user, prenom_user, mail_user, motdepasse, adresse_user, complement_adresse_user, ville_client, codepostal_client, tel_client) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"); 
			
			preparedStatement.setString(1, utilisateur.getType());
			preparedStatement.setString(2, utilisateur.getNom());
			preparedStatement.setString(3, utilisateur.getPrenom());
			preparedStatement.setString(4, utilisateur.getMail());
			preparedStatement.setString(5, utilisateur.getPassword());
			preparedStatement.setString(6, utilisateur.getAdresse());
			preparedStatement.setString(7, utilisateur.getComplementAdresse());
			preparedStatement.setString(8, utilisateur.getVille());
			preparedStatement.setString(9, utilisateur.getCodePostal());
			preparedStatement.setString(10, utilisateur.getTelephone());
			
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
