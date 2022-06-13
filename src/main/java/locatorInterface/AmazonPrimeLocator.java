package locatorInterface;

import org.openqa.selenium.By;

public interface AmazonPrimeLocator {
	
	By loginMenu = By.xpath("//span[text()='Account Menu']");
	By signIn_btn = By.xpath("//a[text()='Sign In']");
	By email_txtbox = By.id("ap_email");
	By pwd_txtbox = By.id("ap_password");
	By signIb_btn_for_login = By.id("signInSubmit");
	By profile_name = By.xpath("//span[@class='profiles-dropdown-name']");
	By search_icon = By.id("pv-search-nav");
	By all_movie_title = By.xpath("//a[@class='av-beard-title-link']");
	By movie_img = By.xpath("//img[@alt='K.G.F Chapter 2 (Hindi)']");
	By close_popup_btn = By.xpath("//label[@class='_1_aZiv']");
	By movie_desc = By.xpath("//div[@dir='auto']");
	By play_trailer = By.xpath("//a[@data-automation-id='trailer-button']");
	By close_video = By.xpath("//button[@aria-label='Close Player']");
	By store_home = By.xpath("//a[text()='Store']");
	By latest_movie = By.xpath("//h2[text()='New release movies']");
	By first_latest_movie = By.xpath("(//div[@class='jxBPRE']/descendant::li[1])[1]");

}
