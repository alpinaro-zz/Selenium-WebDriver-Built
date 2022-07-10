package utilities;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public abstract class Base {

    static int testCount = 1;

    protected static void open(String URL) {

        Driver.getDriver().get(ConfigReader.getProperty(URL));
    }

    protected static void close() {

        Driver.closeDriver();
    }

    // Returns the name of the caller method
    protected static String getMethodName() {

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    // Generates a log record based on the information sent
    protected static void log(String test, boolean result, String expect, String actual, String detail) {

        String status = result ? "PASSED" : "FAILED";
        String separator = ": ";
        String format = "%1$-7s" + separator + "%2$s\n";

        System.out.println(testCount);
        System.out.printf(format, "Test", test);
        if (expect != null) System.out.printf(format, "Expect", expect);
        if (actual != null) System.out.printf(format, "Actual", actual);
        if (detail != null) System.out.printf(format, "Detail", detail);
        System.out.printf(format, "Status", status);

        testCount++;
    }

    // Alternative methods to run the log method
    protected static void log(String test, boolean result) {log(test, result, null, null, null);}
    protected static void log(String test, boolean result, String detail) {log(test, result, null, null, detail);}
    protected static void log(String test, boolean result, String expect, String actual) {log(test, result, expect, actual, null);}
}