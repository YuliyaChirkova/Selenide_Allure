package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.*;

public class CartPage {

    public SelenideElement continueButton = $("#continue-shopping");
    public SelenideElement checkOutButton = $("#checkout");
    public ElementsCollection orderList = $$(byText("Remove"));

    public void clickCheckout() {
        checkOutButton.click();
    }

    public void removeLastOrder() {
        orderList.last().click();
    }

    public int ordersCount() {
        return orderList.size();
    }

    @Step("Удаление всех товаров из корзины")
    public void removeAllOrdersFromCart() {
        int ordersCount = ordersCount();
        for (int i = 0; i < ordersCount; i++) {
            removeLastOrder();
        }
    }


}
