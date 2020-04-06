package selpro1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Test3 {

	WebDriver driver;
	
@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception{
	System.out.println("Browser name is : " + browser);

if(browser.equalsIgnoreCase("firefox")){
System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver.exe");
driver = new FirefoxDriver();
}
 
//else
	if(browser.equalsIgnoreCase("chrome")){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
}

else if(browser.equalsIgnoreCase("ie")){
	
	System.setProperty("webdriver.ie.driver","C:\\Users\\DELL\\Downloads\\IEDriverServer.exe");
	 WebDriver driver = new InternetExplorerDriver();
	}
	
else{
throw new Exception("Browser is not correct");
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@Test	
public void testExecution(){
		
		String keyword = "Instawork";
		String webSite = "www.instawork.com";
		
		WebDriver driver = null;
		WebElement element = null;
		
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
		
	}

@AfterTest
public void teardown() {
	driver.close();
	System.out.println("Test is Successfull");
}
		 }


