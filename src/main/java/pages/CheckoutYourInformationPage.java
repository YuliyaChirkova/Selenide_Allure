package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;


public class CheckoutYourInformationPage {

    SelenideElement firstNameField = $("#first-name");
    SelenideElement lastNameField = $("#last-name");
    SelenideElement zipField = $("#postal-code");
    SelenideElement continueButton = $("#continue");
    SelenideElement cancelButton = $("#cancel");

    @Step("Заполнение данных покупателя при покупке товаров")
    public void setDataFields() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        firstNameField.val(props.getProperty("user.firstName"));
        lastNameField.val(props.getProperty("user.lastName"));
        zipField.val(props.getProperty("user.zip"));
    }
    @Step("Заполнение данных покупателя при покупке товаров и нажатие на кнопку Продолжить")
    public void clickContinue() throws IOException {
        setDataFields();
        continueButton.click();
    }
    @Step("Нажатие на кнопку Продолжить")
    public void clickCancel() throws IOException {
        setDataFields();
        cancelButton.click();
    }
}
