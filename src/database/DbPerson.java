package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Person;


public class DbPerson {
	
	private String url = "jdbc:mysql://127.0.0.1:3306/oblig7";
	
	public void setUrl(String Url){
		url = Url;
	}
	
	public DbPerson(){
		
	}
	
	/*public void savePeople(){
		String user = "root";
		String pass = "";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			for(Person p : Person.getPersons()){
			
			String query = "INSERT INTO person VALUES ("+ p.getId() + ",\""+ p.getfNavn() + "\",\""+ p.geteNavn() + "\"," + p.getAlder() +");";	
			System.out.println(p.getId());
			Statement statement = conn.prepareStatement(query);
			
			statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public void loadPeople(){
		String user = "root";
		String pass = "";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			String query = "SELECT * FROM person;";		
			Statement statement = conn.prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()){
				int idPerson = result.getInt(1);
				String fNavn = result.getString(2);
				String eNavn = result.getString(3);
				int alder = result.getInt(4);
				
				new Person(idPerson , fNavn , eNavn , alder);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public void removePerson(Person p){
		String user = "root";
		String pass = "";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			String query = "DELETE FROM person WHERE idperson = " + p.getId();		
			Statement statement = conn.prepareStatement(query);
			
			statement.executeUpdate(query);			
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void savePerson(Person p){
		String user = "root";
		String pass = "";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			String query = "INSERT INTO person VALUES ("+ p.getId() + ",\""+ p.getfNavn() + "\",\""+ p.geteNavn() + "\"," + p.getAlder() +");";		
			Statement statement = conn.prepareStatement(query);
			
			statement.executeUpdate(query);			
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
