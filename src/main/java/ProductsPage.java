import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;


public class ProductsPage {

   public static SelenideElement productsTitle = $(byText("Products"));

    ElementsCollection products =$$ (".inventory_item_name");
    ElementsCollection addButtons =$$ (byXpath("//button[text()='Add to cart']"));
    SelenideElement shoppingCart = $ (".shopping_cart_link");


    public void clickCart(){
        shoppingCart.click();
    }

    public void addThreeProductsToCart(){
        for( int i = 0; i<3; i++) {
            addButtons.get(i).click();
        }
    }

    public CartPage makeThreeOrder(){
        addThreeProductsToCart();
        clickCart();
        return new CartPage();
    }




}

