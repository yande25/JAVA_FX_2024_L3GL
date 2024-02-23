package com.example.java_fx_2024_l3gl.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonneRepository {
    private Connection connection;

    public  PersonneRepository(){
        this.connection = new Bd().getConnection();
    }

    public void add(Personne personne) {
        try {
            String sql = "INSERT personne  (nom,prenom,anne,classe,specialite) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personne.getNom());
            statement.setString(2, personne.getPrenom());
            statement.setInt(3, personne.getAnnee());
            statement.setString(4,personne.getClasse() );
            statement.setString(5,personne.getSpecialite());
            statement.executeUpdate();
            System.out.println("Personne enregistrer");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(Personne personne) {
        try {
            String sql = "UPDATE personne SET nom= ?, prenom =?, anne = ?, classe = ?, specialite= ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personne.getNom());
            statement.setString(2, personne.getPrenom());
            statement.setInt(3, personne.getAnnee());
            statement.setString(4,personne.getClasse() );
            statement.setString(5,personne.getSpecialite());
            statement.setInt(6, personne.getId());
            statement.executeUpdate();
            System.out.println("Personne modifiée");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete(int id) {
        try {
            String sql = "DELETE FROM personne where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Delete Personne");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ObservableList<Personne> getAll() {
        ObservableList<Personne> list = FXCollections.observableArrayList();
        try {

            String sql =  "SELECT * from personne ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                Personne p =  new Personne();
                p.setId(result.getInt("id"));
                p.setNom(result.getString("nom"));
                p.setPrenom(result.getString("prenom"));
                p.setAnnee(result.getInt("anne"));
                p.setClasse(result.getString("classe"));
                p.setSpecialite(result.getString("specialite"));

                list.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
