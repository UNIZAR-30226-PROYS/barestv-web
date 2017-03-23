<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Login" /> 
</jsp:include>

<!-- Iniciar sesion y registro -->
    <div class="row">
        <div class="col-md-6">
            <!-- Zona iniciar sesion -->
            <div class="row" style="border-right-color: black;border-right-style: inset;">
                <div class="col-md-2">
                </div>
                <div class="col-md-9">
                    <h3 style="text-align: center;margin-bottom:40px;"><s:text name="iniciarSesion"/></h3>
                    <form role="form" action="<s:url action="logearse"/>" method="post" onsubmit="cript()">
                        <div class="form-group">
                             
                            <label for="usuario.correo"><s:text name="dirCorreo"/></label>
                            <s:textfield id="usuario.correo" name="usuario.correo" cssClass="form-control" type="email" value="%{usuario.correo}"/>
            
                        </div>
                        <div class="form-group">
                             
                            <label for="usuario.contrasenya"><s:text name="contrasenya"/></label>
                            <s:textfield id="usuario.contrasenya" name="usuario.contrasenya" cssClass="form-control" type="password" value="%{usuario.contrasenya}"/>
                            
                        </div>
                        <button type="submit" class="btn btn-primary"><s:text name="entrar"/></button>
                    </form>
                </div>
                <div class="col-md-1">
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <!-- Zona registrar -->
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-9">
                    <h3 style="text-align: center;margin-bottom:40px;"><s:text name="registro"/></h3>
                    <form role="form" action="<s:url action="registrarse"/>" method="post" onsubmit="cript()">
                        <div class="form-group">
                             
                            <label for="usr.nick"><s:text name="nick"/></label>
                            <s:textfield id="usr.nick" cssClass="form-control" type="text" name="usr.nick" value="%{usr.nick}"/>
                        </div>
                        <div class="form-group">
                             <label for="usr.nombre"><s:text name="nombre"/></label>
                            <s:textfield id="usr.nombre" cssClass="form-control" type="text" name="usr.nombre" value="%{usr.nombre}"/>
                        </div>
                        <div class="form-group">
                             
                            <label for="usr.apellido"><s:text name="apellido"/></label>
                            <s:textfield id="usr.apellido" cssClass="form-control" type="text" name="usr.apellido" value="%{usr.apellido}"/>
                        </div>
                        <div class="form-group">
                             
                            <label for="usr.correo"><s:text name="correo"/></label>
                            <s:textfield id="usr.correo" cssClass="form-control" type="email" name="usr.correo" value="%{usr.correo}"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="usr.contrasenya"><s:text name="contrasenya"/></label>
                            <s:textfield id="usr.contrasenya" cssClass="form-control" type="password" name="usr.contrasenya" value="%{usr.contrasenya}"/>
                        </div>
                        <div class="form-group">
                             
                            <label for="contrasenya2"><s:text name="segundaContrasenya"/></label>
                            <s:textfield id="contrasenya2" cssClass="form-control" type="password" name="contrasenya2" value="%{contrasenya2}"/>
                        </div>
                        
                        
                        
                        <button type="submit" class="btn btn-primary "><s:text name="crear"/></button>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
            </div>
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
    <script src="js/rollups/md5.js"></script>
	<script src="js/components/enc-base64-min.js"></script>
	<script>
    function cript(){
        var pass = CryptoJS.MD5(document.getElementById('usr.contrasenya').value);
        var pass2 = CryptoJS.MD5(document.getElementById('contrasenya2').value);
        var pass3 = CryptoJS.MD5(document.getElementById('usuario.contrasenya').value);
        var passString = pass.toString();
        var passString2 = pass2.toString();
        var passString3 = pass3.toString();
        console.log(passString);
        console.log(passString2);
        console.log(passString3);
        document.getElementById('usr.contrasenya').value = passString;
        document.getElementById('contrasenya2').value = passString2;
        document.getElementById('usuario.contrasenya').value = passString3;
    }
</script>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/>
