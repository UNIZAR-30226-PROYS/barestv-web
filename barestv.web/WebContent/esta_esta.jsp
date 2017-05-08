<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Establecimiento" />
      <jsp:param name="active" value="0" />
</jsp:include>
	 <!-- Scripts google maps -->
	 <style type="text/css">
#map_canvas { height: 100% }
 div#gmap {
        width: 100%;
        height: 400px;
        border:double;
 }
</style>
  <script type="text/javascript"
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB8WhjZxlrqdbxh8k2-gZNxg91OsdxjUpw&sensor=false">
</script>
<script type="text/javascript">

    function initialize() {
        var myLatlng = new google.maps.LatLng(document.getElementById("est.lat").value,document.getElementById("est.lng").value );
        var myOptions = {
            zoom:17,
            center: myLatlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        map = new google.maps.Map(document.getElementById("gmap"), myOptions);
        // marker refers to a global variable
        marker = new google.maps.Marker({
            position: myLatlng,
            map: map
        });
        // if center changed then update lat and lon document objects
        google.maps.event.addListener(map, 'center_changed', function () {
            var location = map.getCenter();
            document.getElementById("est.lat").value = location.lat();

            document.getElementById("est.lng").value = location.lng();
            // call function to reposition marker location
            placeMarker(location);
        });
        // if zoom changed, then update document object with new info
        google.maps.event.addListener(map, 'zoom_changed', function () {
            zoomLevel = map.getZoom();
            document.getElementById("zoom_level").innerHTML = zoomLevel;
        });
        // double click on the marker changes zoom level
        google.maps.event.addListener(marker, 'dblclick', function () {
            zoomLevel = map.getZoom() + 1;
            if (zoomLevel == 20) {
                zoomLevel = 10;
            }
            document.getElementById("zoom_level").innerHTML = zoomLevel;
            map.setZoom(zoomLevel);
        });

        function placeMarker(location) {
            var clickedLocation = new google.maps.LatLng(location);
            marker.setPosition(location);
        }
    }
    window.onload = function () { initialize() };
</script>
		<h3>
					Usuario del establecimiento: <span>${est.nickbar}</span>
				</h3>
<form role="form" method="post" action="<s:url action="editEstablecimiento"/>">
	<div class="row">
		
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
				
				<h4>
					Datos del establecimiento:
				</h4>
				<div class="form-group">
                    <label for="est.nombre">Nombre</label>
					<s:textfield cssClass="form-control" id="est.nombre" name="est.nombre" type="text" value="%{est.nombre}"/>
				</div>
				<div class="form-group">
					<label for="est.descrbar">Descripción</label>
					<s:textarea cssClass="form-control" id="est.descrbar" name="est.descrbar" type="text" value="%{est.descrbar}"/>
				</div>
				
				<div class="form-group">
					<label for="est.direccion">Dirección</label>
					<s:textarea cssClass="form-control" id="est.direccion" name="est.direccion" type="number" value="%{est.direccion}"/>
				</div> 
				
				
				
			</div>
		
	</div>
	<div class="row">
		<div class="col-md-6">
			<div id="gmap" style="hight:400px;"></div>
		</div>
		<div class="col-md-6">
			<h4>
				Centra el marcador del mapa para seleccionar la latitud y longitud:
			</h4>
			<div class="form-group">
				<label for="est.lat">Latitud</label>
				<s:textfield cssClass="form-control" id="est.lat" name="est.lat" type="text" value="%{est.lat}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="est.lng">Longitud</label>
				<s:textfield cssClass="form-control" id="est.lng" name="est.lng" type="text" value="%{est.lng}" readonly="true"/>
			</div>
		</div>
	</div>
	<hr/>
	<div class="row">
		<div class="col-md-5">
			Presiona el siguiente boton para guardar todos los cambios:
		</div>
	    <div class="col-md-2">
		    <button type="submit" class="btn btn-default">
				Guardar
			</button>
	    </div>

		
	</div>
</form>	
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