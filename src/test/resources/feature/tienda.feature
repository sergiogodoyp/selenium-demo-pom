
Feature: Realizar compras en la Tienda

  @Prueba
  Scenario: Registrar un Usuario
    Given Ingreso a la Wed de la Tienda
    When presiono el boton SignUp
    And ingreso el username "Comprador1000"
    And ingreso el password "Prueba2023"
    And presiono el boton Registrar
    Then Se muestra un mensaje de confirmacion "Sign up successful."

  @Prueba
  Scenario Outline:Iniciar Sesion en la Web
    Given Ingreso a la Wed de la Tienda
    When presiono el boton Login
    And escribo el username "Comprador35"
    And escribo el password "Prueba2023"
    And presiono el boton Iniciar Sesion
    Then se muestra un mensaje de bienvenida "Welcome Comprador35"

  @Prueba
  Scenario:Cerrar Sesion en la Web
    Given Ingreso a la Wed de la Tienda
    When presiono el boton Login
    And escribo el username "Comprador35"
    And escribo el password "Prueba2023"
    And presiono el boton Iniciar Sesion
    And presiono el boton Logout
    Then se muestra la pagina principal

  @Prueba
  Scenario:Agregar laptop al carro de compras
    Given Ingreso a la Wed de la Tienda
    When presiono el boton Login
    And escribo el username "Comprador35"
    And escribo el password "Prueba2023"
    And presiono el boton Iniciar Sesion
    And selecciono la categoria "Laptops"
    And selecciono el Producto "MacBook air"
    And presiono el boton Add to cart
    Then Se muestra un mensaje de confirmacion "Product added."