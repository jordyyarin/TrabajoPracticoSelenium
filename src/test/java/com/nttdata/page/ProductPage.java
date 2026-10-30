package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By cantidadInput = By.id("quantity_wanted");
    public static By anadirCarritoBoton = By.cssSelector("button.add-to-cart");
    public static By finalizarCompraBoton = By.xpath("//div[@id='blockcart-modal']//a[contains(@class, 'btn-primary')]");

    // Selectores del modal que aparece al agregar el producto
    public static By modalTitulo = By.cssSelector("#blockcart-modal .modal-header");
    public static By modalTotal = By.cssSelector("#blockcart-modal .product-total .value");
}