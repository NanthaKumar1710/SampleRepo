package mock;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://in.bookmyshow.com/movies/bengaluru/dies-irae/buytickets/ET00457060/20251106");
//		WebElement bottomElement = driver.findElement(By.xpath("//div[.='Change Location']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", bottomElement);

		List<WebElement> theatre = driver.findElements(
				By.xpath("//div[@class='sc-tk4ce6-2 isNGkZ']/descendant::span[@class='sc-1qdowf4-0 kVfEkA']"));

	//	Set<String> theatreName = new LinkedHashSet<String>();
	

		for (WebElement name : theatre) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,5000)");
			System.out.println(name.getText());

			
			
		
		
		
		}

	}

}
