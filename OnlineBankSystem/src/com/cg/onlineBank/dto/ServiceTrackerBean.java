package com.cg.onlineBank.dto;

public class ServiceTrackerBean {
	
	private int AccountID;
	private int ServiceID;
	private String ServiceDesc;
	private String ServiceRaisedDate;
	private String ServiceStatus;
	
	ServiceTrackerBean(){
		
	}

	public ServiceTrackerBean(int accountID, int serviceID, String serviceDesc, String serviceRaisedDate,
			String serviceStatus) {
		super();
		AccountID = accountID;
		ServiceID = serviceID;
		ServiceDesc = serviceDesc;
		ServiceRaisedDate = serviceRaisedDate;
		ServiceStatus = serviceStatus;
	}
	
	

	

	public ServiceTrackerBean(int serviceID) {
		super();
		ServiceID = serviceID;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public int getServiceID() {
		return ServiceID;
	}

	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}

	public String getServiceDesc() {
		return ServiceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		ServiceDesc = serviceDesc;
	}

	public String getServiceRaisedDate() {
		return ServiceRaisedDate;
	}

	public void setServiceRaisedDate(String serviceRaisedDate) {
		ServiceRaisedDate = serviceRaisedDate;
	}

	public String getServiceStatus() {
		return ServiceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		ServiceStatus = serviceStatus;
	}

	@Override
	public String toString() {
		return "ServiceTrackerBean [AccountID=" + AccountID + ", ServiceID=" + ServiceID + ", ServiceDesc="
				+ ServiceDesc + ", ServiceRaisedDate=" + ServiceRaisedDate + ", ServiceStatus=" + ServiceStatus + "]";
	}
	
	

}
