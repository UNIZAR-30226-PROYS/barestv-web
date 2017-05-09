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
	<!-- mensajes de verificacion -->
    
  <div class="row" style="margin-top: 40px;">
      <div class="col-md-12">
          <div class="row">
              <div class="col-md-3">
              </div>
              <div class="col-md-6">
                  <s:if test="hasActionErrors()">
                      <!-- Mensajes de error -->
                      <div class="alert alert-dismissable alert-danger">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                              ×
                          </button>
                          <h4><s:actionerror/></h4>.
                      </div>
                  </s:if>
                  <s:if test="hasActionMessages()">
                      <!-- Mensaje de exito -->
                      <div class="alert alert-dismissable alert-success">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                              ×
                          </button>
                          <h4><s:actionmessage/></h4>。
                      </div>
                  </s:if>
              </div>
              <div class="col-md-3">
              </div>
          </div>
      </div>
  </div>
	<!--Load Script and Stylesheet -->
	<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>
