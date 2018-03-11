package com.safyd.controlador;

import com.safyd.utils.principalEstructura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public final class FXMLCompraControl extends AnchorPane implements principalEstructura {

    @Override
    public void abrir(){

    }

    @Override
    public void cerrar() {

    }

    @Override
    public void accion() {

    }

    @Override
    public void mensaje() {

    }

    @Override
    public String init() {
        return "/com/safyd/vista/FXMLCompra.fxml";
    }

    public FXMLCompraControl() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(init()));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(FXMLCompraControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
