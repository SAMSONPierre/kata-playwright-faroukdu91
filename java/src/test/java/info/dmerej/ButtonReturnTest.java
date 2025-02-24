package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


import static org.junit.jupiter.api.Assertions.*;

public class ButtonReturnTest {
    @Test
    void test_button_retour() {
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
        assertNotEquals(0, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Retour")).count());
        page.navigate("/employees");
        assertNotEquals(0, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Retour")).count());
        page.navigate("/teams");
        assertNotEquals(0, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Retour")).count());
        page.navigate("/add_team");
        assertNotEquals(0, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Retour")).count());
        page.navigate("/reset_db");
        assertNotEquals(0, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Retour")).count());
    }
}
