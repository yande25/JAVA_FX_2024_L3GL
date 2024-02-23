package com.example.java_fx_2024_l3gl;

import com.example.java_fx_2024_l3gl.model.Personne;
import com.example.java_fx_2024_l3gl.model.PersonneRepository;
import com.mysql.jdbc.ConnectionImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private  PersonneRepository personneRepository;
    @FXML
    private TextField cAnnee;

    @FXML
    private ComboBox cClasse;

    @FXML
    private TextField cNom;

    @FXML
    private TextField cPrenom;

    @FXML
    private TextField cSpecialite;

    @FXML
    private TextField cid;

    @FXML
    private TableColumn<Personne, String> classe;

    @FXML
    private TableColumn<Personne, Integer> id;

    @FXML
    private TableColumn<Personne, String> nom;

    @FXML
    private TableColumn<Personne, String> prenom;

    @FXML
    private TableColumn<Personne, String> specialite;

    @FXML
    private TableColumn<Personne, Integer> annee;
    @FXML
    private TableView<Personne> tablefx;

    @FXML
    void UpdatePersonne(ActionEvent event) {
        Personne personne = new Personne(cNom.getText(),cPrenom.getText(),
                Integer.parseInt(cAnnee.getText()) ,
                cClasse.getAccessibleText(),cSpecialite.getText());
        personne.setId(Integer.parseInt(cid.getText()));

        personneRepository.update(personne);
        affiche();
        clearChamps(event);
    }

    @FXML
    void charge(MouseEvent event) {
        Personne personne= this.tablefx.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2){
            cNom.setText(personne.getNom());
            cPrenom.setText(personne.getPrenom());
            cAnnee.setText(personne.getAnnee()+"");
            cClasse.setValue(personne.getClasse());
            cSpecialite.setText(personne.getSpecialite());
            cid.setText(personne.getId()+"");
        }
    }

    @FXML
    void add(ActionEvent event) {

        Personne personne = new Personne(cNom.getText(),cPrenom.getText(),
                Integer.parseInt(cAnnee.getText()),
               cClasse.getValue(),cSpecialite.getText());

        personneRepository.add(personne);
        this.clearChamps(event);
        this.affiche();
    }



    @FXML
    void deletePersonne(ActionEvent event) {
        int id = this.tablefx.getSelectionModel().getSelectedItem().getId();
        personneRepository.delete(id);
        this.affiche();
    }

    @FXML
    void clearChamps(ActionEvent event) {
        cNom.setText("");
        cPrenom.setText("");
        cAnnee.setText("");
        cClasse.setValue("");
        cSpecialite.setText("");
    }

    void affiche(){
        ObservableList<Personne> list = personneRepository.getAll();
        id.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
        annee.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("annee"));
        classe.setCellValueFactory(new PropertyValueFactory<Personne, String>("classe"));
        specialite.setCellValueFactory(new PropertyValueFactory<Personne, String>("specialite"));
        tablefx.setItems(list);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.personneRepository = new PersonneRepository();
        this.affiche();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("gl");
        list.add("iage");
        cClasse.setItems(list);
    }
}