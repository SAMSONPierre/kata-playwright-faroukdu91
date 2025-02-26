package info.dmerej;

import info.dmerej.model.User;
import info.dmerej.page.AddEmployeePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserTest extends BaseTest {

    @Test
    void test_add_user() {
        User user = new User(
                "888888888888888888888888888888888888888888888",
                "Farouk",
                "faroukdu91@gmail.com",
                "10 avenue de Paris",
                "Villejuif",
                "2025-08-26",
                "Dev"
        );
        AddEmployeePage addEmployeePage = new AddEmployeePage(page);

        addEmployeePage.navigate();

        addEmployeePage.addEmployee(user);

        addEmployeePage.clickAddButton();

        assertTrue(addEmployeePage.isEmployeeVisible("Farouk"));
    }
}
