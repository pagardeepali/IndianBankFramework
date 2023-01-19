import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProviders {
    @DataProvider(name = "getUserDetails")
    public static Object[][] getUserDetails() throws IOException {

        FileInputStream fs = new FileInputStream("./UserDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowCount = sheet.getLastRowNum();
        Object Data[][] = new Object[lastRowCount - 1][1];
        for (int i = 1; i < lastRowCount; i++) {
            String userId = sheet.getRow(i).getCell(0).toString();
            userId = userId.split("\\.")[0];
            Data[i - 1][0] = userId;
        }
        return Data;
    }
}
