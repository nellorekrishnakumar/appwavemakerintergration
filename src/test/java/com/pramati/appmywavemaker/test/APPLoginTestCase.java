package com.pramati.appmywavemaker.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pramati.wavemaker.base.AppBaseTest;
import com.pramati.wavemaker.pages.AppsGroupPage;
import com.pramati.wavemaker.util.ConfigProperties;

/**
 * Test Case for deployement of Application in Cloud
 * 
 * @author krishnakumarnellore
 *
 */
public class APPLoginTestCase extends AppBaseTest {
	
	AppsGroupPage appsGroupPage = null;
	AppsGroupPage.AppsAdminPortal  adminportal = null;
	
	
	/*@Test(description="Check valid email address & Minmum character error message")
	public void testInvalidLogin() throws InterruptedException {
		homePage.setUserName(UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.username());
		homePage.setPassword(UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.password());
		homePage.clickSignInBtn();
		List<String> error = homePage.getError();
		Assert.assertTrue(error.contains(UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.emailErr()), UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.emailErr() +" is not displayed in "+ error);
		Assert.assertTrue(error.contains(UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.pwdErr()), UserPass.INVALIDEMAIL_MINIMUMCHARACTERPASSWORD.pwdErr() +" is not displayed in "+ error);
	}

	@Test(description="Check empty login text error message")
	public void testEmptyLoginTxt() throws InterruptedException {
		homePage.setUserName(UserPass.EMPTYEMAIL_PASSWORD.username());
		homePage.setPassword(UserPass.EMPTYEMAIL_PASSWORD.password());
		homePage.clickSignInBtn();
		List<String> error = homePage.getError();
		Assert.assertTrue(error.contains(UserPass.EMPTYEMAIL_PASSWORD.emailErr()), UserPass.EMPTYEMAIL_PASSWORD.emailErr() +" is not displayed in "+ error);
		Assert.assertTrue(error.contains(UserPass.EMPTYEMAIL_PASSWORD.pwdErr()), UserPass.EMPTYEMAIL_PASSWORD.pwdErr() +" is not displayed in "+ error);
	}
	
	@Test(description="Check Invalid email and valid password text error message")
	public void testInvalidEmailAndValidPassword() throws InterruptedException {
		homePage.setUserName(UserPass.INVALIDEMAIL_VALIDPASSWORD.username());
		homePage.setPassword(UserPass.INVALIDEMAIL_VALIDPASSWORD.password());
		homePage.clickSignInBtn();
		List<String> error = homePage.getError();
		Assert.assertTrue(error.contains(UserPass.INVALIDEMAIL_VALIDPASSWORD.emailErr()), UserPass.INVALIDEMAIL_VALIDPASSWORD.emailErr() +" is not displayed in "+ error);		
	}
	
	@Test(description="Check Valid email and invalid password text error message")
	public void testValidEmailAndInValidPassword() throws InterruptedException {
		homePage.setUserName(UserPass.VALIDEMAIL_INVALIDPASSWORD.username());
		homePage.setPassword(UserPass.VALIDEMAIL_INVALIDPASSWORD.password());
		homePage.clickSignInBtn();
		List<String> error = homePage.getError();
		Assert.assertTrue(error.contains(UserPass.VALIDEMAIL_INVALIDPASSWORD.emailErr()), UserPass.VALIDEMAIL_INVALIDPASSWORD.emailErr() +" is not displayed in "+ error);		
	}
	
	@Test(description="Check empty email and short password text error message")
	public void testEmptyEmailAndShortPassword() throws InterruptedException {
		homePage.setUserName(UserPass.EMPTYEMAIL_SHORTPASSWORD.username());
		homePage.setPassword(UserPass.EMPTYEMAIL_SHORTPASSWORD.password());
		homePage.clickSignInBtn();
		List<String> error = homePage.getError();
		Assert.assertTrue(error.contains(UserPass.EMPTYEMAIL_SHORTPASSWORD.emailErr()), UserPass.EMPTYEMAIL_SHORTPASSWORD.emailErr() +" is not displayed in "+ error);		
	}
	*/
	
	@Test(description="Check valid email and valid password")
	public void testValidEmailAndValidPassword() throws InterruptedException {
		
		homePage.setUserName(UserPass.VALIDEMAIL_VALIDPASSWORD.username());
		homePage.setPassword(UserPass.VALIDEMAIL_VALIDPASSWORD.password());
		homePage.clickSignInBtn();
		homePage.openUrl(ConfigProperties.URL);
		appsGroupPage = new AppsGroupPage();
		appsGroupPage.clickUsernameLink("Account Settings");
		Map<String, String> accountDetail = appsGroupPage.getProfileDetail();
		Assert.assertEquals(accountDetail.get(AccountDetail.USERNAME.key()), AccountDetail.USERNAME.value(),AccountDetail.USERNAME.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.FULLNAME.key()), AccountDetail.FULLNAME.value(),AccountDetail.FULLNAME.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.EMAIL.key()), AccountDetail.EMAIL.value(),AccountDetail.EMAIL.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.COMPANY.key()), AccountDetail.COMPANY.value(),AccountDetail.COMPANY.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.APPDOMAINNAME.key()), AccountDetail.APPDOMAINNAME.value(),AccountDetail.APPDOMAINNAME.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.SUBSCRIPTIONTYPE.key()), AccountDetail.SUBSCRIPTIONTYPE.value(),AccountDetail.SUBSCRIPTIONTYPE.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.COUNTRY.key()), AccountDetail.COUNTRY.value(),AccountDetail.COUNTRY.value() +"Not found in Account detail page");
		Assert.assertEquals(accountDetail.get(AccountDetail.TELEPHONENUMBER.key()), AccountDetail.TELEPHONENUMBER.value(),AccountDetail.TELEPHONENUMBER.value() +"Not found in Account detail page");
		
		appsGroupPage.clickLeftTab("Admin Portal");
		adminportal = appsGroupPage.new AppsAdminPortal();
		adminportal.clickLeftNavLink("Instances");
		
				
	}
}