import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


/*
A Selenium egy Web felület tesztelő eszköz. Minden Selelnium Teszt test lépésekből áll. Miden lépésében:

  -Meg tudunk nyitni egy URL-t
  -A megnyitott weblap tetszőleges pontjára rákereshetünk
    XPATH kifejezésekkel
    CSS kereséssel (név, class vagy ID alapján)
  -A megtalált elemeken user aktivitást emulál a selenium:
    Kitölt egy input mezőt
    Választ egy listából
    Megnyomja a submit-et.

Selenium 4 fő részből áll:
   Selenium IDE
   Selenium Remote Control
   GRID
   WebDriver

Ezek közül mi a WebDriver-t és abból is a Böngésző függő implementációt fogjuk használni.

*/
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamas\\Downloads\\chromedriver_win32\\chromedriver.exe");  //Teszteléshez kivánt böngésző driver utvonalának megoldása

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.cookies", 2);
        prefs.put("network.cookie.cookieBehavior", 2);
        prefs.put("profile.block_third_party_cookies", 2);// Cookie-k mentésének letiltása
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options); //driver példányosítása
        driver.get("http://google.hu"); //tesztelni kívánt oldal címének megadása
        Thread.sleep(2000);// két másodperces késletetés
        String at=driver.getCurrentUrl(); // A megnyitott oldal URL címének elméntése
        Thread.sleep(2000);
        if (at.equalsIgnoreCase("https://www.google.hu/?gws_rd=ssl")){ //URL összehasonlítás
            System.out.println("Az URL egyezik");
        }
        else  {
            System.out.println("Az URL nem egyezik");
        }
        driver.findElement(By.name("q")).sendKeys("Világok pusztítója"); //Elem keresés név alapján. Keresett elem egy Input mező, amibe az adott értéket küldjük el
        Thread.sleep(2000);
        driver.findElement(By.className("gNO89b")).click();//Elem keresés osztáylnév alapján. Keresett elem egy gomb, amire rákattint
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Robert Oppenheimer – Wikipédia']")).click();// Elem keresés XML útvonal kifejezéssel. Ezáltal az adott oldal HTML strukturájában lehet keresni
        String bt=driver.getTitle(); //Oldal címének elmentése
        if (bt.equalsIgnoreCase("Robert Oppenheimer – Wikipédia")){ //Cím összehasonlítás
            System.out.println("A cím egyezik");
        }
        else  {
            System.out.println("A cím nem egyezik");
        }
        Thread.sleep(2000);

        driver.close(); // A teszt végezte után a böngésző bezárása

    }
}
