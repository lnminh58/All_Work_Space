package com.lnminh.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class ExcelReader {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File("src/main/resources/excel-example.xlsx"));

        System.out.println(workbook.getNumberOfSheets()+"\n\n");

//        workbook.forEach(sheet->{
//            System.out.println("sheet name"+ sheet.getSheetName();
//        });

//        lấy sheet từ workbook
        Sheet sheet=null;
        for (Sheet tempSheet: workbook) {
           if(tempSheet.getSheetName().equals("employee")){
               sheet=tempSheet;
               System.out.println("Đã lấy được sheet");
           }
        }
        if(sheet==null){
            System.out.println("không tìm thấy dữ liệu");
            return;
        }

//        duyệt sheet

        DataFormatter dataFormatter = new DataFormatter();
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print("\t" + cellValue);
            }
            System.out.println("");
        }


    }
}
