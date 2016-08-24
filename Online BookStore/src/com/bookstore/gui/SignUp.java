package com.bookstore.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;


import com.bookstore.dbconnection.dbConnection;


public class SignUp {

	private JFrame frmSignup;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frmSignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con=null;
	private void initialize() {
		String database="cs521";
		con=dbConnection.getConnection(database);
		frmSignup = new JFrame();
		frmSignup.setTitle("SignUp");
		frmSignup.setBounds(100, 100, 450, 300);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignup.getContentPane().setLayout(null);
		
		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setBounds(164, 11, 220, 14);
		frmSignup.getContentPane().add(lblCustomerInformation);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(21, 47, 102, 14);
		frmSignup.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(21, 71, 87, 14);
		frmSignup.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(21, 96, 46, 14);
		frmSignup.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("User Name");
		lblNewLabel_4.setBounds(21, 117, 87, 14);
		frmSignup.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(21, 142, 75, 14);
		frmSignup.getContentPane().add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 139, 129, 20);
		frmSignup.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(127, 44, 129, 20);
		frmSignup.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 68, 129, 20);
		frmSignup.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 93, 129, 20);
		frmSignup.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 114, 130, 20);
		frmSignup.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSignup.dispose();
				MainMenu obj= new MainMenu();
				obj.main(new String[0]);
			}
		});
		btnNewButton.setBounds(295, 193, 89, 23);
		frmSignup.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String insertIntoCustomerReservationQuery = "INSERT INTO customerReservation VALUES "
						+ "(?, ?);";
				try {
					PreparedStatement pst = connection.prepareStatement(insertIntoCustomerReservationQuery);
					pst.setInt(1,customerId);
					pst.setInt(2, reservationId);
					pst.executeUpdate();*/
				try
				{
					String input2,input3,input4,input5,input6;
					//int input1;
					//input1=10035;
					input2=textField.getText();
					input3=textField_1.getText();
					input4=textField_2.getText();
					input5=textField_3.getText();
					input6=passwordField.getText();
					
					
				String queryInsertIntoCustomer = "INSERT INTO Customer (FirstName,LastName,Email,Username,Password) VALUES"+" (?,?,?,?,?);";
				PreparedStatement pst = con.prepareStatement(queryInsertIntoCustomer);
				//pst.setInt(1,input1);
				pst.setString(1, input2);
				pst.setString(2,input3);
				pst.setString(3, input4);
				pst.setString(4,input5);
				pst.setString(5, input6);
				pst.executeUpdate();
				String message="Congrats Account Created ***Happy Shopping***";
				JOptionPane.showMessageDialog(null, message, "Roseindia.net", 1);
				//JOptionPane.showMessageDialog(frame,
					  //  "Eggs are not supposed to be green.");
				frmSignup.dispose();
				MainMenu obj= new MainMenu();
				obj.main(new String[0]);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton_1.setBounds(102, 193, 124, 23);
		frmSignup.getContentPane().add(btnNewButton_1);
	}
}
