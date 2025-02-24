package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DeleteTeamTest extends BaseTest{

    @Test
    void test_delete_test() {
        User user1 = new User(
                "94800",
                "Farouk",
                "faroukdu91@gmail.com",
                "10 avenue de Paris",
                "Villejuif",
                "2025-08-26",
                "Dev"
        );

        page.navigate("/add_employee");

        page.getByPlaceholder("Zip code").fill(user1.getZipCode());
        page.getByPlaceholder("Name").fill(user1.getName());
        page.getByPlaceholder("Email").fill(user1.getEmail());
        page.locator("#id_address_line1").fill(user1.getAddress());
        page.getByPlaceholder("City").fill(user1.getCity());
        page.getByPlaceholder("Hiring date").fill(user1.getHiringDate());
        page.getByPlaceholder("Job title").fill(user1.getJobTitle());

        var addButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add"));
        addButton.click();

        page.navigate("/add_team");
        var nameInput = page.locator("input[name=\"name\"]");
        var teamName = "Team Farouk";
        nameInput.fill(teamName);
        page.click("text='Add'");

        page.navigate("/employees");
        var editUser = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit"));
        editUser.click();
        var addToTeam = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to team"));
        addToTeam.click();
        page.locator("id_team");
        page.locator("text=Team " + teamName).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();

        page.navigate("/teams");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delete")).click();

        page.navigate("/employees");

        var noEmployeeYet = page.getByRole(AriaRole.PARAGRAPH, new Page.GetByRoleOptions().setName("No employees yet."));
        if (noEmployeeYet.isVisible()) {
            fail("❌ No employee yet.");
        }

        assertTrue(!noEmployeeYet.isVisible());
    }
}
