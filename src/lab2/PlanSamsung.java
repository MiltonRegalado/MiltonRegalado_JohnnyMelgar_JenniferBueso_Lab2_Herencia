package lab2;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jenniferbueso
 */
public class PlanSamsung extends Plan{
    private String pin;
    ArrayList<String> bbm;

    public PlanSamsung(int numeroTelefono, String nombreCliente, String pin) {
        super(numeroTelefono, nombreCliente);
        this.pin = pin;
        this.bbm = new ArrayList<>();
    }
    
    @Override
    public double pagoMensual(int mins, int msgs) {
        double planCosto = 40, minutosAdicionales = 0.8, mensajitoAdicional = 0.2;
        int minutosGratis = 200, mensajesGratis = 300;
        
        if (mins > minutosGratis) {
            mins -= minutosGratis;
        } else {
            mins = 0;
        }
        
        if (msgs > mensajesGratis) {
            msgs -= mensajesGratis;
        } else {
            msgs = 0;
        }
        
        return planCosto + (mins * minutosGratis) + (msgs * mensajesGratis);
    }
    
    @Override
    public String imprimir() {
        return super.imprimir() + "\nPin: " + pin;
    }
    
    public void agregarPinAmigo(String pin) {
        if (!bbm.contains(pin)) {
            bbm.add(pin);
        }
    }

    public String getPin() {
        return pin;
    }
}
