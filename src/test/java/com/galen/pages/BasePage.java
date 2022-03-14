package com.galen.pages;

import com.galen.utilities.Driver;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.google.gson.Gson;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    Gson gson = new Gson();

// ========================= GALEN CONFIGURATION ========================================

    public void updateReport(LayoutReport layoutReport, List<GalenTestInfo> tests, String testInfo, String testTitle){
        try {

            //The object you create will be consisting the information regarding the test
            GalenTestInfo test = GalenTestInfo.fromString(testInfo); //"TestApp Automation Using Galen Framework"
            //Adding layout report to the test report
            test.getReport().layout(layoutReport,testTitle ); // "Verify the elements"
            tests.add(test);
            //Exporting all test report to html
            new HtmlReportBuilder().build(tests, "target/galen-html-reports/Test_Results");//+testInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ================  Updating Cucumber report based on the Galen test result

        try{
            String reportPath = "target/galen-html-reports/Test_Results/report.json";//"target/galen-html-reports/" + testInfo + "/report.json";
            FileReader myJson = new FileReader(reportPath);

            Map<String, List<Map<String,Object>>> testResult = gson.fromJson(myJson, Map.class);
//            reportPath = reportPath.replace("json","html");

            Assert.assertTrue("Galen Test Failure, check Galen report!",
                    (testResult.get("tests")
                            .stream()
                            .filter(x->x.get("name").equals(testInfo))
                            .map(x -> !((boolean) x.get("failed")))
                            .filter(x -> !x).count() == 0L));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static List<GalenTestInfo> tests = new LinkedList<>();
    public LayoutReport layoutReport;
}
