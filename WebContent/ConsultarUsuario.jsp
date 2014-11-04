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
 		 mensaje = "No Hay Empleados";
 	else {
 		Usuarios uActual;
 		for (int i=0; i < numero; i++) {
 			 uActual = (Usuarios) usuarios.get(i);
 			 mensaje += (" ID:   " + uActual.getId()+
 					 	 " Nombre: " + uActual.getNombre()+
 					     " Apellido:  " + uActual.getApellido()+ 
 					     " Usuario:     " + uActual.getUsername() +
 					     " Tipo usuario: " + uActual.getTipo() +
 					     "<br>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<%= mensaje %><br>
<br><br>
	<a href="Main.jsp">Volver al menu</a>
</body>
</html>