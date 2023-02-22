package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="inputValEnter")
            @Getter
    WebElement searchBox;

    @FindBy(xpath="//span[text()=\"mobiles\"]")
            @Getter
    WebElement searchResult;

    @FindBy(xpath = "//div[@id=\"searchMessageContainer\"]//span[2]")
            @Getter
    WebElement multipleKeywordResult;

    @FindBy(xpath = "//span[@class=\"alert-heading\"]")
    @Getter
    WebElement negativeResult;

    @FindBy(xpath = "(//span[@class=\"nnn\"])[1]")
    @Getter
    WebElement product1;



}
