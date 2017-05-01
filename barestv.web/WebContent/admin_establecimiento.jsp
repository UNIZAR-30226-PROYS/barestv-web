<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Establecimientos" />
      <jsp:param name="active" value="0" />
</jsp:include>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Establecimientos registrados
			</h3>
			<p>Lista de establecimientos en el sistema, desde aqui se podra modificar o eliminar un establecimiento.
			<table class="table">
				<thead>
				  <tr>
					<th>Nombre del establecimiento</th>
					<th>Modificar los atributos</th>
					<th>Eliminar del sistema</th>
				  </tr>
				</thead>
				<tbody>
				<s:iterator value="establecimientos" var="bar">
				 <tr>
					<td>
						<blockquote>
						<p>
							<s:property value="#bar.nickbar"/>: <s:property value="#bar.nombre"/>
						</p> 
						<small><s:property value="#bar.direccion"/></small>
						</blockquote>
					</td>
					<td class="boton">
						<form role="form" method="post" action="<s:url action="getEstablecimiento"/>">
							<input type="hidden" value="<s:property value="#bar.nickbar"/>" name="nickbar"/>
							<button type="submit" class="btn btn-primary">
								Modificar
							</button>
						</form>
					</td>
					<td class="boton">
						<form role="form" method="post" action="<s:url action="deleteAccout"/>">
							<input type="hidden" value="<s:property value="#bar.nickbar"/>" name="nickbar"/>
							<button type="submit" class="btn btn-danger">
								Eliminar
							</button>
						</form>
					</td>
				  </tr>
				  </s:iterator>
				</tbody>
			  </table>
		</div>
		
	</div>
	
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>