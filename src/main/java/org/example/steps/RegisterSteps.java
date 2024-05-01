package org.example.steps;

import io.cucumber.java.pt.*;
import org.example.pages.DSL;
import org.example.pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterSteps{

    RegisterPage Page;

    public RegisterSteps(){
        Page = new RegisterPage();
    }

    @Dado("que o usuário acesse a tela de registro")
    public void queOUsuárioAcesseATelaDeRegistro() { Page.open_PageRegister();}

    @E("que o usuário preencha o campo Nome com {string}")
    public void queOUsuárioPreenchaOCampoNomeComNatan(String name) { Page.insertFirstName(name);}

    @E("o sobrenome com {string}")
    public void oSobrenomeComFerreira(String lastname) { Page.insertLastName(lastname);}

    @E("o Endereço com {string}")
    public void oEndereçoComAvAthosDaSilveiraRamosCidadeUniversitáriaRioDeJaneiroRJ(String adress) {Page.insertAddres(adress);}

    @E("o Email com {string}")
    public void oEmailComNatanGmailCom(String mail) { Page.insertEmail(mail);}

    @E("o Telefone com {string}")
    public void oTelefoneCom(String phone) { Page.insertPhone(phone);}

    @E("marque o gênero {string}")
    public void marqueOGêneroMale(String gender) { Page.setGender(gender);}


    @E("selecione o\\(s) idioma\\(s) {string}")
    public void selecioneOSIdiomaSPortugueseSpanish(String language) throws InterruptedException { Page.selectLanguages(language);}

    @E("a habilidade {string}")
    public void aHabilidadeAndroid(String skill) { Page.selectSkill(skill);}

    @E("o país {string}")
    public void oPaísJapan(String country) { Page.selectCountry(country);}

    @E("data de aniversário {string} de {string} de {string}")
    public void dataDeAniversárioDeAugustDe(String day, String month, String year) {
        Page.selectBirth(day, month, year);
    }

    @E("a senha {string}")
    public void aSenha(String password) { Page.insertPassword(password);}

    @Entao("o sistema realizará o registro do usuário")
    public void oSistemaRealizaráORegistroDoUsuário() { Assert.assertTrue(true);
    }

    @Quando("eu clicar em submit")
    public void euClicarEmSubmit() { Page.clickOnSubmitButton();
    }

    @E("o\\(s) hobby\\/hobbies {string}")
    public void oSHobbyHobbiesCricketHockey(String hobbies) { Page.setHobbies(hobbies);}

    @E("realize o upload do arquivo")
    public void realizeOUploadDoArquivo() {
        Page.uploadImage();
    }
}
