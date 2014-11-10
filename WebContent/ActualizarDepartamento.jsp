<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
 <%
String mensaje="";
CtrlDepartamento departamento=new CtrlDepartamento();
String nombdepto=request.getParameter("nombdepto");
String iddepto=request.getParameter("iddepto");
String zonageografica=request.getParameter("zonageografica");
String username=request.getParameter("username");

boolean exito= departmanento.actualizaDepartamento(nombdepto, iddepto, zonageografica, username); 
if (exito==true)
   mensaje="se actualizo el Departamento correctamente";
else
   mensaje="hubo un error al actualizar el Departamento";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Departamentoo</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Actualiza la informacion del Departamento</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarDepartamento.html" class="button">Actualizar otro Departamento</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>