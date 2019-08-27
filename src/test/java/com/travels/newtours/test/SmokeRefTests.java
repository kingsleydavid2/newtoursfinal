package com.travels.newtours.test;

import java.awt.AWTException;
//import net.sf.saxon.exslt.Date;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestNGException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cnn.expansion.test.library.BaseTest;
import com.cnn.expansion.test.utility.CmdLineHandler;
import com.cnn.expansion.test.utility.Constants;
import com.cnn.expansion.test.utility.ExcelReader;
import com.cnn.expansion.test.webdriver.WdFace;
import com.cnn.expansion.test.webdriver.WdTest;
import com.cnn.expansion.test.core.Prefs;

public class SmokeRefTests extends WdTest{
	// Tests set to group "expansion" will be run on the live server!  Others are older and may need to be tweaked before they function.
	public static String suiteStartTime, suiteEndTime;
	public static Boolean forceresult;
	public static String[] incgroups;
	public static String[] modules;
	public static ITestNGMethod[] allTestMethods;
	// Sets the retry analyzer to repeat failed tests
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) throws MalformedURLException {
		String testEnv = System.getProperty("environment");
		String testSite = System.getProperty("site");
		incgroups = context.getIncludedGroups();
		allTestMethods = context.getAllTestMethods();
			if((testEnv!=null && !testEnv.equals(""))&& (testSite!=null && !testSite.equals(""))){
			if(testEnv.equals("REF") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://ref.next.cnn.com/";
			else if(testEnv.equals("REF") && testSite.equals("INTL"))
				Prefs.AUT_URL = "http://edition.ref.next.cnn.com/";
			else if(testEnv.equals("BETA") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://beta.next.cnn.com/";
			else if(testEnv.equals("BETA") && testSite.equals("INTL"))
				Prefs.AUT_URL = "http://edition.beta.next.cnn.com/";
			else if(testEnv.equals("TRAIN") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://train.next.cnn.com/";
			else if(testEnv.equals("TRAIN") && testSite.equals("INTL"))
				Prefs.AUT_URL = "http://edition.train.next.cnn.com/";
			else if(testEnv.equals("ETRAIN") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://etrain.next.cnn.com/";
			else if(testEnv.equals("STAGE") && testSite.equals("INTL"))
				Prefs.AUT_URL = "http://edition.stage.next.cnn.com/";
			else if(testEnv.equals("STAGE") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://stage.next.cnn.com/";
			else if(testEnv.equals("PROD") && testSite.equals("DOM"))
				Prefs.AUT_URL = "http://www.cnn.com/";	
			else if(testEnv.equals("PROD") && testSite.equals("INTL"))
				Prefs.AUT_URL = "http://edition.cnn.com/";	
		
		}else{
			Reporter.log("FAILED: No Environment & Site details provided");
			Assert.fail();
		}	
			//Getting smoke tests urls from confluence page
			
			try{
				DesiredCapabilities caps = DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				WebDriver driver = new RemoteWebDriver(new URL(Constants.gridHub), caps);
				driver.get("http://docs.turner.com/display/CNNEXPANSION/CNN+Expansion+URLs+for+Smoke+Tests");
				Thread.sleep(2000);
				/*driver.findElement(By.xpath(".//*[@id='os_username']")).sendKeys(Prefs.Conf_UsrName);
				driver.findElement(By.xpath(".//*[@id='os_password']")).sendKeys(Prefs.Conf_Pwd);
				driver.findElement(By.xpath(".//*[@id='loginButton']")).click();
				Thread.sleep(2000);*/
				String article_Url = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article')]/../td/a")).getText();
				String section_Url = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Section')]/../td/a")).getText();
				String gallery_Url = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Gallery Page')]/../td/a")).getText();
				String articleVidUrl = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article w/ Video')]/../td/a")).getText();
				String articleEmVidUrl = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article w/ Exp Video')]/../td/a")).getText();
				String shows_URL = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Show')]/../td/a")).getText();
				String special_URL = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Special')]/../td/a")).getText();
				String profile_URL = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Profile')]/../td/a")).getText();
				String articleGalUrl = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article w/ Gallery')]/../td/a")).getText();
				String articleGalEmUrl = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article w/ Exp Gallery')]/../td/a")).getText();
				String leafPage = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Video Leaf Page')]/../td/a")).getText();
				String articlePTImage = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article PT Image')]/../td/a")).getText();
				String articlePTVideo = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article PT Video')]/../td/a")).getText();
				String articlePTColl = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Article PT Collection')]/../td/a")).getText();
				if(testSite.equals("INTL") && testEnv.equals("PROD")){
					String sports_Url = driver.findElement(By.xpath(
							".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Sports')]/../td/a")).getText();
					String travel_Url = driver.findElement(By.xpath(
							".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+testEnv+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Travel')]/../td/a")).getText();
					Prefs.SPORTS_URL = sports_Url;
					Prefs.INTL_TRAVEL_URL = travel_Url;
				}
				String money_Url = driver.findElement(By.xpath(
						".//table[@class='confluenceTable tablesorter']/tbody/tr/td[contains(.,'"+"PROD"+"')]/../td[contains(.,'"+testSite+"')]/../td[contains(.,'Money')]/../td/a")).getText();
				Prefs.MONEY_URL = money_Url;
				Prefs.ARTICLE_URL = article_Url;
				Prefs.GALLERY_URL = gallery_Url;
				Prefs.SECTION_URL = section_Url;
				Prefs.articleVidUrl = articleVidUrl;
				Prefs.articleEmVidUrl = articleEmVidUrl;
				Prefs.shows_URL = shows_URL;
				Prefs.special_URL = special_URL;
				Prefs.profile_URL = profile_URL;
				Prefs.articleGalUrl = articleGalUrl;
				Prefs.articleGalEmUrl = articleGalEmUrl;
				Prefs.LeafPage = leafPage;
				Prefs.articlePTImage = articlePTImage;
				Prefs.articlePTVideo = articlePTVideo;
				Prefs.articlePTColl = articlePTColl;
				Reporter.log(Prefs.GALLERY_URL + " GALLERY_URL "+ gallery_Url+"<BR>");
				Reporter.log(Prefs.articleGalUrl + " articleGalUrl "+ articleGalUrl+"<BR>");
				Reporter.log(Prefs.articleGalEmUrl + " articleGalEmUrl "+ articleGalEmUrl+"<BR>");
				driver.quit();
			}catch(Exception e){
				Reporter.log("Error in getting the URLs from confluence, hence reading it from static file." + e.getMessage());
			}
			Reporter.log("Scripts executed for site :"+Prefs.AUT_URL );
		for (ITestNGMethod method : context.getAllTestMethods()) {
	         method.setRetryAnalyzer(new Retry());
	     }
		suiteStartTime = getStartTime("of_suite");
		Reporter.log(suiteStartTime);
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite(ITestContext context) throws MalformedURLException {
		//ArrayList<ITestNGMethod> values = moduleMap.get(moduleName);
		suiteEndTime = getEndTime("of_suite");
		int totalPassedMethods = 0;
        int totalFailedMethods = 0;
        int totalSkippedMethods = 0;        
        //allTestMethods = context.getAllTestMethods();
		//Map<String, ISuiteResult> tests = suite.getResults();
		ITestNGMethod[] methods = context.getAllTestMethods();
		for(ITestNGMethod method : methods){
			//Reporter.log("%"+method.getSuccessPercentage());
			//Reporter.log(method.getMethodName());
        	int failedMethods = context.getFailedTests().getResults(method).size();
            int passedMethods = context.getPassedTests().getResults(method).size();
            int skippedMethods = context.getSkippedTests().getResults(method).size();	
            totalPassedMethods += passedMethods;
            totalFailedMethods += failedMethods;
            totalSkippedMethods += skippedMethods;
		}
		Reporter.log("PASSED:"+totalPassedMethods+"<BR>");
		Reporter.log("FAILED:"+totalFailedMethods+"<BR>");
		Reporter.log("SKIPPED:"+totalSkippedMethods+"<BR>");

		String Smk_URL = "";
		try{
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
			WebDriver driver = new RemoteWebDriver(new URL(Constants.gridHub), caps);
			driver.get("https://mpto.hipchat.com/chat");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#email")).sendKeys(Prefs.hip_UsrName);
			driver.findElement(By.cssSelector("#password")).sendKeys(Prefs.hip_Pwd);
			driver.findElement(By.cssSelector("#signin")).click();
			Thread.sleep(10000);
			Smk_URL = "http://mssqacoreqa01.turner.com:8080/job/"+System.getProperty("JOB_NAME")+"/ws/cnn-expanxion-automation/target/custom-test-reports/Default%20Test%20Name-customized-report.html";
			//driver.findElement(By.cssSelector("div[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople\"] > ul > li[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople.0.1:$RoomsNavItem7809_1056659@chat=1hipchat=1comchat\"]")).click();
			//driver.findElement(By.cssSelector("div[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople\"] > ul > li[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople.0.1:$RoomsNavItem7809_1721579@chat=1hipchat=1comchat\"]")).click();
			//driver.findElement(By.cssSelector("div[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople\"] > ul > li[data-reactid=\".0.1.0.0.1.1:$RoomsNavpeople.0.1:$RoomsNavItem7809_801617@chat=1hipchat=1comchat\"]")).click();
			driver.findElement(By.cssSelector("li.hc-tab:nth-child(3) > a:nth-child(1)")).click();
			//driver.findElement(By.cssSelector(".hc-room > a:nth-child(1) > span:nth-child(2)")).click();
			//driver.findElement(By.cssSelector("#hc-message-input")).sendKeys("Test Complete"+Keys.ENTER);
			//driver.findElement(By.cssSelector("#hc-message-input")).sendKeys(Output);
			WebElement hipinput = driver.findElement(By.cssSelector("#hc-message-input"));			
			
			//hipinput.sendKeys("/code Auto-triggered Smoke Test Result:\n");
			//hipinput.sendKeys("/code Start Time = "+suiteStartTime+"\n");
			//hipinput.sendKeys("/code End Time = "+suiteEndTime+"\n");
			//hipinput.sendKeys("/code Environment:"+System.getProperty("environment")+" Edition: "+System.getProperty("site")+"\n");
			//hipinput.sendKeys("/code Number Of Passed Tests Count = "+totalPassedMethods+" \n");
			//hipinput.sendKeys("/code Number Of Failed Tests Count = "+totalFailedMethods+"\n");
			//hipinput.sendKeys("/code Note: For more details kindly refer to the Report @\n");
			hipinput.sendKeys("/code Auto-triggered Smoke Test Result: Job: "+System.getProperty("JOB_NAME")+" :: Env: "+System.getProperty("environment")+" :: Ed."+System.getProperty("site")+" :: Pass:"+totalPassedMethods+" :: FAIL:"+totalFailedMethods+" :: Report:\n");
			hipinput.sendKeys(Smk_URL+Keys.ENTER);
			Thread.sleep(10000);
			driver.findElement(By.cssSelector("li.hc-tab:nth-child(4) > a:nth-child(1)")).click();
			hipinput = driver.findElement(By.cssSelector("#hc-message-input"));
			//hipinput.sendKeys("/code Autotriggered post - Kindly ignore\n");
			hipinput.sendKeys("/code Auto-triggered Smoke Test Result: Job: "+System.getProperty("JOB_NAME")+" :: Env: "+System.getProperty("environment")+" :: Ed."+System.getProperty("site")+" :: Pass:"+totalPassedMethods+" :: FAIL:"+totalFailedMethods+" :: Report:\n");
			hipinput.sendKeys(Smk_URL+Keys.ENTER);
			Thread.sleep(20000);
			driver.quit();
		} catch(Exception e){
			Reporter.log("Error logging results in Hipchat" + e.getMessage());
		}
	}
	
	//@Test(dataProvider = "HomePage", groups = {"testMegaNav","testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Tests Home Page elements including header search")
	@Test(dataProvider = "HomePage", groups = {"testMegaNav","testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Tests Home Page elements")
	public void HomePage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testHomePage(windowWidth, windowHeight, url);
	}
	
	//@Test(dataProvider = "HomePage", groups = {"testMegaNav","testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Tests Home Page elements including header search")
	@Test(dataProvider = "HomePage", groups = {"testMegaNav","testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11678 || Search functionality from header")
	public void HomePageSearch(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testHomePageSearch(windowWidth, windowHeight, url);
	}
	
	//@Test(dataProvider = "HomePageMobile", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Tests Login from Home Page")
	@Test(dataProvider = "HomePageMobile", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11712, 11702, 11647, 11649 || Tests Login from Home Page")
	public void LoginSignIn(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){
			BaseTest test = new BaseTest(wf);
			test.testLoginSignIn(windowWidth, windowHeight, url);
		}
	}
	
	//@Test(dataProvider = "HomePageMobile", groups = {"testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Tests My CNN Link from Home Page")
	@Test(dataProvider = "HomePageMobile", groups = {"testHomePage", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11700 || Tests My CNN Link from Home Page")
	public void LoginMyCnn(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){
			BaseTest test = new BaseTest(wf);
			test.testLoginMyCnn(windowWidth, windowHeight, url);
		}
	}
		
	//@Test(dataProvider = "AdChoice", groups = {"testHomePage","smokeTests","SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Tests Ad Choice pop up in home page")
	@Test(dataProvider = "AdChoice", groups = {"testHomePage","smokeTests","SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Tests Ad Choice pop up in home page")
	public void AdChoice(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testAdChoice(windowWidth, windowHeight, url);
	}
		
	//@Test(dataProvider = "SectionPages", groups = {"testSectionPage","smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 2, description = "Verify Section Page loads correctly")
	@Test(dataProvider = "SectionPages", groups = {"testSectionPage","smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Section Page loads correctly")
	public void SectionPage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testSectionPages(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "ArticlePagesInHome", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 1, description = "Verify Article Page Loads Correctly")
	@Test(dataProvider = "ArticlePagesInHome", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "QC Test ID: 11930 || Verify Article Page Loads Correctly")
	public void ArticlePage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(!(brow.startsWith("IE") && windowWidth<1000)){
			BaseTest test = new BaseTest(wf);
			test.testArticlePages(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "ArticlePagesInHomeSocial", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 1, description = "Verify Article Page Loads Correctly")
	@Test(dataProvider = "ArticlePagesInHomeSocial", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "QC Test ID: 11686 || Verify Article share on Facebook")
	public void ArticleFacebookShare(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.testArticleFacebookShare(url, windowWidth, windowHeight);
	}
	//@Test(dataProvider = "ArticlePagesInHomeSocial", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 1, description = "Verify Article Page Loads Correctly")
	@Test(dataProvider = "ArticlePagesInHomeSocial", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "QC Test ID: 11687 || Verify Article share on Twitter")
	public void ArticleTwitterShare(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.testArticleTwitterShare(url, windowWidth, windowHeight);
	}
	
	@Test(dataProvider = "ArticlePagesInHomeSocial", groups = {"smokeTests","testArticlePage","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Article share options - Others")
	public void ArticleOtherShare(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.testArticleOtherShare(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "GalleryPagesInHome", groups = {"smokeTests","testGallery","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 1, description = "Verify Gallery Page loads and Carousels are clickable")
	@Test(dataProvider = "GalleryPagesInHome", groups = {"smokeTests","testGallery","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Gallery Page loads and Carousels are clickable")
	public void GalleryPage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testGalleryPage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "VideoPage", groups = {"testVideos","smokeTests","SmokeRefTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 1, description = "Verify Video page and now playing carousel")
	@Test(dataProvider = "VideoPage", groups = {"testVideos","smokeTests","SmokeRefTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Video page and now playing carousel")
	public void VideoLandingPage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(!brow.startsWith("IE")){
			BaseTest test = new BaseTest(wf);
			test.testVideos(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "SectionPages", groups = {"testHeaders", "smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 3, description = "Verify Header Links are present Correctly")
	@Test(dataProvider = "SectionPages", groups = {"testHeaders", "smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Header Links are present Correctly")
	public void Headers(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.testHeaders(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "SectionPages", groups = {"testFooters", "smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, priority = 3, description = "Verify Footer Links are present Correctly and search works from footer")
	@Test(dataProvider = "SectionPages", groups = {"testFooters", "smokeTests","SmokeTestsIntl", "SmokeRefTests","SmokeRefTestsINTL"}, description = "QC Test ID: 11595 || Verify Footer Links are present Correctly and search works from footer")
	public void Footers(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.testFooters(windowWidth, windowHeight, url);
	}
	
	//@Test(dataProvider = "AdChoice", groups = {"testMegaNav", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Verify Mega Nav functionality in home page")
	@Test(dataProvider = "AdChoice", groups = {"testMegaNav", "smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11831,11837 ||Verify Mega Nav functionality in home page")
	public void MegaNav(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		try{
			test.testMegaNav(windowWidth, windowHeight, url);
		} catch (AWTException awte){
			awte.printStackTrace();
		}
	}
	
	//@Test(dataProvider = "SectFront", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTests","SmokeRefTestsINTL"}, priority = 3, description = "Verify Section front pages loads correctly ")
	@Test(dataProvider = "SectFront", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTests","SmokeRefTestsINTL"}, description = "Verify Section front pages loads correctly ")
	public void testsecfrontpage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testsecfrontpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "IntSectFront", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, priority = 3, description = "Verify International Section front pages loads correctly - Only for International")
	@Test(dataProvider = "IntSectFront", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, description = "Verify International Section front pages loads correctly - Only for International")
	public void testintsecfrontpage(WdFace wf, int windowWidth, int windowHeight, String url){
		if(System.getProperty("site").equals("INTL")){				
			BaseTest test = new BaseTest(wf);
			test.testintsecfrontpage(url, windowWidth, windowHeight);
		}
	}
	
	
	//@Test(dataProvider = "Opinion", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Opinion pages loads correctly ")
	@Test(dataProvider = "Opinion", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Opinion pages loads correctly ")
	public void testopinionpage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testopinionpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "TvSection", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify TV pages loads correctly ")
	@Test(dataProvider = "TvSection", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify TV pages loads correctly ")
	public void testtvpage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testtvpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "MoneyPages", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 4, description = "Verify Money page loads correctly ")
	@Test(dataProvider = "MoneyPages", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Money page loads correctly ")
	public void moneypage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.moneypage(url, windowWidth, windowHeight);
	}

	//@Test(dataProvider = "IntTravelPage", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, priority = 4, description = "Verify Int. Travel Page loads correctly - Only for International")
	@Test(dataProvider = "IntTravelPage", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, description = "Verify Int. Travel Page loads correctly - Only for International")
	public void inttravelpage(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.inttravelpage(url, windowWidth, windowHeight);
	}

	//@Test(dataProvider = "IntVideoPages", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, priority = 4, description = "Verify International Video pages loads correctly ")
	@Test(dataProvider = "IntVideoPages", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, description = "Verify International Video pages loads correctly ")
	public void intvideopage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.intvideopages(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "MorePages", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 1, description = "Verify More pages loads correctly ")
	@Test(dataProvider = "MorePages", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify More pages loads correctly ")
	public void testmorepage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testmorepage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "SportsPage", groups = {"smokeTests","SmokeTestsIntl"}, priority = 1, description = "Verify Sport page loads correctly - Only for Production")
	@Test(dataProvider = "SportsPage", groups = {"smokeTests","SmokeTestsIntl"}, description = "Verify Sport page loads correctly - Only for Production")
	public void sportpage(WdFace wf, int windowWidth, int windowHeight, String url){
		if(System.getProperty("environment").equals("PROD")){				
			BaseTest test = new BaseTest(wf);
			test.sportpage(url, windowWidth, windowHeight);
		}
	}

	//@Test(dataProvider = "iReportPage", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, priority = 3, description = "Verify iReport page loads correctly - Only for INTERNATIONAL")
	@Test(dataProvider = "iReportPage", groups = {"SmokeRefTestsIntl","SmokeTestsIntl"}, description = "Verify iReport page loads correctly - Only for INTERNATIONAL")
	public void ireportpage(WdFace wf, int windowWidth, int windowHeight, String url){
			BaseTest test = new BaseTest(wf);
			test.ireportpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "ArticleVid", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 4, description = "Verify Article page with video and video loads correctly")
	@Test(dataProvider = "ArticleVid", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11734, 11737, 11664 || Verify Article page with video and video loads correctly")
	public void articlevidpage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testarticlevidpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "ArticleEmVid", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Article page with Embedded video and video loads correctly")
	@Test(dataProvider = "ArticleEmVid", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11731 || Verify Article page with Embedded video and video loads correctly")
	public void articleemvidpage(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testarticleemvidpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "ShowsPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify show page loads correctly")
	@Test(dataProvider = "ShowsPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify show page loads correctly")
	public void showspage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){				
				BaseTest test = new BaseTest(wf);
				test.testshowpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "SpecialPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Special page loads correctly")
	@Test(dataProvider = "SpecialPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Special page loads correctly")
	public void specialpage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){				
				BaseTest test = new BaseTest(wf);
				test.testshowpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "ProfilePage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Special page loads correctly")
	@Test(dataProvider = "ProfilePage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11675,11672 || Verify Profile page loads correctly")
	public void profilepage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){				
				BaseTest test = new BaseTest(wf);
				test.testprofilepage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "ArticleGalPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Article page with Gallery loads correctly with Gallery Elements")
	@Test(dataProvider = "ArticleGalPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11874, 11955 || Verify Article page with Gallery loads correctly with Gallery Elements")
	public void articlegalpage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){
				BaseTest test = new BaseTest(wf);
				test.testarticlegalpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "ArticleGalEmPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Article page with Gallery loads correctly with Gallery Elements")
	@Test(dataProvider = "ArticleGalEmPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "QC Test ID: 11660 || Verify Article page with Gallery loads correctly with Gallery Elements")
	public void articlegalempage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){				
				BaseTest test = new BaseTest(wf);
				test.testarticlegalempage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "WeatherPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Weather page loads correctly with proper Elements")
	@Test(dataProvider = "WeatherPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Weather page loads correctly with proper Elements")
	public void weatherpage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){				
				BaseTest test = new BaseTest(wf);
				test.testweatherpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "BrokenPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 4, description = "Verify Broken page text in all environments")
	@Test(dataProvider = "BrokenPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Broken page text in all environments")
	public void brokenpage(WdFace wf, int windowWidth, int windowHeight, String url){
				BaseTest test = new BaseTest(wf);
				test.testbrokenpage(url, windowWidth, windowHeight);
	}
	
	//@Test(dataProvider = "VideoLeafPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, priority = 3, description = "Verify Video leaf page - Page load tests")
	@Test(dataProvider = "VideoLeafPage", groups = {"smokeTests", "SmokeRefTests","SmokeTestsIntl","SmokeRefTestsINTL"}, description = "Verify Video leaf page - Page load tests")
	public void videoleafpage(WdFace wf, int windowWidth, int windowHeight, String url){
		String brow = wf.toString();
		if(((brow.startsWith("IE") || brow.equals("FIREFOX")) && windowWidth>1000) || brow.equals("CHROME") || brow.equals("SAFARI")){
				BaseTest test = new BaseTest(wf);
				test.testvideoleafpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "SponsorSectionPage", groups = {"smokeTests"}, priority = 3, description = "Verify Sponsor section Pages - Only for STAGE Domestic site")
	@Test(dataProvider = "SponsorSectionPage", groups = {"smokeTests"}, description = "Verify Sponsor section Pages - Only for STAGE Domestic site")
	public void sponsorsectionpage(WdFace wf, int windowWidth, int windowHeight, String url){
		if(System.getProperty("environment").equals("STAGE") && System.getProperty("site").equals("DOM")){
			BaseTest test = new BaseTest(wf);
			test.testsponsorsectionpage(url, windowWidth, windowHeight);
		}
	}
	
	//@Test(dataProvider = "StaticSkinnyNav", groups = {"smokeTests","SmokeTestsIntl"}, priority = 2, description = "Tests Home Page elements including header search")
	@Test(dataProvider = "StaticSkinnyNav", groups = {"smokeTests","SmokeTestsIntl"},description = "QC Test ID: 11945, 11947 || Tests Home Page elements including header search")
	public void StaticSkinnyNav(WdFace wf, int windowWidth, int windowHeight, String url){
		BaseTest test = new BaseTest(wf);
		test.testStaticSkinnyNav(windowWidth, windowHeight, url);
	}
	
	/**
	 * Provides information on page sizes and urls to tests requiring that information.
	 * 
	 * @param targetTest The method using this as a provider
	 * @return The window sizes and browsers to be tested
	 */
	
	@DataProvider(name = "ArticlePagesInHome", parallel = true)
	public static Object[][] articleData(Method targetTest){
		String[][] url = new String[1][1];
 		url[0][0] = Prefs.ARTICLE_URL;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	@DataProvider(name = "ArticlePagesInHomeSocial", parallel = true)
	public static Object[][] articleDataSocial(Method targetTest){
		String[][] url = new String[1][1];
 		url[0][0] = Prefs.ARTICLE_URL;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }

	@DataProvider(name = "GalleryPagesInHome", parallel = true)
	public static Object[][] galleryData(Method targetTest){
		String[][] url = new String[1][1];
 		url[0][0] = Prefs.GALLERY_URL;
 		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
 	@DataProvider(name = "SectionPages", parallel = true)
 	public static Object[][] sectionData(Method targetTest){
 		String[][] url = new String[1][1];
 		url[0][0] = Prefs.SECTION_URL;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
 	}
 	
 	@DataProvider(name = "SectFront", parallel = true)
 	public static Object[][] SFData(Method targetTest){
 		ExcelReader reader = new ExcelReader("section_front_dom.xlsx");
 		if(System.getProperty("site").equals("DOM"))
 			reader = new ExcelReader("section_front_dom.xlsx");
 		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("section_front_Intl.xlsx");
 		Object[][] params = reader.readFile();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
 	}
 	
 	@DataProvider(name = "IntSectFront", parallel = true)
 	public static Object[][] ISFData(Method targetTest){
 		ExcelReader reader = new ExcelReader("intl__region_section_urls.xlsx");
		reader = new ExcelReader("intl__region_section_urls.xlsx");
 		Object[][] params = reader.readFile();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
 	}	
 	
 	@DataProvider(name = "MorePages", parallel = true)
 	public static Object[][] MPData(Method targetTest){
 		ExcelReader reader = new ExcelReader("more_urls.xlsx");
 		//if(System.getProperty("site").equals("DOM"))
 			reader = new ExcelReader("more_urls.xlsx");
 		/*else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("more_urls_Intl.xlsx");*/
 		Object[][] params = reader.readFile();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
 	}
 	
 	@DataProvider(name = "TvSection", parallel = true)
 	public static Object[][] tvData(Method targetTest){
 		ExcelReader reader = new ExcelReader("tv_urls.xlsx");
 		if(System.getProperty("site").equals("DOM"))
 			reader = new ExcelReader("tv_urls.xlsx");
 		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("tv_urls_Intl.xlsx");
 		Object[][] params = reader.readFile();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
 	}
 	
 	@DataProvider(name = "Opinion", parallel = true)
 	public static Object[][] OpinionData(Method targetTest){
 		ExcelReader reader = new ExcelReader("opinions_urls.xlsx");
 		if(System.getProperty("site").equals("DOM"))
 			reader = new ExcelReader("opinions_urls.xlsx");
 		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("opinions_urls_Intl.xlsx");
 		Object[][] params = reader.readFile();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
 	}
 	
	@DataProvider(name = "SectionPagesWithOneDimention", parallel = true)
 	public static Object[][] sectionOneDimentionData(Method targetTest){
	 	ExcelReader reader = new ExcelReader("section_list.xlsx");
	 	if(System.getProperty("site").equals("DOM"))
	 	reader = new ExcelReader("section_list.xlsx");
	 	else if (System.getProperty("site").equals("INTL"))
	 	reader = new ExcelReader("section_list_Intl.xlsx");
	 	Object[][] params = reader.readFile();
	 	Integer[][] builtDimensions = new Integer[1][2];
	 	builtDimensions[0][0] = Integer.valueOf(1280);
	 	builtDimensions[0][1] = Integer.valueOf(720);
	 	Object[][] pageParams = builtDimensions;
	 	params = mergeParams(params, pageParams);
	 	return addBrowsers(params);
 	}
 	
 	
 	@DataProvider(name = "ArticlePagesWithOneDimention", parallel = true)
 	public static Object[][] articleOneDimentionData(Method targetTest){
	 	ExcelReader reader = new ExcelReader("AllArticlesInDOMhome.xls");
	 	Object[][] params = reader.readFile();
	 	Integer[][] builtDimensions = new Integer[1][2];
	 	builtDimensions[0][0] = Integer.valueOf(1280);
	 	builtDimensions[0][1] = Integer.valueOf(720);
	 	Object[][] pageParams = builtDimensions;
	 	params = mergeParams(params, pageParams);
	 	return addBrowsers(params);
 	}
																										
	@DataProvider(name = "VideoPage", parallel = true)
	public static Object[][] videoData(Method targetTest){
		ExcelReader reader = new ExcelReader("video_urls.xlsx");;
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("video_urls.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("video_urls_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	
	@DataProvider(name = "HomePage", parallel = true)
	public static Object[][] homePageData(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "HomePageMobile", parallel = true)
	public static Object[][] homePageMobileData(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizesMob();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "AdChoice", parallel = true)
	public static Object[][] adchoice(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "HomePageOneDim", parallel = true)
	public static Object[][] HomePageOneDim(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "HomePageChrIEOneDim", parallel = true)
	public static Object[][] HomePageChrIEOneDim(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
/*	@DataProvider(name = "HomePageFoxAllDim", parallel = true)
	public static Object[][] HomePageFoxAllDim(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes();
		params = mergeParams(params, pageParams);
		return addFoxBrowser(params);
	}
*/
	@DataProvider(name = "HomePageOneDim", parallel = true)
	public static Object[][] homePageDataOneDim(Method targetTest){
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "SponsorSectionPage", parallel = true)
	public static Object[][] SponsorSectionDataOneDim(Method targetTest){
		ExcelReader reader = new ExcelReader("sponsor_content_sections.xlsx");
		reader = new ExcelReader("sponsor_content_sections.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}
	
	@DataProvider(name = "StaticSkinnyNav", parallel = true)
	public static Object[][] StaticSkinnyNav(Method targetTest){
		ExcelReader reader = new ExcelReader("static_skinny_nav.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("static_skinny_nav.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("static_skinny_nav_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "PageSizes", parallel = true)
	public static Object[][] pageData(Method targetTest){
		ExcelReader reader = new ExcelReader("page_sizes.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes();
		params = mergeParams(params, pageParams);
		//addSectionURL(params);
		return addBrowsers(params);
	}
	
	@DataProvider(name = "MoneyPages", parallel = true)
	public static Object[][] moneyData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.MONEY_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "IntTravelPage", parallel = true)
	public static Object[][] intTravelData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.INTL_TRAVEL_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "IntVideoPages", parallel = true)
	public static Object[][] intVideoData(Method targetTest){
		ExcelReader reader = new ExcelReader("video_section_urls_Intl.xlsx");
		if(System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("video_section_urls.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("video_section_urls_Intl.xlsx");
		Object[][] params = reader.readFile();
		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "SportsPage", parallel = true)
	public static Object[][] sportsData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.SPORTS_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "ArticleVid", parallel = true)
	public static Object[][] ArticleVidData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleVidUrl;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "ArticleEmVid", parallel = true)
	public static Object[][] ArticleEmVidData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleEmVidUrl;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
	
	@DataProvider(name = "iReportPage", parallel = true)
	public static Object[][] iReportData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.IREPORT_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addChromeBrowser(params);
	 }
		
	@DataProvider(name = "ShowsPage", parallel = true)
	public static Object[][] showsData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.shows_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "ArticleGalPage", parallel = true)
	public static Object[][] ArticleGalData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleGalUrl;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "ArticleGalEmPage", parallel = true)
	public static Object[][] ArticleGalEmData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleGalEmUrl;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "SpecialPage", parallel = true)
	public static Object[][] SpecialData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.special_URL;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "WeatherPage", parallel = true)
	public static Object[][] WeatherData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.weatherUrl;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "BrokenPage", parallel = true)
	public static Object[][] BrokenData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.brokenUrl;
 		Object[][] params = url;
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes();
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "VideoLeafPage", parallel = true)
	public static Object[][] VideoData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.videoUrl;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	@DataProvider(name = "ProfilePage", parallel = true)
	public static Object[][] ProfileData(Method targetTest){
		String[][] url = new String[1][1];
		url[0][0] = Prefs.profile_URL;
 		Object[][] params = url;
 		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
 		//Object[][] pageParams = CmdLineHandler.getWindowSizes1();
 		params = mergeParams(params, pageParams);
 		return addBrowsers(params);
	 }
	
	public String getStartTime(String s){
		Date starttime = new java.sql.Timestamp(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat( "h:mm:ss a,z" );
		String starttime_formatted = format.format( starttime );
		if (s.equalsIgnoreCase("of_suite")){
			Reporter.log("<br>Suite Start time:"+starttime_formatted+"</br>");	
		}else {
			Reporter.log("<br>Start time:	"+starttime_formatted+"</br>");
		}
		return starttime_formatted;
	}
	 
	public String getEndTime(String s) {
		Date endTime = new java.sql.Timestamp(System.currentTimeMillis());
		DateFormat format = new SimpleDateFormat( "h:mm:ss a,z" );
		String endTime_formatted = format.format(endTime);
		if (s.equalsIgnoreCase("of_suite")){
			Reporter.log("<br>Suite End time:"+endTime_formatted+"</br>");	
		}else {
			Reporter.log("<br>End time:	"+endTime_formatted+"</br>");
		}
		return endTime_formatted;

	}
	
	@AfterSuite
	public void getinfo(){
		Reporter.log(getEndTime("of_suite"));
	}
	
}