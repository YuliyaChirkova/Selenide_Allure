package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;


public class ProductsPage {

    public SelenideElement productsTitle = $(byText("Products"));
    public ElementsCollection products =$$ (".inventory_item_name");
    public ElementsCollection addButtons =$$ (byXpath("//button[text()='Add to cart']"));
    public SelenideElement shoppingCart = $(".shopping_cart_link");


    public void clickCart(){
        shoppingCart.click();
    }

    public void addThreeProductsToCart(){
        for( int i = 0; i<3; i++) {
            addButtons.get(i).click();
        }
    }
    @Step("Добавление трех товаров в корзину")
    public void makeThreeOrder(){
        addThreeProductsToCart();
        clickCart();
    }




}

