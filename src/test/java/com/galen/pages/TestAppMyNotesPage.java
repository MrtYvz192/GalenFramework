package com.galen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestAppMyNotesPage extends BasePage{

    @FindBy(css = "#my-notes-page h2")
    public WebElement headlineText;
}
