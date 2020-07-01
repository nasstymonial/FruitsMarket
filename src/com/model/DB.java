package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Order;
import com.beans.Product;
import com.beans.User;

/*
 * @author Nassim Kissi
 * Class qui représente la connexion à notre base de données ainsi que ses requêtes 
 */
public class DB {
	
	private String username = "root";
	private String password = "";
	private String dbName = "fruitsmarket";
	private String url = "jdbc:mysql://localhost:3308/" + dbName + "?useSSL=false&serverTimezone=UTC";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	ArrayList<Product> list = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	
	private Connection con;
	
	/*
	 * Méthode permettant de connecter la BDD 
	 */
	private void dbConnect() {
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Méthode permettant de fermer la BDD 
	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * Méthode qui appel une requête SQL afin d'ajouter un utilisateur
	 */
	public void addUser(User user) throws SQLException {
		dbConnect();
		String sql = "Insert into user(name,email,username,address,password) values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getUsername());
		st.setString(4, user.getAddress());
		st.setString(5, user.getPassword());
		
		
		st.executeUpdate();
		dbClose();
	}

	/*
	 * Méthode qui appel une requête SQL afin de selectionner tout les utilisateur
	 * Va renvoyer true si il existe, false sinon
	 */
	public boolean checkUser(String username, String password) throws SQLException {
		dbConnect();
		int count = 0;
		String sql = "Select * from user where username = ? and password = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			count = 1;
		}
		
		dbClose();
		if(count == 0)
			return false;
		
		return true;
	}

	/*
	 * Méthode qui appel une requête SQL afin de selectionner tout les produit
	 * et va stocker chaque produit dans une ArrayList
	 */
	public ArrayList<Product> fetch() throws SQLException {
		dbConnect();
		String sql = "Select * from product order by name";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name= rs.getString("name");
			String category= rs.getString("category");
			Double price= rs.getDouble("price");
			String featured= rs.getString("featured");
			int stock = rs.getInt("stock");
			String image= rs.getString("image");
			
			Product p = new Product();
			p.setCategory(category);
			p.setFeatured(featured);
			p.setId(id);
			p.setStock(stock);
			p.setImage(image);
			p.setName(name);
			p.setPrice(price);
			list.add(p);
			p=null;
			
		}
		
		dbClose();
		return list;
	}

	public ArrayList<User> fetchUser() throws SQLException {
		dbConnect();
		String sql = "Select * from user";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String address = rs.getString("address");
			String user = rs.getString("username");
			String email = rs.getString("email");
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String password = rs.getString("password");
			
			User u = new User();
			u.setAddress(address);
			u.setEmail(email);
			u.setId(id);
			u.setName(name);
			u.setUsername(user);
			u.setPassword(password);
			userList.add(u);
			u=null;
				
		}
		
		dbClose();
		return userList;
	}
	
	public User fetchUser(String id) throws SQLException {
		dbConnect();
		String sql = "select * from user where email=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		User u = new User(); 
		while(rst.next()){
			
			u.setId(rst.getInt("id"));
			u.setName(rst.getString("name"));
			u.setAddress(rst.getString("address"));
			u.setEmail(rst.getString("email"));
		}
		dbClose();
		return u;
	}
	
	/*
	 * Méthode qui appel une requête SQL afin de mettre à jour l'utilisateur selon son ID
	 * @Todo : Méthode pas encore finalisé 
	 */
	public void updateUser(User u) throws SQLException {
		dbConnect();
		String sql = "update user set name=?,address=?, email=? where id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, u.getName());
		st.setString(2, u.getAddress());
		st.setString(3, u.getEmail());
		st.setInt(4, u.getId());
		st.executeUpdate();
		dbClose();
	}

	/*
	 * Méthode qui appel une requête SQL afin de supprimé un produit selon son ID
	 * Cette méthode sera appelé dans l'interface admin 
	 */
	public void deleteProduct(String id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from product where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
		
	}

	/*
	 * Méthode qui appel une requête SQL afin de chercher le produit concernant selon son id
	 */
	public Product fetchProduct(String id) throws SQLException {
		dbConnect();
		String sql = "select * from product where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		Product p = new Product();
		while(rst.next()){
			
			p.setId(rst.getInt("id"));
			p.setName(rst.getString("name"));
			p.setPrice(rst.getDouble("price"));
			p.setCategory(rst.getString("category"));
			p.setFeatured(rst.getString("featured"));
			p.setStock(rst.getInt("stock"));
			p.setImage(rst.getString("image"));
		}
		dbClose();
		return p;
	}

	/*
	 * Méthode qui appel une requête SQL afin de mettre à jour le produit selon son ID
	 */
	public void updateProduct(Product p) throws SQLException {
		dbConnect();
		String sql = "update product set name=?,price=?,category=?,featured=?, stock=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, p.getName());
		st.setDouble(2, p.getPrice());
		st.setString(3, p.getCategory());
		st.setString(4, p.getFeatured());
		st.setInt(5, p.getStock());
		st.setInt(6, p.getId());
		st.executeUpdate();
		dbClose();
	}

	/*
	 * Méthode qui appel une requête SQL afin d'insérer un nouveau produit
	 */
	public void addProduct(Product p) throws SQLException {
		dbConnect();
		String sql = "Insert into product(name,price,category,featured,stock, image) values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, p.getName());
		st.setDouble(2, p.getPrice());
		st.setString(3, p.getCategory());
		st.setString(4, p.getFeatured());
		st.setInt(5, p.getStock());
		st.setString(6, p.getImage());
		
		
		st.executeUpdate();
		dbClose();
	}
	
	public void addOrder(Order o) throws SQLException {
		dbConnect();
		String sql = "INSERT INTO `order`(`date_order`, `total`, `id_user`, `name_user`) VALUES (?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		st.setDouble(2, o.getTotal());
		st.setInt(3, o.getId_user());
		st.setString(4, o.getName_user());
		
		
		st.executeUpdate();
		dbClose();
	}
	
	public void deleteOrder(String id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from `order` where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
		
	}

	
	
	
}
