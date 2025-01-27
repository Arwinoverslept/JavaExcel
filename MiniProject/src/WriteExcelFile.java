import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.RowId;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.CellEditor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
		
		Map<String, Object[]> dataSet = new TreeMap<String,Object[]>();
		dataSet.put("1",new Object[] {"ID", "NAME", "COMPANY"});
		dataSet.put("2",new Object[] {"1", "ARWIN VIERNES", "Asianlink.Ai"});
		dataSet.put("3",new Object[] {"2", "CK RANA", "CPC New Employee"});
		dataSet.put("4",new Object[] {"3", "JM TUMBAGA", "Asianlink.ai"});
		dataSet.put("5",new Object[] {"4", "LLOYD BUTAY", "Asianlink.ai"});
		dataSet.put("6",new Object[] {"5", "ERNEST MAMANTA", "Asianlink.ai"});
		dataSet.put("7",new Object[] {"6", "EJ Dela Rosa", "Xiamen Team"});
		dataSet.put("8",new Object[] {"7", "Ice Benitez", "Asianlink.ai"});
		dataSet.put("9",new Object[] {"8", "Raquel Mallanao", "Asianlink.ai"});
		
		Set<String> set = dataSet.keySet();
		int rowNum = 0;
		
		for (String key : set) {
			Row row = samplesheet.createRow(rowNum++);
			
			int cellNum = 0;
			Object[] data = dataSet.get(key);
			for (Object valueObject : data) {
				Cell cell = row.createCell(cellNum++);
				
				if(valueObject instanceof String) {
					cell.setCellValue((String)valueObject);
					
				}else if (valueObject instanceof Integer) {
					cell.setCellValue((Integer)valueObject);
				}
			}
		}
		
		
		try {
			FileOutputStream writeFile = new FileOutputStream("SampleTest.xlsx");
			workbook.write(writeFile);
			writeFile.close();
			System.out.println("Excel successfully created.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	
	
	
	}
}
