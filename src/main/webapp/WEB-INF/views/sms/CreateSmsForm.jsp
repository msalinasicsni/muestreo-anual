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
						<div class="widget wgreen">
							<div class="widget-head">
								<div class="pull-left">
									<c:set var="method" value="post" />
									<fmt:message key="sms.new" />
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
											modelAttribute="sms" method="${method}" autocomplete="off"
											id="add-sms-form">
											<div class="form-group">
												<form:label class="col-lg-4 control-label"
													for="toNumber" path="toNumber">
													<fmt:message key="sms.num" />
												</form:label>
												<div class="col-lg-6">
													<form:input id="toNumber" path="toNumber"
														class="form-control" />
												</div>
											</div>
											<div class="form-group">
												<form:label class="col-lg-4 control-label"
													for="content" path="content">
													<fmt:message key="sms.content" />
												</form:label>
												<div class="col-lg-6">
													<form:input id="content" path="content"
														class="form-control" />
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-success">
													<i class="icon-ok"> <fmt:message key="sms.send" /></i>
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
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			if("${respuesta}"){
				noty({text:'<strong>'+ '${respuesta}'+'</strong>',layout:'topRight',type:'information',timeout:5000});
			}
			var form = $('#add-sms-form');
			form.validate({
                rules: {
                    //Datos generales
                	toNumber: {
                        required: true
                    },
                    content: {
                        required: true
                    }
                }
            });
		});
	</script>
</body>
</html>
