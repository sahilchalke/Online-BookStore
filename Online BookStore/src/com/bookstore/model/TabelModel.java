package com.bookstore.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookstore.dbconnection.dbConnection;

public class TabelModel {

	Connection con =null;
	public void insertIntoTbale()
	{String database="cs521";
	//connection1=dbConnection.getDafaultConnection();
	con=dbConnection.getConnection(database);
	Admin admin = new Admin();
	Book book =new Book();
	BookStoreModel bookStore =new BookStoreModel();
	CreditCard creditCard =new CreditCard();
	Customer customer = new Customer();
	Order order =new Order();
	OrderState orderState =new OrderState();
	ShippingAddress shippingAddress=new ShippingAddress();
	ShoppingCart shopCart =new ShoppingCart();
	SystemUser user =new SystemUser();

	try{
		String query="insert into Customer values("+customer.getFirstName()+", "+
				customer.getLastName()+","+customer.getEmailId()+", "+customer.getUserName()+
				", "+customer.getPassqord()+")";

		PreparedStatement ps=con.prepareStatement(query);
		int  r=ps.executeUpdate();


		String query1="insert into Book value("+book.getBookName()+", "+book.getIsbn()
		+", "+book.getAuthor()+", "+book.getPrice()+", "+book.getCount();
		PreparedStatement ps1=con.prepareStatement(query);
		int  r1=ps1.executeUpdate();


	}
	catch(Exception e){}





	}

	
}
