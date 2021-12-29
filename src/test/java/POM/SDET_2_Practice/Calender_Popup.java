package POM.SDET_2_Practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_Popup {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		Date date = new Date();
		String todaydate = date.toString();
		System.out.println(todaydate);
		String[] arr = todaydate.split(" ");
		// Tue Dec 21 15:35:49 IST 2021
		// 0 1 2 3 4 5
		String day = arr[0];
		String month = arr[1];
		String date1 = arr[2];
		String year = arr[5];
		String tdaydate = day + " " + month + " " + date1 + " " + year;
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("[class='langCardClose']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
		driver.findElement(By.xpath("//div[text()='HYD']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("TIR");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='TIR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 11; i++) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='" + tdaydate + "']")).click();
				break;
			} catch (Exception e) {

				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

		driver.close();

	}

	public void datatype() {
		

	}

}
