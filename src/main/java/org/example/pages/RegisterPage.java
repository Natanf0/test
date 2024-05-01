package org.example.pages;
import org.openqa.selenium.By;

public class RegisterPage{
    private DSL _DSL;

    public RegisterPage(){
        _DSL = new DSL();
    }
    public void open_PageRegister(){_DSL.openHomePage("https://demo.automationtesting.in/Register.html");}

    public void insertFirstName(String firstName){_DSL.insertText(By.xpath("//input[@placeholder='First Name']"), firstName);}
    public void insertLastName(String lastName){_DSL.insertText(By.xpath("//input[@placeholder='Last Name']"), lastName);}
    public void insertAddres(String addres){_DSL.insertText(By.xpath("//textarea[@ng-model='Adress']"), addres);}
    public void insertEmail(String email){ _DSL.insertText(By.xpath("//input[@ng-model='EmailAdress']"), email);}
    public void insertPhone(String phone){_DSL.insertText(By.xpath("//input[@ng-model='Phone']"), phone);}
    public void setGender(String option){
        if(option.equalsIgnoreCase("Male")){
            _DSL.setRadioButton(By.xpath("//input[@value='Male']"));
        }else if(option.equalsIgnoreCase("FeMale")){
            _DSL.setRadioButton(By.xpath("//input[@value='FeMale']"));
    }}

    public void setHobbies(String options){
        String[] array = options.split(" ");
        for(String option : array){
            if(option.equalsIgnoreCase("Cricket")){_DSL.setCheckBox(By.id("checkbox1"));}
            if(option.equalsIgnoreCase("Movies")){_DSL.setCheckBox(By.id("checkbox2"));}
            if(option.equalsIgnoreCase("Hockey")){_DSL.setCheckBox(By.id("checkbox3"));}
        }
    }
    public void selectLanguages(String languages) {
        String[] array = languages.split(" ");
        for(String language : array){
            _DSL.selectMultiCombobox(By.xpath("//label[.='Languages']/../div/multi-select"), language);
        }

    }
    public void selectSkill(String skill){_DSL.selectSimpleCombobox(By.id("Skills"), skill);}
    public void selectCountry(String country){_DSL.selectSimpleCombobox(By.id("country"),country);}
    public void selectBirth(String day, String month, String year){
        _DSL.selectSimpleCombobox(By.id("daybox"), day);
        _DSL.selectSimpleCombobox(By.xpath("//select[@ng-model='monthbox']"), month);
        _DSL.selectSimpleCombobox(By.id("yearbox"), year);
    }
    public void insertPassword(String password){_DSL.insertText(By.id("firstpassword"), password);
                                                _DSL.insertText(By.id("secondpassword"), password);}

    public void uploadImage(){
        _DSL.uploadImage(By.id("imagesrc"),
                System.getProperty("user.dir")+"\\src\\main\\resources\\imgTest.png");
    }
    public void clickOnSubmitButton(){_DSL.scrollAndClick(By.id("submitbtn"));}
}
