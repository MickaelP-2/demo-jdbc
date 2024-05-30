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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FournisseurDaoJdbc FDAOJDBC = new FournisseurDaoJdbc();
		//Fournisseur nouvoFour = new Fournisseur(6,"France de materiaux");
		FDAOJDBC.insert(new Fournisseur(6,"France de materiaux"));
		FDAOJDBC.extraire();
		FDAOJDBC.update("France de materiaux", "France de matériaux");//France de matériaux
		FDAOJDBC.extraire();
		FDAOJDBC.delete(new Fournisseur(6,"France de matériaux"));
		FDAOJDBC.extraire();
	}
}
