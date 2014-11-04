<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String nom = request.getParameter("nombre");
	String ape = request.getParameter("apellido");
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	int tipo = Integer.parseInt(request.getParameter("tipo"));
	
	CtrlUsuarios ctrl = new CtrlUsuarios();

	boolean exito = ctrl.crearUsuarios(nom, ape, user, pass, tipo);

	String mensaje;
	
	if (exito) {
		mensaje = "Se creo el usuario";
	}else {
		mensaje = "Ya existe ese usuario";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= mensaje %>
	<br><br>
	<a href="CrearUsuario.html">Ingresar otro usuario</a>
</body>
</html>