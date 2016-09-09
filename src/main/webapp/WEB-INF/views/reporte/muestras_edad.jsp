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
									<fmt:message key="reps.sxage" />
								</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<!-- Barchart. jQuery Flot plugin used. -->
									<div id="bar-chart"></div>
									<hr />
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
									<fmt:message key="reps.sxage" />
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
											<th><fmt:message key="age" /></th>
											<th><fmt:message key="tablas.total" /></th>
											<th><fmt:message key="study.taken" /></th>
											<th><fmt:message key="study.pending" /></th>
											<th><fmt:message key="perc" /></th>
										</tr>
									</thead>
									<c:forEach items="${muestrasEdad}" var="conteo">
										<tr>
											<td><c:out value="${conteo[0]}" /></td>
											<td><c:out value="${conteo[1]}" /></td>
											<td><c:out value="${conteo[2]}" /></td>
											<td><c:out value="${conteo[3]}" /></td>
											<td><c:out value="${conteo[4]}" /></td>
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
										<li><span id="todayspark6"></span> <span class="bold"><fmt:message
													key="study.taken" /> : <input id="ihechas" name="ihechas" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
										<li><span id="todayspark2"></span> <span class="bold"><fmt:message
													key="study.pending" /> : <input id="ifaltan" name="ifaltan" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
										<li><span id="todayspark3"></span> <span class="bold"><fmt:message
													key="summary.part" /> : <input id="itotal" name="itotal" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
										<li><span id="todayspark5"></span> <span class="bold"><fmt:message
													key="perc" /> : <input id="iperc" name="iperc" readonly="readonly" style="font-weight: bold;border:none"></input> </span></li>
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
				"aoColumns" : [null,{sClass: "aw-right" },{sClass: "aw-right" },{sClass: "aw-right" },{sClass: "aw-right" }],
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
				                                              "sFileName": "muestrasxedad.csv",
	                    	                                     "sTitle": "Muestras por Edad",
	                    	                                     "oSelectorOpts": { filter: 'applied', order: 'current' }
				                                          },
				                                          {
				                                              "sExtends": "pdf",
				                                              "sButtonText": "Guardar PDF",
				                                              "sFileName": "muestrasxedad.pdf",
	    	            	                                     "sTitle": "Informe de Avance de Muestreo Anual 2015",
	    	            	                                     "sPdfMessage": "Muestras por Edad",
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
		var porcentajes = [];
		var faltantes = [];
		var hechos = [];
		var totales = [];
		var barrios = [];
		var tottotal = 0;
		var tothechos = 0;
		var totfaltan = 0;
		var v = 0;
		<c:forEach var="mEdad" items="${muestrasEdad}">
		barrios.push([ "${mEdad[0]}" ]);
		totales.push([ "${mEdad[0]}", "${mEdad[1]}" ]);
		tottotal = tottotal + parseInt("${mEdad[1]}");
		hechos.push([ "${mEdad[0]}", "${mEdad[2]}" ]);
		tothechos = tothechos + parseInt("${mEdad[2]}");
		faltantes.push([ "${mEdad[0]}", "${mEdad[3]}" ]);
		totfaltan = totfaltan + parseInt("${mEdad[3]}");
		porcentajes.push([ "${mEdad[0]}", "${mEdad[4]}" ]);
		</c:forEach>
		totporc = tothechos / tottotal *100;
		totporc = Math.round(totporc * 100) / 100;
		$("#itotal").val(tottotal);
		$("#ihechas").val(tothechos);
		$("#ifaltan").val(totfaltan);
		$("#iperc").val(totporc + ' %');
		var plot = $.plot("#bar-chart", [ {
			data : totales,
			label : "Total",
			bars : {
				show : true,
				barWidth : 0.8,
				fill : true,
			},
			points : {
				show : true
			}
		}, {
			data : hechos,
			label : "Realizados",
			bars : {
				show : true,
				barWidth : 0.8,
				fill : true
			},
			points : {
				show : true
			}
		}, {
			data : faltantes,
			label : "Pendientes",
			bars : {
				show : true,
				barWidth : 0.8,
				fill : true
			},
			points : {
				show : true
			}
		}, {
			data : porcentajes,
			label : "%",
			yaxis : 2,
			lines : {
				show : true,
				fill : false
			},
			points : {
				show : true
			}
		} ], {
			grid : {
				hoverable : true,
				clickable : true,
				borderWidth : 0
			},
			xaxis : {
				mode : "categories",
				tickLength : 0
			},
			yaxes : [ {
				min : 0
			}, {
				position : "right"
			} ]

		});

		$("<div id='tooltip'></div>").css({
			position : "absolute",
			display : "none",
			border : "1px solid #fdd",
			padding : "2px",
			"background-color" : "#fee",
			opacity : 0.80
		}).appendTo("body");

		$("#bar-chart").bind(
				"plothover",
				function(event, pos, item) {

					/*if ($("#enableTooltip:checked").length > 0) {*/
					if (item) {
						var x = item.datapoint[0], y = item.datapoint[1];
						$("#tooltip").html(
								barrios[x] + "<br/>" + "<strong>" + y
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