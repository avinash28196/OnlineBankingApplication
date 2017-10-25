package com.cg.onlineBank.service;

import java.util.ArrayList;

import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.PayeeDetailsBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;

public interface ITrackingService {

	ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID);
	ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID);
	ArrayList<ServiceTrackerBean> statusOfAllRequest();
	ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID);
	ArrayList<ServiceTrackerBean> getRequestHistory();
	
	ArrayList<BankCustomerBean> getAccountNumber(String pan);
	
	
	int registerPayee(int accountID, int payeeAccountID, String payeeAccountName);
	int transferFund(int transferFromAccount, int transferToAccount, int transferAmount);
	
	
	ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID);

}
