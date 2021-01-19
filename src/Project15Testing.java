import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project15Testing {
    private WebDriverWait wait;
    private WebDriver driver;
    private String sendKeyUserName = "daulet2030@gmail.com";
    private String sendKeyPassword = "TechnoStudy123@";
    private String sendKeySchoolDepartmentName = "High School";
    private String codeInput = "HS-1";
    private String sectionName = "Junior Classes";
    private String sectionShortName = "Juniors";
    private String saveButtonCss = "ms-save-button[class='ng-star-inserted']";
    private String setupMenu = " .group-items > :nth-child(1)";
    private String schoolSetupSecondLevel = " fuse-nav-vertical-collapsable:nth-child(2)";
    private String departmentButtonThirdLevel = " > div > fuse-nav-vertical-item:nth-child(6) > a";
    private String plusButtonToAdd = "ms-table-toolbar > div ms-add-button";
    private String nameSchoolDepartmentElement = "[placeholder='GENERAL.FIELD.NAME']>input";
    private String codeInputElement = "[placeholder='GENERAL.FIELD.CODE'] > input";
    private String sectionElement = "//div[text()='Section']";
    private String nameElementLocation = "ms-text-field[placeholder='GENERAL.FIELD.NAME']>input";
    private String shortNameElementLocation = "ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input";
    private String secondPersonName = "Senior Classes";
    private String secondPersonShortName = "Senior Classes";
    private String trashIcon = "tbody > tr:first-child td:nth-child(5) ms-delete-button";


    @BeforeClass
    public void setUpWebSite(){
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://test.campus.techno.study/" );

        wait = new WebDriverWait(driver, 5);
        WebElement cookieButton = driver.findElement(By.cssSelector("a[aria-label='dismiss cookie message']"));
        cookieButton.click();
    }
    //    @AfterClass
//    public void closeWindow(){
//        driver.quit();
//    }
    @Test
    public void loginTestCase(){
        driver.findElement(By.cssSelector("input[data-placeholder=\"Username\"]")).sendKeys(sendKeyUserName);
        driver.findElement(By.cssSelector("input[data-placeholder=\"Password\"]")).sendKeys(sendKeyPassword);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        System.out.println("You successfully login !!!");
    }
    @Test(dependsOnMethods = {"loginTestCase"})
    public void clickingSetUpMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(setupMenu)));
        driver.findElement(By.cssSelector(setupMenu)).click();
        System.out.println("You clicked on setup button !!!");
    }
    @Test(dependsOnMethods = {"clickingSetUpMenu"})
    public void clickingSchoolSetupMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(setupMenu + schoolSetupSecondLevel)));
        driver.findElement(By.cssSelector(setupMenu+schoolSetupSecondLevel)).click();
        System.out.println("You clicked on school setup button !!!");
    }
    @Test(dependsOnMethods = {"clickingSchoolSetupMenu"})
    public void clickingOnDepartment(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(setupMenu+schoolSetupSecondLevel+departmentButtonThirdLevel)));
        driver.findElement(By.cssSelector(setupMenu+schoolSetupSecondLevel+departmentButtonThirdLevel)).click();
        System.out.println("You clicked on DEPARTMENT");
    }
    @Test(dependsOnMethods = {"clickingOnDepartment"})
    public void clickingAddButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(plusButtonToAdd)));
        driver.findElement(By.cssSelector(plusButtonToAdd)).click();
        System.out.println("You clicked Add button");
    }

    //////////////////////////////////////////    SENDING THE KEY "High School" AND CODE "HS-1"   /////////////////////////////////////////////////
    @Test(dependsOnMethods = {"clickingAddButton"})
    public void sendingAKey(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(nameSchoolDepartmentElement)));
        driver.findElement(By.cssSelector(nameSchoolDepartmentElement)).sendKeys(sendKeySchoolDepartmentName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(codeInputElement)));
        driver.findElement(By.cssSelector(codeInputElement)).sendKeys(codeInput);
        driver.findElement(By.xpath(sectionElement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cdk-overlay-pane ms-table-toolbar > div ms-add-button fa-icon")));
        driver.findElement(By.cssSelector("div.cdk-overlay-pane ms-table-toolbar > div ms-add-button fa-icon")).click();
        System.out.println("You fill up the input with High School and CODE HS-1 ");
    }
    @Test(dependsOnMethods = {"sendingAKey"})
    public void nameAndShortName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(nameElementLocation)));
        driver.findElement(By.cssSelector(nameElementLocation)).sendKeys(sectionName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(shortNameElementLocation)));
        driver.findElement(By.cssSelector(shortNameElementLocation)).sendKeys(sectionShortName);
        //WebElement addButton = driver.findElement(By.cssSelector("div[fxflexalign='center']"));
        //addButton.click();
    }
}
