<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="negocio.*" %> 
<%@ page import="dominio.*" %>
<%@ page import="java.util.*" %>
<%! String mensaje = "" ; %>

<%     
	CtrlPartidoPolitico partido = new CtrlPartidoPolitico();
 	List partidopolitico = partido.daPartido();
	int numero = partidopolitico.size();
	 
 	if (partidopolitico.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		PartidoPolitico uActual;
 		mensaje += "<table><tr> <th>ID PARTIDO</th> <th>NOMBRE DEL PARTIDO</th> <th>FECHA DE FUNDACION</th> <th>NOMBRE DEL SECRETARIO GENERAL</th> <th>USUARIO</th> </tr>";  
 		for (int i=0; i < numero; i++) {
 			 uActual = (PartidoPolitico) partidopolitico.get(i);
 			 mensaje += ("<tr><th>" + uActual.getIdPartidoPolitico()+ "</th>"+
 					     "<th>" + uActual.getNombrePartido()+ "</th>"+
 					 	 "<th>" + uActual.getFechaDeFundacion()+ "</th>"+
 					 	 "<th>" + uActual.getNombreSecretarioGeneral()+ "</th>"+
 					     "<th>" + uActual.getUsername()+ "</th></tr>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Partido Politico</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend> Partidos Politicos</legend>
<center><%= mensaje %></center>
<a href="Main.jsp">Volver al menu</a>
</fieldset>
</body>
</html>