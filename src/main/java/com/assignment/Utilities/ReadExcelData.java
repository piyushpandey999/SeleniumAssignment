package com.assignment.Utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData {
    public static Object[][] getdata() throws IOException {

        Object[][] data = new Object[0][];
        try {

            File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Data.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheetname = wb.getSheet("Sheet1");

            int totalRow = sheetname.getLastRowNum();
            Row row = sheetname.getRow(0);
            int totalCol = row.getLastCellNum();

            DataFormatter format = new DataFormatter();
            data = new String[totalRow][totalCol];
            for (int i = 1; i <=totalRow; i++) {
                for (int j = 0; j < totalCol; j++) {
                    data[i-1][j] = format.formatCellValue(sheetname.getRow(i).getCell(j));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
