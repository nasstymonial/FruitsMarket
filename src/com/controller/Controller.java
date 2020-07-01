package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.Order;
import com.beans.Product;
import com.beans.User;
import com.model.DB;

/*
 * @Author Nassim Kissi
 * Servlet qui permet de gérer nos page principal
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Product> list = new ArrayList<>();
	static ArrayList<String> cartlist = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	HttpSession session;

	/*
	 * Permet de récupérer une ressource web du serveur via une URL
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null || page.equals("index")) {
			
			DB db = new DB();
			try {
				list = db.fetch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 session = request.getSession();
			 session.setAttribute("cartlist", cartlist);
			 session.setAttribute("list", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	/*
	 *  Permet de soumettre au serveur des données de tailles variables, ou que l'on sait volumineuses.
	 *  Ici on soumet au serveur plusieur données pour chacune de nos pages 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		// Si la page concerne la page de connexion
		if(page.equals("login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		// Si la page concerne la page d'inscription 
		if(page.equals("sign-up")) {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		
		// Si la page concerne le formulaire d'inscription qui se trouve dans notre page inscription
		if(page.equals("sign-up-form")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String address = request.getParameter("address");
			String password_1 = request.getParameter("password_1");
			String password_2 = request.getParameter("password_2");
			
			/*
			 * Verification des deux mots de passes pour voir ci celle-ci sont identique 
			 * Si les deux mot de passe sont identique on envoie tout dans la base de données puis on affiche un message 
			 * de confirmation sinon on envoie un message d'erreur
			 */
			if(password_1.equals(password_2)) {
				
				User user = new User();
				user.setAddress(address);
				user.setEmail(email);
				user.setName(name);
				user.setUsername(username);
				user.setPassword(password_1);
				
				DB db = new DB();
				try {
					db.addUser(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				request.setAttribute("username", username);
				request.setAttribute("msgSuccess", "Compte crée avec succès, veuillez vous connecter !");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "Les deux mots de passe ne correspondent pas");
				request.setAttribute("name", name);
				request.setAttribute("address", address);
				request.setAttribute("email", email);
				request.setAttribute("username", username);
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
			
		}
		
		/*
		 * Si la page concerne le formulaire de connexion qui se trouve dans notre page connexion
		 * Va permettre d'ouvrir une session si le status est vrai, c'est à dire mot de passe et identifiant
		 * bien enregistré dans notre BDD, renvoie faux sinon avec un message d'erreur
		 */
		if(page.equals("login-form")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			DB db = new DB();
			User user = new User();
			boolean status = false;
			try {
				status = db.checkUser(username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status) {
				session = request.getSession();
				session.setAttribute("session", session);
				
				try {
					userList = db.fetchUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				session.setAttribute("id", user.fetchid(userList, username));
				session.setAttribute("address", user.fetchadd(userList,username));
				session.setAttribute("email", user.fetchemail(userList,username));
				session.setAttribute("name", user.fetchname(userList,username));
				session.setAttribute("username", username);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Identifiants invalides");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		
		/*
		 * Si la page est égal à logout nous détruisons la session qui est actif 
		 */
		if(page.equals("logout")) {
			session = request.getSession();
			session.invalidate();
			
			 session = request.getSession();
			 cartlist.clear();
			 session.setAttribute("cartlist", cartlist);
			 session.setAttribute("list", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		/*
		 * Si la page concerne la page "mon compte" 
		 */
		if(page.equals("account")) {
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
		
		/*
		 * Si la page permet de modifier le compte
		 */
		if(page.equals("edit")) {
			String id = request.getParameter("id");
			DB account = new DB();
			User u = null;
			try {
				 u = account.fetchUser(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("u", u);
			request.getRequestDispatcher("editAccount.jsp").forward(request, response);
		}
		
		if(page.equals("edit_account")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			User u = new User();
			u.setName(name);
			u.setAddress(address);
			u.setEmail(email);
			
			DB account = new DB();
			try {
				account.updateUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msgSuccess", "Les détails de votre compte ont été mis à jour avec succès");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
		
		/*
		 * Si la pages concerne l'une des catégories des produits du site, nous faisont une redirection puis nous affichons tout nos produits à l'aide d'une list
		 * selon leurs propres catégories 
		 */
		if(page.equals("fruits") || page.equals("legumes") || page.equals("salades") || page.equals("fines-herbes") || page.equals("all-products")) {
			DB db = new DB();
			 try {
				list = db.fetch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list", list);
			
			if(page.equals("fruits"))
				request.getRequestDispatcher("fruits.jsp").forward(request, response);
			if(page.equals("legumes"))
				request.getRequestDispatcher("legumes.jsp").forward(request, response);
			if(page.equals("salades"))
				request.getRequestDispatcher("salades.jsp").forward(request, response);
			if(page.equals("fines-herbes"))
				request.getRequestDispatcher("fines-herbes.jsp").forward(request, response);
			if(page.equals("all-products"))
				request.getRequestDispatcher("all-products.jsp").forward(request, response);
		}
		
		
		/*
		 * Si la page concerne la page panier
		 */
		if(page.equals("showcart")) {
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		/*
		 * Va permettre d'ajouter les produits dans notre page panier avec un message de confirmation ou d'erreur 
		 */
		if(page.equals("addtocart")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			Product p = new Product();
			boolean check = p.check(cartlist,id);
			
			if(check)
				request.setAttribute("msg", "Le produit est déjà ajouté au panier");
			else {
				cartlist.add(id);
				request.setAttribute("msgSuccess", "Produit ajouté avec succès au panier");
			}
			
			if(action.equals("index"))
				request.getRequestDispatcher("index.jsp").forward(request, response);
			if(action.equals("allproducts"))
				request.getRequestDispatcher("all-products.jsp").forward(request, response);
			if(action.equals("salades"))
				request.getRequestDispatcher("salades.jsp").forward(request, response);
			if(action.equals("fines-herbes"))
				request.getRequestDispatcher("fines-herbes.jsp").forward(request, response);
			if(action.equals("legumes"))
				request.getRequestDispatcher("legumes.jsp").forward(request, response);
			if(action.equals("fruits"))
				request.getRequestDispatcher("fruits.jsp").forward(request, response);
		}
		
		if(page.equals("form-cart")){
			String id = request.getParameter("id");
			String total = request.getParameter("total");
			String name_user = request.getParameter("user_client"); 
			
			Order o = new Order(); 
			o.setId_user(Integer.parseInt(id));
			o.setTotal(Double.parseDouble(total));
			o.setName_user(name_user);
			
			DB account = new DB();
			try {
				account.addOrder(o);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		/*
		 * Va permettre de renvoyer un message de confirmation à l'utilisateur connecté lors de sa confirmation d'achat 
		 */
		if(page.equals("success")) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
		}
		
		/*
		 * Permet de supprimer un produit de notre panier 
		 */
		if(page.equals("remove")) {
			String id = request.getParameter("id");
			Product p = new Product();
			cartlist = p.remove(cartlist,id);
			
			session = request.getSession();
			session.setAttribute("cartlist", cartlist);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
	}

}
