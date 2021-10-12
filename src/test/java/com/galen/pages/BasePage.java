package com.galen.pages;

import com.galen.utilities.Driver;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void updateReport(LayoutReport layoutReport, List<GalenTestInfo> tests, String testInfo, String testTitle){
        try {

            //The object you create will be consisting the information regarding the test
            GalenTestInfo test = GalenTestInfo.fromString(testInfo); //"TestApp Automation Using Galen Framework"
            //Adding layout report to the test report
            test.getReport().layout(layoutReport,testTitle ); // "Verify the elements"
            tests.add(test);
            //Exporting all test report to html
            //new HtmlReportBuilder().build(tests, "target/galen-html-reports/"+testInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
