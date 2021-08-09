#language:ru
#encoding:UTF-8

@all
Функционал: Вход на сайт Sauсedemo

  Предыстория:
    Допустим открыта страница "https://www.saucedemo.com/"

  @positive
  Сценарий: Проверка входа на сайт при верном введении логина и пароля
    Когда в поле логин введено значение "standard_user"
    И в поле пароль введено значение "secret_sauce"
    И нажата кнопка Login
    Тогда открыта страница "https://www.saucedemo.com/inventory.html"

  @negative
  Структура сценария:Проверка входа на сайт при неверном введении логина и/или пароля
    Когда в поле логин введено значение "<userName>"
    И в поле пароль введено значение "<password>"
    И нажата кнопка Login
    Тогда появляется сообщение с текстом "Epic sadface: Username and password do not match any user in this service"

      Примеры:
        | userName     |password    |
        | login        |password    |
        | problem_user |123         |
        | qwe          |secret_sauce|