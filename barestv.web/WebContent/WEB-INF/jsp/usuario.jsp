<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Mi cuenta" /> 
</jsp:include>

<!-- Contenido -->
    <div class="row" style="margin-bottom:10px;">
        <div class="col-md-12">
            <h1 class="text-center">
                <s:text name="Micuenta"/>
            </h1>
        </div>
    </div>
    <br/>
    <div class="row" >
        <!-- Tabla de productos en venta -->
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="background-color: #efefef;">
            <h3 style="text-align:center;">
                <s:text name="Misproductosenlatienda"/>
            </h3>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>
                            #
                        </th>
                        <th>
                            <s:text name="Nombre"/>
                        </th>
                        <th>
                            <s:text name="Precio"/>
                        </th>
                        <th>
                            <s:text name="Fecha"/>
                        </th>
                        <th>
                            <s:text name="Accion"/>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="lista">
                        <!-- Mostar tabla -->
                        <tr class="active">
                            <td>
                                <s:property value="idProducto"/>
                            </td>
                            <td>
                                <s:url action="mostrarProducto" var="urlTag" >
                                    <s:param name="idProducto"><s:property value="idProducto"/></s:param>
                                </s:url>
                                <a href="<s:property value="#urlTag" />"><s:property value="nombre"/></a>
                            </td>
                            <td>
                                <s:property value="precio"/>€
                            </td>
                            <td>
                                <s:property value="fechaPublicacion"/>
                            </td>
                            <td>
                                <!-- Botones de editar y eliminar -->
                                <form style="display: inline-block;" action="<s:url action="mostrarEditarProducto"/>" method="post">
                                <input type="hidden" name="producto.idProducto" value="<s:property value="idProducto"/>"/>
                                <button type="submit" class="btn btn-warning btn-xs"><s:text name="Editar"/></button>
                                </form>
                                <form style="display: inline-block;" action="<s:url action="borrarProducto"/>" method="post">
                                <input type="hidden" name="producto.idProducto" value="<s:property value="idProducto"/>"/>
                                <button type="submit" class="btn btn-danger btn-xs"><s:text name="Eliminar"/></button>
                                </form>
                                
                                
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            
            <!-- Anyadir producto -->
            <form method="post" action="<s:url action="mostrarCrearProducto"/>">
               <button type="submit" type="button" class="btn btn-primary"><s:text name="AnyadirProducto"/></button>
            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
    <br/>

    <!-- Historial -->
    <div class="row" >
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="background-color: #efefef;">
            <h3 style="margin-bottom:20px;text-align:center;">
                <s:text name="Historialdeacciones"/>
            </h3>
            <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
                <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>&nbsp;
                <span></span> <b class="caret"></b>
            </div>
            <form id='filtro' action='<s:url action="mostrarCuenta"/>' method="post">
        
                <input type='hidden' name='fecha1' id="fecha1" />
                <input type='hidden' name='fecha2' id="fecha2" />   
            </form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>
                            #
                        </th>
                        <th>
                            <s:text name="Fecha"/>
                        </th>
                        <th>
                            <s:text name="Actividad"/>
                        </th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="filtrado" var="historial">
                    <tr class="active">
                        <td>
                            <s:property value="getIdEvento()"/>
                        </td>
                        <td>
                             <s:property value="getFecha()"/>
                            
                        </td>
                        <td>
                             <s:property value="getEvento()"/>
                        </td>
                        
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-md-3">
        </div>
    </div>
    <br/>

    <!-- Datos de la cuenta -->
    <div class="row" >
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="background-color: #efefef;">
            <h3 id="actualizar" style="text-align:center;">
                <s:text name="Editardatosdelacuenta"/>
            </h3>
            <form role="form" action='<s:url action="actualizarCuenta"/>' method="post" onsubmit="cript()">
                <div class="form-group">
                     
                    <label for="exampleInputEmail1">
                        <s:text name="correo"/>
                    </label>
                    <input class="form-control" name="correo" id="exampleInputEmail1" type="email" value="<s:property value="user.correo" />" />
                </div>
                <div class="form-group">
                     
                    <label for="pass1">
                        <s:text name="contrasenya"/>
                    </label>
                    <input class="form-control" name="pass1" id="pass1" type="password" value="<s:property value="user.contrasenya" />"/>
                </div>
                <div class="form-group">
                     
                    <label for="pass2">
                        <s:text name="segundaContrasenya"/>
                    </label>
                    <input class="form-control" name="pass2" id="pass2" type="password" value="<s:property value="user.contrasenya" />"/>
                </div>
                <div class="form-group">
                     
                    <label for="exampleInputFile">
                        <s:text name="Imagen"/> 
                    </label>
                    <input class="form-control" name="imagen" id="exampleInputFile" type="text" value="<s:property value="user.imagen" />"/>
                    <p class="help-block">
                        <s:text name="url"/>
                    </p>
                </div>
                
                <button type="submit" class="btn btn-success">
                    <s:text name="Actualizar"/>
                </button>
            </form>
            
        </div>
        <div class="col-md-3">
        </div>
    </div>
    <br/>

    <!-- Eliminar cuenta -->
    <div class="row" >
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="background-color: #efefef;">
            <h3 style="text-align:center;">
                <s:text name="Eliminarcuenta"/>
            </h3>
            <p>
                <s:text name="Avisoeliminarcuenta"/>
            </p>
            
            <button  class="btn btn-danger" data-toggle="modal" data-target="#EliminaCuenta">
                <s:text name="Eliminarcuenta"/>
            </button>
            <br/>
            <br/>
            
                            
            <div class="modal fade" id="EliminaCuenta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel"><s:text name="Eliminarcuentadefinitivamente"/></h4>
                        </div>
                        <div class="modal-body">
                            <p> <s:text name="Avisodefinitivo"/>
                            </p>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="Cancelar"/></button>
                        
                            
                            <form style="display:inline;" action="<s:url action="eliminarCuenta"/>" method="post">
                                <button class="btn btn-primary" type="submit">
                                    <s:text name="Aceptar"/>
                                </button>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
    
        </div>
        <div class="col-md-3">
        </div>
    </div>
    <br/>
    
    <!-- fin contenido -->
    
    <!-- -->
    <!-- Include Required Prerequisites -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
     
    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
    
    <!--  --> 
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="https://cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <script type="text/javascript">
        $(function() {
            <s:if test='fecha1 != ""'>
                var start =  moment("<s:property value="fecha1"/>", "DD-MM-YY");
                var end =  moment("<s:property value="fecha2"/>", "DD-MM-YY");
            </s:if>
            <s:else>
                var start = moment().subtract(29, 'days');
                var end = moment();
            </s:else>
            function cb(start, end) {
                $('#reportrange span').html(start.format("DD/MM/YY") + ' - ' + end.format("DD/MM/YY"));
            }

            $('#reportrange').daterangepicker({
                startDate: start,
                endDate: end,
                ranges: {
                   'Hoy': [moment(), moment()],
                   'Ayer': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                   'Ultimos 7 dias': [moment().subtract(6, 'days'), moment()],
                   'Ultimos 30 dias': [moment().subtract(29, 'days'), moment()],
                   'Este mes': [moment().startOf('month'), moment().endOf('month')],
                   'Mes pasado': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                }
            }, cb);

            cb(start, end);
            
            $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
                    
                  console.log(picker.startDate.format('YYYY-MM-DD'));
                  console.log(picker.endDate.format('YYYY-MM-DD'));
                  $('#fecha1').val(picker.startDate.format('DD-MM-YY'));
                  $('#fecha2').val(picker.endDate.format('DD-MM-YY'));
                  $('#filtro').submit();
            });
            
        });
    </script>
    <script src="js/rollups/md5.js"></script>
	<script src="js/components/enc-base64-min.js"></script>
	<script>
    function cript(){
        var pass = CryptoJS.MD5(document.getElementById('pass1').value);
        var pass2 = CryptoJS.MD5(document.getElementById('pass2').value);
        
        var passString = pass.toString();
        var passString2 = pass2.toString();
        
        console.log(passString);
        console.log(passString2);
        
        document.getElementById('pass1').value = passString;
        document.getElementById('pass2').value = passString2;
        
    }
</script>    
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/>