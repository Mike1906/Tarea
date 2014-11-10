<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
    <%
	
    String idPartidoPolitico = request.getParameter("idpartido");	
	
	CtrlPartidoPolitico partidopolitico = new CtrlPartidoPolitico();
	boolean exito = partidopolitico.eliminarPartidoPolitico(idPartidoPolitico);
	String mensaje;
	
	if (exito) {
		mensaje = "¡¡¡ Se elimino el Partido Politico !!! ";
	}else {
		mensaje = "¡¡¡ No existe ese Partido  Politico !!! ";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Partido Politico</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Borrar un Partido Politico</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="BorrarPartidoPolitico.html" class="button">Borrar otro Partido Politico</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a></center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</body>
</html>