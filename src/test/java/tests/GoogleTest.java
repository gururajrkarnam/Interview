package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GooglePage;
import listeners.ExtentListener;

@Listeners(ExtentListener.class)
public class GoogleTest extends BaseTest {

    @Test
    public void launchGoogle() {

        GooglePage googlePage =
                new GooglePage(driver);

        googlePage.openGoogle();

        String title =
                googlePage.getTitle();

        Assert.assertTrue(
                title.contains("Google"));
    }
}