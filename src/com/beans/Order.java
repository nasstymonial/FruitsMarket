/**
 * 
 */
package com.beans;

/**
 * @author Nass
 *
 */
public class Order {

	private int id; 
	private int id_user; 
	private String name_user; 
	private double total;
	private String list_product; 
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getList_product() {
		return list_product;
	}
	public void setList_product(String list_product) {
		this.list_product = list_product;
	} 
	
	
}
