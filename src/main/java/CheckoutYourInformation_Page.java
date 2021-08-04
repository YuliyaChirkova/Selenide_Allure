import com.codeborne.selenide.SelenideElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;


public class CheckoutYourInformation_Page {

    SelenideElement firstNameField = $("#first-name");
    SelenideElement lastNameField = $("#last-name");
    SelenideElement zipField = $("#postal-code");
    SelenideElement continueButton = $("#continue");
    SelenideElement cancelButton = $("#cancel");

    public void setDataFields() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        firstNameField.val(props.getProperty("user.firstName"));
        lastNameField.val(props.getProperty("user.lastName"));
        zipField.val(props.getProperty("user.zip"));
    }


    public CheckoutOverview_Page clickContinue() throws IOException {
        setDataFields();
        continueButton.click();
        return new CheckoutOverview_Page();
    }

    public CartPage clickCancel() throws IOException {
        setDataFields();
        cancelButton.click();
        return new CartPage();
    }
}
