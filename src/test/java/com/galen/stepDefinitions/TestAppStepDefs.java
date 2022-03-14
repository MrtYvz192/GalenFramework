package com.galen.stepDefinitions;

import com.galen.pages.BasePage;
import com.galen.pages.TestAppLoginPage;
import com.galen.pages.TestAppMyNotesPage;
import com.galen.pages.TestAppPage;
import com.galen.utilities.Driver;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestAppStepDefs {

    private String specSource = "src/test/resources/specs/tutorial.gspec";

    protected TestAppPage testAppPage = new TestAppPage();
    protected TestAppLoginPage testAppLoginPage = new TestAppLoginPage();
    protected TestAppMyNotesPage testAppMyNotesPage = new TestAppMyNotesPage();


    @Given("the user is on the testapp page")
    public void the_user_is_on_the_testapp_page() {
        Driver.get().get("http://testapp.galenframework.com/");
        Driver.get().manage().window().maximize();
    }

    @Given("the page layout is checked")
    public void the_page_layout_is_checked() throws IOException {
        testAppPage.layoutReport = Galen.checkLayout(Driver.get(), specSource, Arrays.asList("desktop"));
        testAppPage.updateReport(testAppPage.layoutReport, BasePage.tests,"TestApp Automation Using Galen Framework","Verify the elements");
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_Login_button() {
        testAppPage.button.click();
    }

    @When("the user provides username and password")
    public void the_user_provides_username_and_password() {
        // testuser@example.com test123
        testAppLoginPage.usernameInputBox.clear();
        testAppLoginPage.usernameInputBox.sendKeys("testuser@example.com");

        testAppLoginPage.passwordInputBox.clear();
        testAppLoginPage.passwordInputBox.sendKeys("test123");

        testAppLoginPage.loginButton.click();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("verify the My notes page","My Notes",testAppMyNotesPage.headlineText.getText());
    }

    @Then("the layout should be valid")
    public void the_layout_should_be_valid() throws IOException {

        specSource = "src/test/resources/specs/MyNotes.gspec";
        testAppLoginPage.layoutReport = Galen.checkLayout(Driver.get(), specSource, null);
        testAppMyNotesPage.updateReport(testAppLoginPage.layoutReport,BasePage.tests,"TestAppMyNotes Automation Using Galen Framework2","Verify the MyNote page");
    }

    @Given("the user lands on the home page")
    public void the_user_lands_on_the_home_page() {
        Driver.get().get("https://gitlab.com/users/sign_in");
    }
}
