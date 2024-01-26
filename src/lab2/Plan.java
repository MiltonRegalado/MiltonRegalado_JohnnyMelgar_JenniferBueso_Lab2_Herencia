/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author jenniferbueso
 */
public abstract class Plan {
    private int numeroTelefono;
    private String nombreCliente;
    
    public Plan(int numeroTelefono, String nombreCliente) {
        this.numeroTelefono = numeroTelefono;
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public abstract double pagoMensual(int mins, int msgs);
    
    public String imprimir() {
        return "Número teléfono: " + numeroTelefono + "\nNombre de Cliente: " + nombreCliente;
    }
    
}
