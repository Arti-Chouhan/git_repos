package Common_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Common_Utility.Log;;

public class ExcelUtils {
	
	private static XSSFWorkbook ExcelWorkbook;
	private static XSSFSheet ExcelSheet;
	private static XSSFRow Row;
	private static XSSFCell Cell;
	
	public static void setFile (String filepath, String Sheetname) throws Exception
	
	{
		try
		{
		FileInputStream file = new FileInputStream(filepath);
		ExcelWorkbook = new XSSFWorkbook(file);
		ExcelSheet = ExcelWorkbook.getSheet(Sheetname);
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getCellData(int RowNum,int ColNum)
	{
		
		try
		{
			 Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			 
			 DataFormatter df = new DataFormatter();
			 String cellData = df.formatCellValue(Cell).toString();
			// System.out.println("Cell value for "+ RowNum + " & " + ColNum +" is: " + cellData);
			 return cellData;
			 
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static void setCellData (String Result,int RowNum,int ColNum )
	{
		try
		{
			Row = ExcelSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			//System.out.println("Getting cell");
			if(Cell == null)
			{
				Cell = Row.createCell(ColNum);
				//System.out.println("New Cell is created");
				Cell.setCellValue("");
				Cell.setCellValue(Result);
			}
			else
			{
				
				//System.out.println("Cell is already there");
				Cell.setCellValue("");
				Cell.setCellValue(Result);
			}
			
			FileOutputStream file_out = new FileOutputStream(System.getProperty("user.dir")+Constants.path_testData  + "\\" +Constants.fileName_testData);
			ExcelWorkbook.write(file_out);
			System.out.println("Successfully data is written in excel file");
			file_out.flush();
			file_out.close();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			Log.error(e.toString());
		}
	}
	
	public static int getRowContains(String sTestcaseName, int colNum)throws Exception
	{
		
		//int rows[] = new int[200];
		
		int j;
		
		try 
		{
			int RowCount = ExcelSheet.getLastRowNum();
			
			for(j=0;j<RowCount;j++)
			{
				if(ExcelUtils.getCellData(j, colNum).equalsIgnoreCase(sTestcaseName))
						
						{
							//System.out.println("Row no. matching is : "+ j);
								break;
							
							
						}
				
			}
			//System.out.println("Returning row no : "+j);
			return j;
		}
		catch(Exception e)
		{
			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
			throw(e);
		}
	}

}
