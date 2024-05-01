package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.example.driver.DriverFactory.getDriver;

public class DSL {
    private Actions actions;
    public DSL(){
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected void openHomePage(String homePageLink){
        getDriver().get(homePageLink);}

    // REGISTER PAGE

    protected void insertText(By by, String text){
        scrollToElement(getDriver().findElement(by));
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(text);
    }

    protected void setRadioButton(By by){
        scrollToElement(getDriver().findElement(by));
        getDriver().findElement(by).click();
    }
    private void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected void setCheckBox(By by){
        scrollToElement(getDriver().findElement(by));
        getDriver().findElement(by).click();
    }

    protected void selectMultiCombobox(By by, String option){

    }
    protected void selectSimpleCombobox(By by, String option){
        scrollToElement(getDriver().findElement(by));
        Select select = new Select(getDriver().findElement(by));
        select.selectByVisibleText(option);
    }

    protected void uploadImage(By by, String path){
        scrollToElement(getDriver().findElement(by));
        getDriver().findElement(by).sendKeys(path);
    }
    protected void scrollAndClick(By by){
        scrollToElement(getDriver().findElement(by));
        getDriver().findElement(by).click();
    }

    //  SWITCH TO
    protected void click(By by){
        getDriver().findElement(by).click();
    }

    protected void acceptAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    protected void dismissAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }
    protected void insertTextInAlertPrompt(String str){
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(str);
    }
    protected String getTextAlert(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    protected boolean compareMsg(By by, String msg){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver().findElement(by).getText().equalsIgnoreCase(msg);
    }

    // SLIDE

    protected void slide() {
        getDriver().get("https://demo.automationtesting.in/Slider.html");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement slider = getDriver().findElement(By.xpath("//div[@id='slider']/a")) ;
        while(!slider.getAttribute("style").equalsIgnoreCase("left: 90%;")){
            // Arrasta para o lado até 90% da barra do slide;
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    // DRAG AND DROP
    protected void dragAndDropDynamic() throws InterruptedException {
        getDriver().get("https://demo.automationtesting.in/Dynamic.html");
        WebElement element1 = getDriver().findElement(By.id("angular"));
        WebElement element2 = getDriver().findElement(By.id("mongo"));
        WebElement element3 = getDriver().findElement(By.id("node"));
        WebElement target = getDriver().findElement(By.id("droparea"));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        scrollToElement(element1);
        actions.dragAndDrop(element1,target).build().perform();
        actions.dragAndDrop(element2,target).build().perform();
        actions.dragAndDrop(element3,target).build().perform();
        Thread.sleep(5000);
        actions.dragAndDrop(element3,target).build().perform();
        actions.dragAndDrop(element2,target).build().perform();
        actions.dragAndDrop(element1,target).build().perform();
        Thread.sleep(5000);
    }

    // RESIZABLE

    protected void resizable() throws InterruptedException {
        getDriver().get("https://demo.automationtesting.in/Resizable.html");
        Thread.sleep(5000);
        WebElement element = getDriver().findElement(By.xpath("//div[@id='resizable']/div[3]"));
        actions.clickAndHold(element).moveByOffset(250, 250).perform();
        Thread.sleep(6000);
    }

    protected void selectable(String values) throws InterruptedException {
        String[] options = values.split(" , ");

        getDriver().get("https://demo.automationtesting.in/Selectable.html");
        getDriver().findElement(By.xpath("//a[.='Serialize ']")).click();

        for(String s: options){
            getDriver().findElement(By.xpath("//ul[@class='SerializeFunc']/li[.='Sakinalium - "+s+"']")).click();
            actions.keyDown(Keys.CONTROL).build().perform();
        }
        actions.keyUp(Keys.CONTROL).build().perform();
        String msg = getDriver().findElement(By.xpath("//p[@id='feedback']/span")).getText() +
                        getDriver().findElement(By.xpath("//p[@id='feedback']/span[@id='result']")).getText();
        Thread.sleep(5000);
        Assert.assertEquals(msg, "You've selected:Cross Browser Testing , Functional Testing , Readability");
    }

    protected void datePickerEnabled() throws InterruptedException {
        getDriver().get("https://demo.automationtesting.in/Datepicker.html");
        getDriver().findElement(By.id("datepicker2")).click();
        Thread.sleep(2000);
        Select month = new Select(getDriver().findElement(By.xpath("//select[@title='Change the month']")));
        month.selectByVisibleText("December");
        Thread.sleep(2000);
        Select year = new Select(getDriver().findElement(By.xpath("//select[@title='Change the year']")));
        year.selectByVisibleText("2022");
        getDriver().findElement(By.xpath("//div[@class='datepick-month']//a[.='15']")).click();
        Thread.sleep(5000);
    }

    protected void datePickerDisabled(String _year, String _month, String _day) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        getDriver().get("https://demo.automationtesting.in/Datepicker.html");
        String[] meses = {"January,February,March,April,May,June,July,August,September,October,November,December"};
        getDriver().findElement(By.xpath("//div[@class='form-group']//img")).click();
        Thread.sleep(2000);
        WebElement month = getDriver().findElement(By.xpath("//div[@class='ui-datepicker-title']/span"));
        WebElement year = getDriver().findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
        String ano = year.getText();
        Thread.sleep(2000);
        while(!(ano).equalsIgnoreCase(_year)) {
            if (Integer.parseInt(ano) > Integer.parseInt(_year)) {
                getDriver().findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']/span")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-title']/span[2]")));
                ano = year.getText();
            } else if (Integer.parseInt(ano) < Integer.parseInt(_year)) {
                getDriver().findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-title']/span[2]")));
                ano = year.getText();
            }
        }
        //driver.findElement(By.xpath("//div[@class='form-group']//img")).click();
        //driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[.='13']")).click();
        Thread.sleep(4000);
    }

    public void test() throws InterruptedException {
        getDriver().get("https://docs.google.com/document/d/1F_EOnDP2yI9uR4G9K744B7TqfjaTpnH7lVpAgreF1r8/edit?usp=sharing");
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//canvas[@class='kix-canvas-tile-content']")).sendKeys("Natan");
    }

    public void openSubmenu(By menu, By submenu){
        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(getDriver().findElement(menu)).perform();
        actions.click(getDriver().findElement(submenu)).perform();
    }

}