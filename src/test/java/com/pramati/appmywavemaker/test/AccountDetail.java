package com.pramati.appmywavemaker.test;


public enum AccountDetail {
	FULLNAME ("Full Name", "krishna kumar"),
	USERNAME ("User Name", "krishnakumar.nellore@imaginea.com"),
	EMAIL ("Email", "krishnakumar.nellore@imaginea.com"),
	COMPANY ("Company", "imaginea"),
	APPDOMAINNAME ("App Domain Name", "krishna.apps.mywavemaker.com"),
	SUBSCRIPTIONTYPE ("Subscription Type", "Free"),
	COUNTRY ("Country", "India"),
	TELEPHONENUMBER ("Telephone Number", "91908900808");

	private final String key;   
	private final String value;
	

	AccountDetail(String key, String value) {
		this.key = key;
		this.value = value;
	}

	
	public String key() { return key; }
	public String value() { return value; }
	
	


}
