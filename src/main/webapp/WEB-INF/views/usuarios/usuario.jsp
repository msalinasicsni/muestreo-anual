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
									<fmt:message key="users.user" />
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">
								<h3>
									<c:out value="${SUCCESS}" />
								</h3>
								<c:set var="rolesString">
									<c:forEach var="rol" items="${user.authorities}">
										<c:out value="${rol.authId.authority}" />
									</c:forEach>
								</c:set>
								<br />
								<table class="table table-striped table-bordered table-hover"
									id="tabla">
									<tr>
										<th><fmt:message key="users.username" /></th>
										<td><b><c:out value="${user.username}" /></b></td>
									</tr>
									<tr>
										<th><fmt:message key="users.desc" /></th>
										<td><c:out value="${user.completeName}" /></td>
									</tr>
									<tr>
										<th><fmt:message key="users.enabled" /></th>
										<td><c:out value="${user.enabled}" /></td>
									</tr>
									<tr>
										<th><fmt:message key="users.roles" /></th>
										<td><c:out value="${rolesString}" /></td>
									</tr>

								</table>
								<div class="widget-foot">
									<table class="table table-striped table-bordered table-hover"
										id="tabla">
										<tr class="warning">
											<td><spring:url value="{username}/edit" var="editUrl">
													<spring:param name="username" value="${user.username}" />
												</spring:url>
												<button onclick="location.href='${fn:escapeXml(editUrl)}'"
													class="btn btn-info">
													<fmt:message key="users.edit" />
												</button>
											<td><spring:url value="{username}/chgpass"
													var="chgpassUrl">
													<spring:param name="username" value="${user.username}" />
												</spring:url>
												<button
													onclick="location.href='${fn:escapeXml(chgpassUrl)}'"
													class="btn btn-info">
													<fmt:message key="users.changepass" />
												</button> <c:choose>
													<c:when test="${user.enabled}">
														<td><spring:url value="{username}/disable"
																var="disableUrl">
																<spring:param name="username" value="${user.username}" />
															</spring:url>
															<button
																onclick="location.href='${fn:escapeXml(disableUrl)}'"
																class="btn btn-info">
																<fmt:message key="users.disable" />
															</button>
													</c:when>
													<c:otherwise>
														<td><spring:url value="{username}/enable"
																var="enableUrl">
																<spring:param name="username" value="${user.username}" />
															</spring:url>
															<button
																onclick="location.href='${fn:escapeXml(enableUrl)}'"
																class="btn btn-info">
																<fmt:message key="users.enable" />
															</button>
													</c:otherwise>
												</c:choose>
											<td><spring:url value="/usuarios/admin/list"
													var="listUrl"></spring:url>
												<button onclick="location.href='${fn:escapeXml(listUrl)}'"
													class="btn btn-info">
													<fmt:message key="users.list" />
												</button></td>
										</tr>
										<tr class="info">
											<c:choose>
												<c:when test="${fn:contains(rolesString,'ROLE_ADMIN')}">
													<td><spring:url value="{username}/noadmin"
															var="noadminUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button
															onclick="location.href='${fn:escapeXml(noadminUrl)}'"
															class="btn btn-danger">
															<fmt:message key="users.noadmin" />
														</button>
												</c:when>
												<c:otherwise>
													<td><spring:url value="{username}/mkadmin"
															var="adminUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button
															onclick="location.href='${fn:escapeXml(adminUrl)}'"
															class="btn btn-success">
															<fmt:message key="users.admin" />
														</button>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${fn:contains(rolesString,'ROLE_SUPER')}">
													<td><spring:url value="{username}/nosup"
															var="nosupUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button
															onclick="location.href='${fn:escapeXml(nosupUrl)}'"
															class="btn btn-danger">
															<fmt:message key="users.nosup" />
														</button>
												</c:when>
												<c:otherwise>
													<td><spring:url value="{username}/mksup" var="supUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button onclick="location.href='${fn:escapeXml(supUrl)}'"
															class="btn btn-success">
															<fmt:message key="users.sup" />
														</button>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${fn:contains(rolesString,'ROLE_WEB')}">
													<td><spring:url value="{username}/noweb"
															var="nowebUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button
															onclick="location.href='${fn:escapeXml(nowebUrl)}'"
															class="btn btn-danger">
															<fmt:message key="users.noweb" />
														</button>
												</c:when>
												<c:otherwise>
													<td><spring:url value="{username}/mkweb" var="webUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button onclick="location.href='${fn:escapeXml(webUrl)}'"
															class="btn btn-success">
															<fmt:message key="users.web" />
														</button>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${fn:contains(rolesString,'ROLE_MOVIL')}">
													<td><spring:url value="{username}/noterr"
															var="noterrUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button
															onclick="location.href='${fn:escapeXml(noterrUrl)}'"
															class="btn btn-danger">
															<fmt:message key="users.noterr" />
														</button>
												</c:when>
												<c:otherwise>
													<td><spring:url value="{username}/mkterr"
															var="terrUrl">
															<spring:param name="username" value="${user.username}" />
														</spring:url>
														<button onclick="location.href='${fn:escapeXml(terrUrl)}'"
															class="btn btn-success">
															<fmt:message key="users.terr" />
														</button>
												</c:otherwise>
											</c:choose>
											<td></td>
										</tr>
									</table>
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
			$('#tabla').dataTable();
		});
	</script>
</body>
</html>