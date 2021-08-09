package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.*;

public class CheckoutOverviewPage {

    public SelenideElement finishButton = $("#finish");
    public SelenideElement cancelButton = $("#cancel");
    public SelenideElement shoppingList = $ (".inventory_item_price");
    public ElementsCollection prices = $$(byXpath("//div[@class = 'inventory_item_price']"));
    public SelenideElement itemTotalPrice=$(".summary_subtotal_label");



    public void clickFinishButton(){
        finishButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public double getSum(){
        double sum = 0;
        for (SelenideElement selenideElement : prices) {
            String priceString = selenideElement.getText().substring(1);
            double price = Double.parseDouble(priceString);
            sum = sum + price;
        }
        return sum;
    }

    public double itemTotalPrice(){
        String substring = itemTotalPrice.getText().substring(13);
        return Double.parseDouble(substring);
    }
}
