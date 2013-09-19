package com.pramati.wavemaker.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pramati.wavemaker.page.BasePage;
import com.pramati.wavemaker.util.ConfigProperties;

/**
 * All API's of Cloud Jee application should be written here.
 * 
 * @author krishnakumarnellore
 *
 */
public class CloudJeeApplication extends BasePage {

	private static final String CLOUDJEE_APP_LIST = "studio_deploymentDialog_deploymentDialog_cloudJeeAppList";
	private static final String APP_NAME ="div[id^='studio.deploymentDialog.deploymentDialog.cloudJeeAppList_ITEM_']";
	private static final String START_BTN = "studio_deploymentDialog_deploymentDialog_cloudJeeStartFromListButton";
	private static final String STOP_BTN = "studio_deploymentDialog_deploymentDialog_cloudJeeStopFromListButton";
	private static final String UNDEPLOY_BTN = "studio_deploymentDialog_deploymentDialog_cloudJeeUndeployFromListButton";
	private static final String CLOSE_BTN = "studio_deploymentDialog_deploymentDialog_cloudJeeAppListDialogCloseButton";

	private static final String WAIT_DIALOG_MSG = "wmWaitDialog";

	private static final String WAIT_SIZENODE = "wmSizeNode";

	BasePage basePage = new BasePage();


	private static Logger log = Logger.getLogger(CloudJeeApplication.class);

	public WebElement Deployment() {
		log.info("In CloudJee Application page ,Waiting for element located by class "+ WAIT_SIZENODE);
		waitForElementToEnableByClass(WAIT_SIZENODE);

		log.info("In CloudJee Application page ,Waiting for element located by Id "+ CLOUDJEE_APP_LIST);
		waitForElementLocatedByID(CLOUDJEE_APP_LIST, getTimeOutInSeconds());

		log.info("In CloudJee Application page ,Getting element located by ID "+ CLOUDJEE_APP_LIST);
		return basePage.getElementByID(CLOUDJEE_APP_LIST);
	}
	private static final String USERNAME = "studio_deploymentDialog_deploymentDialog_loginDialogUserEditor";
	public void changeAPPStatus(String applicationName,String status){
		log.info("In CloudJee Application page ,Waiting for element located by CSS "+ APP_NAME);
		waitForElementLocatedByCSS(APP_NAME, getTimeOutInSeconds());
		log.info("In CloudJee Application page ,Getting elements located by CSS "+ APP_NAME);
		List<WebElement> appName = Deployment().findElements(By.cssSelector(APP_NAME));		
		for (WebElement aName : appName) {
			List<WebElement> tdList = aName.findElements(By.tagName("td"));
			if((tdList.get(0).getText().equalsIgnoreCase(applicationName)) ){
				if(status.equalsIgnoreCase("Start")){					
					tdList.get(0).click();
					log.info("In CloudJee Application page ,Clicking start button for application name "+ applicationName);
					basePage.getElementByID(START_BTN).click();					
					waitForElementToDisableByClass(WAIT_DIALOG_MSG);
					break;
				}
				else if(status.equalsIgnoreCase("Stop")){
					log.info("In CloudJee Application page ,Clicking stop button for application name "+ applicationName);					
					tdList.get(0).click();
					basePage.getElementByID(STOP_BTN).click();					
					waitForElementToDisableByClass(WAIT_DIALOG_MSG);					
					break;
				}
				else if(status.equalsIgnoreCase("Undeploy")){
					log.info("In CloudJee Application page ,Clicking undeploy button for application name "+ applicationName);
					tdList.get(0).click();
					basePage.getElementByID(UNDEPLOY_BTN).click();
					new Deployment().clickOkBtn();
					break;
				}
				else if(status.equalsIgnoreCase("Close")){
					basePage.getElementByID(CLOSE_BTN).click();
					break;
				}
			}
			else {
				log.info("No Change can be done, As app is already in status "+status);

			}
		}		
	}

	public String getAPPStatus(String applicationName){
		String statusText = null;
		basePage.sleep(5000);
		waitForElementLocatedByCSS(APP_NAME, getTimeOutInSeconds());
		try {
			waitForElementLocatedByLinkText(applicationName, getTimeOutInSeconds());
			List<WebElement> appName = Deployment().findElements(By.cssSelector(APP_NAME));		
			for (WebElement aName : appName) {
				List<WebElement> tdList = aName.findElements(By.tagName("td"));
				if((tdList.get(0).getText().equalsIgnoreCase(applicationName)) ){
					statusText = tdList.get(1).getText();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		return statusText;
	}
}


