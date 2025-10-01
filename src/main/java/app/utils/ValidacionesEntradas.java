package app.utils;

import javax.swing.*;

public class ValidacionesEntradas {


    public static String LeerString (String mensaje){
        while(true){
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if(entrada == null){
                JOptionPane.showMessageDialog(null,"Se cancelo");
                return null;
            }
            entrada = entrada.trim();
            if (entrada.isEmpty()){
                JOptionPane.showMessageDialog(null, "No puede estar vacio");
                continue;
            }
            try{
                Double.parseDouble(entrada);
                JOptionPane.showMessageDialog(null, "No peudes poner un numero");
                continue;
            }catch (NumberFormatException error){
                return entrada;
            }
        }
    }
    public static String LeerCorreo(String mensaje) {
        while(true){
            String correo = JOptionPane.showInputDialog(null, "Correo: ");
            if (correo == null){
                JOptionPane.showMessageDialog(null, "Se cancelo");
                return null;
            }
            correo = correo.trim();
            if(!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|io|net|org)$")){
                JOptionPane.showMessageDialog(null, "Correo invalido");
                continue;
            }
            return correo;
        }
    }

    public static String LeerStringconNumero(String mensaje){
        while (true){
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null){
                return null;
            }
            entrada = entrada.trim();
            if (entrada.isEmpty()){
                JOptionPane.showMessageDialog(null, "No puede estar vacio");
                continue;
            }
            return entrada;
        }
    }
}
