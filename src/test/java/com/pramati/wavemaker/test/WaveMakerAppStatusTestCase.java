package com.pramati.wavemaker.test;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pramati.wavemaker.base.BaseTest;
import com.pramati.wavemaker.pages.CloudJeeApplication;
import com.pramati.wavemaker.pages.Deployment;
import com.pramati.wavemaker.pages.NewProjectDialog;
import com.pramati.wavemaker.pages.ProjectCreationPage;
import com.pramati.wavemaker.util.ConfigProperties;

/**
 * 
 * 
 * @author krishnakumarnellore
 *
 */
public class WaveMakerAppStatusTestCase extends BaseTest {
	
	private static final String START = "START";
	private static final String STOP = "STOP";
	
	NewProjectDialog newProjectDialog = null;
	ProjectCreationPage projectCreationPage = null;
	Deployment deployment = null;
	CloudJeeApplication cloudJeeApplication = null;
	
	private static Logger log = Logger.getLogger(WaveMakerAppStatusTestCase.class);
	
	@Test(enabled=true, description="")
	public void verifyAppChangeStatus(){
		homePage.openExistingProject("Project");
		projectCreationPage = new ProjectCreationPage();
		projectCreationPage.clickMenuBar("File","Deploy Project");
		projectCreationPage.clickFileSubSubMenu("Manage Deployment");
		deployment = new Deployment();
		deployment.setUserPassword(ConfigProperties.USERNAME, ConfigProperties.PASSWORD);
		deployment.clickManageWMCloudApBtn();		
		cloudJeeApplication = new CloudJeeApplication();
		deployment.setUserPassword(ConfigProperties.USERNAME, ConfigProperties.PASSWORD);
		cloudJeeApplication.changeAPPStatus("ProjectA570", START);
		Assert.assertEquals(cloudJeeApplication.getAPPStatus("ProjectA570"),"STARTED","App is not stopped");
		cloudJeeApplication.changeAPPStatus("ProjectA570", STOP);
		Assert.assertEquals(cloudJeeApplication.getAPPStatus("ProjectA570"),"STOPPED","App is not started");
		cloudJeeApplication.changeAPPStatus("ProjectA570", START);		
		Assert.assertEquals(cloudJeeApplication.getAPPStatus("ProjectA570"),"STARTED","App is not stopped");
		cloudJeeApplication.changeAPPStatus("ProjectA570", STOP);
		Assert.assertEquals(cloudJeeApplication.getAPPStatus("ProjectA570"),"STOPPED","App is not started");
		System.out.println("Done");
		
	}

}
