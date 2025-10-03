package app.model;

import app.database.ConfigDB;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class NotasAsignaturaModulo {

    public void InscribirAsignatura(int id_persona, int id_asignatura, Double nota){
        String sql = "INSERT INTO NotasAsignatura(id_persona, id_asignatura, notas) VALUES (?, ?, ?)";
         try (Connection connexion = ConfigDB.openConnection();
              PreparedStatement prepare = connexion.prepareStatement(sql) ){
             prepare.setInt(1, id_persona);
             prepare.setInt(2, id_asignatura);

             if(nota == null){
                 prepare.setNull(3, Types.DECIMAL); // aqui se admite que las notas sean null p
             }else{
                prepare.setBigDecimal(3, BigDecimal.valueOf(nota));
             }
             prepare.executeUpdate();

             JOptionPane.showMessageDialog(null, "Incripcion realizada correctamente");

         }catch (Exception e){
             System.out.println("Error" + e.getMessage());
         }
    }
}
