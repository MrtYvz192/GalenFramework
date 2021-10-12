package com.galen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestAppPage extends BasePage{

    @FindBy(id = "header")
    public WebElement header;

    @FindBy(css = "#header [class='middle-wrapper']")
    public WebElement headline;

    @FindBy(id = "header-logo")
    public WebElement logo;

    @FindBy(id = "menu")
    public WebElement menu;

    @FindBy(css = "#menu ul")
    public WebElement tabs;

    @FindBy(id = "welcome-page")
    public WebElement welcomePanel;

    @FindBy(css = "button[type='button']")
    public WebElement button;

    @FindBy(css = "welcome-page p a")
    public WebElement link;

    @FindBy(id = "footer")
    public WebElement footer;

    @FindBy(css = "#footer .footer-signature")
    public WebElement signature;



}
