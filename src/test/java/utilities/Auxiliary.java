package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Auxiliary {

    private static final String PATH_OUTPUT = "src/test/output/";

    // Returns current date and time
    protected static String datetime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        LocalDateTime ldt = LocalDateTime.now();
        String datetime = dtf.format(ldt);

        return datetime;
    }

    // Writes the data into a log file
    protected static void writeLogTXT(String data) {

        writeOutputTXT("Log " + datetime() + ".log", data);
    }

    // Writes the data into an output file with the specified name
    protected static void writeOutputTXT(String fileName, String data) {

        String path = PATH_OUTPUT + fileName;

        writeTXT(path, data);
    }

    // Writes the data into a file at the specified path
    protected static void writeTXT(String path, String data) {

        FileOutputStream outputStream = null;

        byte[] dataByte = data.getBytes();

        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(dataByte);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}