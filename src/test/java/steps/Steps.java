package steps;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.ProductsPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Допустим("открыта страница \"([^\"]*)\"$")
    public void openPage(String pageURL) {
        open(pageURL);
        getWebDriver().manage().window().maximize();
        String currentPageURL = getWebDriver().getCurrentUrl();
        assertEquals(pageURL, currentPageURL, "Открыта неверная страница или неверно введен адрес страницы");
    }

   @Когда("в поле логин введено значение \"([^\"]*)\"$")
      public void fillLoginField(String string) {
        loginPage.userNameField.val(string);
        String name = loginPage.userNameField.getValue();
        Assertions.assertEquals(name, string);
   }

    @Когда ("в поле пароль введено значение {string}")
    public void fillPasswordField(String string) {
        loginPage.loginField.val(string);
        String pass = loginPage.loginField.getValue();
        Assertions.assertEquals(pass, string);
    }

    @Когда ("нажата кнопка Login")
    public void clickLogin() {
        loginPage.loginButton.click();
    }

    @Тогда("появляется сообщение с текстом \"([^\"]*)\"$")
    public void getErrorMessage (String messageText) {
        String errMess = loginPage.errorMessage.getText();
        Assertions.assertEquals(messageText, errMess);
    }
}
