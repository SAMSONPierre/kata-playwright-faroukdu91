package info.dmerej;

import info.dmerej.page.AddTeamPage;
import info.dmerej.page.TeamPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTeamTest extends BaseTest {

    @Test
    void test_add_team() {
        AddTeamPage addTeamCreatePage = new AddTeamPage(page);

        page.navigate("/add_team");

        String teamName = "my team";
        addTeamCreatePage.fillTeamName(teamName);

        addTeamCreatePage.clickAddButton();

        TeamPage teamPage = new TeamPage(page);
        teamPage.navigate();

        assertTrue(teamPage.isTeamVisible(teamName));
    }
}
