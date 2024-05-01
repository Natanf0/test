
package org.example.steps;

import io.cucumber.java.pt.*;
import org.example.pages.DSL;
import org.example.pages.RegisterPage;
import org.example.pages.SwitchToPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsSteps {
    SwitchToPage switchToPage;
    public AlertsSteps() {
        switchToPage = new SwitchToPage();
    }


    @Então("o sistema exibirá um alerta com a mensagem {string}")
    public void oSistemaExibiráUmAlertaComAMensagemIAmAnAlertBox(String msg) {
        Assert.assertEquals(msg, switchToPage.getTextAlert());
    }

    @E("acesse o submenu {string}")
    public void acesseOSubmenuAlerts(String submenu) {
        switchToPage.open_SwitchToSubmenu(submenu);
    }

    @Quando("o usuário clicar no botão para disparar o alerta")
    public void oUsuárioClicarNoBotãoParaDispararOAlerta() {
        switchToPage.openSimpleAlert();
    }

    @E("clique no botão para disparar a caixa de confirmação")
    public void cliqueNoBotãoParaDispararACaixaDeConfirmação() {
        switchToPage.clickAlertWitchOkCancel();
    }

    @Quando("o usuário clicar em OK")
    public void oUsuárioClicarEmOK() {
    }

    @Então("o sistema exibirá a mensagem {string}")
    public void oSistemaExibiráAMensagemYouPressedOk() {
    }

    @E("que o usuário clique no botão para disparar a caixa de confirmação")
    public void queOUsuárioCliqueNoBotãoParaDispararACaixaDeConfirmação() {
    }

    @Quando("o usuário clicar em Cancelar")
    public void oUsuárioClicarEmCancelar() {
    }

    @Quando("o usuário clicar no botão para disparar a caixa de entrada")
    public void oUsuárioClicarNoBotãoParaDispararACaixaDeEntrada() {
    }

    @Então("o sistema exibirá o texto {string} no campo")
    public void oSistemaExibiráOTextoAutomationTestingUserNoCampo() {
    }

    @E("clique no botão para disparar a caixa de entrada")
    public void cliqueNoBotãoParaDispararACaixaDeEntrada() {
    }

    @E("preencha o campo com o valor {string}")
    public void preenchaOCampoComOValorValor() {
    }

    @Quando("o usuário clicar no botão OK")
    public void oUsuárioClicarNoBotãoOK() {
    }

    @Quando("o usuário clicar no botão Cancelar")
    public void oUsuárioClicarNoBotãoCancelar() {
    }

    @Então("o sistema não exibirá nenhuma mensagem")
    public void oSistemaNãoExibiráNenhumaMensagem() {
    }

}
