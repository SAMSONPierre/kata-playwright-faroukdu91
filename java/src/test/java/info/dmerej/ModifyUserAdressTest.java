package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyUserAdressTest {

    @Test
    void test_modify_user_adress() {
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

        page.navigate("/add_employee");
        page.getByPlaceholder("Zip code").fill("91380");
        page.getByPlaceholder("Name").fill("Farouk");
        page.getByPlaceholder("Email").fill("faroukdu91@gmail.com");
        page.locator("#id_address_line1").fill("10 avenue de Paris");
        page.getByPlaceholder("City").fill("Villejuif");
        page.getByPlaceholder("Hiring date").fill("2025-08-26");
        page.getByPlaceholder("Job title").fill("Dev");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();

        String addressLine2Value = page.locator("#id_address_line2").inputValue();
        assertEquals("", addressLine2Value, "Address line 2 should be empty!");
    }
}
