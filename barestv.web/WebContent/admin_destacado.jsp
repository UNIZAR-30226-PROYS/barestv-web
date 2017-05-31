<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Destacado" />
      <jsp:param name="active" value="2" />
</jsp:include>
	<h4>Busqueda</h4>
	<form method="post" action="<s:url action="getDestacado"/>">
		<input type="text" value="<s:property value="filtro"/>" name="filtro"/>
		<button type="submit" class="btn btn-primary">
			Filtrar
		</button>
	</form>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Destacados		
			</h3>
			
			<table>
				<tbody>
					<s:iterator value="destacados" var="programa">
						<tr>
							<td>
								<s:property value="#programa.titulo"/>
							</td>
							<td>
								<s:property value="#programa.nombrelargo"/>
							</td>
							<td>
								<s:date name="#programa.inicio" format="dd/MM/yyyy hh:mm" />-<s:date name="#programa.fin" format="hh:mm"/>
							</td>
							<td class="boton">
								<form role="form" method="post" action="<s:url action="nodestacar"/>">
									<input type="hidden" name="bar" value="<s:property value="#programa.bar"/>" />
									<input type="hidden" name="titulo" value="<s:property value="#programa.titulo"/>" />
									<button type="submit" class="btn btn-danger">
										Quitar
									</button>
								</form>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>	
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Disponibles		
			</h3>
			<table class="table">

				<tbody>
					<s:iterator value="nodestacados" var="programa">
						<tr>
							<td>
								<s:property value="#programa.titulo"/>
							</td>
							<td>
								<s:property value="#programa.nombrelargo"/>
							</td>
							<td>
								<s:date name="#programa.inicio" format="dd/MM/yyyy hh:mm" />-<s:date name="#programa.fin" format="hh:mm"/>
							</td>
							<td class="boton">
								<form role="form" method="post" action="<s:url action="destacar"/>">
									<input type="hidden" name="bar" value="<s:property value="#programa.bar"/>" />
									<input type="hidden" name="titulo" value="<s:property value="#programa.titulo"/>" />
									<button type="submit" class="btn btn-primary">
										Añadir
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