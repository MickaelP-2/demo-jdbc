package fr.diginamic.jdbc.entite;

public class Fournisseur {
	//
	private int id_fournisseur;
	private String nom;
	//
	public Fournisseur(){
		this.id_fournisseur = 0;
		this.nom = null;
	}
	public Fournisseur(int id, String nom){
		this.id_fournisseur = id;
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Fournisseur [id_fournisseur=" + id_fournisseur + ", nom=" + nom + "]";
	}
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
