package page;

import org.openqa.selenium.By;

public class AuthPage extends BasePage {

    String pageURL = "https://idemo.bspb.ru/auth?response_type=code&client_id=1&redirect_uri=https%3A%2F%2Fidemo.bspb.ru%2Flogin%2Fsuccess&prefetch_uri=https%3A%2F%2Fidemo.bspb.ru%2Flogin%2Fprefetch&force_new_session=true";

    private static final By USERNAME_LOCATOR = By.xpath("//input[@name='username']");
    private static final By PASSWORD_LOCATOR = By.xpath("//input[@name='password']");
    private static final By SING_IN_BUTTON_LOCATOR = By.xpath("//button[@id='login-button']");
    private static final By SING_CODE_LOCATOR = By.xpath("//input[@id='otp-code']");
    private static final By SING_IN_BUTTON_SMS_LOCATOR = By.xpath("//button[@id='login-otp-button']");
    private static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");
    private static final By USER_NAME = By.xpath("//span[@class='filter-option pull-left']");

    public void clearLogin(){
        clear(USERNAME_LOCATOR);
    }

    public void clearPassword(){
        clear(PASSWORD_LOCATOR);
    }

    public void clearCode(){
        clear(SING_CODE_LOCATOR);
    }

    public AuthPage insertLogin(String login){
        type(USERNAME_LOCATOR, login);
        return this;
    }

    public AuthPage insertPassword(String password){
        type(PASSWORD_LOCATOR, password);
        return this;
    }

    public void clicSingInButton(){
        click(SING_IN_BUTTON_LOCATOR);
    }

    public AuthPage insertCode(String code){
        type(SING_CODE_LOCATOR, code);
        return this;
    }

    public void clicSingInButtonCode(){
        click(SING_IN_BUTTON_SMS_LOCATOR);
    }

    public String getErrorMessage() {
        return getElementText(ERROR_MESSAGE);
    }

    public String checkUserName() {
        return getElementText(USER_NAME);
    }

    public void openAuthPage() {
        openUrl(pageURL);
    }

    public MainPage fullAuth(String login, String password, String code) {
        clearLogin();
        clearPassword();
        insertLogin(login);
        insertPassword(password);
        clicSingInButton();
        clearCode();
        insertCode(code);
        clicSingInButtonCode();

        return new MainPage();
    }

}
