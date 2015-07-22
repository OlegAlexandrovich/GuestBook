
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class Webdriver {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();      
        
    
    @Before
    public void setUp() throws Exception {
        
        
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    
        
    }

    @Test
    public void MainSuite() throws Exception {                  
        driver.get("http://localhost:8080/WebApplication1/"); 
        
        //ввод неверных данных
        WebElement element = driver.findElement(By.id("index:login"));
        element.clear();
        element.sendKeys("test1");
        element = driver.findElement(By.id("index:password"));
        element.sendKeys("test1");
        element = driver.findElement(By.id("index:enter"));
        element.click();        
        if(isElementPresent(By.id("index:enter"))){
            System.out.println("Wrong data test passed");
        }
        else{System.out.println("Wrong data test failed");}
        
        
       //ссылка на форму регистрации
       element=driver.findElement(By.id("index:registration"));
       element.click();
        if(isElementPresent(By.id("regForm:regPanel"))){
           System.out.println("regLink test passed");
       }
       else{System.out.println("regLink test failed");}
       
       //регистрация
        element=driver.findElement(By.id("regForm:firstNameInput"));
        element.sendKeys("test");
        element=driver.findElement(By.id("regForm:secondNameInput"));
        element.sendKeys("test");
        element=driver.findElement(By.id("regForm:emailInput"));
        element.sendKeys("test"); 
        element=driver.findElement(By.id("regForm:unameInput"));
        element.sendKeys("test"); 
        element=driver.findElement(By.id("regForm:passwordInput"));
        element.sendKeys("test"); 
        element=driver.findElement(By.id("regForm:regButton"));
        element.click();
        if(isElementPresent(By.id("index:enter"))){
            System.out.println("registration test passed");
        }
        else{System.out.println("registration test failed");}
        
        //ввод верных данных
        element = driver.findElement(By.id("index:login"));
        element.clear();
        element.sendKeys("test");
        element = driver.findElement(By.id("index:password"));
        element.sendKeys("test");
        element = driver.findElement(By.id("index:enter"));
        element.click();
        if(isElementPresent(By.id("logindexForm:messagePanel"))){
            System.out.println("login test passed");
        }
        else{System.out.println("login test failed");}
        
        //ввод сообщения
        element = driver.findElement(By.id("logindexForm:enter"));
        element.sendKeys("test title");
        element=driver.findElement(By.tagName("iframe"));
        element.sendKeys("test message");
        element=driver.findElement(By.id("logindexForm:submit"));
        element.click();
        element=driver.findElement(By.id("logindexForm:update"));
        element.click();
        if(isElementPresent(By.id("logindexForm:messPanel"))){
            System.out.println("message enter test passed");
        }
        else{System.out.println("message enter test failed");}
       
        //изменение данных профиля
        element=driver.findElement(By.id("loginWindow:profile"));
        element.click();
        element=driver.findElement(By.id("profForm:avatarChange"));
        element.sendKeys("images/test.png");
        element=driver.findElement(By.id("profForm:firstNameChange"));
        element.sendKeys("testChange");
        element=driver.findElement(By.id("profForm:secondNameChange"));
        element.sendKeys("testChange"); 
        element=driver.findElement(By.id("profForm:emailChange"));
        element.sendKeys("testChange"); 
        element=driver.findElement(By.id("profForm:saveChanges"));
        element.click();
        if(isElementPresent(By.id("profForm:profPanel"))){
            System.out.println("profile change test passed");
        }
        else{System.out.println("profile change test failed");}
        
        //выход из системы
        element=driver.findElement(By.id("loginWindow:exit"));
        element.click();
        if(isElementPresent(By.id("index:enter"))){
            System.out.println("logout test passed");
        }
        else{System.out.println("logout test failed");}
        
        
        
    }

    @After
    public void tearDown() throws Exception {
   
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

public boolean isElementPresent(By by) {
    try {
      driver.findElements(by);
      return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
      return false;
    }
}
}