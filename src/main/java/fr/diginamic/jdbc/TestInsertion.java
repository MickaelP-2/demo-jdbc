package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TestInsertion {
//
static String url,user,pwd;
static Connection myConnexion;
static Statement stat;
static ResultSet resultat;
//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		//String driver = config.getString("database.driver");
		url = config.getString("database.url");
		user = config.getString("database.user");//root par defaut
		pwd = config.getString("database.pwd");//== par defaut
		System.out.println("\n url: "+url+"\n user: "+user+"\n pwd: "+pwd);
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		} 
		//
		try {
			//inserer un fournisseur
			myConnexion = DriverManager.getConnection(url, user, pwd);//!!portee de la var
			stat =  myConnexion.createStatement();
			int nbLignesModif = stat.executeUpdate("INSERT INTO FOURNISSEUR (id_fournisseur,nom) values (6,'Maison de la peinture')");
			
			ArrayList<String> listeFournisseur = new ArrayList<>();
			resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			while(resultat.next()) {
				String sf = new String(resultat.getInt("id_fournisseur")+" "+resultat.getString("nom"));
				listeFournisseur.add(sf);
				System.out.println("sf: "+sf.toString());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		}
		
		finally{
			try {
				resultat.close();
				stat.close();//fermeture statement
				myConnexion.close();//fermeture connection
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}//fermeture de resultat
			
		}//fin finally()
		
		
	}//fin main

}//fin classe()
