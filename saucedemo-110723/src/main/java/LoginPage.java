import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "user-name")

    private WebElement usernameInputField;

    @FindBy(id = "password")

    private WebElement passwordInputField;

    public boolean userNameInputFieldIsDisplayed(){
        return usernameInputField.isDisplayed();
    }

    @FindBy(id = "login-button")

    private WebElement loginButton;



    @FindBy(css = "[data-test=\"error\"]")

    private WebElement errorMessage;

    @FindBy(className = "login_logo")

    private WebElement logo;

    @FindBy(id = "login_credentials")

    private WebElement credentials;

    @FindBy(className = "login_password")

    private WebElement password;



    public void enterUsername(String usernameValue){

        usernameInputField.sendKeys(usernameValue);

    }

    public void enterPassword (String passwordValue){

        passwordInputField.sendKeys(passwordValue);

    }

    public void clickOnLoginButton (){

        loginButton.click();

    }

    public String errorMessageGetText(){

        return errorMessage.getText();

    }

    public boolean logoIsDisplayed(){

        return logo.isDisplayed();

    }

    public boolean credentialsIsDisplayed(){

        return credentials.isDisplayed();

    }

    public boolean passwordIsDisplayed(){

        return password.isDisplayed();

    }

    public boolean usernameFieldIsDisplayed(){

        return usernameInputField.isDisplayed();

    }



}

