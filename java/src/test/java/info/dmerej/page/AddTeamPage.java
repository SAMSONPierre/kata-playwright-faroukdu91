package info.dmerej.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddTeamPage {

    private final Page page;

    private final String nameInputField = "input[name='name']";

    public AddTeamPage(Page page) {
        this.page = page;
    }

    public void fillTeamName(String teamName) {
        page.locator(nameInputField).fill(teamName);
    }

    public void clickAddButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
    }

    public void navigate() {
        page.navigate("/add-team");
    }

    public boolean isTeamVisible(String teamName) {
        String selector = String.format("td:has-text('%s')", teamName);
        return page.isVisible(selector);
    }
}
