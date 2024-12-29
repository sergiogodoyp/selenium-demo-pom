package baufest.com.page;

import bausfest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaRegistro extends BasePage {

    public PaginaRegistro(WebDriver driver) {
        super(driver);
    }

    private By campoNombreUsuario  = By.id("sign-username");
    private By campoContrasena = By.id("sign-password");
    private By botonRegistrar = By.cssSelector("button[onclick=\"register()\"]");

    public void cargarPaginaInicio(){
        navegarA("https://www.demoblaze.com/index.html");
    }

    public void ingresarNombreUsuario(String username) {
        esperarElementoVisible(campoNombreUsuario);
        escribirTexto(username,campoNombreUsuario);
    }

    public void ingresarContrasena(String password){
        escribirTexto(password,campoContrasena);
    }

    public void hacerClicEnRegistrar(){
        hacerClic(botonRegistrar);
    }

    public String obtenerMensajeDeAlerta() {
        esperarAlertaPresente();
        return driver.switchTo().alert().getText();
    }

}