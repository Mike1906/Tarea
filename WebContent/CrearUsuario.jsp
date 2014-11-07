<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
	String nom = request.getParameter("nombre");
	String ape = request.getParameter("apellido");
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	int tipo = Integer.parseInt(request.getParameter("tipo"));
	
	CtrlUsuarios ctrl = new CtrlUsuarios();

	boolean exito = ctrl.crearUsuarios(nom, ape, user, pass, tipo);

	String mensaje;
	
	if (exito) {
		mensaje = "Se creo el usuario";
	}else {
		mensaje = "Ya existe ese usuario";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Inserta la informacion del Tipo de Miembro de la JRV</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="CrearUsuario.html" class="button">Ingresar otro usuario</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>