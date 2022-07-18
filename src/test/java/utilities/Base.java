package utilities;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public abstract class Base {

    static int testCount = 1;
    static String logs = "";

    protected static void open(String URL) {

        Driver.getDriver().get(ConfigReader.getProperty(URL));
    }

    protected static void close() {

        Driver.closeDriver();
    }

    // Generates a log record based on the information sent
    private static void logger(boolean result, String tested, String expect, String actual) {

        String method = Thread.currentThread().getStackTrace()[3].getMethodName();
        String status = result ? "PASSED" : "FAILED";
        String separator = ": ";
        String format = "%1$-7s" + separator + "%2$s\n";

        String log = "";
        log += String.valueOf(testCount) + "\n";
        log += String.format(format, "Method", method);
        if (tested != null) log += String.format(format, "Tested", tested);
        if (expect != null) log += String.format(format, "Expect", expect);
        if (actual != null) log += String.format(format, "Actual", actual);
        log += String.format(format, "Status", status);

        System.out.print(log);
        logs += log;
        testCount++;
    }

    // Caller methods to run the logger method
    protected static void log(boolean result) {logger(result, null, null, null);}
    protected static void log(boolean result, String tested) {logger(result, tested, null, null);}
    protected static void log(boolean result, String expect, String actual) {logger(result, null, expect, actual);}
    protected static void log(boolean result, String tested, String expect, String actual) {logger(result, tested, expect, actual);}

    // Creates a txt file and saves all logs to the file
    protected static void writeLogFile() {

        Auxiliary.writeLogTXT(logs);
    }
}