<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Login" />
      <jsp:param name="active" value="-1" />
</jsp:include>

<div class="row">
	<div class="col-sm-6 col-md-4 col-md-offset-2">
		<h3>Login</h3>
		<form role="form" method="post" action="<s:url action="logearse"/>">
			<div class="form-group">
				<label for="usuario">Usuario</label> 
				<s:textfield cssClass="form-control" id="usuario" name="usuario" value="%{usuario}"/>
			</div>
			
			<div class="form-group">
				<label for="password">Contraseña</label>
				<s:textfield cssClass="form-control" id="password" name="password" type="password" value="%{password}"/>
			</div>
			<button type="submit" class="btn btn-default center-block">Entrar</button>
		</form>
	</div>
	<div class="col-sm-6 col-md-4">
		<h3>Registrar</h3>
		<form role="form" method="post" action="<s:url action="logearse"/>">
			<div class="form-group">
				<label for="usuario1">Usuario</label>
				<s:textfield cssClass="form-control" id="usuario1" name="usuario1" type="text" value="%{usuario1}"/>
			</div>
			
			<div class="form-group">
				<label for="password1">Contraseña</label>
				<s:textfield cssClass="form-control" id="password1" name="password1" type="password" value="%{password1}"/>
			</div>
			
			<div class="form-group">
				<label for="password2">Repetir contraseña</label>
				<s:textfield cssClass="form-control" id="password2" name="password2" type="password" value="%{password2}"/>
			</div>
			
			<div class="form-group">
				<label for="establecimiento">Establecimiento</label>
				<s:textfield cssClass="form-control" id="establecimiento" name="establecimiento" type="text" value="%{establecimiento}"/>
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
                          <h4><s:text name="sorry"/></h4> <strong><s:actionerror/></strong>.
                      </div>
                  </s:if>
                  <s:if test="hasActionMessages()">
                      <!-- Mensaje de exito -->
                      <div class="alert alert-dismissable alert-success">
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                              ×
                          </button>
                          <h4><s:text name="Cuentacreadaconexito"/></h4> <strong><s:text name="Felicidades"/></strong> <s:text name="Yapuedesiniciarsesion"/>。
                      </div>
                  </s:if>
              </div>
              <div class="col-md-3">
              </div>
          </div>
      </div>
  </div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>