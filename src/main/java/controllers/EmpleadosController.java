package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadosDAO;
import models.Empleados;

/**
 * Servlet implementation class EmpleadosController
 */
 @WebServlet("/EmpleadosController")
public class EmpleadosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = null;

		EmpleadosDAO empDAO = null;

		try {
			empDAO = new EmpleadosDAO();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		RequestDispatcher dispatcher = null;

		accion = request.getParameter("accion");

		if (accion == null || accion.isEmpty()) {
			dispatcher = request.getRequestDispatcher("vists/empleados.jsp");
		} 
		else if (accion.equals("modificar")) {
			dispatcher = request.getRequestDispatcher("vists/update.jsp");
		} 
		else if (accion.equals("actualizar")) {
			int id = Integer.parseInt(request.getParameter("id_emp"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));
			int nrodep = Integer.parseInt(request.getParameter("nroDep"));
			Empleados empleado = new Empleados(id, dni, nombre, apellido, nrodep);
			empDAO.updateEmployee(empleado);

			dispatcher = request.getRequestDispatcher("vists/empleados.jsp");
		} 
		else if (accion.equals("eliminar")) {
			int id = Integer.parseInt(request.getParameter("id_emp"));
			empDAO.deleteEmployee(id);
			dispatcher = request.getRequestDispatcher("vists/empleados.jsp");
		} 
		else if (accion.equals("nuevo")) {
			dispatcher = request.getRequestDispatcher("vists/new.jsp");
		} 
		else if (accion.equals("insert")) {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int dni = Integer.parseInt(request.getParameter("dni"));
			int nrodep = Integer.parseInt(request.getParameter("nroDep"));
			Empleados empleado = new Empleados(0, dni, nombre, apellido, nrodep);
			empDAO.insertEmployee(empleado);
			dispatcher = request.getRequestDispatcher("vists/empleados.jsp");
		}

		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
