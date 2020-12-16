import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tamas\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://gmail.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys("tamazsi40@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();
        Thread.sleep(2000);
        String at=driver.getTitle();
        String et="Gmail";
        if(at.equalsIgnoreCase(et)){
            System.out.println("Test Sikeres");
        }
        else{
            System.out.println("Test sikertelen");
        }


    }
}
