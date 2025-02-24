package info.dmerej.page;

import com.microsoft.playwright.Page;

public class ResetDbPage {

    private final Page page;

    // Locators
    private final String proceedButton = "button:has-text('proceed')";

    public ResetDbPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("/reset_db");
    }

    public void clickProceedButton() {
        page.locator(proceedButton).click();
    }

    public void navigateToHomePage() {
        page.navigate("/");
    }
}
