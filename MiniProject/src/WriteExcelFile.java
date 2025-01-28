import java.io.FileNotFoundException; // To handle exceptions when the output file is not found
import java.io.FileOutputStream; // To write data to a file
import java.io.IOException; // To handle general input/output exceptions
import java.util.Map; // To work with key-value pairs in the dataset
import java.util.Set; // To retrieve keys from the dataset
import java.util.TreeMap; // To create a dataset with keys in sorted order

import org.apache.poi.ss.usermodel.Cell; // Represents a cell in an Excel sheet
import org.apache.poi.ss.usermodel.Row; // Represents a row in an Excel sheet
import org.apache.poi.xssf.usermodel.XSSFSheet; // Represents a sheet in an XLSX workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // Represents an XLSX workbook

public class WriteExcelFile {
    public static void main(String[] args) {
        // Create a new workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        // Create a new sheet named "SampleSheet"
        XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
        
        // Define the dataset using a TreeMap to store rows in a sorted order
        Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
        dataSet.put("1", new Object[] {"ID", "NAME", "COMPANY"}); // Header row
        dataSet.put("2", new Object[] {"1", "ARWIN VIERNES", "Asianlink.Ai"});
        dataSet.put("3", new Object[] {"2", "CK RANA", "CPC New Employee"});
        dataSet.put("4", new Object[] {"3", "JM TUMBAGA", "Asianlink.ai"});
        dataSet.put("5", new Object[] {"4", "LLOYD BUTAY", "Asianlink.ai"});
        dataSet.put("6", new Object[] {"5", "ERNEST MAMANTA", "Asianlink.ai"});
        dataSet.put("7", new Object[] {"6", "EJ Dela Rosa", "Xiamen Team"});
        dataSet.put("8", new Object[] {"7", "Ice Benitez", "Asianlink.ai"});
        dataSet.put("9", new Object[] {"8", "Raquel Mallanao", "Asianlink.ai"});
        
        // Retrieve the set of keys (row identifiers) from the dataset
        Set<String> set = dataSet.keySet();
        int rowNum = 0; // Variable to track the current row number
        
        // Iterate through each key in the dataset
        for (String key : set) {
            // Create a new row in the sheet
            Row row = samplesheet.createRow(rowNum++);
            
            int cellNum = 0; // Variable to track the current cell number
            Object[] data = dataSet.get(key); // Retrieve the array of values for the current row
            
            // Iterate through each value in the current row
            for (Object valueObject : data) {
                // Create a new cell in the row
                Cell cell = row.createCell(cellNum++);
                
                // Set the cell value based on its type
                if (valueObject instanceof String) {
                    cell.setCellValue((String) valueObject); // Set string value
                } else if (valueObject instanceof Integer) {
                    cell.setCellValue((Integer) valueObject); // Set integer value
                }
            }
        }
        
        // Write the workbook to an Excel file
        try {
            FileOutputStream writeFile = new FileOutputStream("SampleTest.xlsx");
            workbook.write(writeFile); // Write data to the file
            writeFile.close(); // Close the file output stream
            System.out.println("Excel successfully created.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle file not found exception
        } catch (IOException e) {
            e.printStackTrace(); // Handle input/output exceptions
        }
    }
}
