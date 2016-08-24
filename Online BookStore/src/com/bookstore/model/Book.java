package com.bookstore.model;

public class Book {

private int isbn;
private String author; 
private String bookName; 
private String catagory;
private double price;
private int count;


public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
} 


}
