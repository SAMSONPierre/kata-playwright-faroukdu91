package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyUserAdressTest extends BaseTest{

    @Test
    void test_modify_user_adress() {
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
