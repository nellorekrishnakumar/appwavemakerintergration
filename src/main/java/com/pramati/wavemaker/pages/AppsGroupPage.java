package com.pramati.wavemaker.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pramati.wavemaker.page.BasePage;

/**
 * All Api's of Group's should be added in Group Page
 * 
 * @author krishnakumarnellore
 *
 */
public class AppsGroupPage extends BasePage{
	
	private static Logger log = Logger.getLogger(AppsGroupPage.class);
	
	private final String CREATEBUTTON = "div.createButton";
	
	private final String TABS = "ul.cjee-tabs-ul";
	
	private final String USERNAME = "a.dropdown-toggle.usrName";
	
	private final String LINKACCOUNT_SETTINGS = "Account Settings";
	private final String LINKSIGN_OUT = "Sign Out";
	
	private final String DROPDOWNMENU = "ul.dropdown-menu.onflyDropdown";
	private final String FORM = "form.pf_details.ng-pristine.ng-valid";
	private final String ROWS = "pf_detailRows";
	
	
	public AppsGroupPage() {
		waitForElementLocatedByCSS(CREATEBUTTON, getTimeOutInSeconds());
	}
	
	public void clickAddGroup(){
		waitForElementLocatedByCSS(CREATEBUTTON, getTimeOutInSeconds());
		getElementByCSS(CREATEBUTTON).click();
	}
	
	public void clickLeftTab(String tabLinkTxt){
		clickTab(tabLinkTxt);
	}

	/**
	 * @param tabLinkTxt
	 */
	private void clickTab(String tabLinkTxt) {
		List<WebElement> tabLink =getElementByCSS(TABS).findElements(By.tagName("li"));
		for (WebElement tLTxt : tabLink) {
			if(tLTxt.getText().equalsIgnoreCase(tabLinkTxt)){
				tLTxt.click();
			}
			else{
				log.error("Unable to click on Tab link text on TAB of Group page "+ tabLinkTxt);
			}
		}
	}
	
	public void clickUsernameLink(String linkText){
		waitForElementLocatedByCSS(USERNAME, getTimeOutInSeconds());
		WebElement usernameLink = getElementByCSS(USERNAME);
		usernameLink.click();
		clickDropDownMenu(linkText);
	}

	/**
	 * @param linkText
	 */
	private void clickDropDownMenu(String linkText) {
		waitForElementLocatedByCSS(DROPDOWNMENU, getTimeOutInSeconds());
		WebElement dropdown_menu = getElementByCSS(DROPDOWNMENU);
		if (linkText.equalsIgnoreCase(LINKACCOUNT_SETTINGS)) {
			dropdown_menu.findElement(By.linkText(LINKACCOUNT_SETTINGS)).click();
		}
		else if(linkText.equalsIgnoreCase(LINKSIGN_OUT)){
			dropdown_menu.findElement(By.linkText(LINKSIGN_OUT)).click();
		}
	}
	
	
	/**
	 * Gets the profile detail from Account detail page.
	 * 
	 * @return
	 */
	public Map<String,String> getProfileDetail(){
		waitForElementLocatedByCSS(FORM, getTimeOutInSeconds());
		WebElement form = getElementByCSS(FORM);
		Map< String,String> rowTxt = new HashMap<String, String>();
		 List<WebElement> rows = form.findElements(By.className(ROWS));
		 for (WebElement fRow : rows) {
			rowTxt.put(fRow.findElement(By.tagName("label")).getText(),fRow.findElement(By.tagName("span")).getText());
		}
		 return rowTxt;
		
		
	}
	
	
	/**
	 * Application Page.
	 * 
	 * All API's of Application page should be written here
	 * 
	 * @author krishnakumarnellore
	 *
	 */
	public class AppsApplicationPage extends BasePage{
		
		private final String CREATEBUTTON = "div.createButton";
		
		public AppsApplicationPage() {
			waitForElementLocatedByCSS(this.CREATEBUTTON, getTimeOutInSeconds());
		}
		
		public void clickAddApplication(){
			waitForElementLocatedByCSS(this.CREATEBUTTON, getTimeOutInSeconds());
			getElementByCSS(this.CREATEBUTTON).click();
		}
		
	}
	
	/**
	 * Admin Portal Page.
	 * 
	 * All Api's for Admin portal should be updated here.
	 * 
	 * @author krishnakumarnellore
	 *
	 */
	public class AppsAdminPortal extends BasePage{
		private final String ACCOUNTMANAGERLINK = "li.userM";
		
		
		

		public AppsAdminPortal() {
			waitForElementLocatedByCSS(this.ACCOUNTMANAGERLINK, getTimeOutInSeconds());
		}
		
		public void clickLeftNavLink(String linkText){
			clickLink(linkText);
		}

		/**
		 * @param linkText
		 */
		private void clickLink(String linkText) {
			List<WebElement> leftNav= getElementByClassName("cjee-tabs-ul").findElements(By.tagName("li"));
			for (WebElement lN : leftNav) {
				if(lN.getText().equalsIgnoreCase(linkText)){
					lN.click();
					break;
				}else{
					log.error("Unable to click on link text on Left Nav of Admin Portal for "+ linkText);
				}
			}
		}
		
		
	}
}