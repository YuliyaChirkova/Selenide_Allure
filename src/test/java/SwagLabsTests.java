import org.junit.jupiter.api.*;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class SwagLabsTests extends BeforeAfterEach{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutYourInformation_Page checkoutYourInformationPage = new CheckoutYourInformation_Page();
    CheckoutOverview_Page checkoutOverviewPage = new CheckoutOverview_Page();
    CheckoutComplete_Page checkoutCompletePage = new CheckoutComplete_Page();
   

    @Test
    @Order(1)
    public void loginTest() throws IOException {
        loginPage.openPageAndLogin();
        Assertions.assertEquals("PRODUCTS", ProductsPage.productsTitle.getText());
    }

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

    @Test
    @Order(3)
    public void cancelOrderTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.clickCheckout();
        checkoutYourInformationPage.clickContinue();
        checkoutOverviewPage.clickCancelButton();
        Assertions.assertEquals("PRODUCTS", ProductsPage.productsTitle.getText());
    }

    @Test
    @Order(4)
    public void removeAllOrdersFromCartTest() throws IOException {
        loginPage.openPageAndLogin();
        productsPage.makeThreeOrder();
        cartPage.removeAllOrdersFromCart();
        int finalOrderList = cartPage.ordersCount();
        Assertions.assertEquals(0,finalOrderList );
    }

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



