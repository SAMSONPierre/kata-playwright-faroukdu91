package info.dmerej;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import info.dmerej.page.AddEmployeePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyUserAdressTest extends BaseTest{

    @Test
    void test_modify_user_adress() {
        AddEmployeePage addEmployeePage = new AddEmployeePage(page);

        addEmployeePage.navigate();

        addEmployeePage.fillZipCode("91380");
        addEmployeePage.fillName("Farouk");
        addEmployeePage.fillEmail("faroukdu91@gmail.com");
        addEmployeePage.fillAddressLine1("10 avenue de Paris");
        addEmployeePage.fillCity("Villejuif");
        addEmployeePage.fillHiringDate("2025-08-26");
        addEmployeePage.fillJobTitle("Dev");

        addEmployeePage.clickAddButton();

        //TODO Page object model for these pages
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();

        String addressLine2Value = page.locator("#id_address_line2").inputValue();
        assertEquals("", addressLine2Value, "Address line 2 should be empty!");
    }
}
