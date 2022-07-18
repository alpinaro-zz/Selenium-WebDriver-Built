package tests;

import org.openqa.selenium.Keys;
import pages.AmazonPages;
import utilities.Base;
import utilities.Driver;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Sample01Amazon extends Base {

    static AmazonPages amazon;

    public static void main(String[] args) {

        amazon = new AmazonPages();

        open("amazonURL");
        isTitleContains("Amazon");
        isSearchBoxEnabled();
        search("java");
        writeLogFile();
        close();
    }

    // Test Methods
    private static void isTitleContains(String title) {

        String expectedTitle = title;
        String actualTitle = Driver.getDriver().getTitle();

        boolean result = actualTitle.contains(expectedTitle);

        log(result, expectedTitle, actualTitle);
    }

    private static void isSearchBoxEnabled() {

        boolean result = amazon.searchBox.isEnabled();

        log(result);
    }

    private static void search(String keyword) {

        amazon.searchBox.sendKeys(keyword + Keys.ENTER);

        String expectedResult = keyword;
        String actualResult = amazon.searchResult.getText();

        boolean result = actualResult.contains(expectedResult);

        String tested = "We've searched for the word \"java\" and are checking if the results contain that word.";

        log(result, tested, expectedResult, actualResult);
    }
}