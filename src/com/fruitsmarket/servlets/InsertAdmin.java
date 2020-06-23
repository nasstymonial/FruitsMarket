package com.fruitsmarket.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fruitsmarket.bdd.AdminBDD;
import com.fruitsmarket.beans.Products;

/**
 * Servlet implementation class InsertAdmin
 */
@WebServlet("/InsertAdmin")
public class InsertAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHIERS = "C:\\Users\\Nass\\eclipse-workspace\\Fruits_Market\\WebContent\\images\\";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/insert.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On r�cup�re le champ du fichier
		Part part = request.getPart("image");
		
		// On v�rifie qu'on a bien re�u un fichier
		String nomFichier = getNomFichier(part);
		
		Products produit = new Products(); 
		
		produit.setNomProduits(request.getParameter("nom"));
		produit.setPortions(request.getParameter("portion"));
		produit.setPrix(request.getParameter("prix"));
		produit.setType(request.getParameter("categorie"));
        
        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On �crit d�finitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
        }
        produit.setImages("images/" + nomFichier);
		
		AdminBDD insertion = new AdminBDD();
		insertion.insererProduits(produit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin/indexAdmin.jsp").forward(request, response); 
	}
	
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   

}
