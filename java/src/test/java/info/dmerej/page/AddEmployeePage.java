package info.dmerej.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddEmployeePage {

    private final Page page;

    // Locators
    private final String zipCodeField = "input[placeholder='Zip code']";
    private final String nameField = "input[placeholder='Name']";
    private final String emailField = "input[placeholder='Email']";
    private final String addressLine1Field = "#id_address_line1";
    private final String cityField = "input[placeholder='City']";
    private final String hiringDateField = "input[placeholder='Hiring date']";
    private final String jobTitleField = "input[placeholder='Job title']";

    public AddEmployeePage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("/add_employee");
    }

    public void fillZipCode(String zipCode) {
        page.locator(zipCodeField).fill(zipCode);
    }

    public void fillName(String name) {
        page.locator(nameField).fill(name);
    }

    public void fillEmail(String email) {
        page.locator(emailField).fill(email);
    }

    public void fillAddressLine1(String address) {
        page.locator(addressLine1Field).fill(address);
    }

    public void fillCity(String city) {
        page.locator(cityField).fill(city);
    }

    public void fillHiringDate(String date) {
        page.locator(hiringDateField).fill(date);
    }

    public void fillJobTitle(String jobTitle) {
        page.locator(jobTitleField).fill(jobTitle);
    }

    public void clickAddButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
    }

    public boolean isEmployeeVisible(String name) {
        String selector = String.format("td:has-text('%s')", name);
        return page.isVisible(selector);
    }
}
