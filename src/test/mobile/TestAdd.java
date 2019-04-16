package test.mobile;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import test.mobile.activities.MainModel;

public class TestAdd extends MainModel{
	private AppiumDriver<MobileElement> driver;
	private static Properties props;
	
	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new BufferedReader(new FileReader("resources/general.properties")));
	
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", props.getProperty("deviceName"));
        caps.setCapability("udid", props.getProperty("udid")); //Give Device ID of your mobile phone
        caps.setCapability("platformName", props.getProperty("platformName"));
        caps.setCapability("platformVersion", props.getProperty("platformVersion"));
        caps.setCapability("appPackage", props.getProperty("appPackage"));
        caps.setCapability("appActivity", props.getProperty("appActivity"));
        caps.setCapability("noReset", "true");

        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver<MobileElement>(new URL(props.getProperty("appiumUrl")), caps);
            ((AndroidDriver) driver).unlockDevice();

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
	}
	
	@BeforeMethod
	public void setupMethod() {
		if(((AndroidDriver) driver).isDeviceLocked()) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.POWER));
		}
	}
	
	@Test(dataProvider="operands")
//	@Parameters({"op1","op2","expected"})
	public void testAdd(String op1, String op2, String expected) {		
		if(((AndroidDriver) driver).isDeviceLocked()) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.POWER));
		}
		driver.findElement(By.id(getDigit(op1))).click();
		driver.findElement(By.id(getOp_add())).click();
		driver.findElement(By.id(getDigit(op2))).click();
		driver.findElement(By.id(getEquals())).click();
		assertEquals(driver.findElement(By.id(getResult())).getText(), expected);
	}
	
	@AfterClass
	public void teardown() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.POWER));
		 driver.quit();
	}

}
