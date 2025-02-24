package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class AddUserWithInvalidZIPCodeTest {

    @Test
    void test_add_user_with_invalid_zip_code() {
        // Use playwright driver to get a browser and open a new page
        var playwright = Playwright.create();
        var launchOptions = new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(1000); // Remove this when you're done debugging
        var browser = playwright.chromium().launch(launchOptions);

        // Set base URL for the new context
        var contextOptions = new Browser.NewContextOptions();
        contextOptions.setBaseURL("https://f.lsi2.hr.dmerej.info");
        var context = browser.newContext(contextOptions);

        var page = context.newPage();

        ResetDB.reset_db(page);
    }
}
