package models;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String pin;
    private int intentosFallidos;


    public Cuenta(String numeroCuenta, double saldo, String pin, int intentosFallidos) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
        this.intentosFallidos = intentosFallidos;
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


    public String getPin() {
        return pin;
    }


    public void setPin(String pin) {
        this.pin = pin;
    }


    public int getIntentosFallidos() {
        return intentosFallidos;
    }


    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    

    

}
