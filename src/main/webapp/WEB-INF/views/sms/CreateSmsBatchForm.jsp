<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
<style type="text/css">
#edit-user-form {
	width: 800px;
}

#edit-user-form label.error {
	margin-left: 10px;
	width: auto;
	display: inline;
}
</style>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />
	<!-- Main bar -->
	<div class="mainbar">

		<!-- Page heading -->
		<div class="page-head">
			<h2 class="pull-left">
				<i class="icon-envelope"></i>
				<fmt:message key="sms" />
			</h2>

			<!-- Breadcrumb -->
			<div class="bread-crumb pull-right">
				<a href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i> <fmt:message key="home" /></a>
			</div>

			<div class="clearfix"></div>
		</div>
		<!-- Page heading ends -->
		<!-- Matter -->

		<div class="matter">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="sms.new" />
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<form class="form-horizontal" action="#" id="search_form">
										<div class="col-lg-offset-2 col-lg-8">
											<div class="form-group">
												<label class="col-lg-4 control-label">Barrio:</label>
			                                  	<div class="col-lg-4">
				                                    <select class="form-control" name="cmbBarrio" id="cmbBarrio">
				                                    	<option value=""></option>
				                                    	<c:forEach items="${barrios}" var="barrio">
															<option value="${barrio.barrio}">${barrio.nombreBarrio}</option>
														</c:forEach>
			            	                        </select>
			                	                </div>
			                	           	</div>
			                	           	<div class="form-group">
			                	                <label class="col-lg-4 control-label">Tipo Tubo:</label>
			                                  	<div class="col-lg-4">
				                                    <select class="form-control" name="cmbTubo" id="cmbTubo">
				                                    	<option value=""></option>
				                                    	<option value="Si">Tubo PBMC</option>
				                                    	<option value="No">Tubo Rojo</option>
			            	                        </select>
			                	                </div>
			                	            </div>
			                	            <div class="form-group">
			                	                <label class="col-lg-4 control-label">Estudio:</label>
			                                  	<div class="col-lg-4">
				                                    <select class="form-control" name="cmbEstudio" id="cmbEstudio">
				                                    	<option value=""></option>
				                                    	<option value="%">Todos</option>
				                                    	<option value="Cohorte BB">Cohorte BB</option>
				                                    	<option value="Influenza">Influenza</option>
				                                    	<option value="Influenza  Cohorte BB">Influenza  Cohorte BB</option>
				                                    	<option value="Dengue">Dengue</option>
				                                    	<option value="Dengue  Influenza">Dengue  Influenza</option>
				                                    	<option value="Chikungunya">Chikungunya</option>
			            	                        </select>
			                	                </div>
											</div>
											<div class="form-group">
			                	                <label class="col-lg-4 control-label">Edad:</label>
			                                  	<div class="col-lg-4">
				                                    <select class="form-control" name="cmbEdad" id="cmbEdad">
				                                    	<option value=""></option>
				                                    	<option value="%">Todos</option>
				                                    	<option value="<2">De seis meses a dos años</option>
				                                    	<option value=">2">Mayor de dos años</option>
			            	                        </select>
			                	                </div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label">Mensaje:</label>
			                                  	<div class="col-lg-4">
				                                    <select class="form-control" name="cmbMensaje" id="cmbMensaje">
				                                    	<option value=""></option>
				                                    	<c:forEach items="${mensajes}" var="mensaje">
															<option value="${mensaje[0]}">${mensaje[1]}</option>
														</c:forEach>
			            	                        </select>
			                	                </div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-8">
												<button id="viewPart" class="btn btn-info"><i class="icon-search"> <fmt:message key="view" /></i></button>
												<button id="sendSmd" type="button" disabled class="btn btn-success"><i class="icon-ok"> <fmt:message key="sms.send" /></i></button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="widget">

							<div class="widget-head">
								<div class="pull-left">
									Lista de participantes con teléfono
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">
								<br />
								<table class="table table-striped table-bordered table-hover"
									id="tabla">
									<thead>
										<tr>
											<th>Codigo</th>
											<th>Nombre</th>
											<th>Apellido</th>
											<th>Edad (meses)</th>
											<th>Teléfono</th>
											<th>Estudio</th>
										</tr>
									</thead>
								</table>
								<div class="widget-foot"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Matter ends -->
		</div>
		<!-- Mainbar ends -->
		<div class="clearfix"></div>

	</div>

	<!-- Content ends -->
	<!-- Footer starts -->
	<jsp:include page="../fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<spring:url value="/resources/scripts/sms.js" var="smsSearch" />
	<script src="${smsSearch}"></script>
	<spring:url value="/sms/admin/sms2" var="smsUrl"/>
	<spring:url value="/sms/admin/smssend" var="smsSendUrl"/>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
			var parametros = {smsUrl: "${smsUrl}",
					smsSendUrl: "${smsSendUrl}"};
			Sms.init(parametros);
		});
	</script>
</body>
</html>
