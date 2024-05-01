#language: pt
#encoding: utf-8

Funcionalidade: Incluir registro no sistema

  Contexto:
    Dado que o usuário acesse a tela de registro

   Cenario: : Incluir registro com dados válidos
     E que o usuário preencha o campo Nome com 'Natan'
     E o sobrenome com 'Ferreira'
     E o Endereço com 'Av. Athos da Silveira Ramos, 274 - Cidade Universitária, Rio de Janeiro - RJ, 21941-909'
     E o Email com 'natan@gmail.com'
     E o Telefone com '5521968216944'
     E marque o gênero 'Male'
     E o(s) hobby/hobbies 'Cricket Hockey'
     E selecione o(s) idioma(s) 'Portuguese Spanish'
     E a habilidade 'Android'
     E o país 'Japan'
     E data de aniversário '16' de 'August' de '2001'
     E a senha '1234'
     E realize o upload do arquivo
     Quando eu clicar em submit
     Entao o sistema realizará o registro do usuário
