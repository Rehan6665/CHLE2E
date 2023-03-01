package utils;



import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {



	static String excelPath = "C:\\\\Eclipse\\\\CHLE2E\\\\Data\\\\LoginData.xlsx";
	static String sheetName = "PatientDetails";
	






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



			}
			System.out.println();

		}
		return data;


	}


}
