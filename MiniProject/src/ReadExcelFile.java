import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {
        
        FileInputStream readFile = new FileInputStream("SampleTest.xlsx");
        
        XSSFWorkbook workbook = new XSSFWorkbook(readFile);
        XSSFSheet sheet = workbook.getSheet("SampleSheet");
        
        Row row;
        Cell cell;
        
        Iterator<Row> rowIterator = sheet.iterator();
        
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            
            Iterator<Cell> cellIterator = row.cellIterator();
            
            StringBuilder rowContent = new StringBuilder();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                
                DataFormatter formatter = new DataFormatter();
                String text = formatter.formatCellValue(cell);
                
                rowContent.append(String.format("%-20s", text));
            }
            System.out.println(rowContent.toString().trim());
        }
        
        workbook.close();
        readFile.close();
    }
}