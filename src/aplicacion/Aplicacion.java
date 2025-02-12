package aplicacion;

/*
 * Main de la aplicación
 * @author (Tu Nombre)
 */

import interfaz.VentanaPrincipal;

public class Aplicacion {
    public static void main(String[] args) {
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        miVentanaPrincipal.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        miVentanaPrincipal.setVisible(true);
    }
}
