package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserTest extends BaseTest {

    @Test
    void test_add_user() {
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
