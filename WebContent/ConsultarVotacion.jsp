<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>
<%!String mensaje = "";%>
<%
	CtrlVotacion votacion = new CtrlVotacion();
	List lista = votacion.daVotacion();
	int numero = lista.size();
	if (lista.isEmpty())
		mensaje = "No Hay Datos";
	else {
		Votacion vactual;
		mensaje += "<table><tr> <th>ID</th> <th>ID URNA</th> <th>ID PARTIDO POLITICO</th> <th>CANTIDAD DE VOTOS VALIDOS</th> <th>USERNAME</th> </tr>";
		for (int i = 0; i < numero; i++) {
			vactual = (Votacion) lista.get(i);
			mensaje += ("<tr><th>" + vactual.getIdvotacion() + "</th>"
					+ "<th>" + vactual.getIdurna() + "</th>"
					+ "<th>" + vactual.getIdpartido() + "</th>"
					+ "<th>" + vactual.getCantvotosvalidos() + "</th>" 
					+ "<th>" + vactual.getUsername() + "</th></tr>");
		}
	}
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Votacion</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
		<legend>Votaciones</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>