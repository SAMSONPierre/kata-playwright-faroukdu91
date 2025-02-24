package info.dmerej;

import info.dmerej.page.AddEmployeePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserTest extends BaseTest {

    @Test
    void test_add_user() {
        AddEmployeePage addEmployeePage = new AddEmployeePage(page);

        addEmployeePage.navigate();

        addEmployeePage.fillZipCode("888888888888888888888888888888888888888888888");
        addEmployeePage.fillName("Farouk");
        addEmployeePage.fillEmail("faroukdu91@gmail.com");
        addEmployeePage.fillAddressLine1("10 avenue de Paris");
        addEmployeePage.fillCity("Villejuif");
        addEmployeePage.fillHiringDate("2025-08-26");
        addEmployeePage.fillJobTitle("Dev");

        addEmployeePage.clickAddButton();

        assertTrue(addEmployeePage.isEmployeeVisible("Farouk"));
    }
}
