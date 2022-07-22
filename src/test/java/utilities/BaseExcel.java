package utilities;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public abstract class BaseExcel extends Logger {

    protected static void open(String file) {

        Excel.open(file);
    }

    protected static void close() {

        Excel.close();
    }
}