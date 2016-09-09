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
					<i class="icon-fire"></i>
					<fmt:message key="temp.menu" />
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
										<fmt:message key="temp.pbmc.out" />
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
												<th><fmt:message key="temp.fecha" /></th>
												<th><fmt:message key="temp.recurso" /></th>
												<th><fmt:message key="temp.temp" /></th>
												<th><fmt:message key="temp.lugar" /></th>
												<th><fmt:message key="temp.obs" /></th>
												<th><fmt:message key="temp.sup" /></th>
											</tr>
										</thead>
										<c:forEach items="${pbmcsfuera}" var="temps">
											<tr>
												<td><c:out value="${temps.tempPbmcId.fechaTempPbmc}" /></td>
												<td><c:out value="${temps.tempPbmcId.recurso}" /></td>
												<td><c:out value="${temps.temperatura}" /></td>
												<td><c:out value="${temps.lugar}" /></td>
												<td><c:out value="${temps.observacion}" /></td>
												<td><c:out value="${temps.username}" /></td>
											</tr>
										</c:forEach>
									</table>
									<div class="widget-foot"></div>
								</div>
							</div>
							<div class="widget">

								<div class="widget-head">
									<div class="pull-left">
										<fmt:message key="temp.rojo.out" />
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
										id="tabla2">
										<thead>
											<tr>
												<th><fmt:message key="temp.fecha" /></th>
												<th><fmt:message key="temp.recurso" /></th>
												<th><fmt:message key="temp.temp" /></th>
												<th><fmt:message key="temp.lugar" /></th>
												<th><fmt:message key="temp.obs" /></th>
												<th><fmt:message key="temp.sup" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${rojosfuera}" var="temps">
												<tr>
													<td><c:out
															value="${temps.tempRojoBhcId.fechaTempRojoBhc}" /></td>
													<td><c:out value="${temps.tempRojoBhcId.recurso}" /></td>
													<td><c:out value="${temps.temperatura}" /></td>
													<td><c:out value="${temps.lugar}" /></td>
													<td><c:out value="${temps.observacion}" /></td>
													<td><c:out value="${temps.username}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="widget-foot"></div>
								</div>
							</div>
							<div class="widget">
								<div class="widget-head">
									<div class="pull-left">
										<fmt:message key="temp.pbmc.all" />
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
										id="tabla3">
										<thead>
											<tr>
												<th><fmt:message key="temp.fecha" /></th>
												<th><fmt:message key="temp.recurso" /></th>
												<th><fmt:message key="temp.temp" /></th>
												<th><fmt:message key="temp.lugar" /></th>
												<th><fmt:message key="temp.obs" /></th>
												<th><fmt:message key="temp.sup" /></th>
											</tr>
										</thead>
										<c:forEach items="${tPbmc}" var="temps">
											<tr>
												<td><c:out value="${temps.tempPbmcId.fechaTempPbmc}" /></td>
												<td><c:out value="${temps.tempPbmcId.recurso}" /></td>
												<td><c:out value="${temps.temperatura}" /></td>
												<td><c:out value="${temps.lugar}" /></td>
												<td><c:out value="${temps.observacion}" /></td>
												<td><c:out value="${temps.username}" /></td>
											</tr>
										</c:forEach>
									</table>
									<div class="widget-foot"></div>
								</div>


							</div>

							<div class="widget">

								<div class="widget-head">
									<div class="pull-left">
										<fmt:message key="temp.rojo.all" />
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
										id="tabla4">
										<thead>
											<tr>
												<th><fmt:message key="temp.fecha" /></th>
												<th><fmt:message key="temp.recurso" /></th>
												<th><fmt:message key="temp.temp" /></th>
												<th><fmt:message key="temp.lugar" /></th>
												<th><fmt:message key="temp.obs" /></th>
												<th><fmt:message key="temp.sup" /></th>
											</tr>
										</thead>
										<c:forEach items="${tRojo}" var="temps">
											<tr>
												<td><c:out
														value="${temps.tempRojoBhcId.fechaTempRojoBhc}" /></td>
												<td><c:out value="${temps.tempRojoBhcId.recurso}" /></td>
												<td><c:out value="${temps.temperatura}" /></td>
												<td><c:out value="${temps.lugar}" /></td>
												<td><c:out value="${temps.observacion}" /></td>
												<td><c:out value="${temps.username}" /></td>
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
		$(document).ready(
				function() {
					$('#tabla').dataTable(
							{
								"iDisplayLength" : 5,
								"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "Todos" ] ]
							});
					$('#tabla2').dataTable(
							{
								"iDisplayLength" : 5,
								"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "Todos" ] ]
							});
					$('#tabla3').dataTable(
							{
								"iDisplayLength" : 5,
								"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "Todos" ] ]
							});
					$('#tabla4').dataTable(
							{
								"iDisplayLength" : 5,
								"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "Todos" ] ]
							});
				});
	</script>
</body>
</html>