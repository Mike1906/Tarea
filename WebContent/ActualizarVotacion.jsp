<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
    <%
String mensaje="";
CtrlVotacion votacion = new CtrlVotacion();
String idVotacion = request.getParameter("idvotacion");
int idUrna = Integer.parseInt(request.getParameter("idurna"));
String idPartidoPolitico = request.getParameter("idpartidopolitico");
int cantidadVotosValidos = Integer.parseInt(request.getParameter("votosvalidos"));
String username = request.getParameter("username");

boolean exito = votacion.actualizarVotacion(idVotacion, idUrna, idPartidoPolitico, cantidadVotosValidos, username); 
if (exito==true)
   mensaje="se actualizo la votacion correctamente";
else
   mensaje="hubo un error al actualizar la votacion";	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Votacion</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Actualiza la informacion de la Votacion</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarVotacion.html" class="button">Actualizar otra Votacion</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>
