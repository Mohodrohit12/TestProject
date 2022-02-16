package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExcel(String sheet, int row, int col) throws EncryptedDocumentException, IOException{
		//String data
		
		 String path = "C:\\Users\\User\\Desktop\\Velocity.xlsx";
		 FileInputStream file = new FileInputStream(path);
		 String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		
		  return data;

	}
	
	public static void getScreenshot(WebDriver driver, int testID) throws IOException {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");
			LocalDateTime now = LocalDateTime.now();
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("G:\\\\RRR\\\\Test123"+testID+" "+dtf.format(now)+".jpg");
			FileHandler.copy(src, dest);
		}
	}


