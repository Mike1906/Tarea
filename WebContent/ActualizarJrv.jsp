<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
 <%
String mensaje="";
CtrlJrv jrv=new CtrlJrv();
String idmunicipio=request.getParameter("idmunicipio");
String iddepto=request.getParameter("iddepto");
String dui=request.getParameter("dui");
String idjrv=request.getParameter("idjrv");
String username=request.getParameter("username");

boolean exito=jrv.actualizaJrv(idjrv, iddepto, idmunicipio, dui, username); 
if (exito==true)
   mensaje="se actualizo la jrv correctamente";
else
   mensaje="hubo un error al actualizar la jrv";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar JRV</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Actualiza la informacion de la JRV</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarJrv.html" class="button">Actualizar otra JRV</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>