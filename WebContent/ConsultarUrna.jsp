<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.*"%>
<%! String mensaje = "" ; %>
<%     
	CtrlUrna urna=new CtrlUrna();
List lista=urna.daUrna();
	int numero = lista.size();////private int idurna;  private int idmunicipio;	private int iddepto;private int numjunta;  
	 						 //private String presidente;  private String secretario;  private int cantvotosnulos;  if (lista.isEmpty())
 		 mensaje = "No Hay Datos";//private int cantvotosnovalid;  private int username;
 		if (lista.isEmpty())
 	 		 mensaje = "No Hay Datos";
 		 
 	else {
 		Urna urnaact;
 		mensaje += "<table><tr> <th>ID Urna</th> <th>ID municipio</th> <th>ID DEPARTAMENTO</th> <th>NUMERO JUNTA</th> <th>PRESIDENTE</th> <th>SECRETARIO</th> <th>VOTOS NULOS</th> <th>VOTOS NO VALIDOS</th> <th>USUARIO</th> </tr>";                          
 		for (int i=0; i < numero; i++) {
 			urnaact = (Urna) lista.get(i);
 			 mensaje += ("<tr><th>" + urnaact.getIdurna()+ "</th>"+
 					 "<th>" + urnaact.getIdmunicipio()+ "</th>"+
					 "<th>" + urnaact.getIddepto()+ "</th>"+
					 "<th>" + urnaact.getNumjunta()+ "</th>"+
				 	 "<th>" + urnaact.getPresidente()+ "</th>"+
				 	 "<th>" + urnaact.getSecretario()+ "</th>"+
				 	 "<th>" + urnaact.getCantvotosnulos()+ "</th>"+
				 	 "<th>" + urnaact.getCantvotosnovalid()+ "</th>"+
 					 "<th>" + urnaact.getUsername() + "</th></tr>");
 		}
 	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Urna</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>

	<fieldset>
		<legend>Urnas ingresadss</legend>
		<center><%=mensaje%></center>
		<a href="Main.jsp">Volver al menu</a>
	</fieldset>
</body>
</html>