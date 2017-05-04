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
				<i class="icon-user"></i>
				<fmt:message key="users" />
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
						<div class="widget wgreen">
							<div class="widget-head">
								<div class="pull-left">
									<c:set var="method" value="post" />
									<fmt:message key="users.new" />
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
								<div class="widget-content">
									<div class="padd">
										<hr />
										<form:form class="form-horizontal" role="form"
											modelAttribute="user" method="${method}" autocomplete="off"
											id="add-user-form">
											<div class="form-group">
												<form:label class="col-lg-4 control-label" for="username"
													path="username">
													<fmt:message key="users.username" />
												</form:label>
												<div class="col-lg-6">
													<form:input id="username" path="username"
														class="form-control" />
													<form:errors path="username" cssClass="error" />
												</div>
											</div>
											<div class="form-group">
												<form:label class="col-lg-4 control-label"
													for="completeName" path="completeName">
													<fmt:message key="users.desc" />
												</form:label>
												<div class="col-lg-6">
													<form:input id="completeName" path="completeName"
														class="form-control" />
												</div>
											</div>
											<div class="form-group">
												<form:label class="col-lg-4 control-label" for="password"
													path="password">
													<fmt:message key="users.pass1" />
												</form:label>
												<div class="col-lg-6">
													<input id="password" name="password" class="form-control"
														type="password" />
												</div>
											</div>
											<div class="form-group">
												<form:label class="col-lg-4 control-label"
													for="confirm_password" path="password">
													<fmt:message key="users.pass2" />
												</form:label>
												<div class="col-lg-6">
													<input id="confirm_password" name="confirm_password"
														class="form-control" type="password" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label"><fmt:message
														key="permission" /></label>
												<div class="col-lg-8">
													<label class="checkbox-inline"> <form:checkbox
															path="muestra" /> <fmt:message key="muestra" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="vacunas" /> <fmt:message key="vacunas" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="consentimiento" /> <fmt:message
															key="consentimiento" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="recepcion" /> <fmt:message key="recepcion" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="visitas" /> <fmt:message key="visitas" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="obsequio" /> <fmt:message key="obsequio" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="pesoTalla" /> <fmt:message key="pesotalla" />
													</label>
													<label class="checkbox-inline"> <form:checkbox
															path="datosparto" /> <fmt:message key="datosparto" />
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label"><fmt:message
														key="encuestas" /></label>
												<div class="col-lg-8">
													<label class="checkbox-inline"> <form:checkbox
															path="encuestaCasa" /> <fmt:message key="ecasa" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="encuestaParticipante" /> <fmt:message
															key="eparticipante" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="encuestaLactancia" /> <fmt:message
															key="elactancia" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="encuestaSatisfaccion" /> <fmt:message
															key="esatisfaccion" />
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label"><fmt:message
														key="encuestas" /></label>
												<div class="col-lg-8">
													<label class="checkbox-inline"> <form:checkbox
															path="tamizajezika" /> <fmt:message key="user.tamzika" />
													</label> <label class="checkbox-inline"> <form:checkbox
															path="casazika" /> <fmt:message
															key="user.casazika" />
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label"><fmt:message
														key="users.enabled" /></label>
												<div class="col-lg-8">
													<label class="checkbox-inline"> <form:checkbox
															path="enabled" />
													</label>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-success">
													<i class="icon-ok"> <fmt:message key="users.save" /></i>
												</button>
												<button type="reset"
													onclick="location.href='/muestreo-anual/usuarios/admin/list'"
													class="btn btn-danger">
													<i class="icon-remove"> <fmt:message key="users.cancel" /></i>
												</button>
											</div>
										</form:form>
									</div>
								</div>
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
	<script>
		$()
				.ready(
						function() {
							jQuery.validator.addMethod("noSpace", function(
									value, element) {
								return value.indexOf(" ") < 0 && value != "";
							}, "No se permite espacio en blanco");
							// validate edit-user-form form on keyup and submit
							$("#add-user-form")
									.validate(
											{
												rules : {
													username : {
														required : true,
														noSpace : true,
														minlength : 5,
														maxlength : 50
													},
													completeName : {
														required : true,
														minlength : 5,
														maxlength : 250
													},
													email : {
														email : true
													},
													password : {
														required : true,
														noSpace : true,
														minlength : 4
													},
													confirm_password : {
														required : true,
														noSpace : true,
														minlength : 4,
														equalTo : "#password"
													},
													nivel : "required",
													region : "required"
												},
												messages : {
													username : {
														required : "Por favor ingrese nombre de usuario",
														minlength : "Debe contener al menos 5 caracteres",
														maxlength : "Debe contener máximo 50 caracteres"
													},
													completeName : {
														required : "Por favor ingrese descripción",
														minlength : "Debe contener al menos 5 caracteres",
														maxlength : "Debe contener máximo 250 caracteres"
													},
													email : {
														email : "Correo electrónico inválido"
													},
													password : {
														required : "Por favor ingrese contraseña",
														minlength : "Su contraseña debe tener como mínimo 4 caracteres"
													},
													confirm_password : {
														required : "Por favor ingrese nuevamente la contraseña",
														minlength : "Su contraseña debe tener como mínimo 4 caracteres",
														equalTo : "Las contraseñas deben coincidir"
													},
													nivel : "Es requerido",
													region : "Es requerido"
												}
											});
						});
	</script>
</body>
</html>
