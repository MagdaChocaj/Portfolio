import fakestore.pages.*;
import fakestore.pages.Base.BaseProductPage;
import fakestore.pages.Base.CategoryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaceOrderTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final CategoryPage categoryPage = new CategoryPage();
    private final BaseProductPage baseProductPage = new BaseProductPage();
    private final CartPage cartPage = new CartPage();
    private final OrderPage orderPage = new OrderPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Test
    public void placeOrderTest(){
        String categoryName = "Windsurfing";
        String product = "Egipt - El Gouna";
        mainPage.goToTab("Sklep");
        shopPage.selectCategory(categoryName);
        assertEquals(categoryName, categoryPage.getHeader(), "Category is incorrect");
        categoryPage.selectProduct(product);
        baseProductPage.viewAdditionalInformation();
        baseProductPage.viewReviews();
        baseProductPage.viewProductDescription();
        baseProductPage.addQuantity("2");
        assertNotEquals("1", baseProductPage.getQuantity());
        baseProductPage.addProductToCart();
        assertThat(baseProductPage.getSuccessMessage()).isVisible();
        baseProductPage.clickViewCartButtonInSuccessMessage();
        cartPage.clickProceedToCheckoutButton();
        orderPage.fillConsumerDetailsAndCreateAnAccount();
        orderPage.addAdditionalDetails("Jeśli mnie nie będzie, proszę zostawić paczkę u sąsiada obok.");
        orderPage.fillCardDetails();
        orderPage.goToCheckout();

    }
}
