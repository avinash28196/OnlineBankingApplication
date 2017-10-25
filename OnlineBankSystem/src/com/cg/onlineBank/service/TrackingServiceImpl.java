package com.cg.onlineBank.service;

import java.util.ArrayList;

import com.cg.onlineBank.dao.IServiceTrackerDAO;
import com.cg.onlineBank.dao.ServiceTrackerDAOImpl;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.PayeeDetailsBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;

public class TrackingServiceImpl implements ITrackingService {
	IServiceTrackerDAO dao = null;
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceDetailsByID(serviceID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceDetailsByAccountID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> statusOfAllRequest() {
		dao = new ServiceTrackerDAOImpl();
		return dao.statusOfAllRequest();
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.fetchServiceRequestID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> getRequestHistory() {
		dao = new ServiceTrackerDAOImpl();
		return dao.getRequestHistory();
	}

	@Override
	public ArrayList<BankCustomerBean> getAccountNumber(String pan) {
		dao = new ServiceTrackerDAOImpl();
		return dao.getAccountNumber(pan);
	}

	

	@Override
	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName) {
		dao = new ServiceTrackerDAOImpl();
		return dao.registerPayee(accountID,payeeAccountID,payeeAccountName);
	}

	@Override
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount) {
		dao = new ServiceTrackerDAOImpl();
		return dao.transferFund(transferFromAccount,transferToAccount,transferAmount);
	
	}

	@Override
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID) {
		dao = new ServiceTrackerDAOImpl();
		return dao.getPayeeDetails(accountID);
	}

}
