#language: pt
#encoding: utf-8

Funcionalidade: Alerts

  Contexto:
    Dado que o usuário acesse a tela de registro
    E acesse o submenu 'Alerts'

  Cenario: CT01 - Validar Alerta Simples
    Quando o usuário clicar no botão para disparar o alerta
    Então o sistema exibirá um alerta com a mensagem 'I am an alert box!'

  Cenario: CT02 - Validar Confirm Box - Botão OK
    E clique no botão para disparar a caixa de confirmação
    Quando o usuário clicar em OK
    Então o sistema exibirá a mensagem 'You pressed Ok'

  Cenario: CT02 - Validar Confirm Box - Botão Cancelar
    E que o usuário clique no botão para disparar a caixa de confirmação
    Quando o usuário clicar em Cancelar
    Então o sistema exibirá a mensagem 'You Pressed Cancel'

  Cenario: CT03 - Validar mensagem default Prompt Box
    Quando o usuário clicar no botão para disparar a caixa de entrada
    Então o sistema exibirá o texto 'Automation Testing user' no campo

  Esquema do Cenario: Cenario: CT03 - Validar Prompt Box - Botão OK
    E clique no botão para disparar a caixa de entrada
    E preencha o campo com o valor '<valor'
    Quando o usuário clicar no botão OK
    Então o sistema exibirá a mensagem "Hello '<valor>' How are you today"

    Exemplos: |valor|
              | Natan    |
              | QA    |

  Cenario: Cenario: CT03 - Validar Prompt Box - Botão Cancelar
    E clique no botão para disparar a caixa de entrada
    E preencha o campo com o valor 'Teste'
    Quando o usuário clicar no botão Cancelar
    Então o sistema não exibirá nenhuma mensagem