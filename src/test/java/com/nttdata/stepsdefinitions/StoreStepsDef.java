package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class StoreStepsDef {

    private WebDriver driver;
    private StoreSteps storeSteps;

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_página_de_la_tienda() {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.abrirUrl("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        storeSteps.loguear(usuario, clave);
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        storeSteps.navegarCategoria(categoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int cantidad) {
        storeSteps.agregarProducto(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmación_del_producto_agregado() {
        storeSteps.validarPopupConfirmacion();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        storeSteps.validarTotalPopup();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizo_la_compra() {
        storeSteps.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        storeSteps.validarTituloCarrito();
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        storeSteps.validarPrecioCarrito();
        esperaImplicita();
        screenShot();
    }
}