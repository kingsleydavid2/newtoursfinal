package com.travels.newtours.test;

import java.awt.AWTException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cnn.expansion.test.core.Prefs;
import com.cnn.expansion.test.library.BaseTestMethods;
import com.cnn.expansion.test.utility.CmdLineHandler;
import com.cnn.expansion.test.utility.ExcelReader;
import com.cnn.expansion.test.webdriver.WdFace;
import com.cnn.expansion.test.webdriver.WdTest;

public class RegressionTests extends WdTest {

	// Weather Card Tests
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11822 || Home Page - Weather Card is Present")
	public void WeatherCardElem(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherCardElem(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11822 || Home Page - Weather Card Functionality with city name")
	public void WeatherCardCity(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherCardFnCity(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11822 || Home Page - Weather Card Functionality with Zip Code")
	public void WeatherCardZip(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherCardFnZip(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11825 || Home Page - Weather Card Functionality with Toggle")
	public void WeatherCardToggleCelcius(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherCardFnToggle(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "Home Page - Weather Card Functionality with Toggle")
	public void WeatherCardRedirect(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherCardRedirect(windowWidth, windowHeight, url);
	}

	// Weather Maps
	@Test(dataProvider = "WeatherPageOneDim", groups = { "Regression", "test7" }, description = "QC Test ID: 11821  || Weather Page  Changing Temp from Fahrenheit to Celsius and Celsius to Fahrenheit")
	public void WeatherPageMaps(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherMap(windowWidth, windowHeight, url);
	}

	//SEARCH
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test10" }, description = "Home Page Search CNN Validation")
	public void HomePageHeaderSearchInvalid(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageHeaderSearchInvalid(windowWidth, windowHeight, url);
	}
	
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test10" }, description = "Home Page Search CNN Validation")
	public void HomePageHeaderSearchBlank(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageHeaderSearchBlank(windowWidth, windowHeight, url);
	}	
	
	@Test(dataProvider = "HomePageOneDim", groups = {"test10" }, description = "Home Page Search CNN Validation")
	public void HomePageHeaderSearchValid(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageHeaderSearchValid(windowWidth, windowHeight, url);
	}
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test10" }, description = "Home Page Search CNN Validation")
	public void HomePageFooterSearchInvalid(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageFooterSearchInvalid(windowWidth, windowHeight, url);
	}
	
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test10" }, description = "Home Page Search CNN Validation")
	public void HomePageFooterSearchBlank(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageFooterSearchBlank(windowWidth, windowHeight, url);
	}	
	
	@Test(dataProvider = "HomePageOneDim", groups = { "test10" }, description = "Home Page Search CNN Validation")
	public void HomePageFooterSearchValid(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageFooterSearchValid(windowWidth, windowHeight, url);
	}	

	
	
	// HOME PAGE - HEADER NAV
	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11813, 11798 || Home Page - Nav - On Hover Functionalities")
	public void HomePageNavHover(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageNavHover(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "Header - Test no hyperlinks are broken")
	public void HeaderBrokenLinks(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderBrokenLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11803, 11830,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavLinks(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11802, 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavNewsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavNewsLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavRegionsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavRegionsLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11804, 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavVideoLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavVideoLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11805, 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavTvLinks(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavTvLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: ?, 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavFeaturesLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavFeaturesLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageThreeDimOneBrowser", groups = { "Regression",
			"test3" }, description = "QC Test ID: 11806, 11830, 11832,11835 || Home Page - Nav - All nav and Section Nav Link and Text validation")
	public void HeaderNavOpinionsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavOpinionsLinks(windowWidth, windowHeight, url);
	}

	// HEADER NAV - Sections links
	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void HeaderNavSecNewsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecNewsLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void NavSecNewsRegionsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecNewsRegionsLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void HeaderNavSecVideosLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecVideosLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void HeaderNavSecTvLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecTvLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void HeaderNavSecFeaturesLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecFeaturesLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "QC Test ID: 11906, 11833,11835  || Home Page - Nav - All Section Nav is highlighted in their corresponding pages")
	public void HeaderNavSecOpinionsLinks(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHeaderNavSecOpinionsLinks(windowWidth, windowHeight, url);
	}

	// Header watch Tv
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11906 || Home Page - Presence of Watch Live TV ")
	public void testHomepageMutedWatchTv(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testHomePageWatchTv(windowWidth, windowHeight, url);
	}

	// Footer
	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"test" }, description = "Footer - Test no Functionality are broken")
	public void FooterBrokenLinks(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testFooterBrokenLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "Footer - Test all sections are present and having correct url")
	public void FooterLinkValidation(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testFooterSectionValidation(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "StaticPages", groups = { "Regression", "test" }, description = "Footer Static Page - Test no Functionality are broken")
	public void FooterBrokenLinksStaticPage(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testFooterBrokenLinks(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "StaticPages", groups = { "Regression", "test" }, description = "Footer Static Page- Test all sections are present and having correct url")
	public void FooterLinkValidationStaticPage(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testFooterSectionValidation(windowWidth, windowHeight, url);
	}

	// Section Front Validations
	@Test(dataProvider = "SectionPagesThreeDimOneBrowser", groups = {
			"Regression", "test" }, description = "Section Front Advertisement scenarios")
	public void SectionPageAds(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testSectionPageAds(windowWidth, windowHeight, url);
	}

	// Section Page SubSection Validations
	@Test(dataProvider = "SectionPagesOneDimOneBrowser", groups = {
			"Regression", "test" }, description = "Section Page")
	public void SectionPageSubSec(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testSectionPageSubSec(windowWidth, windowHeight, url);
	}

	// Section Page SubSection Validations
	@Test(dataProvider = "SectionPagesOneDimOneBrowser", groups = {
			"Regression", "test" }, description = "Section Page")
	public void IntlSectionPageSubSec(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testIntlSectionPageSubSec(windowWidth, windowHeight, url);
	}

	// Gallery Page Validations
	@Test(dataProvider = "GalleryPageThreeDim", groups = { "Regression", "test" }, description = "Gallery Page Elements Validation")
	public void GalleryElements(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testGalleryElements(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "GalleryPageThreeDim", groups = { "Regression", "test" }, description = "Gallery Page Captions Validation")
	public void GalleryCaptions(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testGalleryCaptions(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "GalleryEmPage", groups = { "Regression", "test" }, description = "Gallery Page Embedded Validation")
	public void ArticleGalleryEmb(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleGalleryEmb(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "PullQuote", groups = { "Regression", "test8" }, description = "Article: Pull Quote")
	public void ArticlePullQuoteValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testPullQuoteValidations(windowWidth, windowHeight, url);
	}

	// Article Full width gallery
	@Test(dataProvider = "ArticleFullWidthGalleryOneDim", groups = {
			"Regression", "test" }, description = "Article: Article Full width gallery")
	public void ArticleFullWidthGalleryValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleFullWidthGallery(windowWidth, windowHeight, url);
	}

	// Profile Page
	@Test(dataProvider = "ProfilePage", groups = { "Regression", "test1" }, description = "Profile Page Elements Validation")
	public void ProfilePage(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testProfilePage(windowWidth, windowHeight, url);
	}

	// Weather Page
	@Test(dataProvider = "WeatherPageOneDim", groups = { "Regression", "test" }, description = "Weather Page Elements Validation")
	public void WeatherPage(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testWeatherPage(windowWidth, windowHeight, url);
	}

	// Weather Page Current Condition
	@Test(dataProvider = "WeatherPageOneDim", groups = { "Regression", "test" }, description = "Weather Page Current Condition")
	public void WeatherPageCurrent(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testCurrentConditions(windowWidth, windowHeight, url);
	}

	// Weather Page
	@Test(dataProvider = "WeatherPageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11821  || Weather Page  Changing Temp from Fahrenheit to Celsius and Celsius to Fahrenheit")
	public void WeatherPageChangeTemp(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testChangeTemp(windowWidth, windowHeight, url);
	}

	// Mega Nav
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "test" }, description = "QC Test ID: 11831, 11828, 11827, 11829  || Mega Nav Functionality")
	public void Meganav(WdFace wf, int windowWidth, int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testMegaNav(windowWidth, windowHeight, url);
	}

	// Video Leaf Page - Sunrise Player
	@Test(dataProvider = "LeafPage", groups = { "Regression", "test" }, description = "QC Test ID: 11976  || Video Leaf Page - Sunrise Player")
	public void VideoLeafBasicElements(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testVideoLeaf(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "LeafPage", groups = { "Regression", "test2" }, description = "QC Test ID: 11756  || Video Leaf Page - Sunrise Player Elements")
	public void VideoLeafVideoElements(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testVideoLeafVid(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "LeafPage", groups = { "Regression", "test" }, description = "QC Test ID: 11758, 12056  || Video Leaf Page - Dynamic Meta Data & Facet navigation")
	public void VideoLeafPlayerDynamicContent(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testVideoLeafPlayerDynamicContent(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "LeafPage", groups = { "Regression", "test" }, description = "QC Test ID: 11766  || Video Leaf Page - Carousel navigation test - Prev")
	public void VideoLeafPlayerNavPrev(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testVideoLeafPlayerPrevNav(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "LeafPage", groups = { "Regression", "test" }, description = "QC Test ID: 11765  || Video Leaf Page - Carousel navigation test - Next")
	public void VideoLeafPlayerNavNext(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testVideoLeafPlayerNextNav(windowWidth, windowHeight, url);
	}

	// Login
	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "login" }, description = "Validating Facebook login on my cnn page")
	public void loginMyCnnFB(WdFace wf, int windowWidth, int windowHeight,
			String url) throws InterruptedException {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.loginValidationFB(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDim", groups = { "Regression", "login" }, description = "Validating Twitter login on my cnn page")
	public void loginMyCnnTwitter(WdFace wf, int windowWidth, int windowHeight,
			String url) throws InterruptedException {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.loginValidationTwitter(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"login" }, description = "Validating Google+ login on my cnn page")
	public void loginMyCnnGoogle(WdFace wf, int windowWidth, int windowHeight,
			String url) throws InterruptedException {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.loginValidationGoogle(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "HomePageOneDimOneBrowser", groups = { "Regression",
			"login" }, description = "Validating LinkedIn login on my cnn page")
	public void loginMyCnnLinkedIn(WdFace wf, int windowWidth,
			int windowHeight, String url) throws InterruptedException {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.loginValidationLinkedIn(windowWidth, windowHeight, url);
	}

	/*
	 * // Video Landing Page
	 * 
	 * @Test(dataProvider = "LeafPage", groups = { "Regression", "test4" },
	 * description =
	 * "QC Test ID: 11831, 11828, 11827, 11829  || Mega Nav Functionality")
	 * public void VideoLandingPlayer(WdFace wf, int windowWidth, int
	 * windowHeight, String url){ BaseTestMethods test = new
	 * BaseTestMethods(wf); test.testVideoLandingPlayer(windowWidth,
	 * windowHeight, url); }
	 */

	// Article Leaf Page
	@Test(dataProvider = "ArticlePageOneDim", groups = { "Regression", "test" }, description = "Article Leaf Page")
	public void ArticlePage(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticlePage(windowWidth, windowHeight, url);

	}

	// Article Gallery Page
	@Test(dataProvider = "ArticlePageGalleryOneDim", groups = { "Regression",
			"test9" }, description = "QC TEST ID : 11736 || Article Page Elements Validation")
	public void ArticleGalleryElements(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testPageTopGallery(windowWidth, windowHeight, url);
	}

	// TV Shows
	@Test(dataProvider = "TvShowPageOneDime", groups = { "Regression", "test" }, description = "TV SHOWS PAGE")
	public void TvShowPageValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testTVShowValidations(windowWidth, windowHeight, url);
	}

	@DataProvider(name = "TvShowPageOneDime", parallel = true)
	public static Object[][] tvshowDataOneDim(Method targetTest) {
		ExcelReader reader = new ExcelReader("show_urls.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("show_urls.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("show_urls_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Show leaf page
	@Test(dataProvider = "ShowLeafPage", groups = { "Regression", "test" }, description = "SHOW LEAF PAGE : ElEMENTS")
	public void ShowLeafPageValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testShowLeafValidations(windowWidth, windowHeight, url);
	}

	@DataProvider(name = "ShowLeafPage", parallel = true)
	public static Object[][] ShowLeafPage(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.shows_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Full width Gallery
	@DataProvider(name = "ArticleFullWidthGalleryOneDim", parallel = true)
	public static Object[][] ArticleFullWidthGalleryData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = "http://edition.cnn.com/2015/07/27/politics/bobby-jindal-strengthen-gun-laws/index.html";
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Video Page
	@Test(dataProvider = "ArticlePageVideoOneDim", groups = { "Regression",
			"test" }, description = "QC TEST ID : 11737, 11734 || Article Page Top Video - No Auto Play")
	public void ArticleVideoPage(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleVideoPage(windowWidth, windowHeight, url);
	}

	// Article AutoPlay Video Page
	@Test(dataProvider = "ArticlePageAutoVideoOneDim", groups = { "Regression",
			"test" }, description = "QC TEST ID : 11737, 11734 || Article Page Top Video - Auto Play")
	public void ArticleAutoPlayVideoPage(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleAutoPlayVideoPage(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "ArticleCollectionsPageOneDim", groups = {
			"Regression", "test" }, description = "Article Top Collections Page")
	public void ArticleCollectionsPage(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleCollectionsPage(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "ArticleCollectionsPageOneDim", groups = {
			"Regression", "test" }, description = "Article TOp collection : click PRev")
	public void ArticleCollectionsPlayerNavPrev(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleCollectionPlayerPrevNav(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "ArticleCollectionsPageOneDim", groups = {
			"Regression", "test" }, description = "Article TOp collection : click Next")
	public void ArticleCollectionsPlayerNavNext(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testArticleCollectionPlayerNextNav(windowWidth, windowHeight, url);
	}

	// Container and Zone
	@Test(dataProvider = "SectionOneDim", groups = { "Regression", "test" }, description = "Section Page: Container and Zone elements")
	public void ContainerElements(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testContainerAndZoneElements(windowWidth, windowHeight, url);
	}

	// Feed card
	@Test(dataProvider = "SectionOneDim", groups = { "Regression", "test" }, description = "Feed card")
	public void FeedCard(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testFeedCard(windowWidth, windowHeight, url);
	}

	// Politics
	@Test(dataProvider = "PoliticsPageOneDim", groups = { "Regression", "test" }, description = "Politics Header elements")
	public void PoliticsSections(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testPoliticsHeaderElements(windowWidth, windowHeight, url);
	}

	//Politics Page Footer Validation
	@Test(dataProvider = "PoliticsPageOneDim", groups = { "Regression", "test" }, description = "Politics page Footer Validation")
	public void PoliticsPageFooterValidation(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.PoliticsPageFooter(windowWidth, windowHeight, url);
	}

	// Style page header
	@Test(dataProvider = "StylePageOneDim", groups = { "Regression", "test" }, description = "International Style page")
	public void StyleHeaderValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testStyleHeaderValidations(windowWidth, windowHeight, url);
	}

	// Style page gallery elements
	@Test(dataProvider = "StylePageOneDim", groups = { "Regression", "test" }, description = "International Style page: Gallery elements")
	public void StyleGalleryValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testStyleGalleryValidations(windowWidth, windowHeight, url);
	}

	@Test(dataProvider = "StylePageOneDim", groups = { "Regression", "test" }, description = "International Style page: click Prev and Next")
	public void StyleGalleryClickPrevValidations(WdFace wf, int windowWidth,
			int windowHeight, String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.testStyleGalleryPrevAndNext(windowWidth, windowHeight, url);
	}
	@Test(dataProvider = "StylePageOneDim", groups = { "Regression", "test10" }, description = "Style Page Footer Validation")
	public void StylePageFooterValidation(WdFace wf, int windowWidth, int windowHeight,
			String url) {
		BaseTestMethods1 test = new BaseTestMethods1(wf);
		test.StylePageFooter(windowWidth, windowHeight, url);
	}
	
	// Style Page
	@DataProvider(name = "StylePageOneDim", parallel = true)
	public static Object[][] StylePageOneDim(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.Style_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Politics Page
	@DataProvider(name = "PoliticsPageOneDim", parallel = true)
	public static Object[][] PoliticsPageOneDim(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.politicsURL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// One Dim Section Page
	@DataProvider(name = "SectionOneDim", parallel = true)
	public static Object[][] FeedCardData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.SECTION_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Collections Page
	@DataProvider(name = "ArticleCollectionsPageOneDim", parallel = true)
	public static Object[][] ArticleCollectionData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articlePTColl;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Leaf Page
	@DataProvider(name = "ArticlePageOneDim", parallel = true)
	public static Object[][] ArticleData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articlePTImage;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Gallery
	@DataProvider(name = "ArticlePageGalleryOneDim", parallel = true)
	public static Object[][] ArticleGalleryData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleGalUrl;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Video
	@DataProvider(name = "ArticlePageVideoOneDim", parallel = true)
	public static Object[][] ArticleVideoData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articlePTVideo;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	// Article Auto Video Play
	@DataProvider(name = "ArticlePageAutoVideoOneDim", parallel = true)
	public static Object[][] ArticleAutoVideoData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleVidUrl;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "HomePageOneDim", parallel = true)
	public static Object[][] HomePageOneDim(Method targetTest) {
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "HomePageOneDimOneBrowser", parallel = true)
	public static Object[][] HomePageOneDimOneBrowser(Method targetTest) {
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}

	@DataProvider(name = "HomePageOneDimAllBrowsers", parallel = true)
	public static Object[][] HomePageOneDimAllBrowsers(Method targetTest) {
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "HomePageThreeDimOneBrowser", parallel = true)
	public static Object[][] HomePageThreeDimOneBrowser(Method targetTest) {
		ExcelReader reader = new ExcelReader("homepage.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("homepage.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("homepage_intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}

	@DataProvider(name = "GalleryPageThreeDimOneBrowser", parallel = true)
	public static Object[][] GalleryPageThreeDimOneBrowser(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.GALLERY_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "GalleryPageThreeDim", parallel = true)
	public static Object[][] GalleryPageThreeDim(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.GALLERY_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "SectionPagesOneDimOneBrowser", parallel = true)
	public static Object[][] SectionPagesOneDimOneBrowser(Method targetTest) {
		ExcelReader reader = new ExcelReader("section_front_dom.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("section_front_dom.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("section_front_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}

	@DataProvider(name = "IntlSectionPagesOneDimOneBrowser", parallel = true)
	public static Object[][] IntlSectionPagesOneDimOneBrowser(Method targetTest) {
		ExcelReader reader = new ExcelReader("section_front_dom.xlsx");
		Object[][] params = null;
		if (System.getProperty("site").equals("DOM")) {
			// reader = new ExcelReader("section_front_dom.xlsx");
			params = null;
		} else if (System.getProperty("site").equals("INTL")) {
			reader = new ExcelReader("intl__region_section_urls.xlsx");
			params = reader.readFile();
		}
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}

	@DataProvider(name = "SectionPagesThreeDimOneBrowser", parallel = true)
	public static Object[][] SectionPagesThreeDimOneBrowser(Method targetTest) {
		ExcelReader reader = new ExcelReader("section_front_dom.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("section_front_dom.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("section_front_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addChromeBrowser(params);
	}

	@DataProvider(name = "ProfilePage", parallel = true)
	public static Object[][] ProfilePage(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.profile_URL;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "GalleryEmPage", parallel = true)
	public static Object[][] GalleryEmPage(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleGalEmUrl;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "GalleryEmPageOneDim", parallel = true)
	public static Object[][] GalleryEmPageThreeDim(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.articleGalEmUrl;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "LeafPage", parallel = true)
	public static Object[][] LeafPage(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.LeafPage;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "WeatherPageOneDim", parallel = true)
	public static Object[][] WeatherData(Method targetTest) {
		String[][] url = new String[1][1];
		url[0][0] = Prefs.weatherUrl;
		Object[][] params = url;
		// Object[][] pageParams = CmdLineHandler.getWindowSizes();
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "StaticPages", parallel = true)
	public static Object[][] StaticSkinnyNav(Method targetTest) {
		ExcelReader reader = new ExcelReader("static_skinny_nav.xlsx");
		if (System.getProperty("site").equals("DOM"))
			reader = new ExcelReader("static_skinny_nav.xlsx");
		else if (System.getProperty("site").equals("INTL"))
			reader = new ExcelReader("static_skinny_nav_Intl.xlsx");
		Object[][] params = reader.readFile();
		Object[][] pageParams = CmdLineHandler.getWindowSizes1();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

	@DataProvider(name = "PullQuote", parallel = true)
	public static Object[][] PullQuoteData(Method targetTest) {
		String[][] url = new String[1][1];
		if (!System.getProperty("site").equals("REF"))
			url[0][0] = Prefs.articlePullQuote;
		else
			url[0][0] = Prefs.articlePullQuoteRef;
		Object[][] params = url;
		Object[][] pageParams = CmdLineHandler.getWindowSizes3();
		params = mergeParams(params, pageParams);
		return addBrowsers(params);
	}

}
