<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Establecimiento" />
      <jsp:param name="active" value="0" />
</jsp:include>

	<div class="row">
		<form role="form" method="post" action="<s:url action="editEstablecimiento"/>">
		<s:textfield id="est.nickbar" name="est.nickbar" type="hidden" value="%{est.nickbar}"/>
				
			<div class="col-md-6">
				<div class="thumbnail">
					<img class="img-responsive" alt="Bootstrap Image Preview" src='${est.urlimagen}'/>
					<div class="form-group">
	                    <label for="est.urlimagen">Url imagen:</label>
						<s:textfield cssClass="form-control" id="est.urlimagen" name="est.urlimagen" type="text" value="%{est.urlimagen}"/>
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<h3>
					Editar datos establecimiento: <span>${est.nickbar}</span>
				</h3>
				
				<div class="form-group">
                    <label for="est.nombre">Nombre</label>
					<s:textfield cssClass="form-control" id="est.nombre" name="est.nombre" type="text" value="%{est.nombre}"/>
				</div>
				<div class="form-group">
					<label for="est.descrbar">Descripción</label>
					<s:textarea cssClass="form-control" id="est.descrbar" name="est.descrbar" type="text" value="%{est.descrbar}"/>
				</div>
				<div class="form-group">
					<label for="est.lat">Latitud</label>
					<s:textfield cssClass="form-control" id="est.lat" name="est.lat" type="number" value="%{est.lat}"/>
				</div>
				<div class="form-group">
					<label for="est.lng">Longitud</label>
					<s:textfield cssClass="form-control" id="est.lng" name="est.lng" type="number" value="%{est.lng}"/>
				</div>
				<div class="form-group">
					<label for="est.direccion">Dirección</label>
					<s:textarea cssClass="form-control" id="est.direccion" name="est.direccion" type="number" value="%{est.direccion}"/>
				</div> 
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
				
			</div>
		</form>
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
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>