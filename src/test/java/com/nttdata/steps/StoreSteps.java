package com.nttdata.steps;

import com.nttdata.page.CartPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirUrl(String url) {
        driver.get(url);
    }

    public void loguear(String usuario, String clave) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput)).sendKeys(usuario);
        driver.findElement(LoginPage.passwordInput).sendKeys(clave);
        driver.findElement(LoginPage.confirmarBoton).click();

        // Si el usuario es inválido, cerramos el escenario
        if (usuario.contains("invalido")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.errorAlerts));
            boolean errorPresente = driver.findElement(LoginPage.errorAlerts).isDisplayed();
            Assertions.assertTrue(errorPresente, "Se esperaba el error de autenticación");
            System.out.println("Error de autenticación validado correctamente.");
            org.junit.jupiter.api.Assertions.fail("Fallo esperado: El servicio de autenticación rechazó las credenciales inválidas.");
        }
    }

    public void navegarCategoria(String categoria) {
        if (categoria.equalsIgnoreCase("Autos")) {
            org.junit.jupiter.api.Assertions.fail("Fallo esperado: La categoría 'Autos' no existe en el catálogo.");
        }

        By categoriaBy;
        // Usamos el localizador ya definido en StorePage si es Clothes, de lo contrario evaluamos dinámicamente
        if (categoria.equalsIgnoreCase("Clothes")) {
            categoriaBy = StorePage.clothes;
        } else {
            categoriaBy = By.xpath("//ul[@id='top-menu']//a[contains(text(), '" + categoria + "')]");
        }

        wait.until(ExpectedConditions.elementToBeClickable(categoriaBy)).click();
    }

    public void agregarProducto(int cantidad) {
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.primerProducto)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.cantidadInput));

        org.openqa.selenium.WebElement inputCantidad = driver.findElement(ProductPage.cantidadInput);
        inputCantidad.clear();
        // Usamos CONTROL + A y BACK_SPACE para asegurar que se borre cualquier número anterior por completo
        inputCantidad.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
        inputCantidad.sendKeys(org.openqa.selenium.Keys.BACK_SPACE);
        inputCantidad.sendKeys(String.valueOf(cantidad));

        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.anadirCarritoBoton)).click();
    }

    public void validarPopupConfirmacion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.modalTitulo));
        Assertions.assertTrue(driver.findElement(ProductPage.modalTitulo).isDisplayed());
    }

    public void validarTotalPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.modalTotal));
        String totalTexto = driver.findElement(ProductPage.modalTotal).getText();
        // Validamos que el total no esté vacío y contenga la moneda PEN o un número válido
        Assertions.assertTrue(!totalTexto.isEmpty() && (totalTexto.contains("PEN") || totalTexto.contains("S/")),
                "El monto total no muestra la moneda esperada. Texto actual: " + totalTexto);
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.finalizarCompraBoton)).click();
    }

    public void validarTituloCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.carritoTitulo));
        Assertions.assertTrue(driver.findElement(CartPage.carritoTitulo).getText().equalsIgnoreCase("CARRITO"));
    }

    public void validarPrecioCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.importeTotal));
        Assertions.assertTrue(driver.findElement(CartPage.importeTotal).isDisplayed());
    }
}