package com.bookstore.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.bookstore.dbconnection.dbConnection;

import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookSearch {

	private JFrame frmSearchBook;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String temp=args[0];
					BookSearch window = new BookSearch(temp);
					window.frmSearchBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookSearch(String isbn) {
		initialize(isbn);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection=null;
	private void initialize(String isbn) {
		String database="cs521";
		//connection1=dbConnection.getDafaultConnection();
		connection=dbConnection.getConnection(database);
		frmSearchBook = new JFrame();
		frmSearchBook.setTitle("Search Book");
		frmSearchBook.setBounds(100, 100, 711, 300);
		frmSearchBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearchBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setBounds(10, 11, 91, 14);
		frmSearchBook.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ISBN");
		rdbtnNewRadioButton.setBounds(10, 30, 109, 23);
		frmSearchBook.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Auther Name");
		rdbtnNewRadioButton_1.setBounds(10, 52, 109, 23);
		frmSearchBook.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Book Name");
		rdbtnNewRadioButton_2.setBounds(10, 79, 109, 23);
		frmSearchBook.getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(10, 176, 89, 23);
		frmSearchBook.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 11, 525, 110);
		frmSearchBook.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSearchBook.dispose();
				MainMenu obj= new MainMenu();
				obj.main(new String[0]);
			}
		});
		btnNewButton_1.setBounds(526, 212, 89, 23);
		frmSearchBook.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Category");
		rdbtnNewRadioButton_3.setBounds(10, 102, 109, 23);
		frmSearchBook.getContentPane().add(rdbtnNewRadioButton_3);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 150, 20);
		frmSearchBook.getContentPane().add(textField);
		textField.setColumns(10);
		
		try{
			String query="select BookName,BookISBN,BookAuthor,BookDescription,BookPrice from Book where BookISBN = '"+isbn+"'";
			System.out.println(query);
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet  r=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
				
			
			
			}
		catch(Exception e)
		{System.out.println(e);}
		
	}
}
