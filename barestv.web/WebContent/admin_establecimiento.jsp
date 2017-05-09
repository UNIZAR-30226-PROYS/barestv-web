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
			<h4>Filtrar establecimientos:</h4>
			<form method="post" action="<s:url action="getEstablecimientos"/>">
				<input type="text" value="<s:property value="filtro"/>" name="filtro"/>
				<button type="submit" class="btn btn-primary">
					Filtrar
				</button>
			</form>
			<p>Lista de establecimientos en el sistema, desde aqui se podra modificar o eliminar un establecimiento.</p>
			<table class="table">
				<thead>
				  <tr>
					<th>Establecimiento</th>
					<th>Editar programación</th>
					<th>Editar datos</th>
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
						<form method="post" action="<s:url action="getProgramacion"/>">
							<input type="hidden" value="<s:property value="#bar.nickbar"/>" name="user"/>
							<button type="submit" class="btn btn-primary">
								Modificar
							</button>
						</form>
					</td>
					<td class="boton">
						<form method="post" action="<s:url action="getEstablecimiento"/>">
							<input type="hidden" value="<s:property value="#bar.nickbar"/>" name="nickbar"/>
							<button type="submit" class="btn btn-primary">
								Modificar
							</button>
						</form>
					</td>
					<td class="boton">
						<form method="post" action="<s:url action="deleteAccout"/>">
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