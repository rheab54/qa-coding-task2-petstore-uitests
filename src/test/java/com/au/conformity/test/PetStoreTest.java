package com.au.conformity.test;

import com.au.conformity.pages.LoginSignInPage;
import com.au.conformity.pages.PetCatalogPage;
import com.au.conformity.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test cases for the pet store
 *
 */
public class PetStoreTest extends BaseTest {

    WelcomePage welcomePage;
    LoginSignInPage loginPage;
    PetCatalogPage catalogPage;

    // Test verifies all images are displayed on homepage
    // Another way to test this is to click on each image url and verify response code ... not implemented
    @Test
    public void validateWelcomePageWithImagesTest() throws InterruptedException {
        test = report.createTest("To verify Welcome Page");
        welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.verifyIamOnWelcomePage(), "Welcome Page is not displayed");
        welcomePage.clickToEnter();
        Assert.assertTrue(welcomePage.verifySplashIsDisplayed().contains("splash.gif"), "Pets are not displayed");
        Assert.assertTrue(welcomePage.verifyAllPetImagesAreDisplayed(), "Some Images are not displayed properly");
    }

    // Register a User and login to see if the correct user is displayed-
    @Test
    public void registerUserTest() throws InterruptedException {
        test = report.createTest("To Register user successfully");
        welcomePage = new WelcomePage(driver);
        loginPage = new LoginSignInPage(driver);
        welcomePage.clickToEnter();
        welcomePage.clickSignIn();
        loginPage.registerUser();
        Assert.assertTrue(loginPage.welcomeFirstNameIsDisplayed("Rhea"), "Welcome firstname wasn't displayed");
        Assert.assertTrue(loginPage.myAccountIsDisplayed(), "My account wasnt displayed");
        // further assertions can be added - click on mystore and verify all fields were added properly
    }

    @Test
    public void addItemsToCartTest() throws InterruptedException {
        test = report.createTest("To checkout cart successfully");
        welcomePage = new WelcomePage(driver);
        loginPage = new LoginSignInPage(driver);
        catalogPage = new PetCatalogPage(driver);
        welcomePage.clickToEnter();
        welcomePage.clickSignIn();
        loginPage.enterUserLoginDetails();
        Assert.assertTrue(loginPage.welcomeFirstNameIsDisplayed("Rhea"), "Welcome firstname wasn't displayed");
        Assert.assertTrue(loginPage.myAccountIsDisplayed(), "My account wasnt displayed");
        catalogPage.addFishToCart();
        Assert.assertTrue(catalogPage.verifyItemsIsAddedToCart("EST-1"), "Fish was not added to cart");
        catalogPage.returnToMainMenu();
        catalogPage.addDogToCart();
        Assert.assertTrue(catalogPage.verifyItemsIsAddedToCart("EST-6"), "Bulldog was not added to cart");
        catalogPage.returnToMainMenu();
        catalogPage.addBirdToCart();
        Assert.assertTrue(catalogPage.verifyItemsIsAddedToCart("AV-CB-01"), "Parrot was not added to cart");

    }
}
