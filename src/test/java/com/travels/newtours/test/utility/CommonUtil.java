package com.travels.newtours.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtil {

	static public String getPropertyValue(String fileName, String abc) throws FileNotFoundException{
		try(FileInputStream fis = new FileInputStream("testdata/"+fileName+".properties")){
			Properties p = new Properties();
			p.load(fis);
			return p.getProperty(abc);
		}catch(IOException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	static public String getCurrentDate(){
		String localdate = LocalDateTime.now().toString();
		return localdate.substring(0,localdate.indexOf(".")).replace("/","-");
	}
	
	static public void takeScreenshot(WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("screenshot/"+ getCurrentDate()+".png");
		FileUtils.copyFile(src, des);
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("D://SeleniumTrainingByJitendra//Practicals//SeleniumPracticals//mavenseleniumproject//screenshot//Test.jpg"));
		}
	
	 public static void sleepTime(int st) throws IOException{
		 try {
			Thread.sleep(st);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	
}
