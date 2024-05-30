package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestUpdate {
static String url,user,pwd;
static Connection myConnexion;
static Statement stat;
static ResultSet resultat;

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
			//modifier le nom d'un fournisseur
			myConnexion = DriverManager.getConnection(url, user, pwd);//!!portee de la var
			stat =  myConnexion.createStatement();
			int nbLignesModif = stat.executeUpdate("UPDATE FOURNISSEUR SET NOM = 'Maison des peintures' WHERE Id_fournisseur=6");
			ArrayList<String> listeFournisseur = new ArrayList<>();
			resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			while(resultat.next()) {
				String sf = new String(resultat.getInt("id_fournisseur")+" "+resultat.getString("nom"));
				listeFournisseur.add(sf);
				System.out.println("sf: "+sf.toString());
			}
			System.out.println("lignes modifiées: "+nbLignesModif);
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
		
	}

}
