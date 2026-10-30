package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    // Categoria 'clothes' usando el ID exacto del DOM de la tienda
    public static By clothes = By.xpath("//li[@id='category-3']/a");

    // Categoria 'accessorios'
    public static By accesorios = By.xpath("//ul[@id='top-menu']//a[contains(text(), 'ACCESORIOS')]");

    // Primer producto del catálogo
    public static By primerProducto = By.xpath("(//article[contains(@class, 'product-miniature')]//a)[1]");
}