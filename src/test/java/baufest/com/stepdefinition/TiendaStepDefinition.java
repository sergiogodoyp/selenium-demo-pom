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

    @Given("Ingreso a la tienda online")
    public void ingresoALaTiendaOnline() {
        paginaRegistro.cargarPaginaInicio();
    }

    @When("hago clic en el enlace Registrarse")
    public void hagoClicEnElEnlaceRegistrarse() {
        paginaInicio.hacerClicEnRegistrarse();
    }

    @And("completo el formulario de registro con {string} y {string}")
    public void completoElFormularioDeRegistroConY(String username, String password) {
        paginaRegistro.ingresarNombreUsuario(username);
        paginaRegistro.ingresarContrasena(password);
    }

    @And("hago clic en el boton Registrarse")
    public void presionoElBotonRegistrar() {
        paginaRegistro.hacerClicEnRegistrar();
    }

    @Then("se muestra un mensaje de confirmacion {string}")
    public void seMuestraUnMensajeDeConfirmacion(String mensaje)  {
        Assert.assertEquals(paginaRegistro.obtenerMensajeDeAlerta(),mensaje);
    }

    @When("hago clic en el enlace Iniciar Sesion")
    public void hagoClicEnElEnlaceIniciar() {
        paginaInicio.hacerClicEnIniciarSesion();
    }

    @And("completo el formulario de inicio de sesion con {string} y {string}")
    public void completoElFormularioDeInicioDeSesionConY(String username, String password) {
        paginaLogin.ingresarNombreUsuario(username);
        paginaLogin.ingresarContrasena(password);
    }

    @Then("se muestra un mensaje de bienvenida {string}")
    public void seMuestraUnMensajeDeBienvenida(String mensaje)  {
        Assert.assertEquals(paginaInicio.obtenerMensajeBienvenida(),mensaje);
    }

    @And("hago clic en el boton Iniciar Sesion")
    public void hagoClicEnELBotonInciarSesion() {
        paginaLogin.hacerClicEnIniciarSesion();
    }

    @And("hago clic en el enlace Cerrar Sesion")
    public void hagoClicEnELEnlaceCerrarSession() {
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

    @And("hago clic en el boton Agregar al carrito")
    public void hagoClicEnElBotonAgregarAlCarrito() {
        paginaProducto.hacerClicEnAgregarAlCarrito();
    }
}