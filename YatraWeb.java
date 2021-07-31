package asssignment1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class YatraWeb {
	
	public WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void login(String Bangalore, String NewDelhi) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation testing\\Chrome\\Chromedriver.exe");
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Go to Test URL https://www.yatra.com/
		driver.get("https://www.yatra.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).sendKeys("Bangalore");
		//Actions a=new Actions(driver);
		//a.moveToElement(e).build().perform();
		
		Thread.sleep(3000);
		
		 driver.findElement(By.id("//input[@id='BE_flight_arrival_city']")).sendKeys("NewDelhi");
		
		//a.moveToElement(e).build().perform();
		
		Thread.sleep(3000);
		
		//click a Departure Date and select a date
		driver.findElement(By.xpath("//input[@id='BE_flight_origin_date']")).click(); 
		driver.findElement(By.xpath("//td[@id='03/08/2021']")).click(); 
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[contains(text(),'Traveller(s), Class')]")).click();
		ArrayList<String> wins=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(wins);
		Thread.sleep(3000);
		
		driver.switchTo().window(wins.get(1)); 
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")).click(); 
		//driver.switchTo().window(wins.get(0)); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='BE_flight_flsearch_btn'])[1]")).click(); 
	
	}
	  @AfterMethod
	  public void gettestResult(ITestResult testResult)
	  {
		  System.out.println("TestCase Name:"+testResult.getName());
		  System.out.println("TestCase Name:"+testResult.getStatus());
		  int status=testResult.getStatus();
		  if(status==1)
		  {
			  driver.close();
		  }
		  else
		  {
			  //TakeScreenshot
			  File outfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  try {
				FileUtils.copyFile(outfile,new File("C:\\Automation testing\\MyFirstProject\\src\\assignment1"+ testResult.getParameters()[0]+"Defect.jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  driver.close();
			  
		  }
		  
	  }
	 @DataProvider(name="test_Data")
	 public Object[][] readExcal() throws BiffException, IOException
	  {
		File F = new File("C:\\Automation testing\\MyFirstProject\\src\\assignment1\\Data Worksheet.xls");
		Workbook w = Workbook.getWorkbook(F);
		Sheet s = w.getSheet(0);
		int noofrow = s.getRows();
		System.out.println(noofrow);
		int noofcol = s.getColumns();
		System.out.println(noofcol);
		 
		String data[][] = new String[noofrow-1][noofcol];
		
		int count=0;
		for(int i=0;i<noofrow;i++)
		{
			for(int j=0;j<noofcol;j++)
			{
				Cell c = s.getCell(j,i);
				data[count][j]=c.getContents();
			}	
			count++;
		}
		return data;
	  }
	

}
