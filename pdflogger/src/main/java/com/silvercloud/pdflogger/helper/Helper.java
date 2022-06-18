package com.silvercloud.pdflogger.helper;

import com.silvercloud.pdflogger.entity.MockData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    //check that file type is excel
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        else {
            return false;
        }
    }

    // convert excel to List of Mock Data
    public static List<MockData> convertExcelToListOfMockData (InputStream is){
        List <MockData> list = new ArrayList<>();
        try {
             XSSFWorkbook workbook = new XSSFWorkbook(is);
             XSSFSheet sheet = workbook.getSheet("data");
             int rowNumber = 0;
             Iterator<Row> iterator = sheet.iterator();
             while (iterator.hasNext()){
                 Row row = iterator.next();
                 if (rowNumber==0){
                     rowNumber++;
                     continue;
                 }
                 Iterator<Cell> cells = row.iterator();
                 int cid = 0;
                 MockData m = new MockData();
                 while (cells.hasNext()){
                     Cell cell = cells.next();
                     switch (cid){
                         case 0:
                             m.setId((int) cell.getNumericCellValue());
                             break;
                         case 1:
                             m.setTime(cell.getStringCellValue());
                             break;
                         case 2:
                             m.setTemperature((float)cell.getNumericCellValue());
                             break;
                         default:
                             break;
                     }
                     cid++;
                 }
                 list.add(m);

             }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



}
