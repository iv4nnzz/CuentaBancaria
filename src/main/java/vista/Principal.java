/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author 9spot
 */

import javax.swing.JOptionPane;
import modelo.CuentaAhorros;

public class Principal {
    
    private CuentaAhorros cuenta;
    
    public Principal() {
        this.cuenta = null;
    }
    
    public CuentaAhorros crearCuenta() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del titular:");
        
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido");
            return null;
        }
        
        String numero = JOptionPane.showInputDialog(null, "Ingrese el número de cuenta:");
        
        if (numero == null || numero.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número de cuenta válido");
            return null;
        }
        
        String saldoStr = JOptionPane.showInputDialog(null, "Ingrese el saldo inicial:");
        
        try {
            double saldoInicial = Double.parseDouble(saldoStr);
            if (saldoInicial < 0) {
                JOptionPane.showMessageDialog(null, "El saldo inicial no puede ser negativo");
                return null;
            }
            
            cuenta = new CuentaAhorros(nombre, numero, saldoInicial);
            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente!\n\n" + cuenta.mostrarDatos());
            return cuenta;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saldo inválido");
            return null;
        }
    }
    
    public int mostrarMenu() {
        String[] opciones = {
            "1. Crear Nueva Cuenta",
            "2. Mostrar Datos de la Cuenta",
            "3. Realizar Reembolso",
            "4. Realizar Consignación",
            "5. Realizar Retiro",
            "6. Salir"
        };
        
        String menu = " SISTEMA BANCARIO \n\n";
        for (String opcion : opciones) {
            menu += opcion + "\n";
        }
        menu += "\nSeleccione una opción:";
        
        String seleccion = JOptionPane.showInputDialog(null, menu);
        
        try {
            return Integer.parseInt(seleccion);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void mostrarDatosCuenta() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta creada. Por favor cree una cuenta primero.");
        } else {
            JOptionPane.showMessageDialog(null, cuenta.mostrarDatos());
        }
    }
    
    public void realizarReembolso() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta creada. Por favor cree una cuenta primero.");
            return;
        }
        
        String montoStr = JOptionPane.showInputDialog(null, "Ingrese el monto del reembolso:");
        
        try {
            double monto = Double.parseDouble(montoStr);
            
            if (cuenta.realizarReembolso(monto)) {
                JOptionPane.showMessageDialog(null, 
                    "Reembolso exitoso!\n" +
                    "Monto reembolsado: $" + monto + "\n" +
                    "Nuevo saldo: $" + cuenta.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "Error: El monto debe ser mayor a 0");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Monto inválido");
        }
    }
    
    public void realizarConsignacion() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta creada. Por favor cree una cuenta primero.");
            return;
        }
        
        String montoStr = JOptionPane.showInputDialog(null, "Ingrese el monto a consignar:");
        
        try {
            double monto = Double.parseDouble(montoStr);
            
            String descripcion = JOptionPane.showInputDialog(null, "Ingrese una descripción (opcional):");
            
            boolean exitoso;
            if (descripcion != null && !descripcion.trim().isEmpty()) {
                exitoso = cuenta.consignar(monto, descripcion);
            } else {
                exitoso = cuenta.consignar(monto);
            }
            
            if (exitoso) {
                JOptionPane.showMessageDialog(null, 
                    "Consignación exitosa!\n" +
                    "Monto consignado: $" + monto + "\n" +
                    "Nuevo saldo: $" + cuenta.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "Consignación fallida. El monto debe ser mayor a 0");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Monto inválido");
        }
    }
    
    public void realizarRetiro() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, 
                "No hay ninguna cuenta creada. Por favor cree una cuenta primero.");
            return;
        }
        
        String montoStr = JOptionPane.showInputDialog(null, 
            "Saldo actual: $" + cuenta.getSaldo() + "\n" +
            "Ingrese el monto a retirar:");
        
        try {
            double monto = Double.parseDouble(montoStr);
            
            if (cuenta.retirar(monto)) {
                JOptionPane.showMessageDialog(null, 
                    "Retiro exitoso!\n" +
                    "Monto retirado: $" + monto + "\n" +
                    "Nuevo saldo: $" + cuenta.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Retiro fallido.\n" +
                    "Verifique que tenga saldo suficiente y que el monto sea válido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Monto inválido");
        }
    }
    
    public CuentaAhorros getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(CuentaAhorros cuenta) {
        this.cuenta = cuenta;
    }
}