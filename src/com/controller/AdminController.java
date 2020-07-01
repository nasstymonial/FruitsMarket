package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.beans.Product;
import com.model.DB;

/*
 * @Author Nassim Kissi
 * Servlet qui permet de g�rer nos pages admin 
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
	public static final String FILE_PATH = "C:\\Users\\Nass\\eclipse-workspace\\Fruits_Market\\WebContent\\images\\"; // A adapter
	
	/*
	 * Permet de r�cup�rer une ressource web du serveur via une URL
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null) {
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);;
		}else {
			doPost(request, response);
		}
	}

	/*
	 *  Permet soumettre au serveur des donn�es de tailles variables, ou que l'on sait volumineuses.
	 *  Ici on soumet au serveur plusieur donn�es pour chacune de nos pages admin
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("admin-login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			if(username.equals("root") && password.equals("toor")) {
				
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);

			}
			else {
				request.setAttribute("msg", "Identifiants invalides");
				request.setAttribute("username", username);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);

			}
		}
		
		if(page.equals("delete")) {
			String id = request.getParameter("id");
			DB db = new DB();
			try {
				db.deleteProduct(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("msgSuccess", "Produits supprim� avec succ�s");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("order")) {
			request.getRequestDispatcher("admin/order.jsp").forward(request, response);
		}
		
		if(page.equals("delete_order")) {
			String id = request.getParameter("id");
			DB db = new DB();
			try {
				db.deleteOrder(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("msgSuccess", "Commande annul� avec succ�s");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		if(page.equals("index")) {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("addproduct")) {
			request.getRequestDispatcher("admin/addProduct.jsp").forward(request, response);
		}
		
		if(page.equals("edit")) {
			String id = request.getParameter("id");
			DB account = new DB();
			Product p = null;
			try {
				 p = account.fetchProduct(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("p", p);
			request.getRequestDispatcher("admin/editProduct.jsp").forward(request, response);
		}
		
		if(page.equals("edit_product")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String featured = request.getParameter("featured");
			String stock = request.getParameter("stock"); 
			Product p = new Product();
			p.setId(Integer.parseInt(id));
			p.setName(name);
			p.setPrice(Double.parseDouble(price));
			p.setCategory(category);
			p.setFeatured(featured);
			p.setStock(Integer.parseInt(stock)); 
			
			DB account = new DB();
			try {
				account.updateProduct(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msgSuccess", "Les d�tails du produit ont �t� mis � jour avec succ�s");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("add_product")){
			// On r�cup�re le nom du fichier
			Part part = request.getPart("image"); 
			
			// On v�rifie qu'on a bien recu un fichier
			String nameFile = getNameFile(part); 
			
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String featured = request.getParameter("featured");
			String stock = request.getParameter("stock"); 
			Product p = new Product();
			p.setName(name);
			p.setPrice(Double.parseDouble(price));
			p.setCategory(category);
			p.setFeatured(featured);
			p.setStock(Integer.parseInt(stock));
			
			// Si on a bien un fichier
			if (nameFile != null && !nameFile.isEmpty()) {
				String fieldName = part.getName(); 
				// Corrige un bug du fonctionnement d'Internet Explorer
				 nameFile = nameFile.substring(nameFile.lastIndexOf('/') + 1)
		                    .substring(nameFile.lastIndexOf('\\') + 1);
				 
	            // On �crit d�finitivement le fichier sur le disque
	            writeFile(part, nameFile, FILE_PATH);

	            request.setAttribute(fieldName, nameFile);
			}
			p.setImage("images/"+ nameFile);
			
			DB account = new DB();
			try {
				account.addProduct(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msgSuccess", "Produit ajout� avec succ�s");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
	}

	/*
	 * M�thode utilitaire qui a pour but d'�crire le fichier pass� en param�tre
	 * sur le disque, dans le r�pertoire donn� et avec le nom donn�.
	 */
	private void writeFile(Part part, String nameFile, String path) throws IOException {
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try {
        	input = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            output = new BufferedOutputStream(new FileOutputStream(new File(path + nameFile)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = input.read(tampon)) > 0) {
                output.write(tampon, 0, longueur);
            }
        } finally {
            try {
                output.close();
            } catch (IOException ignore) {
            }
            try {
                input.close();
            } catch (IOException ignore) {
            }
        }		
	}
	
    /*
     * M�thode utilitaire qui a pour unique but d'analyser l'en-t�te
     * "content-disposition", et de v�rifier si le param�tre "filename" y est
     * pr�sent. Si oui, alors le champ trait� est de type File et la m�thode
     * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
     * la m�thode retourne null.
     */
	private static String getNameFile(Part part) {
		// Boucle sur chacun des param�tres de l'en-t�te "content-disposition".
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
        	// Recherche de l'�ventuelle pr�sence du param�tre "filename".
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est pr�sent, alors renvoi de sa valeur,
                 * c'est-�-dire du nom de fichier sans guillemets.
                 */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        // Si rien n'a �t� trouv� 
		return null;
	}

}
