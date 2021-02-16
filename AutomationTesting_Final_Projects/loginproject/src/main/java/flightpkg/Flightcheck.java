package flightpkg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Flightcheck {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/home/poonam/Downloads/drivers/chromedriver");
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://demo.guru99.com/test/newtours/");
		
		FileInputStream fis=new FileInputStream("/home/poonam/Desktop/logindata.xls");
		HSSFWorkbook book=new HSSFWorkbook(fis);
		HSSFSheet sh=book.getSheet("Sheet6");
		
System.out.println("no. of record: "+ sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			wb.findElement(By.linkText("Flights")).click();
			String type=sh.getRow(i).getCell(0).toString();
			String pass=sh.getRow(i).getCell(1).toString();
			String depfrom=sh.getRow(i).getCell(2).toString();
			String Onmon=sh.getRow(i).getCell(3).toString();
			String Ondate=sh.getRow(i).getCell(4).toString();
			String Arr=sh.getRow(i).getCell(5).toString();
			String Returnmon=sh.getRow(i).getCell(6).toString();
			String Returndate=sh.getRow(i).getCell(7).toString();
			String Serviceclass=sh.getRow(i).getCell(8).toString();
			String airline=sh.getRow(i).getCell(9).toString();
			
			System.out.println(type+" "+pass+" "+depfrom+" "+Onmon+" "+Ondate+" "+Arr+" "+Returnmon+" "+Returndate+" "+Serviceclass+" "+airline);
			
			if(type.equals("roundtrip"))
			{
				wb.findElement(By.cssSelector("input[value='roundtrip']")).click();
			}
			else if(type.equals("oneway"))
			{
				wb.findElement(By.cssSelector("input[value='oneway']")).click();
			}
			Select pas=new Select(wb.findElement(By.name("passCount")));
			pas.selectByVisibleText(pass);
			
			Select dep=new Select(wb.findElement(By.name("fromPort")));
			dep.selectByVisibleText(depfrom);
			
			Select mon=new Select(wb.findElement(By.name("fromMonth")));
			mon.selectByVisibleText(Onmon);
			Select day=new Select(wb.findElement(By.name("fromDay")));
			day.selectByVisibleText(Ondate);
			Select arrive=new Select(wb.findElement(By.name("toPort")));
			arrive.selectByVisibleText(Arr);
			Select mo=new Select(wb.findElement(By.name("toMonth")));
			mo.selectByVisibleText(Returnmon);
			Select da=new Select(wb.findElement(By.name("toDay")));
			da.selectByVisibleText(Returndate);
			if(Serviceclass.equals("Economy class"))
			{
				wb.findElement(By.cssSelector("input[value='Economy class]")).click();
			}
			else if(Serviceclass.equals("Business"))
			{
				wb.findElement(By.cssSelector("input[value='Business']")).click();
			}
			else if(Serviceclass.equals("First class"))
			{
				wb.findElement(By.cssSelector("First class")).click();
			}
			Thread.sleep(3000);
			Select air=new Select(wb.findElement(By.name("airline")));
			air.selectByVisibleText(airline);
			if(depfrom.equals(Arr)||Onmon.equals(Returnmon)&&Ondate.equals(Returndate))
			{
				System.out.println("test case failed");
				wb.findElement(By.name("findFlights")).click();
			}
			else
			{
					System.out.println("test case Pass");
					wb.findElement(By.name("findFlights")).click();
			}
			}wb.close();
			
		
		

	}

}
