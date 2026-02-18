package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        workbook = WorkbookFactory.create(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";
        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public void close() throws IOException {
        workbook.close();
    }
}
