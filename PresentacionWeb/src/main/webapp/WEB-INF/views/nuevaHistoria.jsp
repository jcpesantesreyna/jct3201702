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
 <form action="insertarHistoria" method="get">
  Apellido Paterno:<br>
  <input type="text" name="apepat"><br>
  Apellido Materno:<br>
  <input type="text" name="apemat"><br>
  Nombres:<br>
  <input type="text" name="nombres"><br>
  Fecha nacimiento:<br>
  <input type="date" name="fechanac" ><br>
  Dni:<br>
  <input type="text" name="dni" maxlength="8"><br>
  Direccion:<br>
  <input type="text" name="direccion"><br>
  
  <input type="submit" value="Enviar"> 
</form> 
</body>
</html>