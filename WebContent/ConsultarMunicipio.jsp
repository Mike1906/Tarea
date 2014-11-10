<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>
<%! String mensaje = "" ; %>
<%     
	CtrlMunicipio municipio=new CtrlMunicipio();
List lista=municipio.daMunicipio();
	int numero = lista.size();
	 
 	if (lista.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		Municipio muniactual;
 		mensaje += "<table><tr> <th>ID DPTO</th> <th>NOMBRE DPTO</th> <th>ZONA GEOGRAFICA</th> <th>USERNAME</th> </tr>";  
 		for (int i=0; i < numero; i++) {
 			muniactual = (Municipio) lista.get(i);
 			 mensaje += ("<tr><th>" + muniactual.getiddepto()+ "</th>"+
 					 	 "<th>" + muniactual.getidmunicipio()+ "</th>"+
 					 	"<th>" + muniactual.getnombmunicipio()+ "</th>"+
 					 	"<th>" + muniactual.getUsername() + "</th></tr>");
 		}
 	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Municipio</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>

	<fieldset>
		<legend>Municipios ingresados</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>