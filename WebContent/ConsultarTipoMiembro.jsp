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
 		for (int i=0; i < numero; i++) {
 			 uActual = (TipoMiembro) tipomiembro.get(i);
 			 mensaje += (" ID:   " + uActual.getIdtipomiembro()+
 					 	 " Descripcion: " + uActual.getDescripcion()+
 					     " Usuario:  " + uActual.getUsername()+ 
 					     "<br>");
 		}
 	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Tipos de Miembros</title>
</head>
<body>
<%= mensaje %><br>
</body>
</html>