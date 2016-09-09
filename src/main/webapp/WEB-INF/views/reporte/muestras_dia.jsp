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
<spring:url value="/resources/plugins/data-tables/TableTools/css/dataTables.tableTools.css" var="dtttcss" />
<link rel="stylesheet" href="${dtttcss}"/>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />
	<!-- Main bar -->
	<div class="mainbar">

		<!-- Page heading -->
		<div class="page-head">
			<h2 class="pull-left">
				<i class="icon-ok"></i>
				<fmt:message key="informe" />
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
									<fmt:message key="reps.sxday" />
								</div>
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
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">						
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="reps.sxday" />
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
											<th><fmt:message key="samples.pbmc" /></th>
											<th><fmt:message key="samples.red" /></th>
										</tr>
									</thead>
									<c:forEach items="${muestrasDia}" var="conteo">
										<tr>
											<td><c:out value="${conteo[0]}" /></td>
											<td><c:out value="${conteo[1]}" /></td>
											<td><c:out value="${conteo[2]}" /></td>
											<td><c:out value="${conteo[3]}" /></td>
										</tr>
									</c:forEach>
								</table>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>					
					<div class="col-md-4">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left"><fmt:message key="summary" /></div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<!-- Visitors, pageview, bounce rate, etc., Sparklines plugin used -->
									<ul class="current-status">
										<li><span id="todayspark2"></span> <span class="bold"><fmt:message
													key="summary.rojo" /> : <input id="trojo" name="trojo" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
										<li><span id="todayspark3"></span> <span class="bold"><fmt:message
													key="summary.pbmc" /> : <input id="tpbmc" name="tpbmc" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
										<li><span id="todayspark6"></span> <span class="bold"><fmt:message
													key="tablas.total" /> : <input id="ttotal" name="ttotal" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
									</ul>
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
	<spring:url value="/resources/plugins/data-tables/TableTools/js/dataTables.tableTools.js" var="dataTablesTT" />
	<script type="text/javascript" src="${dataTablesTT}"></script>
	<spring:url value="/resources/plugins/data-tables/TableTools/swf/copy_csv_xls_pdf.swf" var="dataTablesTTSWF" />
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			var table1 = $('#tabla').dataTable({
				"iDisplayLength" : 10,
				"aoColumns" : [null,{sClass: "aw-right" },{sClass: "aw-right" },{sClass: "aw-right" }],
				"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
						[ 5, 10, 25, 50, 100, "Todos" ] ],
						"dom": 'T<"clear">lfrtip',
				        "tableTools": {
				            "sSwfPath": "${dataTablesTTSWF}",
				            "aButtons": [
				                         {
				                             "sExtends":    "collection",
				                             "sButtonText": "Exportar",
				                             "aButtons": [
				                                          {
				                                              "sExtends": "copy",
				                                              "sButtonText": "Copiar",
				                                              "oSelectorOpts": { filter: 'applied', order: 'current' }
				                                          },
				                                          {
				                                              "sExtends": "csv",
				                                              "sButtonText": "Guardar CSV",
				                                              "sFileName": "muestrasxdia.csv",
	                    	                                     "sTitle": "Muestras por día",
	                    	                                     "oSelectorOpts": { filter: 'applied', order: 'current' }
				                                          },
				                                          {
				                                              "sExtends": "pdf",
				                                              "sButtonText": "Guardar PDF",
				                                              "sFileName": "muestrasxdia.pdf",
	    	            	                                     "sTitle": "Informe de Avance de Muestreo Anual 2015",
	    	            	                                     "sPdfMessage": "Muestras por día",
	                    	                                     "oSelectorOpts": { filter: 'applied', order: 'current' },
	                    	                                     "sPdfSize": "letter"
				                                          }
				                                      ]
				                         }
				                     ]
				        }
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			var rojo = [];
			var pbmc = [];
			var total = [];
			var fechas = [];
			var totrojo = 0;
			var totpbmc = 0;
			var totales = 0;
			<c:forEach var="conteo" items="${muestrasDia}">
			fechas.push([ "${conteo[0]}" ]);
			total.push([ "${conteo[0]}", "${conteo[1]}" ]);
			totales = totales + parseInt("${conteo[1]}");
			</c:forEach>
			<c:forEach var="conteo" items="${muestrasDia}">
			rojo.push([ "${conteo[0]}", "${conteo[3]}" ]);
			totrojo = totrojo + parseInt("${conteo[3]}");
			</c:forEach>
			<c:forEach var="conteo" items="${muestrasDia}">
			pbmc.push([ "${conteo[0]}", "${conteo[2]}" ]);
			totpbmc = totpbmc + parseInt("${conteo[2]}");
			</c:forEach>
			$("#trojo").val(totrojo);
			$("#tpbmc").val(totpbmc);
			$("#ttotal").val(totales);
			var plot = $.plot("#curve-chart", [ {
				data : total,
				label : "Total"
			} , {
				data : rojo,
				label : "Rojo"
			}, {
				data : pbmc,
				label : "PBMC"
			} ], {
				series : {
					lines : {
						show : true,
						fill : true
					},
					points : {
						show : true
					}
				},
				grid : {
					hoverable : true,
					clickable : true,
					borderWidth : 0
				},
				xaxis : {
					mode : "categories",
					tickLength : 0
				},
				colors : [ "#bee0ae", "#ff5d5e", "#5eb2d9" ]
			});

			$("<div id='tooltip'></div>").css({
				position : "absolute",
				display : "none",
				border : "1px solid #fdd",
				padding : "2px",
				"background-color" : "#fee",
				opacity : 0.80
			}).appendTo("body");

			$("#curve-chart").bind(
					"plothover",
					function(event, pos, item) {

						/*if ($("#enableTooltip:checked").length > 0) {*/
						if (item) {
							var x = item.datapoint[0], y = item.datapoint[1];
							$("#tooltip").html(
									fechas[x] + "<br/>" + "<strong>" + y
											+ "</strong>").css({
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