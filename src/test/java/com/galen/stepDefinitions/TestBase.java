package com.galen.stepDefinitions;

import com.galen.pages.TestAppLoginPage;
import com.galen.pages.TestAppMyNotesPage;
import com.galen.pages.TestAppPage;
import com.galen.utilities.Driver;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;

public abstract class TestBase {

    //Creating a list of tests
    protected static List<GalenTestInfo> tests = new LinkedList<>();
    protected LayoutReport layoutReport;

    protected TestAppPage testAppPage = new TestAppPage();
    protected TestAppLoginPage testAppLoginPage = new TestAppLoginPage();
    protected TestAppMyNotesPage testAppMyNotesPage = new TestAppMyNotesPage();

    WebDriver driver = Driver.get();
}
