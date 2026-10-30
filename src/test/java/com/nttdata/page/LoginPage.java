package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    // Localizador del enlace "Iniciar sesión" en el menú superior
    public static By loginLink = By.cssSelector("div.user-info a");

    // Campo de texto para el correo
    public static By emailInput = By.id("field-email");

    // Campo de texto para la contraseña
    public static By passwordInput = By.id("field-password");

    // Botón para enviar el formulario de login
    public static By confirmarBoton = By.id("submit-login");

    // Alerta de error en caso de credenciales incorrectas
    public static By errorAlerts = By.cssSelector("li.alert-danger");
}