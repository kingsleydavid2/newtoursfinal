package com.travels.newtours.test.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


import com.travels.newtours.test.utility.*;

public class ExcelReader {
	
	@Test
	public void verifyConfirmationMessage(){
		System.out.println(Arrays.deepToString(ExcelReader.getTestData("verifyConfirmationMessage")));
	}
	
	private static Sheet sh;
	static{
		try{FileInputStream fis = new FileInputStream("./testdata/NTData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet1");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static String[][] getTestData(String tcn){
		String tname = tcn;
		int tr = sh.getPhysicalNumberOfRows();
		List<String[]> allTestCaseData = new ArrayList<>();
		for(int i=1;i<tr;i++){
			List<String>eachTestCaseData = new ArrayList<>();
			Row eachRow = sh.getRow(i);
			int tcellcount = eachRow.getPhysicalNumberOfCells();
			String tn = eachRow.getCell(1).getStringCellValue();
			String ts = eachRow.getCell(2).getStringCellValue();
			
			if(tn.equalsIgnoreCase(tname)&&ts.equalsIgnoreCase("Y")){
				for(int j=3;j<tcellcount;j++){
					eachTestCaseData.add(eachRow.getCell(j).getStringCellValue());
				}
				eachTestCaseData.add(i+ "");
				allTestCaseData.add(eachTestCaseData.toArray(new String[0]));
			}
			//System.out.println(allTestCaseData);
			return allTestCaseData.toArray(new String[0][0]);
						
		}
		return null;
		
	}
	
	
	}
	
	
	

	

