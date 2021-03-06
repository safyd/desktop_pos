
package com.safyd.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FXMLMenuControlador extends AnchorPane {

    @FXML
    private JFXButton btnReporte;

    @FXML
    private AnchorPane panelPrincipal;

    @FXML
    private JFXDrawer drawerMenu;

    @FXML
    private JFXButton btnVenta;

    @FXML
    private JFXButton btnCompra;

    @FXML
    private JFXButton btnInventario;

    @FXML
    private JFXButton btnFactura;

    @FXML
    private ImageView btn;

   
    public String init() {
        return "/com/safyd/vista/FXMLMenu.fxml";
    }

    public FXMLMenuControlador() {
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
