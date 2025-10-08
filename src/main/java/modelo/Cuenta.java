/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 9spot
 */
public class Cuenta {
    protected String nombreTitular;
    protected String numeroCuenta;
    protected double saldo;
    
    public Cuenta() {
        this.saldo = 0;
    }
    
    public Cuenta(String nombreTitular, String numeroCuenta, double saldoInicial) {
        this.nombreTitular = nombreTitular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    public String mostrarDatos() {
        return "Cuenta General\n" +
               "Titular: " + nombreTitular + "\n" +
               "Número: " + numeroCuenta + "\n" +
               "Saldo: $" + saldo;
    }
    
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}