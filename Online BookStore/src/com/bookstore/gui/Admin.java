package com.bookstore.gui;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

import com.bookstore.dbconnection.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class Admin {

	private JFrame frmAdmin;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection=null;
	private void initialize() {
		String database="cs521";
		//connection1=dbConnection.getDafaultConnection();
		connection=dbConnection.getConnection(database);
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 450, 300);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Customer");
		btnNewButton.setBounds(10, 11, 166, 23);
		frmAdmin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Order");
		btnNewButton_1.setBounds(232, 11, 173, 23);
		frmAdmin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Books");
		btnNewButton_2.setBounds(10, 56, 166, 23);
		frmAdmin.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Admin Profile");
		btnNewButton_3.setBounds(232, 56, 173, 23);
		frmAdmin.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 89, 385, 113);
		frmAdmin.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.setBounds(10, 227, 89, 23);
		frmAdmin.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.setBounds(170, 227, 89, 23);
		frmAdmin.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.setBounds(335, 227, 89, 23);
		frmAdmin.getContentPane().add(btnNewButton_6);
		try{
			String query="select CustomerId,FirstName,LastName,Email,Username from Customer ";
			System.out.println(query);
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet  r=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
				
			
			
			}
		catch(Exception e)
		{System.out.println(e);}
	}
}
