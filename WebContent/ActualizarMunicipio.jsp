<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
 <%
String mensaje="";
CtrlMunicipio municipio=new CtrlMunicipio();
String idmunicipio=request.getParameter("idmunicipio");
String iddepto=request.getParameter("iddepto");
String nombmunicipio=request.getParameter("nombmunicipio");
String username=request.getParameter("username");

boolean exito= municipio.actualizar(idmunicipio, iddepto, nombmunicipio, username); 
if (exito==true)
   mensaje="se actualizo el municipio correctamente";
else
   mensaje="hubo un error al actualizar el municipio";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Municipio</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Actualiza la informacion del Municipio</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarMunicipio.html" class="button">Actualizar otro Municipio</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>