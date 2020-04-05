package selpro1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	WebDriver driver = null;
	static WebElement element = null;
	
	public static void main(String[] args){
		
		String keyword = "Instawork";
		String webSite = "www.instawork.com";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		Boolean found = false;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		element = driver.findElement(By.name("q"));
		element.sendKeys(keyword);
		element.sendKeys(Keys.RETURN);
		int page = 0;
		
		while (!found){
			try{
			List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'TbwUpd')]"));
		
			Thread.sleep(10000);
			page++;
			
			for(int i=0;i<list.size();i++)
			{
			String link = list.get(i).getText();
			
			if(link.contains(webSite))
			{
				System.out.println("Website Found at Page" + page);
				found = true;
				
				break;
			}
		
			}
			}catch (Exception e)
			{
				   System.out.println(e);
			}
			
			if (!found) {
				try {
			         driver.findElement(By.xpath("//*[contains(@class,'TbwUpd')]")).click();
			         Thread.sleep(10000);
				}catch (Exception e)
				{
					   System.out.println(e);
				}
			}
			}
		driver.close();
	}

		 }


