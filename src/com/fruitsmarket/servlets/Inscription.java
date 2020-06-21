package com.fruitsmarket.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitsmarket.bdd.Client;
import com.fruitsmarket.beans.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur(); 
		
		utilisateur.setType(request.getParameter("type"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setMail(request.getParameter("mail"));
		utilisateur.setPassword(request.getParameter("motdepasse"));
		utilisateur.setAdresse(request.getParameter("adresse"));
		utilisateur.setComplementAdresse(request.getParameter("complement_adresse"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setCodePostal(request.getParameter("code_postal"));
		utilisateur.setTelephone(request.getParameter("telephone"));
		
		Client tableClients = new Client(); 
		tableClients.creerUtilisateur(utilisateur);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response); 
		
	}

}
