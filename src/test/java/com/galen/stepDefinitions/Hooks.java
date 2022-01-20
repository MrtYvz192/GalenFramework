package com.galen.stepDefinitions;

import com.galen.utilities.Driver;
import com.galenframework.reports.HtmlReportBuilder;
import io.cucumber.java.After;


import java.io.IOException;

public class Hooks {

    @After
    public void reporting() throws IOException {
        new HtmlReportBuilder().build(TestBase.tests, "target/galen-html-reports/");
       // Driver.get().close();
    }

}
