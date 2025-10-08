/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author 9spot
 */
public class CuentaAhorros extends Cuenta {
    
    public CuentaAhorros(String nombreTitular, String numeroCuenta, double saldoInicial) {
        super(nombreTitular, numeroCuenta, saldoInicial);
    }
    
    @Override
    public String mostrarDatos() {
        return "CUENTA DE AHORROS" + "\n" +
               "Titular: " + nombreTitular + "\n" +
               "Número de Cuenta: " + numeroCuenta + "\n" +
               "Saldo Actual: $" + String.format("%.2f", saldo);
    }
    
    public boolean realizarReembolso(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }
    
    public boolean consignar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }
    
    public boolean consignar(double monto, String descripcion) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }
    
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }
    
    public boolean retirar(double monto, double saldoMinimo) {
        if (monto > 0 && (this.saldo - monto) >= saldoMinimo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }
}
