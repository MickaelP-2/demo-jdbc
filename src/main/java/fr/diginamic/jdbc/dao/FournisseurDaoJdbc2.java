package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entite.Fournisseur;

public class FournisseurDaoJdbc2 implements FournisseurDao{
	
	static String url,user,pwd;
	static Connection myConnexion;
	static Statement stat;
	static ResultSet resultat;
	
	//
		@Override
	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		ArrayList<Fournisseur> listeFournisseur = new ArrayList<>();
		ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		//String driver = config.getString("database.driver");
		url = config.getString("database.url");
		user = config.getString("database.user");//root par defaut
		pwd = config.getString("database.pwd");//== par defaut
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
			PreparedStatement selectFournisseur = myConnexion.prepareStatement("SELECT * FROM FOURNISSEUR");
			resultat = selectFournisseur.executeQuery();
			
			//resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			while(resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id_fournisseur"),resultat.getString("nom"));
				listeFournisseur.add(f);
				System.out.println(f.toString());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		}
		finally{
			try {
				//resultat.close();
				stat.close();//fermeture statement
				myConnexion.close();//fermeture connection
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}//fermeture de resultat
		}//fin finally()
		return listeFournisseur;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		url = config.getString("database.url");
		user = config.getString("database.user");//root par defaut
		pwd = config.getString("database.pwd");//== par defaut
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
			//stat.executeUpdate("INSERT INTO FOURNISSEUR (id_fournisseur,nom) values ("+fournisseur.getId_fournisseur()+",'"+fournisseur.getNom()+"')");
			PreparedStatement insertFournisseur = myConnexion.prepareStatement("INSERT INTO FOURNISSEUR (id_fournisseur,nom) values (?,?)");
			insertFournisseur.setInt(1, fournisseur.getId_fournisseur());
			insertFournisseur.setString(2, fournisseur.getNom());
			insertFournisseur.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		}
		finally{
			try {
				//resultat.close();
				stat.close();//fermeture statement
				myConnexion.close();//fermeture connection
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fermeture de resultat
		}//fin finally()
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
			ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		url = config.getString("database.url");
		user = config.getString("database.user");//root par defaut
		pwd = config.getString("database.pwd");//== par defaut
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
			//stat.executeUpdate("UPDATE FOURNISSEUR SET NOM = '"+nouveauNom+"' WHERE Nom = '"+ancienNom+"'");
			PreparedStatement updateFournisseur = myConnexion.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE Nom = ?");
			updateFournisseur.setString(1,nouveauNom);
			updateFournisseur.setString(2,ancienNom);
			updateFournisseur.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		}
		
		finally{
			try {
				//resultat.close();
				stat.close();//fermeture statement
				myConnexion.close();//fermeture connection
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fermeture de resultat
		}//fin finally()
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		//String driver = config.getString("database.driver");
		url = config.getString("database.url");
		user = config.getString("database.user");//root par defaut
		pwd = config.getString("database.pwd");//== par defaut
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
			//supprimer un fournisseur
			myConnexion = DriverManager.getConnection(url, user, pwd);//!!portee de la var
			stat =  myConnexion.createStatement();
			//stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE Id_fournisseur = '"+fournisseur.getId_fournisseur()+"'");
			PreparedStatement deleteFournisseur = myConnexion.prepareStatement("DELETE FROM FOURNISSEUR WHERE Id_fournisseur = ?");
			deleteFournisseur.setInt(1,fournisseur.getId_fournisseur());
			deleteFournisseur.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		}
		finally{
			try {
				//resultat.close();
				stat.close();//fermeture statement
				myConnexion.close();//fermeture connection
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}//fermeture de resultat
		}//fin finally()
		return false;
	}
	
}
