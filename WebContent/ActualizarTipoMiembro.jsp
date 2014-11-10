<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String id = request.getParameter("id");
	String descr = request.getParameter("descr");
	String user = request.getParameter("user");		
	
	CtrlTipoMiembro ctrl = new CtrlTipoMiembro();

	boolean exito = ctrl.actualizar(id, descr, user);

	String mensaje;
	
	if (exito) {
		mensaje = "¡¡ Se actualizo el Tipo de Miembro !!";
	}else {
		mensaje = "¡¡ No se pudo actualizar, No existe ese Tipo de Miembro !!";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Tipo de Miembro</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Inserta nueva informacion al Tipo de Miembro de la JRV</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarTipoMiembro.html" class="button">Actualizar otro tipo de miembro</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>