package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class ResetDB {

    public static void reset_db(Page page) {
        // Reset database
        page.navigate("/reset_db");
        var proceedButton = page.locator("button:has-text('proceed')");
        proceedButton.click();
        page.navigate("/");
    }
}
