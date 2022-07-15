package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionMain {
	
	public String driver="com.mysql.jdbc.Driver";

	public Connection getConnection() throws ClassNotFoundException {
		Connection conexion = null;
		try {
		Class.forName(driver);
		 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/desafio22026","root","mostazA159-");
		}
		catch (SQLException e) {
		  System.out.println(e.toString());
		}				
		return conexion;
	}
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conexion = null;
		ConexionMain con = new ConexionMain();
		conexion = con.getConnection();		
		
		PreparedStatement ps;
		ResultSet rs;
				
		ps = conexion.prepareStatement("select * from empleados");
		rs = ps.executeQuery();
				
		while(rs.next()) {
			int id = rs.getInt("id_emp");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int dni = rs.getInt("dni");
			int nroDep = rs.getInt("nrodep");
			
			System.out.println("Id: "+id+" Nombre:"+nombre+" Apellido:"+apellido+" DNI:"+dni+" Nro Departamento:"+ nroDep);
		}
	}

}
