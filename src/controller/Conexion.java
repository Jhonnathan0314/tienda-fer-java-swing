/**
 * 
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author JONATAN FRANCO
 *
 */
public class Conexion {
	//Declaracion de variables
	private Connection connect = null;
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tienda_dona_lola";
			String user = "root";
			String password = "Ias2023*.";
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Confirmacion ------------> Realice una conexion");
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
		} catch (SQLException e) {
			System.out.println("Error --> con la BD");
		}
		return connect;
	}
	
	//Metodos get y set
	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
}
