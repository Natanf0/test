package org.example;
import org.example.pages.RegisterPage;
import org.example.pages.SwitchToPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


import static org.example.driver.DriverFactory.killDriver;

public class Test {
    private final String url_project = "https://the-internet.herokuapp.com/";

    private RegisterPage Page;
    private SwitchToPage SwitchToPage;

    @Before
    public void inicializa() {
        Page = new RegisterPage();
        SwitchToPage = new SwitchToPage();
    }

    @After
    public void finaliza() {
        killDriver();
    }

    @org.junit.Test
    public void registerSucess(){
        Page.open_PageRegister();
        Page.insertFirstName("Natan");
        Page.insertLastName("Ferreira");
        Page.insertAddres("Av. Athos da Silveira Ramos, 274 - Cidade Universitária, Rio de Janeiro - RJ, 21941-909");
        Page.insertEmail("natan@gmail.com");
        Page.uploadImage();
        Page.insertPhone("5521968216944");
        Page.setGender("Male");
        Page.setHobbies("Movies Hockey");
        Page.selectLanguages("Portuguese Spanish");
        Page.selectSkill("Android");
        Page.selectCountry("Japan");
        Page.selectBirth("16", "August", "2001");
        Page.insertPassword("1234");

        Page.clickOnSubmitButton();

    }

    @org.junit.Test
    public void swithToAlert(){
        SwitchToPage.menuSwitchTo("Alerts");
        SwitchToPage.openSimpleAlert();
        SwitchToPage.verifyTextInSimpleAlert();
        SwitchToPage.acceptSimpleAlert();
    }

    @org.junit.Test
    public void switchToAlertWitchOK(){
        //SwitchToPage.open_SwitchAlert();
        SwitchToPage.clickAlertWitchOkCancel();
        SwitchToPage.clickButtonAlertWitchOkCancel();
        SwitchToPage.acceptSimpleAlert();
        Assert.assertTrue(SwitchToPage.verifyTextOKandCancel("You pressed Ok"));
    }
    @org.junit.Test
    public void switchToAlertWitchCancel(){
        //SwitchToPage.open_SwitchAlert();
        SwitchToPage.clickAlertWitchOkCancel();
        SwitchToPage.clickButtonAlertWitchOkCancel();
        SwitchToPage.dismissAlert();
        Assert.assertTrue(SwitchToPage.verifyTextOKandCancel("You pressed Cancel"));
    }

    @org.junit.Test
    public void switchToAlertPrompt_OK(){
        //SwitchToPage.open_SwitchAlert();
        SwitchToPage.clickAlertPrompt();
        SwitchToPage.clickButtonAlertPrompt();
        SwitchToPage.insertTextInAlertPrompt("Natan");
        SwitchToPage.acceptSimpleAlert();
        Assert.assertTrue(SwitchToPage.validaAlertPrompt_OK("Natan"));
    }
    @org.junit.Test
    public void switchToAlertPrompt_Cancel(){
        //SwitchToPage.open_SwitchAlert();
        SwitchToPage.clickAlertPrompt();
        SwitchToPage.clickButtonAlertPrompt();
        SwitchToPage.insertTextInAlertPrompt("Natan");
        SwitchToPage.dismissAlert();
        Assert.assertTrue(SwitchToPage.validaAlertPrompt_Cancel());
    }

    @org.junit.Test
    public void slide() {
        SwitchToPage.slider();
    }

    @org.junit.Test
    public void dragAndDropDynamic() throws InterruptedException {
        SwitchToPage.dragAndDropDynamic();
    }

    @org.junit.Test
    public void resizable() throws InterruptedException {
        SwitchToPage.resizable();
    }
    @org.junit.Test
    public void selectable() throws InterruptedException {SwitchToPage.selectable();}

    @org.junit.Test
    public void datePickerEnabled() throws InterruptedException {SwitchToPage.datePickerEnabled();}


    @org.junit.Test
    public void datePickerDisabled() throws InterruptedException {SwitchToPage.datePickerDisabled();}

    @org.junit.Test
    public void test() throws InterruptedException {
        SwitchToPage.test();
    }

/*

    @org.junit.Test
    public void clicaLink() {
        driver.findElement(By.linkText("A/B Testing")).click();
        Assert.assertEquals("https://the-internet.herokuapp.com/abtest", driver.getCurrentUrl());
    }

    @org.junit.Test
    public void dragAndDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        Actions action = new Actions(driver);

        action.dragAndDrop(driver.findElement(By.id("column-a")),
                driver.findElement(By.id("column-b"))).build().perform();
    }

    @org.junit.Test
    public void contextMenu(){
        driver.findElement(By.linkText("Context Menu")).click();
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();

       Assert.assertEquals("You selected a context menu", msg);

    }
    @org.junit.Test
    public void disappearingElements() {
        driver.findElement(By.linkText("Disappearing Elements")).click();
        WebElement btn_gallery = driver.findElement(By.xpath("//a[.='Gallery']"));
        while(!btn_gallery.isDisplayed()){
            driver.navigate().refresh();
        }
        btn_gallery.click();
    }
*/

}