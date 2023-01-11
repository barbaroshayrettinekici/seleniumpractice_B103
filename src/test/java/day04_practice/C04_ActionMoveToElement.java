package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class C04_ActionMoveToElement extends TestBase {

    @Test
    public void test04() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions =new Actions(driver);
        WebElement dilmenu =driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilmenu).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//span[@class='a-text-bold']"));
        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@id='icp-save-button-announce']"));

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        driver.findElement(By.xpath("//*[@aria-labelledby='icp-save-button-announce']")).click();

// acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));

    }
}
