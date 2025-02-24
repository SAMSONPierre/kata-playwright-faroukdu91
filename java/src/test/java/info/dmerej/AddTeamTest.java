package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTeamTest extends BaseTest {
    @Test
    void test_add_team() {
        page.navigate("/add_team");
        var nameInput = page.locator("input[name=\"name\"]");
        var teamName = "my team";
        nameInput.fill(teamName);
        page.click("text='Add'");

        // Check that the team has been added
        page.navigate("/teams");

        // Check the new team is there
        String selector = String.format("td:has-text('%s')", teamName);
        var isVisible = page.isVisible(selector);
        assertTrue(isVisible);
    }
}
