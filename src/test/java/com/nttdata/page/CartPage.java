package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {

    public static By carritoTitulo = By.cssSelector("div.cart-grid-body h1");

    // Valor total en el resumen del carrito
    public static By importeTotal = By.cssSelector("div.cart-summary-totals div.cart-summary-line.cart-total span.value");
}