package Modules;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {

	static PropertyManager prop = new PropertyManager("execution.properties");


	
	public static HashMap<String, String> dataRead(String testcaseid, String filename,String sheetname){
		
		String filepath= System.getProperty("user.dir")+prop.getProperty("testdata")+"\\"+filename;	
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.clear();
		try {
			Thread.sleep(3000);
			FileInputStream fileInputStream = new FileInputStream(filepath);
			DataFormatter dataformtter = new DataFormatter();
			Workbook worbook =WorkbookFactory.create(fileInputStream);
			Sheet  sheet = worbook.getSheet(sheetname);
			int rowcount = (sheet.getLastRowNum()-sheet.getFirstRowNum())+1;
			int header = sheet.getFirstRowNum();
			int testcaserow=0;
			for(int i=0;i<rowcount;i++) {
				String value= dataformtter.formatCellValue(sheet.getRow(i).getCell(0));
				if(value.equalsIgnoreCase(testcaseid)) {
					testcaserow=i;
					break;
				}
			}		
			int cellcount=sheet.getRow(testcaserow).getLastCellNum();
			for(int j=0;j<cellcount;j++) {
				String key=dataformtter.formatCellValue(sheet.getRow(header).getCell(j));
				String value=dataformtter.formatCellValue(sheet.getRow(testcaserow).getCell(j));
				if(value!=null||value=="") {
					map.put(key, value);
				}
				
			}
			//Displaying
			int clocount=0;
			Iterator<Entry<String,String>> iterator= map.entrySet().iterator();
			System.out.println("********************Reading Testdata*******************************");
			while (iterator.hasNext()) {
				Entry<String,String> new_map =iterator.next();
				clocount++;
				System.out.println(clocount+" : "+new_map.getKey()+" | "+new_map.getValue());
			}		
			System.out.println("********************Testdata read sucessfully**********************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
