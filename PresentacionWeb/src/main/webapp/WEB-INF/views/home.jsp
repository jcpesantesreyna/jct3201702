<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SOWAD | Acceso al sistema</title>
  <spring:url value="/resources/Boostrap/assets/css/bootstrap.min.css" var="bootstrapMin" />

    <spring:url value="/resources/Boostrap/assets/css/animate.min.css" var="sbAdmin"/>
    <spring:url value="/resources/Boostrap/assets/css/light-bootstrap-dashboard.css?v=1.4.0" var="dash"/>
    <spring:url value="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" var="fontAwesome"/>
    <spring:url value="http://fonts.googleapis.com/css?family=Roboto:400,700,300" var="google"/>
    <spring:url value="assets/css/pe-icon-7-stroke.css" var="stroke"/>
    
    <link href="${bootstrapMin}" rel="stylesheet"/>
    
    <link href="${sbAdmin}" rel="stylesheet"/>
    <link href="${dash}" rel="stylesheet"/>
    <link href="${fontAwesome}" rel="stylesheet" type="text/css"/>
    <link href="${google}" rel="stylesheet"/>
    <link href="${stroke}" rel="stylesheet"/>
</head>
<body class="bg-dark">
  <div class="container">
    <div class="">
      <div class="">Login</div>
      <div class="">
           <frm:form method="POST" action="VerificarAcceso">
          <div class="form-group">
            <label for="">Usuario</label>
            <frm:input path="sesion" class="form-control" placeholder="Usuario" name="sesion" type="text"></frm:input>
          </div>
          <div class="form-group">
            <label for="">Password</label>
            <frm:input path="password" class="form-control" placeholder="Password" name="password" type="password" value=""></frm:input>
          </div>
          
		                 <div class="text-center">
		          <input type="submit" value="Ingresar" name="btnIngresar" class="btn btn-lg btn-success btn-block"/>
		        </div>
          
          
        </frm:form>
       
      </div>
    </div>
  </div>

 <spring:url value="/resources/Boostrap/assets/js/jquery.3.2.1.min.js" var="jqueryJS"/>
    <spring:url value="/resources/Boostrap/assets/js/bootstrap.min.js" var="bootstrapJS"/>
    
    <spring:url value="/resources/Boostrap/assets/js/chartist.min.js" var="sbadminJS"/>
    <spring:url value="/resources/Boostrap/assets/js/bootstrap-notify.js" var="noti"/>
    <spring:url value="/resources/Boostrap/assets/js/light-bootstrap-dashboard.js?v=1.4.0" var="dashjs"/>
    <spring:url value="/resources/Boostrap/assets/js/demo.js" var="demojs"/>
    <script src="${jqueryJS}"></script>
    <script src="${bootstrapJS}"></script>
    
    <script src="${sbadminJS}"></script>
    <script src="${noti}"></script>
    <script src="${dashjs}"></script>
    <script src="${demojs}"></script>
</body>
</html>
