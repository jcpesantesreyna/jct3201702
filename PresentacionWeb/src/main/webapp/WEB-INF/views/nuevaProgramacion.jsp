<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertarProgramacion" method="get">
  Servicio:<br>
<select name="idservicio">
			
			  	<c:forEach items="${listaservicios}" var="servicio">
			  	 <option value="${servicio.idservicio}">${servicio.descripcion}</option>
					
					</c:forEach>
			</select> 
			<br>
  Responsable:<br>
<select name="idresponsable">
			
			  	<c:forEach items="${listaresponsables}" var="responsable">
			  	 <option value="${responsable.idresposanble}">${responsable.descripcion}</option>
					
					</c:forEach>
			</select> 
			<br>
	Turno		
  <input type="text" name="turno" ><br>
  Lunes<br>
  <input type="text" name="dialun" ><br>
  Martes<br>
  <input type="text" name="diamar" ><br>
  Miercoles
  <br>
  <input type="text" name="diamie" ><br>
  Jueves<br>
  <input type="text" name="diajue"><br>
  Viernes<br>
  <input type="text" name="diavie"><br>
  Sabado<br>


    <input type="text" name="diasab" ><br>
      estado <br>
      <input type="text" name="estado" ><br>

  
  <input type="submit" value="Enviar"> 
</form> 
</body>
</html>