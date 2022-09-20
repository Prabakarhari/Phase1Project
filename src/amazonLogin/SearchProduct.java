package amazonLogin;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement searchBar= driver.findElement(By.xpath("//input[@type='text']"));
		
		searchBar.sendKeys("samsung");
		Thread.sleep(200);
		WebElement search= driver.findElement(By.xpath("//input[@type='submit']"));
		search.click();
		
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='a-section']//span[starts-with(text(),'Samsung ')]"));
		List<WebElement> Priselist= driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		System.out.println(list.size());
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i).getText()+" "+Priselist.get(i).getText());	
	
		}

		String paranetWindow = driver.getWindowHandle();
		String exp = list.get(0).getText(); 
		
		list.get(0).click();
		
		Set<String>Allwindow = driver.getWindowHandles();
		
		for(String win: Allwindow) {
			System.out.println(win);
			
			if(!win.equals(paranetWindow)) {
				Thread.sleep(200);
				driver.switchTo().window(win);
			
		}
		}
		
		Thread.sleep(200);
		    WebElement actual = driver.findElement(By.xpath("//div[@id='titleSection']//span[@id='productTitle']"));
		
			String name =actual.getText();
			System.out.println(name);
			
			if(name.equals(exp)) {
				System.out.println("The Title is matching");
				
			}else {
				System.out.println("The Title is not matching");
			}
			
			driver.quit();
		}
		
	}


