import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.*;

public class CheckoutOverview_Page {

    SelenideElement finishButton = $("#finish");
    SelenideElement cancelButton = $("#cancel");
    SelenideElement shoppingList = $ (".inventory_item_price");
    ElementsCollection prices = $$(byXpath("//div[@class = 'inventory_item_price']"));
    SelenideElement itemTotalPrice=$(".summary_subtotal_label");



    public CheckoutComplete_Page clickFinishButton(){
        finishButton.click();
        return new CheckoutComplete_Page();
    }

    public ProductsPage clickCancelButton(){
        cancelButton.click();
        return new ProductsPage();

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
