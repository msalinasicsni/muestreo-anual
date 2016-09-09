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
				<i class="icon-tint"></i>
				<fmt:message key="samples.menu" />
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
								<div class="pull-left"><fmt:message key="pax" /></div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<!-- Curve chart (Blue color). jQuery Flot plugin used. -->
									<div id="curve-chart"></div>
									<div class="widget-foot"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">						
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="pbmc.lab" />
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
											<th><fmt:message key="tablas.fecha" /></th>
											<th><fmt:message key="tablas.total" /></th>
										</tr>
									</thead>
									<c:forEach items="${conteoPaxLab}" var="paxs">
										<tr>
											<td><c:out value="${paxs[0]}" /></td>
											<td><c:out value="${paxs[1]}" /></td>
										</tr>
									</c:forEach>
								</table>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-8">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="pax" />
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
									id="tabla1">
									<thead>
										<tr>
											<th><fmt:message key="tubo.codigo" /></th>
											<th><fmt:message key="tubo.fecha" /></th>
											<th><fmt:message key="trip" /></th>
											<th><fmt:message key="tubo.obs" /></th>
											<th><fmt:message key="tubo.lab" /></th>
										</tr>
									</thead>
									<c:forEach items="${labPaxs}" var="paxs">
										<tr>
											<td><c:out value="${paxs.labPaxId.codigo}" /></td>
											<td><c:out value="${paxs.fecreg}" /></td>
											<td><c:out value="${paxs.viaje}" /></td>
											<td><c:out value="${paxs.observacion}" /></td>
											<td><c:out value="${paxs.username}" /></td>
										</tr>
									</c:forEach>
								</table>
								<div class="widget-foot">
									<div class="clearfix"></div>
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
			$('#tabla').dataTable({
				"iDisplayLength" : 10,
				"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
						[ 5, 10, 25, 50, 100, "Todos" ] ]
			});
			$('#tabla1').dataTable({
				"iDisplayLength" : 10,
				"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
						[ 5, 10, 25, 50, 100, "Todos" ] ]
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {

			var paxs = [];
			var fechas = [];
			<c:forEach var="conteo" items="${conteoPaxLab}">
				fechas.push([ "${conteo[0]}" ]);
				paxs.push([ "${conteo[0]}", "${conteo[1]}" ]);
			</c:forEach>

			var plot = $.plot("#curve-chart", [ {
				data : paxs,
				label : "Total de muestras"
			}], {
				series : {
					lines: { show: true, fill: true},
					points : {
						show : true
					}
				},
				grid: { hoverable: true, clickable: true, borderWidth:0 },
				xaxis: {
					mode: "categories",
					tickLength: 0
				},
				colors: ["#658200"]
			});

			$("<div id='tooltip'></div>").css({
				position : "absolute",
				display : "none",
				border : "1px solid #fdd",
				padding : "2px",
				"background-color" : "#fee",
				opacity : 0.80
			}).appendTo("body");

			$("#curve-chart")
					.bind(
							"plothover",
							function(event, pos, item) {

								/*if ($("#enableTooltip:checked").length > 0) {*/
									if (item) {
										var x = item.datapoint[0], y = item.datapoint[1];
										$("#tooltip").html(
												fechas[x] + "<br/>" + "<strong>" + y + "</strong>").css({
											top : item.pageY + 5,
											left : item.pageX + 5
										}).fadeIn(200);
									} else {
										$("#tooltip").hide();
									}
								/*}*/
							});
		});
	</script>
</body>
</html>