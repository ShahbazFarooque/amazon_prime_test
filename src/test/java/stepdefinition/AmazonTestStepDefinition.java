package stepdefinition;

import io.cucumber.java.en.When;
import pageComponent.AmazonPrimeComponent;
import utilities.ConfigReader;

import org.junit.Assert;

import driverfactory.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmazonTestStepDefinition {

	AmazonPrimeComponent primeComponent = new AmazonPrimeComponent();

	@Given("I am at home page of amazon prime {string}")
	public void i_want_to_write_a_step_with(String pageTitle) {
		System.out.println("Step Name ---------- " + pageTitle);
		ConfigReader configReader = new ConfigReader();
		configReader.setPropertiesFile("config");
		String url = configReader.getPropertiesValue("url");
		WebDriverFactory.getDriver().get(url);
		Assert.assertEquals(WebDriverFactory.getDriver().getTitle(), pageTitle);
	}

	@When("I click on user profile logo for login option")
	public void i_click_on_user_profile_logo_for_login_option() {
		primeComponent.clickOnButton("loginMenu");
	}

	@And("I click on sign in option from dropdown")
	public void i_click_on_sign_in_option_from_dropdown() {
		primeComponent.clickOnButton("signIn_btn");
	}

	@And("I do login with email id {string} and {string}")
	public void i_do_login_with_email_pwd(String email, String pwd) {
		primeComponent.userDoLogin("email_txtbox", email, "pwd_txtbox", pwd, "signIb_btn_for_login");
	}

	@Then("I verify is user logged in {string}")
	public void i_verify_is_user_logged_in(String userName) {
		String actualText = primeComponent.getTextFromElement("profile_name");
		Assert.assertEquals(userName, actualText);
	}
	
	@And("I click on search bar")
	public void i_click_on_search_bar() {
		primeComponent.clickOnButton("search_icon");
	}
	
	@And("I search for movie {string}")
	public void i_search_for_movie(String movieName) {
		primeComponent.sendValueToTextbox("search_icon", movieName);
		primeComponent.pressEnter("search_icon");
	}
	
	@Then("I verify same movie is there or not {string}")
	public void i_verify_same_movie_is_there_or_not(String movieName) {
		boolean status = primeComponent.getTextFromElement("all_movie_title", movieName);
		Assert.assertEquals(status, true);
	}
	
	@And("I click on searched movie {string}")
	public void i_click_on_searched_movie(String movieName) {
		primeComponent.searchAndClick("all_movie_title", movieName);
	}
	
	@And("I verify user landed to movie description page {string}")
	public void i_verify_user_landed_to_movie_description_page(String description) {
		primeComponent.clickOnButton("close_popup_btn");
		String actualText = primeComponent.getTextFromElement("movie_desc");
		Assert.assertEquals(description, actualText);
	}
	
	@And("I click on play video button")
	public void i_click_on_play_video_button() {
		primeComponent.clickOnButton("play_trailer");
	}
	
	@And("I close the play video")
	public void i_close_the_play_video() {
		primeComponent.clickOnButton("close_video");
	}
	
	@And("I click on store")
	public void i_click_on_store() {
		primeComponent.clickOnButton("store_home");
	}
	
	@And("I scroll to latest movie section")
	public void i_scroll_to_latest_movie_section() {
		primeComponent.scrollUntilVisibleElement("latest_movie");
	}
	
	@And("I click on first latest movie")
	public void i_click_on_first_latest_movie() {
		primeComponent.hoverAndClick("first_latest_movie");
	}

}
