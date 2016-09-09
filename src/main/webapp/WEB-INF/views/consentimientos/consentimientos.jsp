<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />

	<div class="content">
		<!-- Main bar -->
		<div class="mainbar">

			<!-- Page heading -->
			<div class="page-head">
				<h2 class="pull-left">
					<i class="icon-pencil"></i>
					<fmt:message key="consents.menu" />
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

					<!-- Table -->

					<div class="row">

						<div class="col-md-12">

							<div class="widget">

								<div class="widget-head">
									<div class="pull-left">
										<fmt:message key="consentimientos.all" />
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
												<th><fmt:message key="consentimientos.codigo" /></th>
												<th><fmt:message key="consentimientos.fecha" /></th>
												<th><fmt:message key="consentimientos.partea" /></th>
												<th><fmt:message key="consentimientos.rechazo" /></th>
												<th><fmt:message key="consentimientos.parteb" /></th>
												<th><fmt:message key="consentimientos.partec" /></th>
												<th><fmt:message key="consentimientos.parted" /></th>
												<th><fmt:message key="consentimientos.partee" /></th>
												<th><fmt:message key="consentimientos.asen" /></th>
												<th><fmt:message key="consentimientos.firma" /></th>
												<th><fmt:message key="consentimientos.relfam" /></th>
												<th><fmt:message key="consentimientos.recurso" /></th>
											</tr>
										</thead>
										<c:forEach items="${consentimientos}" var="consentimientos">
											<tr>
												<td><c:out
														value="${consentimientos.reconsdenId.codigo}" /></td>
												<td><c:out
														value="${consentimientos.reconsdenId.fechaCons}" /></td>
												<td><c:out value="${consentimientos.parteADen}" /></td>
												<td><c:out value="${consentimientos.rechazoDen}" /></td>
												<td><c:out value="${consentimientos.parteBDen}" /></td>
												<td><c:out value="${consentimientos.parteCDen}" /></td>
												<td><c:out value="${consentimientos.parteDDen}" /></td>
												<td><c:out value="${consentimientos.parteEDen}" /></td>
												<td><c:out value="${consentimientos.asentimiento}" /></td>
												<td><c:out value="${consentimientos.firmcarta}" /></td>
												<td><c:out value="${consentimientos.relacionFam}" /></td>
												<td><c:out
														value="${consentimientos.movilInfo.recurso1}" /></td>
											</tr>
										</c:forEach>
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
	</div>
	<!-- Footer starts -->
	<jsp:include page="../fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('#tabla').dataTable();
		});
	</script>
</body>
</html>