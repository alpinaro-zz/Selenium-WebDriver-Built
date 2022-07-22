package utilities;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public abstract class Base extends Logger {

    protected static void open(String URL) {

        Driver.getDriver().get(ConfigReader.getProperty(URL));
    }

    protected static void close() {

        Driver.closeDriver();
    }
}