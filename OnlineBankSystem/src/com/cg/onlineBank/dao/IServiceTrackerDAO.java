package com.cg.onlineBank.dao;

import java.util.ArrayList;

import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.PayeeDetailsBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;

public interface IServiceTrackerDAO {
	
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID);
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID);
	public ArrayList<ServiceTrackerBean> statusOfAllRequest();
	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID);
	public ArrayList<ServiceTrackerBean> getRequestHistory();
	public ArrayList<BankCustomerBean> getAccountNumber(String pan);
	

	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName);
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount);
	
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID);
	
}
