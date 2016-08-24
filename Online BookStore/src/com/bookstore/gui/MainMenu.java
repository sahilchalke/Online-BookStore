package com.bookstore.gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bookstore.dbconnection.dbConnection;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu  {

	private JFrame frmBookStore;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmBookStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection=null;
	Connection connection1=null;
	private void initialize() {
		
		
		
		
		String database="cs521";
		//connection1=dbConnection.getDafaultConnection();
		connection=dbConnection.getConnection(database);
		frmBookStore = new JFrame();
		frmBookStore.setTitle("BOOK STORE");
		frmBookStore.setBounds(100, 100, 678, 352);
		frmBookStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookStore.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK STORE");
		lblNewLabel.setBounds(175, 11, 136, 14);
		frmBookStore.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBookStore.dispose();
				Login window2 = new Login();
				window2.main(new String[0]);
			}
		});
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(27, 184, 110, 14);
		frmBookStore.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(175, 184, 204, 14);
		frmBookStore.getContentPane().add(lblNewLabel_2);
		btnNewButton.setBounds(336, 7, 101, 23);
		frmBookStore.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBookStore.dispose();
				SignUp signUp=new SignUp();
				signUp.main(new String [0]);
			}
		});
		btnNewButton_1.setBounds(447, 7, 110, 23);
		frmBookStore.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Book Search");
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 55, 642, 93);
		frmBookStore.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(43, 273, 46, 14);
		frmBookStore.getContentPane().add(lblNewLabel_3);
		
		table = new JTable();
		//String isbnVal1 = new String ();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					//System.out.println("test");
					int row= table.getSelectedRow();
					String bookName= table.getModel().getValueAt(row, 0).toString();
					String isbnVal=table.getModel().getValueAt(row, 1).toString();
					
					//System.out.println(bookName);
					/*lblNewLabel_1.setEnabled(true);
					lblNewLabel_2.setEnabled(true);
					lblNewLabel_2.setText(bookName);*/
					lblNewLabel_1.setEnabled(true);
					lblNewLabel_1.setText("Book Selected");
					lblNewLabel_2.setEnabled(true);
					lblNewLabel_2.setText(bookName);
					lblNewLabel_3.setText(isbnVal);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbnvalTemp;
				isbnvalTemp=lblNewLabel_3.getText();
				
				Checkout checkOut=new Checkout(isbnvalTemp);
				checkOut.main(new String []{isbnvalTemp});
				//System.out.println(isbnvalTemp);
				frmBookStore.dispose();
			}
		});
		btnNewButton_3.setBounds(402, 220, 130, 23);
		frmBookStore.getContentPane().add(btnNewButton_3);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//eventMouse();
				String isbnvalTemp;
				isbnvalTemp=lblNewLabel_3.getText();
				
				BookSearch checkOut=new BookSearch(isbnvalTemp);
				checkOut.main(new String []{isbnvalTemp});
				frmBookStore.dispose();
				
				
				
			
			
			}
		});
		btnNewButton_2.setBounds(213, 220, 110, 23);
		frmBookStore.getContentPane().add(btnNewButton_2);
		
		
		
		try{
			String query="select * from Book";
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet  r=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			
			
			}
		catch(Exception e)
		{}
		//DbUtils.resultSetToTableModel(r).getDataVector().elementAt(table.getSelectedRow());
		
	
	}
	 
	/*public void eventMouse()
	{  
	}*/
}
