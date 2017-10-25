package com.cg.onlineBank.dto;

public class PayeeDetailsBean {
	
	private int accountID;
	private int payeeAccountID;
	private String payeeAccountName;
	
	public PayeeDetailsBean() {
		
	}

	public PayeeDetailsBean(int accountID, int payeeAccountID, String payeeAccountName) {
		super();
		this.accountID = accountID;
		this.payeeAccountID = payeeAccountID;
		this.payeeAccountName = payeeAccountName;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getPayeeAccountID() {
		return payeeAccountID;
	}

	public void setPayeeAccountID(int payeeAccountID) {
		this.payeeAccountID = payeeAccountID;
	}

	public String getPayeeAccountName() {
		return payeeAccountName;
	}

	public void setPayeeAccountName(String payeeAccountName) {
		this.payeeAccountName = payeeAccountName;
	}

	@Override
	public String toString() {
		return "PayeeDetailsBean [accountID=" + accountID + ", payeeAccountID=" + payeeAccountID + ", payeeAccountName="
				+ payeeAccountName + "]";
	}
	
	
	
	

}
