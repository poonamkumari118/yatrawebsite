package asssignment1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class YatraWebsite {

	public static void main(String[] args) throws InterruptedException {
		

       System.setProperty("webdriver.gecko.driver","C:\\Automation testing\\firefox\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver(); 
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

	}


