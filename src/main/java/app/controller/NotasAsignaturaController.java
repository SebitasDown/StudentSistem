package app.controller;

import app.database.ConfigDB;
import app.model.NotasAsignaturaModulo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotasAsignaturaController {

    public static void InscribirAsignatura(int idPersona){

        List<String> asignaturas = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        try(Connection conexion = ConfigDB.openConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_asignatura, nombreAsignatura FROM Asignatura")){
            while(resultSet.next()){
                ids.add(resultSet.getInt("id_asignatura"));
                asignaturas.add(resultSet.getString("nombreAsignatura"));
            }

        }catch (SQLException error){
            error.printStackTrace();
            return;
        }


        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la Asignatura: ",
                "Inscribir Asignatura",
                JOptionPane.QUESTION_MESSAGE,
                null,
                asignaturas.toArray(),
                asignaturas.get(0)
        );

        if(seleccion == null) return;


        int index = asignaturas.indexOf(seleccion);
        int idAsignatura =ids.get(index);

        String inputNota = JOptionPane.showInputDialog("Nota inicial (dejar vacio si no hay):");
        Double nota = null;
        if(inputNota != null && !inputNota.trim().isEmpty()){
            nota = Double.parseDouble(inputNota);
        }

        NotasAsignaturaModulo model = new NotasAsignaturaModulo();
        model.InscribirAsignatura(idPersona, idAsignatura, nota);
    }
}
