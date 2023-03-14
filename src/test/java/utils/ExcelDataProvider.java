package utils;



import org.apache.poi.ss.usermodel.CellType;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {



	static String excelPath = "C:\\Users\\hp\\git\\CHLE2E\\CHLE2E\\Data\\LoginData.xlsx";
	static String sheetName = "PatientDetails";
	static String excelPath1 = "C:\\Users\\hp\\git\\CHLE2E\\CHLE2E\\Data\\LoginData.xlsx";
	static String sheetName1 = "OwnerDetails";
	static String excelPath2 = "C:\\Users\\hp\\git\\CHLE2E\\CHLE2E\\Data\\LoginData.xlsx";
	static String sheetName2 = "ChildSubscrptionDetails";
	

	@DataProvider(name="Child Subscrption Details")
	public  Object[][] getChildAgencyData() {

		Object data[][] = testData(excelPath2, sheetName2);
		return data; 

	}
	
	@DataProvider(name="Owner Data")
	public  Object[][] getownerData() {

		Object data[][] = testData(excelPath1, sheetName1);
		return data; 

	}




	@DataProvider(name="Patient Data")
	public  Object[][] getpatientData() {

		Object data[][] = testData(excelPath, sheetName);
		return data; 

	}


	public   Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		int rowCount = excel.getRowCount();
		int columnCount = excel.getColoumnCount();

		Object data[][] = new Object[rowCount-1][columnCount];



		for(int i=1;i<rowCount;i++) {
			for(int j =0;j<columnCount;j++) {



				if(excel.getCellType(i,j) == CellType.STRING) {
					String cellData = excel.getCellStringData(i, j);
					System.out.print(cellData+"  |  ");
					data[i-1][j] = cellData;
				}
				else if(excel.getCellType(i,j) == CellType.NUMERIC)
				{
					double cellData = excel.getCellNumericData(i, j);
					System.out.print(cellData+"  |  ");
					data[i-1][j] = cellData;

				}
				else if(excel.getCellType(i,j) == CellType.BLANK) {
					
					continue;
				}
				

			}
			System.out.println();

		}
		return data;


	}


}
