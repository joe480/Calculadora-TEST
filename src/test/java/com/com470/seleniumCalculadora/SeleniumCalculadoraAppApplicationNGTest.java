package com.com470.seleniumCalculadora;

import java.sql.Driver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCalculadoraAppApplicationNGTest {

    private WebDriver driver;

    public SeleniumCalculadoraAppApplicationNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/calculadora");
        esperarPagina(3);
    }

    @Test
    public void testCalculadoraSimple() {
        calcularSimple("5", "3", "8", "add");
        calcularSimple("5", "3", "2", "subtract");
        calcularSimple("5", "3", "15", "multiply");
        calcularSimple("25", "5", "5.0", "divide");
    }

    @Test
    public void testCalculadoraCompleja() {
        calcularComplejo("5","5", "fibonacci");
        calcularComplejo("5", "120", "factorial");
        calcularComplejo("25", "5", "sqrt");
        calcularComplejo("5", "25", "power");
    }

    public void calcularSimple(String num1, String num2, String resultado, String operacion) {
        driver.findElement(By.name("clearSimple")).click();
        driver.findElement(By.id("a")).sendKeys(num1);
        driver.findElement(By.id("b")).sendKeys(num2);
        driver.findElement(By.name(operacion)).click();
        esperarPagina(1);
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("Resultado: " + resultado));
    }

    public void calcularComplejo(String num1, String resultado, String operacion) {
        driver.findElement(By.name("clearAdvanced")).click();
        driver.findElement(By.id("c")).sendKeys(num1);
        driver.findElement(By.name(operacion)).click();
        esperarPagina(1);
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("Resultado: " + resultado));
    }

    public void esperarPagina(int num) {
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
        }
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }

}
