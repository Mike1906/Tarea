<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="negocio.*" %>
<%
    int idurna = Integer.parseInt(request.getParameter("idurna"));
	String id = request.getParameter("id");
	String id2 = request.getParameter("id2");
	int num = Integer.parseInt(request.getParameter("num"));		
	String pres = request.getParameter("pre");		
	String sec = request.getParameter("sec");		
	int vot1 = Integer.parseInt(request.getParameter("vot1"));		
	String vot2 = request.getParameter("vot2");
	String user = request.getParameter("user");
	
	CtrlUrna ctrl = new CtrlUrna();

	boolean exito = ctrl.crearUrna(idurna, id, id2, num, pres, sec,vot1,vot2,user);

	String mensaje;
	
	if (exito) {
		mensaje = "Se creo la Urna";
	}else {
		mensaje = "Ya existe esa Urna";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar Urna</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Inserte la informacion a la Urna</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="CrearUrna.html" class="button">Ingresar otra</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>