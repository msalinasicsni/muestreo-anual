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
								<div class="pull-left"><fmt:message key="temp.pbmc.all" /></div>
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
					<div class="col-md-5">						
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
									id="tabla">
									<thead>
										<tr>
											<th><fmt:message key="tablas.fecha" /></th>
											<th><fmt:message key="count" /></th>
											<th><fmt:message key="min" /></th>
											<th><fmt:message key="avg" /></th>
											<th><fmt:message key="max" /></th>
										</tr>
									</thead>
									<c:forEach items="${conteoTemps}" var="cuenta">
										<tr>
											<td><c:out value="${cuenta[0]}" /></td>
											<td><c:out value="${cuenta[1]}" /></td>
											<td><c:out value="${cuenta[4]}" /></td>
											<td><c:out value="${cuenta[5]}" /></td>
											<td><c:out value="${cuenta[6]}" /></td>
										</tr>
									</c:forEach>
								</table>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-7">
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
									id="tabla1">
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
										<c:forEach items="${temps}" var="temps">
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

			var tmin = [];
			var tavg = [];
			var tmax = [];
			var limi = [];
			var lims = [];
			var fechas = [];
			<c:forEach var="datos" items="${conteoTemps}">
				fechas.push([ "${datos[0]}" ]);
				limi.push([ "${datos[0]}", "${datos[2]}" ]);
				lims.push([ "${datos[0]}", "${datos[3]}" ]);
				tmin.push([ "${datos[0]}", "${datos[4]}" ]);
				tavg.push([ "${datos[0]}", "${datos[5]}" ]);
				tmax.push([ "${datos[0]}", "${datos[6]}" ]);
			</c:forEach>

			var plot = $.plot("#curve-chart", [ {
				data : limi,
				label : "Lim Inf"
			},{
				data : tmin,
				label : "Temp Min"
			},{
				data : tavg,
				label : "Temp Prom"
			},{
				data : tmax,
				label : "Temp Max"
			},{
				data : lims,
				label : "Lim Sup"
			}], {
				series : {
					lines: { show: true, fill: false},
					points : {
						show : true
					}
				},
				grid: { hoverable: true, clickable: true, borderWidth:0 },
				xaxis: {
					mode: "categories",
					tickLength: 0
				},
				colors: ["#a0294c", "#f2c319", "#658200", "#008282","#a0294c"]
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