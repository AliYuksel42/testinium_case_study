package Beymen.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static String ExcelRead(int satir, int sutun) throws IOException {
        File file = new File("src/main/resources/urunler.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0); // İlgili sayfa numarası
        XSSFRow row = sheet.getRow(satir); // Satır numarası
        XSSFCell cell = row.getCell(sutun); // Sütun numarası
        String value = cell.getStringCellValue();
        fileInputStream.close();
        return value;
    }
}
