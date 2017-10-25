package com.cg.onlineBank.dto;

public class BankCustomerBean {
	private int accountID;
	private String name;
	private String accountType;
	private String email;
	private String address;
	private String pancard;
	
	public BankCustomerBean(){
		
	}
	
	
	
	
	
	public BankCustomerBean(int accountID, String accountType) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
	}





	public BankCustomerBean(int accountID, String name, String accountType, String email, String address,
			String pancard) {
		super();
		this.accountID = accountID;
		this.name = name;
		this.accountType = accountType;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
	}



	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	
	

}
