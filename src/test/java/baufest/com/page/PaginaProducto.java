package baufest.com.page;

import bausfest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaProducto extends BasePage {

    public PaginaProducto(WebDriver driver) {
        super(driver);
    }

    private By botonAgregarAlCarrito = By.linkText("Add to cart");

    public void hacerClicEnAgregarAlCarrito() {
        esperarElementoClickeable(botonAgregarAlCarrito );
        hacerClic(botonAgregarAlCarrito);
    }
}
