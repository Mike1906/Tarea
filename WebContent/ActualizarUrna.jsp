<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
 <%
String mensaje="";
CtrlUrna urna=new CtrlUrna();
String idurna=request.getParameter("idurna");
String iddepto=request.getParameter("iddepto");
String numjunta=request.getParameter("numjunta");
String presidente=request.getParameter("presidente");
String secretario=request.getParameter("secretario");
String idmunicipio=request.getParameter("idmunicipio");
String cantvotosnulos=request.getParameter("cantvotosnulos");
String cantvotosnovalid=request.getParameter("cantvotosnovalid");
String username=request.getParameter("username");

/*boolean exito= urna.actualizar(idurna, idmunicipio, iddepto, numjunta, presidente, secretario, cantvotosnulos, cantvotosnovalid, username); 
if (exito==true)
   mensaje="La urna se actualizo  correctamente";
else
   mensaje="hubo un error al actualizar urna";*/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Urna</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Actualiza la informacion de la Urna</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarDepartamento.html" class="button">Actualizar otra Urna</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>