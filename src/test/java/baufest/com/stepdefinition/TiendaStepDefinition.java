package baufest.com.stepdefinition;

import baufest.com.page.PaginaInicio;
import baufest.com.page.PaginaLogin;
import baufest.com.page.PaginaProducto;
import baufest.com.page.PaginaRegistro;
import bausfest.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;


import org.openqa.selenium.WebDriver;

public class TiendaStepDefinition {
    WebDriver driver;
    PaginaRegistro paginaRegistro;
    PaginaLogin paginaLogin;
    PaginaInicio paginaInicio;
    PaginaProducto paginaProducto;

    @Before
    public void configuracionInicial() {
        driver = DriverManager.getDriver();
        paginaRegistro = new PaginaRegistro(driver);
        paginaLogin = new PaginaLogin(driver);
        paginaInicio = new PaginaInicio(driver);
        paginaProducto = new PaginaProducto(driver);
    }

    @After
    public void liberarRecursos(){
        DriverManager.quitDriver();
    }

    @Given("Ingreso a la Wed de la Tienda")
    public void ingresoALaWedDeLaTienda() {
        paginaRegistro.cargarPaginaInicio();
    }

    @When("presiono el boton SignUp")
    public void presionoElBotonSignUp() {
        paginaInicio.hacerClicEnRegistrarse();
    }

    @And("ingreso el username {string}")
    public void ingresoElUsername(String username) {
        paginaRegistro.ingresarNombreUsuario(username);
    }

    @And("ingreso el password {string}")
    public void ingresoElPassword(String password) {
        paginaRegistro.ingresarContrasena(password);
    }

    @And("presiono el boton Registrar")
    public void presionoElBotonRegistrar() {
        paginaRegistro.hacerClicEnRegistrar();
    }

    @Then("Se muestra un mensaje de confirmacion {string}")
    public void seMuestraUnMensajeDeConfirmacion(String mensaje)  {
        Assert.assertEquals(paginaRegistro.obtenerMensajeDeAlerta(),mensaje);
    }

    @When("presiono el boton Login")
    public void presionoElBotonLogin() {
        paginaInicio.hacerClicEnIniciarSesion();
    }

    @And("escribo el username {string}")
    public void escriboElUsername(String username)  {
        paginaLogin.ingresarNombreUsuario(username);
    }

    @And("escribo el password {string}")
    public void escriboElPassword(String password) {
        paginaLogin.ingresarContrasena(password);
    }

    @Then("se muestra un mensaje de bienvenida {string}")
    public void seMuestraUnMensajeDeBienvenida(String message)  {
        Assert.assertEquals(paginaInicio.obtenerMensajeBienvenida(),message);
    }

    @And("presiono el boton Iniciar Sesion")
    public void presionoElBotonloginPage() {
        paginaLogin.hacerClicEnIniciarSesion();
    }

    @And("presiono el boton Logout")
    public void presionoElBotonLogout() {
        paginaInicio.hacerClicEnCerrarSesion();
    }

    @Then("se muestra la pagina principal")
    public void seMuestraLaPaginaPrincipal()  {
        Assert.assertTrue(paginaInicio.esVisibleBotonIniciarSesion());
    }

    @And("selecciono la categoria {string}")
    public void seleccionoLaCategoria(String opcion) {
        paginaInicio.seleccionarCategoria(opcion);
    }

    @And("selecciono el Producto {string}")
    public void seleccionoElProducto(String opcion) {
        paginaInicio.seleccionarProducto(opcion);
    }

    @And("presiono el boton Add to cart")
    public void presionoElBotonAddToCart() {
        paginaProducto.hacerClicEnAgregarAlCarrito();
    }

}
