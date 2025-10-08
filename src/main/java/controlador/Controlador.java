/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author 9spot
 */
import vista.Principal;
import javax.swing.JOptionPane;

class Controlador {
    
    private Principal vista;
    
    public Controlador() {
        this.vista = new Principal();
    }
    
    public void ejecutar() {
        boolean continuar = true;
        
        JOptionPane.showMessageDialog(null, "¡Bienvenido al Sistema Bancario!\n");
        
        while (continuar) {
            int opcion = vista.mostrarMenu();
            
            switch (opcion) {
                case 1:
                    vista.crearCuenta();
                    break;
                    
                case 2:
                    vista.mostrarDatosCuenta();
                    break;
                    
                case 3:
                    vista.realizarReembolso();
                    break;
                    
                case 4:
                    vista.realizarConsignacion();
                    break;
                    
                case 5:
                    vista.realizarRetiro();
                    break;
                    
                case 6:
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION);
                    
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "¡Gracias por usar nuestro sistema!");
                        continuar = false;
                    }
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor intente de nuevo.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.ejecutar();
    }
}