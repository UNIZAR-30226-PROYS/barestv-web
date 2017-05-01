<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Usuario" />
      <jsp:param name="active" value="-2" />
</jsp:include>

	<div class="row">
		<div class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
			<h3>
				Cambiar contraseña
			</h3>
			<form role="form" method="post" action="<s:url action="newPassword"/>" onsubmit="cript()">
				<div class="form-group">
					 
					<label for="old">
						Antigua contraseña
					</label>
					<s:textfield cssClass="form-control" id="old" name="old" type="password"/>

				</div>
				<div class="form-group">
					 
					<label for="new1">
						Nueva constraseña
					</label>
					<s:textfield cssClass="form-control" id="new1" name="new1" type="password"/>
				</div>
				<div class="form-group">
					 
					<label for="new2">
						Repetir contraseña
					</label>
					<s:textfield cssClass="form-control" id="new2" name="new2" type="password"/>
				</div>
				<button type="submit" class="btn btn-default center-block">
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
    <script src="js/rollups/md5.js"></script>
<script src="js/components/enc-base64-min.js"></script>
<script>
	$( document ).ready(function() {
	  // Handler for .ready() called.
		document.getElementById('old').value = "";
	    document.getElementById('new1').value = "";
	    document.getElementById('new2').value = "";
	});
		
	
   function cript(){
       var pass = CryptoJS.MD5(document.getElementById('old').value);
       var pass2 = CryptoJS.MD5(document.getElementById('new1').value);
       var pass3 = CryptoJS.MD5(document.getElementById('new2').value);
       var passString = pass.toString();
       var passString2 = pass2.toString();
       var passString3 = pass3.toString();
     	//alert(passString);
       //console.log(passString2);
       //console.log(passString3);
       document.getElementById('old').value = passString;
       document.getElementById('new1').value = passString2;
       document.getElementById('new2').value = passString3;
   }
</script>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>