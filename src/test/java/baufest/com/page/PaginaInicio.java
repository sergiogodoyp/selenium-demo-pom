package baufest.com.page;

import bausfest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicio extends BasePage {
    public PaginaInicio(WebDriver driver) {
        super(driver);
    }

    private By botonRegistrarse = By.id("signin2");

    private By botonIniciarSesion = By.id("login2");

    private By mensajeBienvenida = By.id("nameofuser");

    private By botonCerrarSesion = By.id("logout2");


    public void seleccionarCategoria(String opcion) {
        seleccionarOpcion(opcion);
    }

    public PaginaProducto seleccionarProducto(String opcion)  {
        seleccionarOpcion(opcion);
        return new PaginaProducto(driver);
    }

    public PaginaRegistro hacerClicEnRegistrarse(){
         hacerClic(botonRegistrarse);
         return new PaginaRegistro(driver);
    }

    public PaginaLogin hacerClicEnIniciarSesion(){
        hacerClic(botonIniciarSesion);
        return new PaginaLogin(driver);
    }

    public boolean esVisibleBotonIniciarSesion(){
        esperarElementoClickeable(botonIniciarSesion);
        return estaVisible(botonIniciarSesion);
    }

    public String obtenerMensajeBienvenida() {
        esperarElementoClickeable(mensajeBienvenida);
        return obtenerTexto(mensajeBienvenida);
    }

    public void hacerClicEnCerrarSesion()  {
        esperarElementoClickeable(botonCerrarSesion);
        hacerClic(botonCerrarSesion);
    }
}
