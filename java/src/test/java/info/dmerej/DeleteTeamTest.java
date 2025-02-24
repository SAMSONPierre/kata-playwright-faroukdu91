package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import info.dmerej.page.AddEmployeePage;
import info.dmerej.page.AddTeamPage;
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
        AddEmployeePage addEmployeePage = new AddEmployeePage(page);

        addEmployeePage.navigate();

        addEmployeePage.fillZipCode(user1.getZipCode());
        addEmployeePage.fillName(user1.getName());
        addEmployeePage.fillEmail(user1.getEmail());
        addEmployeePage.fillAddressLine1(user1.getAddress());
        addEmployeePage.fillCity(user1.getCity());
        addEmployeePage.fillHiringDate(user1.getHiringDate());
        addEmployeePage.fillJobTitle(user1.getJobTitle());
        addEmployeePage.clickAddButton();

        AddTeamPage addTeamCreatePage = new AddTeamPage(page);

        page.navigate("/add_team");

        String teamName = "Team Farouk";
        addTeamCreatePage.fillTeamName(teamName);
        addTeamCreatePage.clickAddButton();


        //TODO Page object model for these pages
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
