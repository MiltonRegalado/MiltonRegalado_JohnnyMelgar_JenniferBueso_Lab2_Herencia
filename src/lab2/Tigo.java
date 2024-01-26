/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class Tigo {
    ArrayList<Plan> planesTipo;
    
    public Tigo() {
        this.planesTipo = new ArrayList<>();
    }
    
    public Tigo(ArrayList<Plan> planesTipo) {
        if (planesTipo != null) {
            this.planesTipo = planesTipo;
        } else {
            this.planesTipo = new ArrayList<>();
        }
    }
    
    public void agregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        agregarPlan(numeroTel, nombre, extra, tipo, 0);
    }
    
    private void agregarPlan(int numeroTel, String nombre, String extra, String tipo, int index) {
        if (index < planesTipo.size()) {
            Plan plan = planesTipo.get(index);
            if (plan.getNumeroTelefono() == numeroTel) {
                JOptionPane.showMessageDialog(null, "El número de teléfono proporcionado ya está en uso. Por favor, proporcione un número de teléfono diferente.", "Número de teléfono existente", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (plan instanceof PlanIPhone && ((PlanIPhone) plan).getEmail().equals(extra)) {
                JOptionPane.showMessageDialog(null, "El correo electrónico proporcionado ya está en uso. Por favor, proporcione un correo electrónico diferente.", "Correo electrónico existente", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (plan instanceof PlanSamsung && ((PlanSamsung) plan).getPin().equals(extra)) {
                JOptionPane.showMessageDialog(null, "El PIN proporcionado ya está en uso. Por favor, proporcione un PIN diferente.", "PIN existente", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                agregarPlan(numeroTel, nombre, extra, tipo, index + 1);
            }
        } else {
            switch (tipo.toUpperCase()) {
                case "IPHONE":
                    planesTipo.add(new PlanIPhone(numeroTel, nombre, extra));
                    JOptionPane.showMessageDialog(null, "El plan agregado con éxito.", "Plan Agregado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "SAMSUNG":
                    planesTipo.add(new PlanSamsung(numeroTel, nombre, extra));
                    JOptionPane.showMessageDialog(null, "El plan agregado con éxito.", "Plan Agregado", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "El plan que intenta agregar no está disponible. Los planes disponibles son: IPhone y Samsung.", "Plan no disponible", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean busqueda(int numeroTel, String datoExtra, String tipo) {
        return búsqueda(numeroTel, datoExtra, tipo, 0);
    }
    
    private boolean búsqueda(int numeroTel, String datoExtra, String tipo, int index) {
        if (index < planesTipo.size()) {
            Plan plan = planesTipo.get(index);
            if (plan.getNumeroTelefono() == numeroTel || 
               (tipo.equalsIgnoreCase("IPHONE") && plan instanceof PlanIPhone && ((PlanIPhone) plan).getEmail().equals(datoExtra)) || 
               (tipo.equalsIgnoreCase("SAMSUNG") && plan instanceof PlanSamsung && ((PlanSamsung) plan).getPin().equals(datoExtra))) {
                return true;
            }
            return búsqueda(numeroTel, datoExtra, tipo, index + 1);
        }
        return false;
    }
    
    public double pagoPlan(int numeroTel, int mins, int msgs) {
        return pagoPlan(numeroTel, mins, msgs, 0);
    }
    
    private double pagoPlan(int numeroTel, int mins, int msgs, int index) {
        if (index < planesTipo.size()) {
            Plan plan = planesTipo.get(index);
            if (plan.getNumeroTelefono() == numeroTel) {
                return plan.pagoMensual(mins, msgs);
            }
            return pagoPlan(numeroTel, mins, msgs, index + 1);
        }
        return 0.0;
    }

    public void agregarAmigo(int numeroTel, String pin) {
        if (busqueda(numeroTel, pin, "SAMSUNG")) {
            agregarAmigo(numeroTel, pin, 0);
            JOptionPane.showMessageDialog(null, "Tu amigo ha sido agregado con éxito.", "Amigo Agregado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un PlanSamsung con el número de teléfono proporcionado.", "Plan no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarAmigo(int numeroTel, String pin, int index) {
        if (index < planesTipo.size()) {
            Plan plan = planesTipo.get(index);
            if (plan.getNumeroTelefono() == numeroTel && plan instanceof PlanSamsung) {
                ((PlanSamsung) plan).agregarPinAmigo(pin);
            } else {
                agregarAmigo(numeroTel, pin, index + 1);
            }
        }
    }
    
    public String lista() {
        StringBuilder planesInfo = new StringBuilder();
        lista(planesInfo, 0, 0, 0);
        return planesInfo.toString();
    }

    
    private void lista(StringBuilder planesInfo, int contadorIPhone, int contadorSamsung, int index) {
        if (index < planesTipo.size()) {
            Plan plan = planesTipo.get(index);
            planesInfo.append(plan.imprimir()).append("\n\n");

            if (plan instanceof PlanIPhone) {
                contadorIPhone++;
            } else if (plan instanceof PlanSamsung) {
                contadorSamsung++;
            }
            lista(planesInfo, contadorIPhone, contadorSamsung, index + 1);
        } else {
            planesInfo.append("\n").append("Total de planes IPhone: ").append(contadorIPhone).append("\nTotal de planes Samsung: ").append(contadorSamsung);
        }
    }

    
}
