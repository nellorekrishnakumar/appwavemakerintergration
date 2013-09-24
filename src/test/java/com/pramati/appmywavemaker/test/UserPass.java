package com.pramati.appmywavemaker.test;


public enum UserPass {
	INVALIDEMAIL_MINIMUMCHARACTERPASSWORD ("email", "pwd","Not a valid email address","Too short: Minimum of '6' characters"),
	EMPTYEMAIL_PASSWORD ("","","Email address field can't be empty","Password field can't be empty"),
	INVALIDEMAIL_VALIDPASSWORD ("test@gmail.com","pramati123","Sorry, you entered an invalid User ID. Please try again.",""),
	VALIDEMAIL_INVALIDPASSWORD ("krishnakumar.nellore@imaginea.com","pramati123","Incorrect Email / Password combination. Please try again",""),
	EMPTYEMAIL_SHORTPASSWORD ("", "pwd","Email address field can't be empty","Too short: Minimum of '6' characters"),
	VALIDEMAIL_VALIDPASSWORD ("krishnakumar.nellore@imaginea.com", "pramati","","");

	private final String username;   
	private final String password;
	private final String emailErr;
	private final String pwdErr;

	UserPass(String username, String password,String emailError,String passwordErr) {
		this.username = username;
		this.password = password;
		this.emailErr = emailError;
		this.pwdErr = passwordErr;
	}

	
	public String username() { return username; }
	public String password() { return password; }
	
	public String emailErr() { return emailErr; }
	public String pwdErr() { return pwdErr; }


}
