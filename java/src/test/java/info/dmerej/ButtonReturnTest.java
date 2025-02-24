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

public class ButtonReturnTest extends BaseTest {
    @Test
    void test_button_retour() {
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
