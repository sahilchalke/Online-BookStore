package com.bookstore.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.bookstore.dbconnection.dbConnection;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreditCard {

	private JFrame frmCredit;
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
					String isbnTemp=args[0];
					CreditCard window = new CreditCard(isbnTemp);
					window.frmCredit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreditCard(String isbn) {
		initialize(isbn);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection =null;
	private void initialize(String isbn) {
		String database="cs521";
		//connection1=dbConnection.getDafaultConnection();
		connection=dbConnection.getConnection(database);
		frmCredit = new JFrame();
		frmCredit.setTitle("Credit Card");
		frmCredit.setBounds(100, 100, 491, 342);
		frmCredit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCredit.getContentPane().setLayout(null);
		
		JLabel lblCreditCard = new JLabel("Credit Card");
		lblCreditCard.setBounds(171, 29, 81, 14);
		frmCredit.getContentPane().add(lblCreditCard);
		
		JLabel lblNewLabel = new JLabel("Name on Card");
		lblNewLabel.setBounds(25, 63, 93, 14);
		frmCredit.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setBounds(25, 100, 93, 14);
		frmCredit.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Expiration Date");
		lblNewLabel_2.setBounds(25, 139, 93, 14);
		frmCredit.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Security Code");
		lblNewLabel_3.setBounds(25, 172, 93, 14);
		frmCredit.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(128, 60, 158, 20);
		frmCredit.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 97, 158, 20);
		frmCredit.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 136, 158, 20);
		frmCredit.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 169, 158, 20);
		frmCredit.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int input4;
				String input1,input2,input3;
				String queryInsertIntoCustomer = "INSERT INTO CreditCard VALUES"+" (?,?,?,?);";
				PreparedStatement pst = connection.prepareStatement(queryInsertIntoCustomer);
				input1=textField.getText();
				input2=textField_1.getText();
				input3=textField_2.getText();
				input4=Integer.parseInt(textField_3.getText());
				/*input1=Integer.parseInt((textField.getText()));
			    input2=Integer.parseInt(textField_1.getText());
			    input3=Integer.parseInt(textField_2.getText());
				input4=textField_3.getText();*/
			
				
				pst.setString(1, input1);
				pst.setString(2,input2);
				pst.setString(3, input3);
				pst.setInt(4,input4);
			
				pst.executeUpdate();
				String message="Payment Success ***Redirecting to main page***";
				JOptionPane.showMessageDialog(null, message, "Roseindia.net", 1);
				frmCredit.dispose();
				MainMenu obj= new MainMenu();
				obj.main(new String[0]);
				}
				catch(Exception exp)
				{
					
				}
			}
		});
		btnSubmit.setBounds(171, 248, 89, 23);
		frmCredit.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel_4 = new JLabel("Amount to paid ");
		lblNewLabel_4.setBounds(25, 211, 132, 14);
		frmCredit.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(184, 211, 102, 14);
		frmCredit.getContentPane().add(lblNewLabel_5);
		System.out.println(isbn);
	
	try
	{	
		int price=0;
		String query="select BookPrice from Book where BookISBN = '"+isbn+"'";
		System.out.println(query);
		PreparedStatement ps=connection.prepareStatement(query);
		ResultSet  re=ps.executeQuery();
		while(re.next()){
			price = re.getInt(1);
		}
		//String price=re.toString();
		//System.out.println(re);
		String amount= price+" ";
		lblNewLabel_5.setText(amount);
		
	}
	catch(Exception ex)
	{
		
	}
	}
}
