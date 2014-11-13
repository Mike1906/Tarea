<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>
<%! String mensaje = "" ; %>
<%     
	CtrlDepartamento departamento=new CtrlDepartamento();
	List lista=departamento.daDepartamento();
	int numero = lista.size();
	
 	if (lista.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		Departamento deparactual;
 		mensaje += "<table><tr> <th>ID DPTO</th> <th>NOMBRE DPTO</th> <th>ZONA GEOGRAFICA</th> <th>USERNAME</th> </tr>";  
 		for (int i=0; i < numero; i++) {
 			deparactual = (Departamento) lista.get(i);
 			 mensaje += ("<tr><th>" + deparactual.getIddepto()+ "</th>"+
 					 	 "<th>" + deparactual.getNombredepto()+ "</th>"+
 					 	"<th>" + deparactual.getZonageografica()+ "</th>"+
 					 	"<th>" + deparactual.getUsername() + "</th></tr>");
 		}
 	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Departamento</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>

	<fieldset>
		<legend>Departamentos ingresados</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>