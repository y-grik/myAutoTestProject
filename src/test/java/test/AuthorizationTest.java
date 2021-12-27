package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AuthPage;
import page.MainPage;

public class AuthorizationTest extends BaseTest {
    AuthPage authPage;
    MainPage mainPage;

    @BeforeEach
    public void setup(){
        authPage = new AuthPage();
        authPage.openAuthPage();
    }

    @Test
    public void successAuth(){
        mainPage = authPage.fullAuth("demo", "demo", "0000");
        String userName = authPage.checkUserName();
        Assertions.assertEquals("Королёва Ольга", userName);
    }

    @Test
    public void wrongPassword(){
        authPage.clearLogin();
        authPage.clearPassword();
        authPage.insertLogin("demo");
        authPage.insertPassword("1234");
        authPage.clicSingInButton();
        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }

    @Test
    public void emptyInpyt(){
        authPage.clearLogin();
        authPage.clearPassword();
        authPage.clicSingInButton();
        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }

    @Test
    public void Click() {
        authPage.clicSingInButton();
        authPage.clicSingInButtonCode();
    }


}
