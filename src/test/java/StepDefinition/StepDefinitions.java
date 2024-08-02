package StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    public WebDriver driver;

    @Given("Istifadeci hr kapital bank saytina daxil olub")
    public void istifadeci_hr_kapital_bank_saytina_daxil_olub() {
        System.setProperty("webdriver.chrome.driver","C:/aletler/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://hr.kapitalbank.az/");
        driver.manage().window().maximize();
    }

    @When("Vakansiyalar duymesine klikledikde")
    public void vakansiyalar_duymesine_klikledikde() {
        driver.findElement(By.xpath("/html/body/div[1]/div/header/section/div/div[2]/nav/a")).click();
    }
    @Then("Axtarisa QA Engineer sozunu yazib axtarir")
    public void axtarisa_qa_engineer_sozunu_yazib_axtarir() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Vakansiya axtar\"]"))).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Vakansiya axtar\"]")).sendKeys("QA Engineer");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"/vacancy/3423\"]")));

        // elemente scroll et
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // clickable olmagini gozlet
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/vacancy/3423\"]")));

        // interception olmamagi ucun js ile click et
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);



    }
    @And("QA Engineer vakansiyasi cixir")
    public void qa_engineer_vakansiyasi_cixir() {

    }


}
