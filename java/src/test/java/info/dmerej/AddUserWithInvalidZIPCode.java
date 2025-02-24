package info.dmerej;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class AddUserWithInvalidZIPCode {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://f.lsi2.hr.dmerej.info/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new employee")).click();
            page.getByPlaceholder("Zip code").click();
            page.getByPlaceholder("Zip code").fill("888888888888888888888888888888888888888888888");
            page.getByPlaceholder("Name").click();
            page.getByPlaceholder("Name").fill("Farouk");
            page.getByPlaceholder("Name").press("Tab");
            page.getByPlaceholder("Email").fill("faroukdu91@gmail.com");
            page.locator("#id_address_line1").click();
            page.locator("#id_address_line1").fill("10 avenue de Paris");
            page.getByPlaceholder("City").click();
            page.getByPlaceholder("City").fill("Villejuif");
            page.getByPlaceholder("Hiring date").fill("2025-08-26");
            page.getByPlaceholder("Job title").click();
            page.getByPlaceholder("Job title").fill("Dev");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        }
    }
}