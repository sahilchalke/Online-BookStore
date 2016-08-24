package com.bookstore.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerProfile {

	private JFrame frmCustomerProfile;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerProfile window = new CustomerProfile();
					window.frmCustomerProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerProfile = new JFrame();
		frmCustomerProfile.setTitle("Update Customer Profile");
		frmCustomerProfile.setBounds(100, 100, 450, 300);
		frmCustomerProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerProfile.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Profile");
		lblNewLabel.setBounds(182, 11, 79, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setBounds(10, 42, 79, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(10, 67, 79, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(10, 92, 79, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(10, 117, 59, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("User Name");
		lblNewLabel_5.setBounds(10, 140, 59, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(10, 165, 46, 14);
		frmCustomerProfile.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(107, 39, 138, 20);
		frmCustomerProfile.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 64, 138, 20);
		frmCustomerProfile.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 89, 138, 20);
		frmCustomerProfile.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 114, 138, 20);
		frmCustomerProfile.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(107, 137, 138, 20);
		frmCustomerProfile.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 162, 138, 20);
		frmCustomerProfile.getContentPane().add(passwordField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(302, 202, 89, 23);
		frmCustomerProfile.getContentPane().add(btnUpdate);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerProfile.dispose();
				MainMenu window = new MainMenu();
				window.main(new String[0]);
			}
		});
		btnMainMenu.setBounds(190, 202, 89, 23);
		frmCustomerProfile.getContentPane().add(btnMainMenu);
	}
}
