package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import fr.diginamic.jdbc.entite.Fournisseur;

public class TestDaoJdbc {
//public class TestDaoJdbc implements FournisseurDao{
	static String url,user,pwd;
	static Connection myConnexion;
	static Statement stat;
	static ResultSet resultat;
	//
	/**
	 * Classe executable pour utiliser les 2 versions de la DAO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Lignes en commentaires pour utiliser la premiere version du tp04 de DAO
		 */
		/*
		FournisseurDaoJdbc FDAOJDBC = new FournisseurDaoJdbc();
		//Fournisseur nouvoFour = new Fournisseur(6,"France de materiaux");
		FDAOJDBC.insert(new Fournisseur(6,"France de materiaux"));
		FDAOJDBC.extraire();
		FDAOJDBC.update("France de materiaux", "France de matériaux");//France de matériaux
		FDAOJDBC.extraire();
		FDAOJDBC.delete(new Fournisseur(6,"France de matériaux"));
		FDAOJDBC.extraire();
		*/
		/**
		 * Lignes du dessous pour utiliser les preparedStatement du tp05 de DAO
		 */
		FournisseurDaoJdbc2 DAO2 = new FournisseurDaoJdbc2();
		DAO2.extraire();//pour verifer l'etat de la base de donnée au début
		DAO2.insert(new Fournisseur(11,"France matos"));//inserer un fourniseeur
		DAO2.extraire();//afffcher la base
		DAO2.update("France matos", "French Mattos");//modifier un fournisseur
		DAO2.extraire();//afficher la base
		DAO2.delete(new Fournisseur(11,"French mattos"));//supprimer un fournisseur
		DAO2.extraire();//afficher la base en fin de traitement
	}
}
