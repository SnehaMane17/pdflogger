package com.silvercloud.pdflogger.helper;

import com.silvercloud.pdflogger.entity.Mockdata;
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

    //CHECK FILE IF EXCEL OR NOT?
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }else{
            return false;
        }
    }

    //Convert Excel to List of Mock data.
    public static List<Mockdata> convertExcelToListOfMockdata(InputStream is){

        List <Mockdata> list = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet  = workbook.getSheet("data");
            int rowNumber = 0;
            Iterator <Row> iterator = sheet.iterator();

            while (iterator.hasNext()){

                Row row = iterator.next();

                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cid = 0;
                Mockdata m = new Mockdata();

                while (cells.hasNext()){
                    Cell cell = cells.next();
                    switch(cid) {
                        case 0:
                            m.setId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            m.setTime(cell.getStringCellValue());
                            break;
                        case 2:
                            m.setTemperature((float) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid ++ ;
                }
                list.add(m);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


}
