package registerpkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registerlogin {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "/home/poonam/Downloads/drivers/chromedriver");
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://demo.guru99.com/test/newtours/");
		wb.findElement(By.name("userName")).sendKeys("test1");
		wb.findElement(By.name("password")).sendKeys("test1");
		wb.findElement(By.name("submit")).click();
		wb.findElement(By.linkText("REGISTER")).click();
		
		FileInputStream fis=new FileInputStream("/home/poonam/Desktop/logindata.xls");
		HSSFWorkbook book=new HSSFWorkbook(fis);
		HSSFSheet sh=book.getSheet("Sheet2");
		HSSFSheet sh1=book.getSheet("Sheet5");
		
		System.out.println("no. of record: "+ sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String fn=sh.getRow(i).getCell(0).toString();
			String ln=sh.getRow(i).getCell(1).toString();
			String ph=sh.getRow(i).getCell(2).toString();
			String em=sh.getRow(i).getCell(3).toString();
			String add=sh.getRow(i).getCell(4).toString();
			String city=sh.getRow(i).getCell(5).toString();
			String state=sh.getRow(i).getCell(6).toString();
			String pc=sh.getRow(i).getCell(7).toString();
			String country=sh.getRow(i).getCell(8).toString();
			String un=sh.getRow(i).getCell(9).toString();
			String pw=sh.getRow(i).getCell(10).toString();
			String cpw=sh.getRow(i).getCell(11).toString();
			
			wb.findElement(By.name("firstName")).sendKeys(fn);
			wb.findElement(By.name("lastName")).sendKeys(ln);
			wb.findElement(By.name("phone")).sendKeys(ph);
			wb.findElement(By.name("userName")).sendKeys(em);
			wb.findElement(By.name("address1")).sendKeys(add);
			wb.findElement(By.name("city")).sendKeys(city);
			wb.findElement(By.name("state")).sendKeys(state);
			wb.findElement(By.name("postalCode")).sendKeys(pc);
			Select CN=new Select(wb.findElement(By.name("country")));
			CN.selectByVisibleText(country);
			wb.findElement(By.name("email")).sendKeys(un);
			wb.findElement(By.name("password")).sendKeys(pw);
			wb.findElement(By.name("confirmPassword")).sendKeys(cpw);
			wb.findElement(By.name("submit")).click();
			System.out.println(fn +" "+ln+"  "+ph+"  "+em+"  "+add+"  "+city+"  "+state+"  "+pc+"  "+country+"  "+un+"  "+pw+"  "+cpw);
			
			if(wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/register_sucess.php"))
			{
				System.out.println("testcases passed");
				wb.findElement(By.linkText("REGISTER")).click();
			}
			else
			{
				System.out.println("testcases failed");
				wb.findElement(By.linkText("REGISTER")).click();
			}	
		}
System.out.println("no. of record: "+ sh1.getLastRowNum());
		
		for(int i=1;i<=sh1.getLastRowNum();i++)
		{
			String fn=sh1.getRow(i).getCell(0).toString();
			String ln=sh1.getRow(i).getCell(1).toString();
			String ph=sh1.getRow(i).getCell(2).toString();
			String em=sh1.getRow(i).getCell(3).toString();
			String add=sh1.getRow(i).getCell(4).toString();
			String city=sh1.getRow(i).getCell(5).toString();
			String state=sh1.getRow(i).getCell(6).toString();
			String pc=sh1.getRow(i).getCell(7).toString();
			String country=sh.getRow(i).getCell(8).toString();
			String un=sh.getRow(i).getCell(9).toString();
			String pw=sh.getRow(i).getCell(10).toString();
			String cpw=sh.getRow(i).getCell(11).toString();
			
			wb.findElement(By.name("firstName")).sendKeys(fn);
			wb.findElement(By.name("lastName")).sendKeys(ln);
			wb.findElement(By.name("phone")).sendKeys(ph);
			wb.findElement(By.name("userName")).sendKeys(em);
			wb.findElement(By.name("address1")).sendKeys(add);
			wb.findElement(By.name("city")).sendKeys(city);
			wb.findElement(By.name("state")).sendKeys(state);
			wb.findElement(By.name("postalCode")).sendKeys(pc);
			Select cn=new Select(wb.findElement(By.name("country")));
			cn.selectByVisibleText(country);
			wb.findElement(By.name("email")).sendKeys(un);
			wb.findElement(By.name("password")).sendKeys(pw);
			wb.findElement(By.name("confirmPassword")).sendKeys(cpw);
			wb.findElement(By.name("submit")).click();
			System.out.println(fn +" "+ln+"  "+ph+"  "+em+"  "+add+"  "+city+"  "+state+"  "+pc+"  "+country+"  "+un+"  "+pw+"  "+cpw);
			
			if(wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/register_sucess.php"))
			{
				System.out.println("testcases failed");
				wb.findElement(By.linkText("REGISTER")).click();
			}
			else
			{
				System.out.println("testcases passed");
				wb.findElement(By.linkText("REGISTER")).click();
			}	
		}
		wb.close();
		
	}

}
