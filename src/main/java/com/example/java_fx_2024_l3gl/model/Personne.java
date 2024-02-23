package com.example.java_fx_2024_l3gl.model;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private int annee;

    private String classe;

    private String specialite;

    //Constrcuteur


    public Personne(String nom, String prenom, int annee, String classe, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
        this.classe = classe;
        this.specialite = specialite;
    }

    public Personne() {
    }

    //Getters / Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", annee=" + annee ;
    }
}
