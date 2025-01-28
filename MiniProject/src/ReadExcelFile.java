import java.io.FileInputStream; // To read data from an Excel file
import java.io.IOException; // To handle input/output exceptions
import java.util.Iterator; // To iterate over rows and cells in the Excel sheet

import org.apache.poi.ss.usermodel.Row; // Represents a row in the Excel sheet
import org.apache.poi.ss.usermodel.Cell; // Represents a cell in the Excel sheet
import org.apache.poi.ss.usermodel.DataFormatter; // Formats cell content into readable text
import org.apache.poi.xssf.usermodel.XSSFSheet; // Represents a sheet in an XLSX workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // Represents an XLSX workbook

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {

        // Open the Excel file for reading
        FileInputStream readFile = new FileInputStream("SampleTest.xlsx");

        // Load the workbook from the file
        XSSFWorkbook workbook = new XSSFWorkbook(readFile);

        // Access the specific sheet by name
        XSSFSheet sheet = workbook.getSheet("SampleSheet");

        // Variables to hold rows and cells
        Row row;
        Cell cell;

        // Iterator to go through each row in the sheet
        Iterator<Row> rowIterator = sheet.iterator();

        // Iterate through all rows in the sheet
        while (rowIterator.hasNext()) {
            row = rowIterator.next(); // Get the next row
            
            // Iterator to go through each cell in the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            
            // StringBuilder to store the content of the current row
            StringBuilder rowContent = new StringBuilder();

            // Iterate through all cells in the row
            while (cellIterator.hasNext()) {
                cell = cellIterator.next(); // Get the next cell
                
                // Format the cell value into a string (handles numeric and text values)
                DataFormatter formatter = new DataFormatter();
                String text = formatter.formatCellValue(cell);
                
                // Append the cell content to the row string with spacing
                rowContent.append(String.format("%-20s", text));
            }

            // Print the row content, trimming any trailing spaces
            System.out.println(rowContent.toString().trim());
        }

        // Close the workbook and file input stream to release resources
        workbook.close();
        readFile.close();
    }
}
