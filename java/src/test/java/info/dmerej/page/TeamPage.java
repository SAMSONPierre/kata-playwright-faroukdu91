package info.dmerej.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TeamPage {

    private final Page page;

    public TeamPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("/teams");
    }

    public boolean isTeamVisible(String teamName) {
        String selector = String.format("td:has-text('%s')", teamName);
        return page.isVisible(selector);
    }
}
