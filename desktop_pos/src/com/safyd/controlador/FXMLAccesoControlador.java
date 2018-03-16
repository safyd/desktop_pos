package com.safyd.controlador;

import com.jfoenix.controls.JFXButton;
import com.safyd.utils.Estilo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public final class FXMLAccesoControlador implements Initializable {

    @FXML
    private AnchorPane panelPrincipal;
    @FXML
    private Button btnSoporte, btnConfiguracion, btnTema, btnEntrar;
    @FXML
    private TextField txtUsuario, txtContrasena;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.panelPrincipal.setStyle(Estilo.Fondo.Fondo01);
    }

}
