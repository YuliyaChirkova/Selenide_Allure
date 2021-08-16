package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public SelenideElement userNameField = $(By.id("user-name"));
    public SelenideElement loginField = $(By.id("password"));
    public SelenideElement loginButton = $(By.id("login-button"));
    public SelenideElement errorMessage = $(".error-message-container.error");

    @Step("Ввод логина и пароля")
    void login() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        userNameField.val(props.getProperty("user.username"));
        loginField.val(props.getProperty("user.password"));
        loginButton.click();
    }
    @Step("Открытие страницы логина")
    public void openLoginPage() {
        open("https://www.saucedemo.com/");
    }

    @Step("Открытие страницы логина и ввод логина и пароля")
    public void openPageAndLogin() throws IOException {
        openLoginPage();
        login();
    }

}
