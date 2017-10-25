package com.cg.onlineBank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.onlineBank.dbutil.DBUtil;
import com.cg.onlineBank.dto.BankCustomerBean;
import com.cg.onlineBank.dto.PayeeDetailsBean;
import com.cg.onlineBank.dto.ServiceTrackerBean;
import com.cg.onlineBank.service.ITrackingService;


public class ServiceTrackerDAOImpl implements IServiceTrackerDAO{
	Connection con = null;
	int result = 0;
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = serviceID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where Service_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> statusOfAllRequest() {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = DBUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER";		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = DBUtil.getConnection();
			String sql = "Select SERVICE_ID from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				
				
				list.add(new ServiceTrackerBean(ServiceId));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> getRequestHistory() {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = DBUtil.getConnection();
			String sql = "select * from Service_Tracker  where (sysdate-Service_Raised_Date)>180" ;	
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	public ArrayList<BankCustomerBean> getAccountNumber(String pan) {
		ArrayList <BankCustomerBean> list = new ArrayList<BankCustomerBean>();
		try{
			String pancard = pan;
			Connection conn = DBUtil.getConnection();
			String sql = "select ACCOUNT_ID,ACCOUNTTYPE from BCUSTOMER  where PANCARD=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,pan);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
				int accountID = rs.getInt(1);	
		  	    String accountType = rs.getString(2);
		  	    
				
				list.add(new BankCustomerBean(accountID,accountType));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
	}

	

	@Override
	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName) {
		int rowsAffected=0;
		try{
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into payeeDetails values(?,?,?)");
			st.setInt(1,accountID);
			st.setInt(2, payeeAccountID);
			st.setString(3, payeeAccountName);
			
			rowsAffected = st.executeUpdate();

		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return rowsAffected;
		
		
	}

	@Override
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount) {
		int rowsAffected=0;
		
		try{
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt1=conn.prepareStatement("insert into FUNDTRANSFER values(?,?,?,?,?)");
			stmt1.setInt(1,transferFromAccount);
			stmt1.setInt(2,9990);
			stmt1.setInt(3,transferToAccount);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt1.setTimestamp(4, date);
			
			stmt1.setInt(5,transferAmount);
			
						
			rowsAffected = stmt1.executeUpdate();
			
			PreparedStatement stmt2=conn.prepareStatement("insert into TRANSACTION values(?,transactionSeq.nextval,?,?,?)");
			stmt2.setInt(1,transferFromAccount);
			stmt2.setString(2,"FundTransferd");
			java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt2.setTimestamp(3, date1);
			stmt2.setInt(4,transferAmount);
			stmt2.executeUpdate();
			
			PreparedStatement stmt3=conn.prepareStatement("insert into TRANSACTION values(?,transactionSeq.nextval,?,?,?)");
			stmt3.setInt(1,transferToAccount);
			stmt3.setString(2,"FundReceived");
			java.sql.Timestamp date2 = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt3.setTimestamp(3, date2);
			stmt3.setInt(4,transferAmount);
			stmt3.executeUpdate();
			
			PreparedStatement stmt4=conn.prepareStatement("Update ACCOUNTMASTER SET ACCOUNTBALANCE = ACCOUNTBALANCE+? WHERE AccountID=?");
			stmt4.setInt(1,transferAmount);
			stmt4.setInt(2,transferToAccount);
			stmt4.executeUpdate();
			
			PreparedStatement stmt5=conn.prepareStatement("Update ACCOUNTMASTER SET ACCOUNTBALANCE = ACCOUNTBALANCE-? WHERE AccountID=?");
			stmt5.setInt(1,transferAmount);
			stmt5.setInt(2,transferFromAccount);
			stmt5.executeUpdate();

		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID) {
		ArrayList <PayeeDetailsBean> list = new ArrayList<PayeeDetailsBean>();
		try{
			
			Connection conn = DBUtil.getConnection();
			String sql = "select * from payeeDetails where AccountID=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
				int accountId = rs.getInt(1);	
		  	    int PayeeDetailId = rs.getInt(2);
		  	    String PayeeName = rs.getString(3);
		  	    
		  	    list.add(new PayeeDetailsBean(accountId,PayeeDetailId,PayeeName));
				
			}
		
		}
		catch(SQLException se){
		     se.printStackTrace();
		}
		catch(Exception e){
		      e.printStackTrace();
		}
	
		return list;
		
	}

	
	

}
