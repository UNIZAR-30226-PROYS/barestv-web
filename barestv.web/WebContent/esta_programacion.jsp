<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<% 
String blahValue = "1"; 
if(session.getAttribute("usuario")!=null && session.getAttribute("admin")!= null){
   blahValue = "0";
}
%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Programacion" />
      <jsp:param name="active" value="<%=blahValue%>" />
</jsp:include>

	<div class="row">
		<div class="col-md-12">
			<h3>
				Añadir evento a la programación del establecimiento: <s:property value="user"/>
			</h3>
			<form role="form" method="post" action="<s:url action="addEvento"/>">
				<div class="form-group">
					 
					<label for="nombre">
						Nombre evento:
					</label>
					<s:textfield cssClass="form-control" id="nombre" name="nombre" type="text" value="%{nombre}"/>
					
				</div>
				<div class="form-group">
					 
					<label for="descripcion">
						Descripcion:
					</label>
					<s:textarea cssClass="form-control" id="descripcion" name="descripcion" ></s:textarea>
	
				</div>
				<div class="form-group">
					 
					<label for="fechainicial">
						Introduce la fecha de inicio y fin:
					</label>                     
					<br/>
					<s:textfield cssClass="form-control" id="fechainicial" name="fechainicial" type="text" value="%{fechainicial}"/> -
					<script type="text/javascript">
						$(function(){
							$('*[name=fechainicial]').appendDtpicker({
								"inline": false,
								"locale": "es",
								"firstDayOfWeek": 1,
								"closeOnSelected": true,
								"dateFormat": "DD/MM/YYYY hh:mm"
							});
						});
					</script>
					<s:textfield cssClass="form-control" id="fechafinal" name="fechafinal" type="text" value="%{fechafinal}"/>
					<script type="text/javascript">
						$(function(){
							$('*[name=fechafinal]').appendDtpicker({
								"inline": false,
								"locale": "es",
								"firstDayOfWeek": 1,
								"closeOnSelected": true,
								"dateFormat": "DD/MM/YYYY hh:mm"
							});
						});
					</script>
					</div>
				<div class="form-group">
					 
					<label for="categoria">
						Selecciona la categoria del evento:
					</label>
					<br/>
					<s:select list="categorias" cssclass="form-control" id="categoria" name="categoria" >
					  </s:select>
				</div>
				<input type="hidden" value='<s:property value="user"/>' name="user"/>
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Programacion
			</h3>
			
			<s:iterator value="programacion">
				<table class="table">
						<thead>
						  <tr>
							<th><span class="label label-primary"><s:property value="key"/></span></th>
							<th></th>
							<th></th>
						  </tr>
						</thead>
						<tbody>
				<s:iterator value="value" var="evento">
					<s:set var="fechainicio" value="#evento.inicio"/>	
					<s:set var="fechafin" value="#evento.fin"/>	
						<tr>
							<td>
								<blockquote>
								
								<p>
									<span class="label label-default"><s:date name="fechainicio" format="HH:mm" /> - <s:date name="fechafin" format="HH:mm" /></span>  <s:property value="#evento.titulo"/> 
								</p> 
								<small><s:property value="#evento.descr"/></small>
								<small>Categoria: <s:property value="#evento.cat"/></small>
								</blockquote>
							</td>
							<td class="boton">
								<form role="form" method="post" action="<s:url action="getEvento"/>">
									<input type="hidden" name="titulo" value="<s:property value="#evento.titulo"/>"/>
									<input type="hidden" name="bar" value="<s:property value="user"/>"/>
									<button type="submit" class="btn btn-primary">
										Modificar
									</button>
								</form>
							</td>
							<td class="boton">
								<form role="form" method="post" action="<s:url action="removeEvento"/>">
									<input type="hidden" name="titulo" value="<s:property value="#evento.titulo"/>"/>
									<input type="hidden" name="bar" value="<s:property value="user"/>"/>
									<button type="submit" class="btn btn-danger">
										Eliminar
									</button>
								</form>
							</td>
						  </tr>
						
				
				</s:iterator> 
				</tbody>
				</table>
			</s:iterator> 
		</div>
	</div>
	<!--Load Script and Stylesheet -->
	<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>
