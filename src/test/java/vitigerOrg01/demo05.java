package vitigerOrg01;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class demo05 {
	WebDriver driver;

	@Test
	public void CountofRings() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("search_query")).sendKeys("rings");
		driver.findElement(By.name("submit_search")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window,scrollBy(0,200)");
		WebElement ele = driver.findElement(By.xpath("//span[text()='Price']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//span[text()=' Below ']")).click();

		List<WebElement> ele1 = driver
				.findElements(By.xpath("//li[@data-position='1']/.//span[@id='bst-discounted-price']"));

		for (WebElement options : ele1) {
			System.out.println(options.getSize());
		}

	}

	@Test
	public void CountofDelivery() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("search_query")).sendKeys("rings");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Next Day Delivery ']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//span[text()='Next Day Delivery (1400+ designs)']")).click();

	}

	@Test
	public void Organization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users ");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> orgnameall = driver.findElements(By.xpath(" //table[@class='lvt small']/tbody/tr/td[3]"));
		for (int i = 1; i < orgnameall.size(); i++) {
			System.out.println(orgnameall.get(i).getText());
			if (orgnameall.get(i).getText().equals("Tessa488")) {
				System.out.println("orgname is present");
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td/input")).click();
				driver.findElement(By.xpath("//td[@style='padding-right:20px']/input")).click();
				Alert all = driver.switchTo().alert();
				all.accept();
				break;
			}
		}
	}

	@Test
	public void Organization2() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users ");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> orgnameall = driver
				.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for (int i = 3; i < orgnameall.size() + 2; i++) {
			driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + i + "]/td[1]/input")).click();

		}
	}

	@Test
	public void cricket() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window,scrollBy(0,700)");
		List<WebElement> alldetails = driver.findElements(By.xpath("(//span[@class='u-hide-phablet'])[last()]"));
		for (int i = 0; i < alldetails.size(); i++) {
			System.out.println(alldetails.get(i).getText());
		}
		driver.close();

	}

	@Test
	public void lenskart() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		WebElement ele = driver.findElement(By.name("q"));
		ele.click();
		Thread.sleep(3000);
		List<WebElement> trending = driver.findElements(By.xpath("//div[@class='trending_block']/ul/li/a"));
		for (int i = 0; i < trending.size(); i++) {
			System.out.println(trending.get(i).getText());
		}
		driver.close();
	}

	@Test
	public void NoonAcademy() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.learnatnoon.com/");
		driver.findElement(By.xpath("(//*[name()='svg'])[2]")).click();

	}

	@Test
	public void Orgname() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users ");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@title='Create Organization...']"));
		String firstAttribute = ele.getAttribute("title");
		System.out.println(firstAttribute);
		WebElement ele1 = driver.findElement(By.xpath("//img[@title='Search in Organizations...']"));
		String secondAttribute = ele1.getAttribute("title");
		System.out.println(secondAttribute);

	}

	@Test
	public void cricketscore() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window,scrollBy(0,700)");
		String teamname = "New Zealand";
		List<WebElement> teamnames = driver.findElements(By.xpath("//tr[*]/td[2]/span[@class='u-hide-phablet']"));
		for (int i = 1; i < teamnames.size(); i++) {
			if (teamnames.get(i).getText().equals(teamname)) {
				System.out.println(driver
						.findElement(By.xpath("//span[.='" + teamname + "']/parent::td/parent::tr/td[5]")).getText());
			}

		}
	}

}
