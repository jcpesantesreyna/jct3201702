<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
			<h3>Lista</h3>
			
		
		<td><a href="${pageContext.request.contextPath}/nuevoResponsable">Nuevo</a></td>
			<table class="table table-hover">
				<thead>
					<th>ID</th>
				     <th>Descripcion</th>
				      
 				       
				     
				           <th></th>
				</thead>
				<tbody>
					<c:forEach items="${lista}" var="responsable">
						<tr>
							<td>${responsable.idresposanble}</td>		
							<td>${responsable.descripcion}</td>	
						
							
							<td><a href="${pageContext.request.contextPath}/editarResponsable?idresponsable=${responsable.idresposanble}">Modificar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			
         </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetFooter.jsp"></jsp:include></html>