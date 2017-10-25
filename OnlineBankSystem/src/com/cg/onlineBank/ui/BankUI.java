package com.cg.onlineBank.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.onlineBank.dao.ServiceTrackerDAOImpl;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.PayeeDetailsBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;
import com.cg.onlineBank.service.ITrackingService;
import com.cg.onlineBank.service.TrackingServiceImpl;

public class BankUI {
	
	static Scanner scan = null;
	static ServiceTrackerBean bean = null;
	static BankCustomerBean cBean = null;
	static ITrackingService service = null;
	
	
	public static void main(String[] args){
		
		service = new TrackingServiceImpl();
		scan = new Scanner(System.in);
		
		System.out.println("Online Banking System");
		System.out.println("***********************************");
		
		while(true)
		{
			System.out.println("1.Service Tracking System");
			System.out.println("2.Fund Transaction System");
			
			
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				serviceTrackingSystem();
				
				break;
			case 2:
				fundTransferSystem();
				break;
			default:
				System.exit(0);
				break;
				
			}
		
		
	}
}


	private static void serviceTrackingSystem() {
		
		System.out.println("Service Tracking System");
		System.out.println("***********************************");
		while(true)
		{
			System.out.println("1.To select Account Number and to know Request.");
			System.out.println("2.Enter the service request number");
			System.out.println("3.To check the stauts of all service Request");
			System.out.println("4.To Enter A/C Number");
			System.out.println("5.20 Service Request raised in last 180 days");
			
			
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				fetchServiceRequestID();
				break;
			case 2:
				fetchServiceDetailsByID();
				break;
			case 3:
				statusOfAllRequest();
				break;
			case 4:
				fetchServiceDetailsByAccountID();
				break;
			case 5:
				getRequestHistory();
				break;
			default:
				System.exit(0);
				break;
				
			}
			
		}
		
	}


	private static void fundTransferSystem() {
		System.out.println("Fund Transfer System");
		System.out.println("***********************************");
		System.out.println("Conform you are Account Number");
		int accountID = scan.nextInt();		
		
		while(true)
		{
			
			System.out.println("1.Your own  bank account across India.");
			System.out.println("2.Fund Transfer Across Other account of same bank across india");
	
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				fundTransferOwnAcoount(accountID);
				break;
			case 2:
				fundTransferAcrossOtherAccount(accountID);
				break;
			default:
				System.exit(0);
				break;
		
			}
			
		}
		
	}



	private static void fundTransferAcrossOtherAccount(int accountID) {
		
		
		
		
		
		while(true)
		{
			
			System.out.println("1.Add/Register Payee Details.");
			System.out.println("2.Fund Transfer for Registerd Payee.");
	
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				addPayeeDetails(accountID);
				break;
			case 2:
				System.out.println("Registered Payee Details for the Account ID "+accountID);
				ArrayList<PayeeDetailsBean> list = null;
				list = service.getPayeeDetails(accountID);
				
				for(PayeeDetailsBean payeeBean:list){
					
					System.out.println("Account Holder Name is :" + payeeBean.getPayeeAccountName() );
					System.out.println("Payee Account ID :" + payeeBean.getPayeeAccountID());
					
				}
				System.out.println("Enter The Account number you want to transfer the money to:");
				int transferToAccount  = scan.nextInt();
				System.out.println("Enter the Amount to be transferd to the account "+transferToAccount);
				int transferAmount = scan.nextInt();
				
				
				
				
				int fundStatus = service.transferFund(accountID,transferToAccount, transferAmount);
				System.out.println("FunTransfer Successfull");
				
				fundTransferAcrossOtherAccount(accountID);
				break;
			default:
				System.exit(0);
				break;
		
			}
			
		}
		
		
	}


	private static void addPayeeDetails(int accountID) {
		
		System.out.println("Enter the Payee Account ID");
		int payeeAccountID =scan.nextInt();
		System.out.println("Enter the Payee Account Name");
		String payeeAccountName = scan.next();
		
		
		
		int payeeStatus = service.registerPayee(accountID, payeeAccountID, payeeAccountName);
		System.out.println(payeeStatus+" Payee has been added.");
		
		System.out.println(payeeAccountID +" "+payeeAccountName+" "+accountID);
		
	}


	private static void fundTransferOwnAcoount(int accountID) {
		
		System.out.println("Enter the PAN Number:");
		String pan = scan.next();
		ArrayList<BankCustomerBean> accountList = null;
		accountList = service.getAccountNumber(pan);
		
		for(BankCustomerBean cBean:accountList){
			
			System.out.println("Account ID is :" + cBean.getAccountID() );
			System.out.println("Account Type is :" + cBean.getAccountType());
			
		}
		System.out.println("Enter The Account number you want to transfer the money from:");
		int transferFromAccount  = scan.nextInt();
		System.out.println("Enter The Account number you want to transfer the money to:");
		int transferToAccount  = scan.nextInt();
		System.out.println("Enter the Amount to be transferd to the account "+transferToAccount);
		int transferAmount = scan.nextInt();

		int fundStatus = service.transferFund(transferFromAccount,transferToAccount, transferAmount);
		System.out.println("FundTransfer Successfull");
	}


	private static void getRequestHistory() {
		ArrayList<ServiceTrackerBean> list = null;
		list = service.getRequestHistory();
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceRequestID() {
		System.out.println("Enter the Account ID");
		int AccountID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceRequestID(AccountID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Service ID " +bean.getServiceID());
		}
		
	}

		


	private static void statusOfAllRequest() {
		ArrayList<ServiceTrackerBean> list = null;
		list = service.statusOfAllRequest();
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceDetailsByAccountID() {
		System.out.println("Enter the Account ID");
		int AccountID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceDetailsByAccountID(AccountID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("--------------------------------");
			System.out.println("");
		}
		
	}


	private static void fetchServiceDetailsByID() {
		
		System.out.println("Enter the Service ID You want to track");
		int serviceID = scan.nextInt();
		
		ArrayList<ServiceTrackerBean> list = null;
		list = service.fetchServiceDetailsByID(serviceID);
		
		for(ServiceTrackerBean bean:list){
			System.out.println("Account ID is: " +bean.getAccountID());
			System.out.println("Service ID " +bean.getServiceID());
			System.out.println("Service Request: "+bean.getServiceDesc());
			System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
			System.out.println("Service status: "+bean.getServiceStatus());
			System.out.println("");
			System.out.println("-----------------------------------------");
			System.out.println("");
		}
		
	}

}
