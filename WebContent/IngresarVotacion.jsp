<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="java.text.*" %>

<%
String mensaje="";
CtrlVotacion votacion=new CtrlVotacion();
float idVotacion=Float.parseFloat(request.getParameter("idvotacion"));
float idUrna=Float.parseFloat(request.getParameter("idurna"));
String idPartidoPolitico=request.getParameter("idpartidopolitico");
float cantidadVotosValidos=Float.parseFloat(request.getParameter("votosvalidos"));
String username=request.getParameter("username");

boolean exito=votacion.crearVotacion(idVotacion,idUrna,idPartidoPolitico,cantidadVotosValidos,username);
if (exito==true)
   mensaje="se ingreso la votacion correctamente";
else
   mensaje="hubo un error, ya existe la votacion";	
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar votacion</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Inserta la informacion de la votacion</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ingresarVotacion.html" class="button">Ingresar otra votacion</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>