package info.dmerej;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserTest {

    @Test
    void test_add_user() {
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
        page.onResponse(response -> {
            if (response.status() == 500) {
                fail("❌ Error 500 detected: " + response.url());
            }
        });

        ResetDB.reset_db(page);

        page.navigate("/add_employee");
        page.getByPlaceholder("Zip code").fill("888888888888888888888888888888888888888888888");
        page.getByPlaceholder("Name").fill("Farouk");
        page.getByPlaceholder("Email").fill("faroukdu91@gmail.com");
        page.locator("#id_address_line1").fill("10 avenue de Paris");
        page.getByPlaceholder("City").fill("Villejuif");
        page.getByPlaceholder("Hiring date").fill("2025-08-26");
        page.getByPlaceholder("Job title").fill("Dev");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();

        String selector = String.format("td:has-text('%s')", "Farouk");
        var isVisible = page.isVisible(selector);
        assertTrue(isVisible);
    }
}
