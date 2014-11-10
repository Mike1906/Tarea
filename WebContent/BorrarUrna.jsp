<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String id = request.getParameter("idurna");	
	
	CtrlUrna urna = new CtrlUrna();

	//boolean exito = urna.eliminar(id);

	String mensaje;
	boolean exito = true;
	if (exito) {
		mensaje = " Se elimino la Urna  ";
	}else {
		mensaje = " No existe la urna   ";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar Departamento</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Borrar Departamento</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="BorrarDepartamento.html" class="button">Borrar otro Departamento</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a></center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>