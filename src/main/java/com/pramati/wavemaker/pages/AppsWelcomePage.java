package com.pramati.wavemaker.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.pramati.wavemaker.page.BasePage;

/**
 * apps.wavemaker page
 * 
 * @author krishnakumarnellore
 *
 */
public class AppsWelcomePage extends BasePage{

	private static final String EMAIL = "j_username";
	private static final String PASSWORD = "j_password";
	
	private static final String SIGNINBTN ="regButton";
	
	private static final String ERROR = "p.help-block.validation.alert.alert-error";

	public AppsWelcomePage() {
		super.init();
		waitForElementLocatedByName(EMAIL, getTimeOutInSeconds());	
	}

	/**
	 * Sets Username 
	 */
	public void setUserName(String email){
		waitForElementLocatedByName(EMAIL, getTimeOutInSeconds());
		getElementByName(EMAIL).sendKeys(email);
	}

	/**
	 * Sets Password 
	 */
	public void setPassword(String password){
		waitForElementLocatedByName(PASSWORD, getTimeOutInSeconds());
		getElementByName(PASSWORD).sendKeys(password);
	}
	
	/**
	 * Click on Signin button
	 * 
	 */
	public void clickSignInBtn(){
		getElementByName(SIGNINBTN).click();
	}
	
	/**
	 * Gets the list of all Error text displayed on clicking Signin button
	 * 
	 * @return
	 */
	public List<String> getError(){
		List<String> errorTxt = new ArrayList<String>();
		waitForElementLocatedByCSS(ERROR, getTimeOutInSeconds());
		List<WebElement> errList = getElementsByCSS(ERROR);
		for (WebElement eList : errList) {
			errorTxt.add(eList.getText());
		}
		return errorTxt;
	}
	
	
}
