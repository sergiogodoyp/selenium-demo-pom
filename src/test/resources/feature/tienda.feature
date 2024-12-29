@Prueba
Feature: Realizar compras en la Tienda
  
  Background:
    Given Ingreso a la tienda online

  @Registro
  Scenario: Registrar un Usuario
    When hago clic en el enlace Registrarse
    And completo el formulario de registro con "Comprador1005" y "Prueba2023"
    And hago clic en el boton Registrarse
    Then se muestra un mensaje de confirmacion "Sign up successful."

  @InicioDeSesion
  Scenario Outline:Iniciar Sesion en la Web
    When hago clic en el enlace Iniciar Sesion
    And completo el formulario de inicio de sesion con "<username>" y "<password>"
    And hago clic en el boton Iniciar Sesion
    Then se muestra un mensaje de bienvenida "Welcome <username>"

    Examples:
      | username    | password   |
      | Comprador35 | Prueba2023 |
      | Comprador900| Prueba2023 |

  @CierreDeSesion
  Scenario:Cerrar Sesion en la Web
    When hago clic en el enlace Iniciar Sesion
    And completo el formulario de inicio de sesion con "Comprador35" y "Prueba2023"
    And hago clic en el boton Iniciar Sesion
    And hago clic en el enlace Cerrar Sesion
    Then se muestra la pagina principal

  @AgregarAlCarrito
  Scenario:Agregar laptop al carro de compras
    When hago clic en el enlace Iniciar Sesion
    And completo el formulario de inicio de sesion con "Comprador35" y "Prueba2023"
    And hago clic en el boton Iniciar Sesion
    And selecciono la categoria "Laptops"
    And selecciono el Producto "MacBook air"
    And hago clic en el boton Agregar al carrito
    Then se muestra un mensaje de confirmacion "Product added."