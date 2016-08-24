package com.bookstore.model;

public class Customer extends SystemUser {
private CreditCard cd;
private ShippingAddress ad;

public CreditCard getCd() {
	return cd;
}
public void setCd(CreditCard cd) {
	this.cd = cd;
}
public ShippingAddress getAd() {
	return ad;
}
public void setAd(ShippingAddress ad) {
	this.ad = ad;
}


}
