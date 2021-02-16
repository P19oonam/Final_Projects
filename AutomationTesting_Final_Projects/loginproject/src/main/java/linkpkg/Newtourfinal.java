package linkpkg;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtourfinal {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/home/poonam/Downloads/drivers/chromedriver");
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://demo.guru99.com/test/newtours/");
		/*wb.findElement(By.name("userName")).sendKeys("test1");
		wb.findElement(By.name("password")).sendKeys("test1");
		wb.findElement(By.name("submit")).click();*/
		
		wb.findElement(By.linkText("Flights")).click();
		
        WebElement trp1=wb.findElement(By.cssSelector("input[value='roundtrip']"));
        WebElement trp2=wb.findElement(By.cssSelector("input[value='oneway']"));
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your choice: 1)round trip   2)oneway");
       int t1 = s.nextInt();
       switch(t1)
       {
       case 1:
       trp1.click();
       break;
       
       case 2:
    	   trp2.click();
    	   break;
        default :
    		   System.out.println("not selected");
    		   break;
       }
    	   
        if(trp1.isSelected())
        {System.out.println("round trip");
        }
        else if(trp2.isSelected())
        {System.out.println("one way");
        }
        else
        {System.out.println("no type selected");
        }
        Select pas=new Select(wb.findElement(By.name("passCount")));
		pas.selectByIndex(2);
		
		Select dep=new Select(wb.findElement(By.name("fromPort")));
		dep.selectByVisibleText("Frankfurt");
		
		Select mon=new Select(wb.findElement(By.name("fromMonth")));
		mon.selectByValue("3");
		Select day=new Select(wb.findElement(By.name("fromDay")));
		day.selectByValue("21");
		Select arr=new Select(wb.findElement(By.name("toPort")));
		arr.selectByVisibleText("London");
		Select mo=new Select(wb.findElement(By.name("toMonth")));
		mo.selectByValue("3");
		Select da=new Select(wb.findElement(By.name("toDay")));
		da.selectByValue("21");
		wb.findElement(By.cssSelector("input[value='Business']")).click();
		Thread.sleep(4000);
		Select air=new Select(wb.findElement(By.name("airline")));
		air.selectByVisibleText("Unified Airlines");
		
				wb.findElement(By.name("findFlights")).click();
		
		
		Thread.sleep(4000);
		wb.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a/img")).click();
		
		wb.findElement(By.linkText("Hotels")).click();
		String a=wb.getTitle();
		if(a.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("hotels site is opening");
		}
		wb.findElement(By.linkText("Car Rentals")).click();
		String b=wb.getTitle();
		if(b.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Car rental site is opening ");
		}
		wb.findElement(By.linkText("Cruises")).click();
		String c=wb.getTitle();
		if(c.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Cruises site is opening");
		}
		wb.findElement(By.linkText("Destinations")).click();
		String d=wb.getTitle();
		if(d.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Destination site is opening ");
		}
		wb.findElement(By.linkText("Vacations")).click();
		String e=wb.getTitle();
		if(e.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Vacations site is opening");
		}
		wb.findElement(By.linkText("SUPPORT")).click();
		String f=wb.getTitle();
		if(f.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Support site is opening");
		}
		wb.findElement(By.linkText("CONTACT")).click();
		String g=wb.getTitle();
		if(g.contains("Under Construction")||wb.getCurrentUrl().equals("http://demo.guru99.com/test/newtours/index.php"))
		{
			System.out.println("Page not found");
		}
		else
		{
			System.out.println("Contact site is opening");
		}
		wb.close();
	}
	
}
