<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>

<%!String mensaje = "";%>
<%
	CtrlJrv jrv = new CtrlJrv();
	List lista = jrv.daJrv();

	int numero = lista.size();
	jrv.reporteJrv();
	if (lista.isEmpty())
		mensaje = "No Hay Datos";
	else {
		Jrv jrvactual;
		mensaje += "<table><tr> <th>ID</th> <th>ID MUNICIPIO</th> <th>ID DEPARTAMENTO</th> <th>DUI</th> <th>USERNAME</th> </tr>";
		for (int i = 0; i < numero; i++) {
			jrvactual = (Jrv) lista.get(i);
			mensaje += ("<tr><th>" + jrvactual.getIdjrv() + "</th>"
					+ "<th>" + jrvactual.getIdmunicipio() + "</th>"
					+ "<th>" + jrvactual.getIddepto() + "</th>"
					+ "<th>" + jrvactual.getDui() + "</th>" + "<th>"
					+ jrvactual.getUsername() + "</th></tr>");
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Juntas receptoras de votos</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
	<fieldset>
		<legend>Juntas receptoras de votos</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>