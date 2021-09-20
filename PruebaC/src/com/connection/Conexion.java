package com.connection;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
	public static Connection conectar() {
		Connection conexion = null;
		
		String password = "root";
		String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/mydb?user=" + usuario
				+ "&password=" + password;
		try {
			conexion = DriverManager.getConnection(url);
			if (conexion != null) {
				System.out.println("Conexión Exitosa");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos, por favor verifique sus datos...");
			e.printStackTrace();
		}
		return conexion;
	}
}