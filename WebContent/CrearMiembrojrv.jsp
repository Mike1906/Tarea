<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String id = request.getParameter("id");
	String nombres = request.getParameter("nom");
	String ape1 = request.getParameter("ape1");
	String ape2 = request.getParameter("ape2");
	int idjrv = Integer.parseInt(request.getParameter("id2"));
	String idtm = request.getParameter("id3");
	String user = request.getParameter("user");		
	
	CtrlMiembrojrv ctrl = new CtrlMiembrojrv();

	boolean exito = ctrl.crearMiembrojrv(id, nombres, ape1, ape2, idjrv, idtm, user);

	String mensaje;
	
	if (exito) {
		mensaje = "Se creo el Miembro";
	}else {
		mensaje = "Ya existe ese Miembro";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserta</title>
</head>
<body>
<%= mensaje %>
	<br><br>
	<a href="CrearMiembrojrv.html">Ingresar otro miembro</a>
</body>
</html>