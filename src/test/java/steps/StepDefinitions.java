package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QAProps;
import utils.TestDataReader;

import java.security.Key;
import java.util.HashMap;

public class StepDefinitions {

    private WebDriver driver;
    String url;
    HomePage homePage;
    HashMap<String, String> data;
    Scenario scenario;
    public StepDefinitions(BrowserManager browserManager){
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)public void before(Scenario scenario){
        this.scenario = scenario;}

    @Given("The user is navigated to the SnapDeal website and the search bar is visible.")
    public void theUserIsNavigatedToTheSnapDealWebsiteAndTheSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enters a valid product name in the search bar and hits the enter key.")
    public void the_user_enters_a_valid_product_name_in_the_search_bar_and_hits_the_enter_key() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("Input"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }

    @Then("The search results page should display all the relevant products related to the entered product name.")
    public void theSearchResultsPageShouldDisplayAllTheRelevantProductsRelatedToTheEnteredProductName() {
        String text = homePage.getSearchResult().getText();
        System.out.println(text);
        Assert.assertEquals(text,data.get("Input"));
    }


    @Given("user is able to access the search bar")
    public void userIsAbleToAccessTheSearchBar() {
        System.out.println("Search bar is accessable to the User");
    }


    @Given("The user is on the SnapDeal website and the search bar is visible.")
    public void theUserIsOnTheSnapDealWebsiteAndTheSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("The user enters multiple keywords in the search bar separated by space.")
    public void theUserEntersMultipleKeywordsInTheSearchBarSeparatedBySpace() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("Input"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The search results page should display all the relevant products related to the entered keywords.")
    public void theSearchResultsPageShouldDisplayAllTheRelevantProductsRelatedToTheEnteredKeywords() {
        String text = homePage.getMultipleKeywordResult().getText();
        System.out.println(text);
        Assert.assertEquals(text,data.get("Input"));
    }

    @Given("The user is navigated on to the SnapDeal website and the search bar is visible.")
    public void theUserIsNavigatedOnToTheSnapDealWebsiteAndTheSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("The user enters special characters in the search bar.")
    public void theUserEntersSpecialCharactersInTheSearchBar() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("Input"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The search results page should display relevant message indicating characters not found.")
    public void theSearchResultsPageShouldDisplayRelevantMessageIndicatingCharactersNotFound() {
        String text = homePage.getNegativeResult().getText();
        System.out.println(text);
        Assert.assertEquals(text,"Oops! Looks like something went wrong, please try again in sometime.");
    }


    @Given("the user is on the SnapDeal website and search bar is visible.")
    public void theUserIsOnTheSnapDealWebsiteAndSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user DoesNot enter the input and click on search bar.")
    public void theUserDoesNotEnterTheInputAndClickOnSearchBar() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("Input"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The Search bar should display all the valid results")
    public void theSearchBarShouldDisplayAllTheValidResults() {
        String text = homePage.getNegativeResult().getText();
        System.out.println(text);
        Assert.assertEquals(text,data.get("Input"));
    }

    @Given("the user is on the SnapDeal website")
    public void theUserIsOnTheSnapDealWebsite() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String arg0) {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(arg0);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("the search bar should display all the related results {string} .")
    public void theSearchBarShouldDisplayAllTheRelatedResults(String arg0) {
        String text = homePage.getProduct1().getText();
        System.out.println(text);
        Assert.assertEquals(text,arg0);

    }
}
