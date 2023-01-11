package day04_practice;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {
    @Test
    public void test03() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle=driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        WebElement aramaMotoru= driver.findElement(By.xpath("//input[@id='searchData']"));
        aramaMotoru.sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        Set<String> windowHandlesSeti=driver.getWindowHandles();

        String sayfa2Handle="";
        for (String w:windowHandlesSeti){
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle=w;
            }
        }


        driver.switchTo().window(sayfa2Handle);


        //Basligin 'Oppo' icerdigini test edin.
        String baslikStr=driver.findElement(By.xpath("//h1[@class='proName']")).getText();
        Assert.assertTrue(baslikStr.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println("Başlık = " + driver.getTitle());
    }
}