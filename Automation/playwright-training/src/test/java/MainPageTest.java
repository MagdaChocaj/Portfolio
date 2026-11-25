import fakestore.pages.Base.BasePage;
import fakestore.pages.Base.CategoryPage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import fakestore.pages.Base.BaseProductPage;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final BasePage basePage = new BasePage();
    private final CategoryPage categoryPage = new CategoryPage();
    private final BaseProductPage baseProductPage = new BaseProductPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Order(1)
    @Test
    public void loadBrowserAndOpenMainPageTest() {
        assertThat(mainPage.getMainPage()).hasURL("https://fakestore.testelka.pl/");
        assertEquals("Wybierz podróż dla siebie!", mainPage.getHeader(), "Header is incorrect");

    }

    @Order(2)
    @Test
    public void navigateToShopPageTest() {
        mainPage.goToTab("Sklep");
        assertEquals("Sklep", shopPage.getHeader(), "Header is incorrect");
    }

    @Order(3)
    @Test
    public void selectCategoryTest() {
        assertThat(mainPage.getProductCategorySection()).isVisible();
        mainPage.selectProductCategory("Windsurfing");
        assertEquals("Windsurfing", categoryPage.getHeader(), "Header is incorrect");
        assertThat(categoryPage.getCategoryPage()).hasURL("");
    }

    @Order(4)
    @Test
    public void selectProductFromSectionTest(){
        assertThat(mainPage.getProductSection("Bestsellery")).isVisible();
        String productName = mainPage.getProductNameFromSection("Bestsellery", "Wspinaczka Via Ferraty" );
        mainPage.selectProductFromSection("Bestsellery", "Wspinaczka Via Ferraty");
        assertEquals(productName, baseProductPage.getProductTitle(), "Incorrect product has been opened" );
        assertThat(baseProductPage.getProductPage()).hasURL(baseProductPage.getURL());
    }

    @AfterAll
    public void closeBrowser(){
        basePage.closeBrowser();
    }

}
