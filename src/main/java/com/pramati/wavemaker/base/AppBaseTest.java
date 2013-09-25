package com.pramati.wavemaker.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pramati.wavemaker.pages.AppsWelcomePage;

public class AppBaseTest {

	protected AppsWelcomePage homePage = null;	
	
	@BeforeMethod(alwaysRun = true)
	public void runBeforeMethod() {
		homePage = new AppsWelcomePage();		
	}

	@AfterMethod(alwaysRun = true)
	public void runAfterMethod() {
		if (homePage != null) {
			homePage.quitBrowser();
			homePage.resetDriver();
			homePage = null;
		}

	}
}
