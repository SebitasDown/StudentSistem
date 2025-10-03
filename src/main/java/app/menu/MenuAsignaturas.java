package app.menu;

import app.controller.NotasAsignaturaController;

import javax.swing.*;

public class MenuAsignaturas {
    public static void AsMenu(int idPersona){
        String option = "";

        String  menu = """
                    =====================================
                          📖  MENÚ ASIGNATURAS  📖
                    =====================================
                    1. Añadir asignatura
                    2. Ver tus asignaturas
                    3. Agregar notas
                    4. Seguimiento
                    5. Salir
                    =====================================
                    👉 Elige una opción:
                    """;

        do {
            option = JOptionPane.showInputDialog(menu);
            if(option == null) break;


            switch (option){
                case "1":
                    NotasAsignaturaController.InscribirAsignatura(idPersona);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }while (!option.equals("5"));
    }
}
