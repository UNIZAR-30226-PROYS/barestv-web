<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Dar de alta" />
      <jsp:param name="active" value="1" />
</jsp:include>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Añadir establecimiento
			</h3>
			<form role="form" method="post" action="<s:url action="addUser"/>">
				<div class="form-group">
					<label for="usuario1">Usuario</label>
					<s:textfield cssClass="form-control" id="usuario1" name="usr.usuario" type="text" value="%{usr.usuario}"/>
				</div>
				
				<div class="form-group">
					<label for="password1">Contraseña</label>
					<s:textfield cssClass="form-control" id="password1" name="usr.password" type="password" value=""/>
				</div>
				
				<div class="form-group">
					<label for="password2">Repetir contraseña</label>
					<s:textfield cssClass="form-control" id="password2" name="password1" type="password" value=""/>
				</div>
				
				<button type="submit" class="btn btn-default center-block">Registrar</button>
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
  <!-- Fin mensajes verificacion -->
	<hr>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>