<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>
<%! String mensaje = "" ; %>
<%     
	CtrlPadronElectoral padron=new CtrlPadronElectoral();
List lista=padron.daPadrones();
	int numero = lista.size();
	padron.reportePadron(); 
 	if (lista.isEmpty())
 		 mensaje = "No Hay Datos";
 	else {
 		PadronElectoral padronactual;
 		mensaje += "<table><tr> <th>DUI</th> <th>NOMBRES</th> <th>APELLIDOS</th> <th>FECHA NACIMIENTO</th> <th>DOMICILIO</th> <th>ESTADO VOTACION</th> <th>ID URNA</th> <th>USERNAME</th> </tr>";  
 		for (int i=0; i < numero; i++) {
 			padronactual = (PadronElectoral) lista.get(i);
 			 mensaje += ("<tr><th>" + padronactual.getDui()+ "</th>"+
 					 	 "<th>" + padronactual.getNombre()+ "</th>"+
 					 	"<th>" + padronactual.getApellidos()+ "</th>"+
 					 	"<th>" + padronactual.getFechanac()+ "</th>"+
 					 	"<th>" + padronactual.getDomicilio()+ "</th>"+
 					 	"<th>" + padronactual.getEstadovotacion()+ "</th>"+
 					 	"<th>" + padronactual.getUrna()+ "</th>"+
 					     "<th>" +padronactual.getUsername() + "</th></tr>");
 		}
 	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Padrón electoral</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>

	<fieldset>
		<legend>Padrones electorales ingresados</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>