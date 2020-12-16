import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamas\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081");
        /*Thread.sleep(4000);
        driver.findElement(By.className("dropbtn")).click();*/
        Thread.sleep(4000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(4000);
        driver.findElement(By.name("username")).sendKeys("tm");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("admin");
        Thread.sleep(3000);
        driver.findElement(By.className("btn-primary")).click();
        Thread.sleep(10000);
        driver.close();
        //System.out.println(driver.getTitle());

    }
}
