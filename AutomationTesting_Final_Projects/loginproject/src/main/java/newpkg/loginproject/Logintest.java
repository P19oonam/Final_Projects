package newpkg.loginproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("/home/poonam/Desktop/logindata.xls");
		HSSFWorkbook book=new HSSFWorkbook(fis);
		HSSFSheet sh=book.getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver", "/home/poonam/Downloads/drivers/chromedriver");
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://demo.guru99.com/test/newtours/");
		System.out.println("no. of record: "+ sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String un=sh.getRow(i).getCell(0).toString();
			String pw=sh.getRow(i).getCell(1).toString();
			System.out.println(un+"  "+pw);
			wb.findElement(By.name("userName")).sendKeys(un);
			wb.findElement(By.name("password")).sendKeys(pw);
			wb.findElement(By.name("submit")).click();
			try
			{
				wb.findElement(By.linkText("SIGN-OFF")).click();
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input:"+i);
			}
		}wb.close();
	}

	}
