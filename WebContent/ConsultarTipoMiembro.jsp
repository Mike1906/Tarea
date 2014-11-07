<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %> 
<%@ page import="dominio.*" %>
<%@ page import="java.util.*" %>
<%! String mensaje = "" ; %>
<%     
	CtrlTipoMiembro nomina = new CtrlTipoMiembro();
 	List tipomiembro = nomina.daTipoMiembro();
	int numero = tipomiembro.size();
	 
 	if (tipomiembro.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		TipoMiembro uActual;
 		mensaje += "<table><tr> <th>ID</th> <th>DESCRIPCION</th> <th>USUARIO</th> </tr>";  
 		for (int i=0; i < numero; i++) {
 			 uActual = (TipoMiembro) tipomiembro.get(i);
 			 mensaje += ("<tr><th>" + uActual.getIdtipomiembro()+ "</th>"+
 					 	 "<th>" + uActual.getDescripcion()+ "</th>"+
 					     "<th>" + uActual.getUsername()+ "</th></tr>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Tipos de Miembros</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Tipos de Miembros de la JRV</legend>
<center><%= mensaje %></center>
<a href="Main.jsp">Volver al menu</a>
</fieldset>

</body>
</html>