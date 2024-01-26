/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author jenniferbueso
 */
public class PlanIPhone extends Plan{
    private String email;
    
    public PlanIPhone(int numeroTelefono, String nombreCliente, String email) {
        super(numeroTelefono, nombreCliente);
        this.email = email;
    }

    @Override
    public double pagoMensual(int mins, int msgs) {
      double planInternet = 22, minutoConsumido = 0.4, mensajito = 0.1;
      return planInternet + (minutoConsumido * mins) + (mensajito * msgs);
    }
    
    @Override
    public String imprimir() {
        return super.imprimir() + "\nEmail: " + email;
    }

    public String getEmail() {
        return email;
    }
}
