import org.junit.jupiter.api.*;
import pages.*;
import io.qameta.allure.*;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class SwagLabsTest extends BeforeAfterEach{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();



    @Description("Тест Логин на сайте")
    @Feature("Логин")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Order(1)
    public void loginTest() throws IOException {
        loginPage.openPageAndLogin();
        Assertions.assertEquals("PRODUCTS", productsPage.productsTitle.getText());
    }
    @Description("Тест Покупка товара")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("покупка товаров")
    @Story(value = "Пользователь покупает 3 товара")
    @Issue("1-45")
    @Test
    @Order(2)
    public void buyTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.clickCheckout();
        checkoutYourInformationPage.clickContinue();
        checkoutOverviewPage.clickFinishButton();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", checkoutCompletePage.textMessage.getText());
    }

  @Description("Тест Отмена покупки товара")
    @Severity(SeverityLevel.NORMAL)
    @Feature( "Отмена покупки")
    @Story(value = "Пользователь отменяет покупку")
    @Issue("1-23")
    @Test
    @Order(3)
    public void cancelOrderTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.clickCheckout();
        checkoutYourInformationPage.clickContinue();
        checkoutOverviewPage.clickCancelButton();
        Assertions.assertEquals("PRODUCTS", productsPage.productsTitle.getText());
        cartPage.removeAllOrdersFromCart();
    }

    @Description("Тест Удаление всех товаров из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Удаление товара из корзины")
    @Test
    @Order(4)
    public void removeAllOrdersFromCartTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.removeAllOrdersFromCart();
        int finalOrderList = cartPage.ordersCount();
        Assertions.assertEquals(0,finalOrderList );
    }

    @Description("Тест Проверка подсчета общей стоимости всех товаров в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(5)
    public void checkItemTotalCostTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.clickCheckout();
        checkoutYourInformationPage.clickContinue();
        double total = checkoutOverviewPage.getSum();
        double shouldBeTotal = checkoutOverviewPage.itemTotalPrice();
        Assertions.assertEquals(shouldBeTotal,total);
    }
}



