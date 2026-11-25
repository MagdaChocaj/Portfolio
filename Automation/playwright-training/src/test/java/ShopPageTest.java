import fakestore.pages.Base.BasePage;
import fakestore.pages.Base.CategoryPage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopPageTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final BasePage basePage = new BasePage();
    private final CategoryPage categoryPage = new CategoryPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Order(1)
    @Test
    public void selectCategoryTest(){
        mainPage.goToTab("Sklep");
        shopPage.selectCategory("Windsurfing");
        assertEquals("Windsurfing", categoryPage.getHeader(), "Category is incorrect");
    }

    @AfterAll
    public  void closeBrowser(){
        basePage.closeBrowser();
    }
}
