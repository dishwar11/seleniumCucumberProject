package StepDefination;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases {

	public WebDriver driver;

	public String url = "http://elearning.upskills.in/";

	@Given("User should have launched the application use the admin credentials")
	public void user_should_have_launched_the_application_use_the_admin_credentials() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);

		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin@123");
		driver.findElement(By.id("form-login_submitAuth")).click();

		System.out.println(driver.getTitle());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(500,500)");

	}

	@When("add a session in career and promotions link")
	public void add_a_session_in_career_and_promotions_link() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='tabs-4']/div/div[2]/div[2]/ul/li[8]/a")).click();

		driver.findElement(By.xpath("//*[@id='toolbar-career']/div/div/a[2]/img")).click();

		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/a[2]/img")).click();

		driver.findElement(By.id("career_name")).sendKeys("QA");

		driver.findElement(By.id("career_submit")).click();

		System.out.println("QA created in career ");

		driver.findElement(By.xpath("//*[@id='cm-content']/div/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id='toolbar-career']/div/div/a[3]/img")).click();

		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/a[2]/img")).click();

		driver.findElement(By.id("name")).sendKeys("QA for Tester");

		driver.findElement(By.id("promotion_submit")).click();

		System.out.println("QA for Tester in pramotion");

		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[3]/a[3]/img")).click();

		driver.findElement(By.id("add_session_name")).sendKeys("Selenium training session " + date1);

		driver.findElement(By.xpath("//*[@id='add_session']/fieldset/div[2]/div[1]/span/span[1]/span/span[2]")).click();

		System.out.println(driver.findElement(By.className("select2-search__field")).isEnabled());

		WebElement name = driver.findElement(By.className("select2-search__field"));
		name.sendKeys("Sun");
		Thread.sleep(2000);
		name.sendKeys(Keys.ENTER);

		System.out.println(" droupdown selected");

		driver.findElement(By.id("add_session_submit")).click();

		System.out.println("selenium promation created");

		driver.findElement(By.xpath("//*[@id='origin']/option[6]")).click();

		driver.findElement(By.xpath("//*[@id='multiple-add-session']/div[2]/div[2]/div[1]/button/em")).click();

		driver.findElement(By.xpath("//*[@id='multiple-add-session']/div[2]/div[2]/div[4]/button")).click();

		WebElement name1 = driver.findElement(By.id("user_to_add"));
		name1.sendKeys("suni");
		Thread.sleep(2000);
		name1.sendKeys(Keys.ENTER);
		System.out.println(" droupdown 2 selected");

		System.out.println("done");

	}

	@Then("session should get created & details should get displayed")
	public void session_should_get_created_details_should_get_displayed() {
		WebElement update = driver.findElement(By.className("alert alert-info"));
		String result = update.getText();
		System.out.println(result);
		if (result == "Update successful") {
			System.out.println(result + "  session created");
		} else {
			System.out.println(result + "  session created not created");
		}

		driver.quit();

	}

}
