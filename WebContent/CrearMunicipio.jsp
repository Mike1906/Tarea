<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
 <%
String mensaje="";
CtrlMunicipio municipio=new CtrlMunicipio();
String idmunicipio=request.getParameter("id");
String iddepto=request.getParameter("id2");
String nombmunicipio=request.getParameter("nombre");
String username=request.getParameter("username");

boolean exito= municipio.crearMunicipio(idmunicipio, iddepto, nombmunicipio, username); 
if (exito==true)
   mensaje="se creo el municipio correctamente";
else
   mensaje="hubo un error al crear el municipio";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Municipio</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Crear la informacion del Municipio</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="CrearMunicipio.html" class="button">Crear otro Municipio</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>