package baufest.com.page;

import bausfest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends BasePage {

    public PaginaLogin(WebDriver driver) {
        super(driver);
    }

    private By campoNombreUsuario = By.id("loginusername");
    private By campoContrasena = By.id("loginpassword");
    private By botonIniciarSesion = By.cssSelector("button[onclick=\"logIn()\"]");;

    public void ingresarNombreUsuario(String nombreUsuario){
        esperarElementoVisible(campoNombreUsuario);
        escribirTexto(nombreUsuario,campoNombreUsuario);
    }

    public void ingresarContrasena(String password){
        escribirTexto(password,campoContrasena);
    }

    public void hacerClicEnIniciarSesion(){
        hacerClic(botonIniciarSesion);
    }

}