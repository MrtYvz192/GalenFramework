package com.galen.stepDefinitions;

import com.galen.pages.BasePage;
import com.galen.utilities.Driver;
import com.galenframework.reports.HtmlReportBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before
    public void spinUp(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void reporting(Scenario scenario) throws IOException {
//        new HtmlReportBuilder().build(BasePage.tests, "target/galen-html-reports/");
//        if(scenario.isFailed()) {
        if (!BasePage.tests.isEmpty()) {
            String reportUrl = "http://localhost:63342/ZoetisPets/target/galen-html-reports/Test_Results/report.html?_ijt=isf17c1d196mc96crun4oba2qi&_ij_reload=RELOAD_ON_SAVE";
            String html = "<html><head><link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\"></head><body><a class=\"btn btn-info\" href=\""
                    + reportUrl + "\">Show Galen Test Result</a></body></html>";
            scenario.attach(html.getBytes(StandardCharsets.UTF_8), "text/html", "Galen report"); //==> to insert the galen report to Cucumber report
            scenario.log("<a type=\"button\" href=\""+reportUrl +"\">Show Galen Results</a>"); //==> to insert the galen report to default html report

        }
//        }
        Driver.closeDriver();
    }

}
