<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Inicio" /> 
</jsp:include>
<!-- Cuando ocurre un error interno o de comunicaion -->
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2 style="text-align: center;"><s:text name="errorcabecera"/></h2>
				<p style="text-align: center;"><s:text name="errorcuerpo"/></p>
				<s:actionerror/>
			</div>
		</div>
	</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/>