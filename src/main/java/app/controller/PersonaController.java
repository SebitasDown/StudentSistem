package app.controller;

import app.entity.Persona;
import app.model.PersonaModel;
import app.utils.ValidacionesEntradas;

import javax.swing.JOptionPane;

public class PersonaController {
        public static void crear() {
            PersonaModel personaModel = new PersonaModel();

            String nombre = ValidacionesEntradas.LeerString("Nombre: ");
            String correo = ValidacionesEntradas.LeerCorreo("Correo: ");
            String pass =   ValidacionesEntradas.LeerStringconNumero("Contraseña: ");
            int edad =  Integer.parseInt(JOptionPane.showInputDialog("Edad: "));


            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setCorreo(correo);
            persona.setPass(pass);
            persona.setEdad(edad);

            persona = (Persona) personaModel.crear(persona);
            JOptionPane.showMessageDialog(null, persona.toString());

        }
}
