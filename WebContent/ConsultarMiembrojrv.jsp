<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %> 
<%@ page import="dominio.*" %>
<%@ page import="java.util.*" %>
<%! String mensaje = "" ; %>
<%     
	CtrlMiembrojrv nomina = new CtrlMiembrojrv();

 	List miembro = nomina.daMiembrojrv();
	int numero = miembro.size();
	nomina.reporteMiembroJrv(); 
 	if (miembro.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		Miembrojrv uActual;
 		mensaje += "<table><tr> <th>ID</th> <th>NOMBRE</th> <th>PRIMER APELLIDO</th> <th>SEGUNDO APELLIDO</th>"
 		+ "<th>ID JRV</th> <th>ID TIPO DE MIEMBRO</th> <th>USUARIO</th></tr>";  
 		for (int i=0; i < numero; i++) {
 			 uActual = (Miembrojrv) miembro.get(i);
 			 mensaje += ("<tr><th>" + uActual.getIdmiembrojrv()+ "</th>"+
 					 	 "<th>" + uActual.getNombres()+ "</th>"+
 					     "<th>" + uActual.getApellidop()+ "</th>"+
 					     "<th>" + uActual.getApellidom()+ "</th>"+
 					     "<th>" + uActual.getIdjrv()+ "</th>"+
 					     "<th>" + uActual.getIdtipomiembro()+ "</th>"+
 					     "<th>" + uActual.getUsername()+ "</th></tr>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Miembros JRV</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Miembros JRV</legend>
<center><%= mensaje %></center>
	<a href="Main.jsp">Volver al menu</a>
</fieldset>
</body>
</html>