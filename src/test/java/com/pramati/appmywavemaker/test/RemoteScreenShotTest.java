package com.pramati.appmywavemaker.test;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteScreenShotTest {
	
	public class ScreenShotRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {
		public ScreenShotRemoteWebDriver(URL url, DesiredCapabilities dc) {
			super(url, dc);
		}

		
		public <X> X getScreenshotAs(OutputType<X> target)
				throws WebDriverException {
			if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
			    return target.convertFromBase64Png(execute(DriverCommand.SCREENSHOT).getValue().toString());
			}
			return null;
		}
	}
	
	
	@Test(groups = "unit")
	public void remoteWebDriverScreenshotTest() throws Exception {
		
     
       DesiredCapabilities dc = new DesiredCapabilities();
       dc.setBrowserName("firefox");
       dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
       ScreenShotRemoteWebDriver rwd = new ScreenShotRemoteWebDriver(new URL("http://172.16.12.201:4447/wd/hub"), dc);
       
       rwd.get("http://groups.google.com/group/selenium-users/browse_thread/thread/34b1d79613eb003b/22587bcaa36aedd7");
       
       File f = rwd.getScreenshotAs(OutputType.FILE);
       File o = new File("target/screenshot.png");
       FileUtils.copyFile(f, o);
       
       rwd.quit();
	}
}