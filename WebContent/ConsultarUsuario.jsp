<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %> 
<%@ page import="dominio.*" %>
<%@ page import="java.util.*" %>
<%! String mensaje = "" ; %>
<%     
	CtrlUsuarios nomina = new CtrlUsuarios();
 	List usuarios = nomina.daUsuarios();
	int numero = usuarios.size();
	 
 	if (usuarios.isEmpty())
 		 mensaje = "No Hay Usuarios";
 	else {
 		Usuarios uActual;
 		mensaje += "<table><tr> <th>ID</th> <th>NOMBRES</th> <th>APELLIDOS</th><th>USUARIO</th> <th>TIPO DE USUARIO</th></tr>";
 		for (int i=0; i < numero; i++) {
 			 uActual = (Usuarios) usuarios.get(i);
 			 mensaje += ("<tr><th>" + uActual.getId()+ "</th>"+
 					 	 "<th>" + uActual.getNombre()+ "</th>"+
 					     "<th>" + uActual.getApellido()+ "</th>"+
 					     "<th>" + uActual.getUsername() + "</th>"+
 					     "<th>" + uActual.getTipo() + "</th></tr>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Usuarios registrados en el sistema</legend>
<center><%= mensaje %></center>
	<a href="Main.jsp">Volver al menu</a>
</fieldset>
</body>
</html>