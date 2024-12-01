package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.timeout;

import java.time.Duration;

public class ApprovalRequestsSteps {

    // Setting a default timeout for all operations
    static {
        timeout = 10000; // 10 seconds global timeout
    }

    @Given("the tester logs into the Salesforce application")
    public void logIntoSalesforce(DataTable credentials) {
        open("https://brave-raccoon-1x8diw-dev-ed.trailblaze.lightning.force.com/lightning/n/trlhdtips__Welcome");

        // Retrieve credentials from the DataTable
        String username = credentials.cell(0, 1);
        String password = credentials.cell(1, 1);

        // Enter credentials and log in
        $x("//input[@id='username']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .setValue(username);

        $x("//input[@id='password']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .setValue(password);

        $x("//input[@id='Login']")
            .should(Condition.enabled, Duration.ofSeconds(10))
            .click();
    }

    @When("the tester opens the App Launcher")
    public void openAppLauncher() {
        // Wait for the App Launcher icon to appear and click it
        $x("//div[@class='slds-icon-waffle']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .click();

        // Click on "View All" after it appears
        $x("//button[contains(@aria-label, 'View All')]")
            .should(Condition.visible, Duration.ofSeconds(10))
            .click();
    }

    @When("the tester selects Approval Requests")
    public void selectApprovalRequests() {
        // Wait for "Approval Requests" to appear in the menu and click it
        $x("//p[text()='Approval Requests']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .click();
    }

    @Then("the tester verifies they land on the Approval Requests page")
    public void verifyApprovalRequestsPage() {
        // Verify the "Items to Approve" header is visible
        $x("//span[text()='Items to Approve']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .shouldHave(text("Items to Approve"));
    }

    @Then("there is an \"Items to Approve\" header")
    public void verifyItemsToApproveHeader() {
        // Verify the header is visible and has the correct text
        $x("//span[text()='Items to Approve']")
            .should(Condition.visible, Duration.ofSeconds(10))
            .shouldHave(text("Items to Approve"));
    }

    @Then("there are 0 items")
    public void verifyZeroItems() {
        // Verify the text "0 items" is visible on the page
        $x("//span[@class='countSortedByFilteredBy' and contains(text(), '0 items')]")
            .should(Condition.visible, Duration.ofSeconds(10))
            .shouldHave(text("0 items"));
    }
}
