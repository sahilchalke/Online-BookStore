package com.bookstore.model;

import java.sql.Date;

public class Order {
private int order;
private Date orderDate;
private double totalPrice;
private String orderStatus;
private CreditCard cd;
private OrderState oderst;
private ShoppingCart ShopCart;
private ShippingAddress shipAddress;
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public CreditCard getCd() {
	return cd;
}
public void setCd(CreditCard cd) {
	this.cd = cd;
}
public OrderState getOderst() {
	return oderst;
}
public void setOderst(OrderState oderst) {
	this.oderst = oderst;
}
public ShoppingCart getShopCart() {
	return ShopCart;
}
public void setShopCart(ShoppingCart shopCart) {
	ShopCart = shopCart;
}
public ShippingAddress getShipAddress() {
	return shipAddress;
}
public void setShipAddress(ShippingAddress shipAddress) {
	this.shipAddress = shipAddress;
}



}
