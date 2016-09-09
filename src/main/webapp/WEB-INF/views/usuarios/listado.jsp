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

				<!-- Table -->

				<div class="row">

					<div class="col-md-12">

						<div class="widget">

							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="users.list" />
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">
								<form action="<c:url value="/usuarios/admin/new" />">
									<div class="form-group">
										<div class="col-lg-offset-0 col-lg-9">
											<button type="submit" class="btn btn-primary">
												<fmt:message key="users.new" />
											</button>
										</div>
									</div>
									<div class="clearfix"></div>
								</form>
								<br />
								<table class="table table-striped table-bordered table-hover"
									id="tabla">
									<thead>
										<tr>
											<th><fmt:message key="users.username" /></th>
											<th><fmt:message key="users.desc" /></th>
											<th><fmt:message key="users.email" /></th>
											<th><fmt:message key="users.enabled" /></th>
											<th><fmt:message key="users.roles" /></th>
											<th><fmt:message key="actions" /></th>
										</tr>
									</thead>
									<c:forEach items="${usuarios}" var="usuario">
										<tr class="vigcom">
											<spring:url value="/usuarios/admin/{username}"
												var="usuarioUrl">
												<spring:param name="username" value="${usuario.username}" />
											</spring:url>
											<spring:url value="/usuarios/admin/{username}/edit"
												var="editUrl">
												<spring:param name="username" value="${usuario.username}" />
											</spring:url>
											<spring:url value="/usuarios/admin/{username}/disable"
												var="disableUrl">
												<spring:param name="username" value="${usuario.username}" />
											</spring:url>
											<spring:url value="/usuarios/admin/{username}/chgpass"
												var="chgpassUrl">
												<spring:param name="username" value="${usuario.username}" />
											</spring:url>
											<td><a href="${fn:escapeXml(usuarioUrl)}"><c:out
														value="${usuario.username}" /></a></td>
											<td><a href="${fn:escapeXml(usuarioUrl)}"><c:out
														value="${usuario.completeName}" /></a></td>
											<td><c:out value="${usuario.email}" /></td>
											<c:choose>
												<c:when test="${usuario.enabled}">
													<td><span class="label label-success"><c:out
																value="${usuario.enabled}" /></span></td>
												</c:when>
												<c:otherwise>
													<td><span class="label label-danger"><c:out
																value="${usuario.enabled}" /></span></td>
												</c:otherwise>
											</c:choose>
											<td><c:forEach var="rol" items="${usuario.authorities}">
													<c:out value="${rol.authId.authority}" />
												</c:forEach></td>
											<td>
												<div class="btn-group1">
													<button
														onclick="location.href='${fn:escapeXml(usuarioUrl)}'"
														class="btn btn-xs btn-success">
														<i class="icon-search"></i>
													</button>
													<button onclick="location.href='${fn:escapeXml(editUrl)}'"
														class="btn btn-xs btn-warning">
														<i class="icon-pencil"></i>
													</button>
													<button class="btn btn-xs btn-info"
														onclick="location.href='${fn:escapeXml(chgpassUrl)}'"
														class="btn btn-xs btn-warning">
														<i class="icon-lock"></i>
													</button>
													<button class="btn btn-xs btn-danger"
														onclick="location.href='${fn:escapeXml(disableUrl)}'"
														class="btn btn-xs btn-warning">
														<i class="icon-remove"></i>
													</button>
												</div>
											</td>
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