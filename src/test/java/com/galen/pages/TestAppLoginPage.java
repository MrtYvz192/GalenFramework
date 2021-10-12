package com.galen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestAppLoginPage extends BasePage{

    @FindBy(name = "login.username")
    public WebElement usernameInputBox;

    @FindBy(name = "login.password")
    public WebElement passwordInputBox;


    @FindBy(tagName = "button")
    public WebElement loginButton;
}
