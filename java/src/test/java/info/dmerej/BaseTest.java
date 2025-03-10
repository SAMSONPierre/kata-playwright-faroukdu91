package info.dmerej;

import com.microsoft.playwright.*;
import info.dmerej.page.AddTeamPage;
import info.dmerej.page.ResetDbPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Fail.fail;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void setUpClass() {
        playwright = Playwright.create();
        var launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000);
        browser = playwright.chromium().launch(launchOptions);
    }

    @BeforeEach
    void setUp() {
        var contextOptions = new Browser.NewContextOptions();
        contextOptions.setBaseURL("https://f.lsi2.hr.dmerej.info");
        context = browser.newContext(contextOptions);
        page = context.newPage();
        page.onResponse(response -> {
            if (response.status() == 500) {
                fail("❌ Error 500 detected: " + response.url());
            }
        });
        resetDB();
    }

    void resetDB() {
        ResetDbPage resetDbPage = new ResetDbPage(page);
        resetDbPage.navigate();
        resetDbPage.clickProceedButton();
        resetDbPage.navigateToHomePage();
    }

    @AfterAll
    static void tearDownClass() {
        browser.close();
        playwright.close();
    }
}
