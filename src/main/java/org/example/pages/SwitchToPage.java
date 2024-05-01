package org.example.pages;

import org.openqa.selenium.By;

public class SwitchToPage {
    private DSL DSL;
    public SwitchToPage(){
        DSL = new DSL();
        DSL.openHomePage("https://demo.automationtesting.in/Register.html");}

    public void open_SwitchToSubmenu(String submenu){DSL.openSubmenu(By.xpath("//a[.='SwitchTo']"),
            By.xpath("//a[.='"+submenu+"']"));}
    public void openSimpleAlert(){DSL.click(By.xpath("//button[@class='btn btn-danger']"));}
    public boolean verifyTextInSimpleAlert(){return DSL.getTextAlert().equalsIgnoreCase("I am an alert box!");}
    public void acceptSimpleAlert(){DSL.acceptAlert();}
    public void clickAlertWitchOkCancel() {DSL.click(By.xpath("//a[.='Alert with OK & Cancel ']"));}
    public void clickButtonAlertWitchOkCancel() {DSL.click(By.xpath("//button[@class='btn btn-primary']"));}
    public String getTextAlert() {return DSL.getTextAlert();}

    public boolean verifyTextOKandCancel(String s) {return DSL.compareMsg(By.id("demo"), s);}

    public void dismissAlert() {
        DSL.dismissAlert();
    }

    public void clickAlertPrompt() {DSL.click(By.xpath("//a[.='Alert with Textbox ']"));}

    public void clickButtonAlertPrompt() { DSL.click(By.xpath("//button[@class='btn btn-info']"));}

    public void insertTextInAlertPrompt(String string) {DSL.insertTextInAlertPrompt(string);}

    public boolean validaAlertPrompt_OK(String string) {
        return DSL.compareMsg(By.id("demo1"), "Hello "+string+" How are you today");
    }
    public boolean validaAlertPrompt_Cancel() {
        return DSL.compareMsg(By.id("demo1"), "");
    }

    public void slider() {
        DSL.slide();
    }
    public void dragAndDropDynamic() throws InterruptedException {
        DSL.dragAndDropDynamic();
    }

    public void resizable() throws InterruptedException {DSL.resizable();}

    public void selectable() throws InterruptedException {DSL.selectable("Cross Browser Testing , Functional Testing , Readability");}

    public void datePickerEnabled() throws InterruptedException {
        DSL.datePickerEnabled();
    }

    public void test() throws InterruptedException {
        DSL.test();
    }
    public void menuSwitchTo(String option){
        DSL.openSubmenu(By.xpath("//a[.='SwitchTo']"), By.xpath("//a[.='"+option+"']"));
    }

    public void datePickerDisabled() throws InterruptedException {DSL.datePickerDisabled("2022","August", "16");}

}
