package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ConexionMain;
import models.Empleados;

public class EmpleadosDAO {

	Connection conexion = null;

	public EmpleadosDAO() throws ClassNotFoundException {
		ConexionMain con = new ConexionMain();
		conexion = con.getConnection();
	}

	public List<Empleados> showEmployees() {
		PreparedStatement ps;
		ResultSet rs;
		List<Empleados> lista = new ArrayList<>();

		try {
			ps = conexion.prepareStatement("SELECT * FROM empleados");
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_emp");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				int nroDep = rs.getInt("nroDep");
				Empleados empleado = new Empleados(id, dni, nombre, apellido, nroDep );
				lista.add(empleado);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Error de Conexion");
			return null;
		}
	}

	public boolean insertEmployee(Empleados empleado) {
		PreparedStatement ps;

		try {
			ps = conexion.prepareStatement("insert into empleados (dni, nombre,apellido,nroDep) values(?,?,?,?)");
			// ps.setString(0, null);
			ps.setString(1, empleado.getDni());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellido());
			ps.setInt(4, empleado.getNroDep());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Error al insertar dato");
			return false;
		}

	}

	public boolean updateEmployee(Empleados empleado) {
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement("update empleados set dni=? ,nombre=? ,apellido=?, nroDep=?, where id_emp=?");
			ps.setString(1, empleado.getDni());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellido());
			ps.setInt(4, empleado.getNroDep());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Error al insertar dato");
			return false;
		}
	}

	public boolean deleteEmployee(int _id) {
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement("delete from empleados where id_emp=?");
			ps.setInt(1, _id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Error al insertar dato. El empleado no se encuentra.");
			return false;
		}

	}

	public Empleados showEmployee(int _id) {
		PreparedStatement ps;
		ResultSet rs;
		Empleados empleado = null;

		try {
			ps = conexion.prepareStatement("select * from empleados where id_emp=?");
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_emp");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String dni = rs.getString("dni");
				int nroDep = rs.getInt("nroDep");
				empleado = new Empleados(id, dni, nombre, apellido, nroDep );
			}
			return empleado;
		} catch (SQLException e) {
			System.out.println("Error al insertar dato");
			return null;
		}

	}

}
