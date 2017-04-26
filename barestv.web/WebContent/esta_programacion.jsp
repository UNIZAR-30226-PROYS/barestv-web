<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Programacion" />
      <jsp:param name="active" value="1" />
</jsp:include>

	<div class="row">
		<div class="col-md-12">
			<h3>
				Añadir evento
			</h3>
			<form role="form" method="post" action="<s:url action="addEvento"/>">
				<div class="form-group">
					 
					<label for="nombre">
						Nombre evento
					</label>
					<s:textfield cssClass="form-control" id="nombre" name="nombre" type="text" value="%{nombre}"/>
					
				</div>
				<div class="form-group">
					 
					<label for="descripcion">
						Descripcion
					</label>
					<s:textarea cssClass="form-control" id="descripcion" name="descripcion" ></s:textarea>
	
				</div>
				<div class="form-group">
					 
					<label for="fechainicio">
						Fecha inicio  (DDMMYYYY) 
					</label>
					<label for="horainicio">
						Hora inicio (hhmm)
					</label>                     
					<br/>
					<s:textfield cssclass="form-control-inline" id="fechainicio" name="fechainicio" type="number" title="fechainicio" value="%{fechainicio}"/> 
					<s:textfield cssclass="form-control-inline" id="horainicio" name="horainicio" type="number" title="horainicio" value="%{horainicio}"/> 
					
					<br/>
					<label for="fechafin">
						Fecha fin  (DDMMYYYY) 
					</label>
					<label for="horafin">
						Hora fin (hhmm)
					</label>                     
					<br/>
					<s:textfield cssclass="form-control-inline" id="fechafin" name="fechafin" type="number" title="fechafin" value="%{fechafin}"/>
					<s:textfield cssclass="form-control-inline" id="horafin" name="horafin" type="number" title="horafin" value="%{horafin}"/> 
					
				</div>
				<div class="form-group">
					 
					<label for="categoria">
						Categoria
					</label>
					<s:select list="categorias" cssclass="form-control" id="categoria" name="categoria" >
					  </s:select>
				</div>
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
									<span class="label label-default"><s:property value="#evento.inicio.ho"/>-<s:property value="#evento.fin.ho"/></span>  <s:property value="#evento.nombre"/> 
								</p> 
								<small><s:property value="#evento.descripcion"/></small>
								<small>Categoria: <s:property value="#evento.categoria"/></small>
								</blockquote>
							</td>
							<td class="boton">
								<button type="button" class="btn btn-primary">
									Modificar
								</button>
							</td>
							<td class="boton">
								<button type="button" class="btn btn-danger">
									Eliminar
								</button>
							</td>
						  </tr>
						
				
				</s:iterator> 
				</tbody>
				</table>
			</s:iterator> 
		</div>
	</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>
