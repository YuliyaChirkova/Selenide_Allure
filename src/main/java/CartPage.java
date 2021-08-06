import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.*;

public class CartPage {

    SelenideElement continueButton = $("#continue-shopping");
    SelenideElement checkOutButton = $("#checkout");
    ElementsCollection orderList = $$(byText("Remove"));

    public void clickCheckout() {
        checkOutButton.click();
    }

    public void removeLastOrder() {
        orderList.last().click();
    }

    public int ordersCount() {
        return orderList.size();
    }

    public void removeAllOrdersFromCart() {
        int ordersCount = ordersCount();
        for (int i = 0; i < ordersCount; i++) {
            removeLastOrder();
        }
    }


}
