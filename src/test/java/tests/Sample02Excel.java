package tests;

import utilities.BaseExcel;
import utilities.Driver;
import utilities.Excel;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Sample02Excel extends BaseExcel {

    public static void main(String[] args) {

        open("sampledata.xlsx");
        isCellValue11();
        isCellValue21();
        setCellValue41();
        setCellValue51();
        lastRowIndex();
        usedRowNumber();
        writeLogFile();
        close();
    }

    private static void isCellValue11() {

        String expectedValue = "Alper";
        String actualValue = Excel.workbook.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();

        boolean result = actualValue.equals(expectedValue);

        log(result, expectedValue, actualValue);
    }

    private static void isCellValue21() {

        String expectedValue = "Ece";
        String actualValue = Excel.workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();

        boolean result = actualValue.equals(expectedValue);

        log(result, expectedValue, actualValue);
    }

    private static void setCellValue41() {

        String inputValue = "Asya";
        Excel.workbook.getSheet("Sheet1").createRow(3).createCell(0).setCellValue(inputValue);
        Excel.write();
        String actualValue = Excel.workbook.getSheet("Sheet1").getRow(3).getCell(0).getStringCellValue();

        boolean result = actualValue.equals(inputValue);

        log(result, inputValue, actualValue);
    }

    private static void setCellValue51() {

        String inputValue = "Ararat";
        Excel.workbook.getSheet("Sheet1").createRow(4).createCell(0).setCellValue(inputValue);
        Excel.write();
        String actualValue = Excel.workbook.getSheet("Sheet1").getRow(4).getCell(0).getStringCellValue();

        boolean result = actualValue.equals(inputValue);

        log(result, inputValue, actualValue);
    }

    private static void lastRowIndex() {

        int expectedIndex = 5;
        int actualIndex = Excel.workbook.getSheet("Sheet1").getLastRowNum() + 1;

        boolean result = actualIndex == expectedIndex;

        log(result, String.valueOf(expectedIndex), String.valueOf(actualIndex));
    }

    private static void usedRowNumber() {

        int expectedNumber = 4;
        int actualNumber = Excel.workbook.getSheet("Sheet1").getPhysicalNumberOfRows();

        boolean result = actualNumber == expectedNumber;

        log(result, String.valueOf(expectedNumber), String.valueOf(actualNumber));
    }
}