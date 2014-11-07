<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String id = request.getParameter("id");	
	
	CtrlMiembrojrv ctrl = new CtrlMiembrojrv();

	boolean exito = ctrl.eliminarMiembro(id);

	String mensaje;
	
	if (exito) {
		mensaje = "¡¡¡ Se elimino el Miembro jrv !!! ";
	}else {
		mensaje = "¡¡¡ No existe ese Miembro !!! ";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar Miembros JRV</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Borrar miembro jrv</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="BorrarMiembrojrv.html" class="button">Borrar otro miembro</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a></center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>