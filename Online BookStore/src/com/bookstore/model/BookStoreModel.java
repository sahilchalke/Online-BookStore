package com.bookstore.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookStoreModel {
	
	private String setTable;
	private String convertModel;
	public String getSetTable() {
		return setTable;
	}
	public void setSetTable(String setTable) {
		this.setTable = setTable;
	}
	public String getConvertModel() {
		return convertModel;
	}
	public void setConvertModel(String convertModel) {
		this.convertModel = convertModel;
	}
	
	public boolean checkStatus(String setTable)
	{
		int a,b;
	    
		String temp ;
		TabelModel tbMD=new TabelModel();
		tbMD.insertIntoTbale();
		//Stub
		
		
		return true;
	}
	
	Connection con =null;
	
	 public BookStoreModel() {
		
		// TODO Auto-generated constructor stub
	}

}
