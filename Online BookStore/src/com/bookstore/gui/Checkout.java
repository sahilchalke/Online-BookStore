package com.bookstore.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.bookstore.dbconnection.dbConnection;

import javax.swing.JButton;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checkout {
    //private String isbnVal;
	private JFrame frmCheckout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String temp;
					temp = args[0];
					Checkout window1 = new Checkout(temp);

					//Checkout window = new Checkout();
					window1.frmCheckout.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public Checkout (String isbnval)
	{
		this.isbnVal=isbnval;
	}*/
	public Checkout(String isbnval) {
		
		initialize(isbnval);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection=null;
	private JTable table;
	private void initialize(String isbn) {
		String isbnval;
		isbnval=isbn;
		String database="cs521";
		//connection1=dbConnection.getDafaultConnection();
		connection=dbConnection.getConnection(database);
		frmCheckout = new JFrame();
		frmCheckout.setTitle("Checkout");
		frmCheckout.setBounds(100, 100, 450, 300);
		frmCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckout.getContentPane().setLayout(null);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setBounds(21, 24, 132, 14);
		frmCheckout.getContentPane().add(lblBookDetails);
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row= table.getSelectedRow();
				//String price= table.getModel().getValueAt(row, 0).toString();
				String isbnVal=table.getModel().getValueAt(row, 1).toString();
				frmCheckout.dispose();
				CreditCard checkOut=new CreditCard(isbnVal);
				checkOut.main(new String []{isbnVal});
				
			}
		});
		btnCheckout.setBounds(290, 209, 89, 23);
		frmCheckout.getContentPane().add(btnCheckout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 61, 401, 55);
		frmCheckout.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		try{
			String query="select BookName,BookISBN,BookAuthor,BookDescription,BookPrice from Book where BookISBN = '"+isbnval+"'";
			System.out.println(query);
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet  r=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
				
			
			
			}
		catch(Exception e)
		{System.out.println(e);}
		
		
		
		
		
	}
}
