<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String id = request.getParameter("idmunicipio");	
	
	CtrlMunicipio ctrl = new CtrlMunicipio();

	boolean exito = ctrl.eliminar(id);

	String mensaje;
	
	if (exito) {
		mensaje = "¡¡¡ Se elimino el Municipio !!! ";
	}else {
		mensaje = "¡¡¡ No existe ese Municipio !!! ";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar Municipio</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Borrar Municipio</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="BorrarMunicipio.html" class="button">Borrar otro Municipio</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a></center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>