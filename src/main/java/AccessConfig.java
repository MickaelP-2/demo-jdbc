import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import org.mariadb.jdbc.Connection;

public class AccessConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle config = ResourceBundle.getBundle("config");//fichier .properties
		//String driver = config.getString("database.driver");
		String url = config.getString("database.url");
		String user = config.getString("database.user");//root par defaut
		String pwd = config.getString("database.pwd");//== par defaut
		System.out.println("\n url: "+url+"\n user: "+user+"\n pwd: "+pwd);
		
		//chargement du pilote pour mysql
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
			System.exit(-1);
		} 
		/*
		//bloc catch pour Class.forName()
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//connection a la BDD: Connection myConnection = DriverManager.getConnection(url,user,pwd)
		try {
			//ouverture de la connexion
			Connection myConnexion = DriverManager.getConnection(url, user, pwd);//!!portee de la var
			System.out.println("con: "+myConnexion.toString());
			//fermeture de la connexion
			//myConnexion.close();
			System.out.println("con: "+myConnexion.toString());
			//requete
			Statement stat =  myConnexion.createStatement();
			int nbLignesModif = stat.executeUpdate("INSERT INTO FOURNISSEUR (id_fournisseur,nom) values (4,'Leroy Merlin')");
			//Exception si existant(id_fourniseur)
			int nbLignesDelete = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE id_fournisseur =7");//0 car id=7 inexistant
			//
			//SELECT = executeQuery-> se positionner sur la premiere ligne = resultat.next()
			//ArrayList<Fournisseur> listeFournisseur = new ArrayList<>();//-> ajouter classe fournisseur
			ResultSet resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			/*
			while(resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id_fournisseur"),resultat.getString("nom"));
				listeFournisseur.add(f);
			}
			*/
			resultat.close();//fermeture de resultat
			stat.close();//fermeture statement
			myConnexion.close();//fermeture connection
			System.out.println("nb lignes: "+nbLignesModif+"\n nb Lignes: "+nbLignesDelete);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
