package com.org.codewithsitangshu.eyeSpyTest.web.google;

import com.org.codewithsitangshu.eyeSpy.comparator.EyeSpyResult;
import com.org.codewithsitangshu.eyeSpyTest.web.BaseTest;
import com.org.codewithsitangshu.eyeSpyTest.web.google.pages.GoogleHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(GoogleTest.class);

    private GoogleHomePage googleHomePage;

    @BeforeMethod
    public void launchGoogleHomePage() {
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.goTo();
        String title = driver.getTitle();
        logger.info("Page title: {}", title);
        Assert.assertEquals(title, "Google", "Page title mismatch.");
        logger.info("Google Test completed successfully.");
    }

    @Test(description = "Compare Home Page")
    public void googleHomePageTest() {
        EyeSpyResult result = googleHomePage.compareHomePage();
        Assert.assertEquals(result.getSimilarity(), 100, "Home page is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }

    @Test(description = "Compare only search box")
    public void matchSearchBoxOnlyTest() {
        EyeSpyResult result = googleHomePage.compareSearchBoxOnly();
        Assert.assertEquals(result.getSimilarity(), 100, "Search box is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }

    @Test(description = "Compare Search box and ignore  Mic")
    public void matchSearchBoxWithoutMicTest() {
        EyeSpyResult result = googleHomePage.compareSearchBoxIgnoreMic();
        Assert.assertEquals(result.getSimilarity(), 100, "Search Box without Mic is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }

    @Test(description = "Compare Search box and ignore  Mic and Image")
    public void matchSearchBoxWithoutMicAndImageTest() {
        EyeSpyResult result = googleHomePage.compareSearchBoxIgnoreMicAndImage();
        Assert.assertEquals(result.getSimilarity(), 100, "Search Box without Mic and Image is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }

    @Test(description = "Compare Home page without mic")
    public void matchHomePageWithoutMicTest() {
        EyeSpyResult result = googleHomePage.compareHomePageIgnoreMic();
        Assert.assertEquals(result.getSimilarity(), 100, "Home Page without Mic is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }

    @Test(description = "Compare Home page without mic, image and Logo")
    public void matchHomePageWithoutMicLogoTest() {
        EyeSpyResult result = googleHomePage.compareHomePageIgnoreMicImageLogo();
        Assert.assertEquals(result.getSimilarity(), 100, "Home Page without Mic, Image and Logo is mismatched with sample one." +
                "Mismatch % is " + (100 - result.getSimilarity()));
    }


}
