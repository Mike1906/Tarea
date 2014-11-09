<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="java.text.*" %>
<%
String mensaje="";
CtrlJrv jrv=new CtrlJrv();
String idmunicipio=request.getParameter("idmunicipio");
String iddepto=request.getParameter("iddepartamento");
String dui=request.getParameter("dui");
String username=request.getParameter("username");

boolean exito=jrv.crearJrv(iddepto, idmunicipio, dui, username);
if (exito==true)
   mensaje="se ingreso la jrv correctamente";
else
   mensaje="hubo un error, ya existe la jrv";	

%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar Junta receptora de votos</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>

<fieldset>
<legend>Inserta la informacion de la JRV</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="IngresarJrv.html" class="button">Ingresar otra JRV</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>

</body>
</html>