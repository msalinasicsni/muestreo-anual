<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<jsp:include page="fragments/headTag.jsp" />
</head>
<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<jsp:include page="fragments/bodyNavigation.jsp" />
	<!-- Main bar -->
	<div class="mainbar">

		<!-- Page heading -->
		<div class="page-head">
			<h2 class="pull-left">
				<i class="icon-home"></i>
				<fmt:message key="welcome" />
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
					<div class="col-md-9">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="samples.menu" />
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
					<c:forEach var="muestrasTotal" items="${muestrasTotal}">
						<c:set var="totalBhc" value="${muestrasTotal[3]}"/>
						<c:set var="totalRojo" value="${muestrasTotal[4]}"/>
						<c:set var="totalPbmc" value="${muestrasTotal[5]}"/>
						<c:set var="totalPax" value="${muestrasTotal[8]}"/>
					</c:forEach>
					<c:set var="totalPart" value="${0.00}"/>
					<c:set var="totalTaken" value="${0.00}"/>
					<c:forEach var="muestrasEstudio" items="${muestrasEstudio}">
						<c:set var="totalPart" value="${totalPart + muestrasEstudio[1]}"/>
						<c:set var="totalTaken" value="${totalTaken + muestrasEstudio[2]}"/>
					</c:forEach>
					<div class="col-md-3">
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
										<li><span id="todayspark4"></span> <span class="bold"><fmt:message
													key="summary.part" /> : <c:out value="${totalPart}" /></span></li>
										<li><span id="todayspark5"></span> <span class="bold"><fmt:message
													key="summary.taken" /> : <c:out value="${totalTaken}" /></span></li>
										<li><span id="todayspark1"></span> <span class="bold"><fmt:message
													key="summary.bhc" /> : <c:out value="${totalBhc}" /></span></li>
										<li><span id="todayspark2"></span> <span class="bold"><fmt:message
													key="summary.rojo" /> : <c:out value="${totalRojo}" /></span></li>
										<li><span id="todayspark3"></span> <span class="bold"><fmt:message
													key="summary.pbmc" /> : <c:out value="${totalPbmc}" /></span></li>
										<li><span id="todayspark6"></span> <span class="bold"><fmt:message
													key="summary.pax" /> : <c:out value="${totalPax}" /></span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="samples.neigh" />
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
					<div class="col-md-12">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">
									<fmt:message key="samples.age" />
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
									<div id="age-chart"></div>
									<hr />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- Pie chart starts -->
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left"><fmt:message key="samples.study" /></div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd">
									<div class="row">
										<div class="col-md-4">
											<div class="pull-left"><fmt:message key="study.total" /></div>
											<div id="pie-chart"></div>
										</div>
										<div class="col-md-4">
											<div class="pull-left"><fmt:message key="study.taken" /></div>
											<div id="pie-chart2"></div>
										</div>
										<div class="col-md-4">
											<div class="pull-left"><fmt:message key="study.pending" /></div>
											<div id="pie-chart3"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Pie chart ends -->
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
	<jsp:include page="fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="fragments/scripts.jsp" />
	<script type="text/javascript">
		
		$(function() {
			var bhclab = [];
			var rojolab = [];
			var pbmclab = [];
			var paxlab = [];
			var fechas = [];
			<c:forEach var="labbhc" items="${labBhcsTotales}">
			fechas.push([ "${labbhc[0]}" ]);
			bhclab.push([ "${labbhc[0]}", "${labbhc[1]}" ]);
			</c:forEach>
			<c:forEach var="labrojo" items="${labRojosTotales}">
			rojolab.push([ "${labrojo[0]}", "${labrojo[1]}" ]);
			</c:forEach>
			<c:forEach var="labpbmc" items="${labPbmcsTotales}">
			pbmclab.push([ "${labpbmc[0]}", "${labpbmc[1]}" ]);
			</c:forEach>
			<c:forEach var="labpax" items="${labPaxsTotales}">
			paxlab.push([ "${labpax[0]}", "${labpax[1]}" ]);
			</c:forEach>

			var plot = $.plot("#curve-chart", [ {
				data : bhclab,
				label : "BHC"
			}, {
				data : rojolab,
				label : "Rojo"
			}, {
				data : paxlab,
				label : "Paxgene"
			}, {
				data : pbmclab,
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
				colors : [ "#9F28BF", "#ff5d5e", "#078446", "#5eb2d9" ]
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
		
		$(function() {
			var porcentajes = [];
			var faltantes = [];
			var hechos = [];
			var totales = [];
			var barrios = [];
			<c:forEach var="mBarrio" items="${muestrasBarrio}">
			barrios.push([ "${mBarrio[0]}" ]);
			totales.push([ "${mBarrio[0]}", "${mBarrio[1]}" ]);
			hechos.push([ "${mBarrio[0]}", "${mBarrio[2]}" ]);
			faltantes.push([ "${mBarrio[0]}", "${mBarrio[3]}" ]);
			porcentajes.push([ "${mBarrio[0]}", "${mBarrio[4]}" ]);
			</c:forEach>
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
		
		
		$(function() {
			var porcEdad = [];
			var faltantesEdad = [];
			var hechosEdad = [];
			var totalEdad = [];
			var edades = [];
			<c:forEach var="mEdad" items="${muestrasEdad}">
			edades.push([ "${mEdad[0]}" ]);
			totalEdad.push([ "${mEdad[0]}", "${mEdad[1]}" ]);
			hechosEdad.push([ "${mEdad[0]}", "${mEdad[2]}" ]);
			faltantesEdad.push([ "${mEdad[0]}", "${mEdad[3]}" ]);
			porcEdad.push([ "${mEdad[0]}", "${mEdad[4]}" ]);
			</c:forEach>
			var plot = $.plot("#age-chart", [ {
				data : totalEdad,
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
				data : hechosEdad,
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
				data : faltantesEdad,
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
				data : porcEdad,
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

			$("#age-chart").bind(
					"plothover",
					function(event, pos, item) {

						/*if ($("#enableTooltip:checked").length > 0) {*/
						if (item) {
							var x = item.datapoint[0], y = item.datapoint[1];
							$("#tooltip").html(
									edades[x] + "<br/>" + "<strong>" + y
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
		
		/* Pie chart starts */

		$(function () {
			var faltantesEstudio = [];
			var hechosEstudio = [];
			var totalEstudio = [];
			<c:forEach var="muestrasEstudio" items="${muestrasEstudio}">
			totalEstudio.push({label:"${muestrasEstudio[0]}", data:"${muestrasEstudio[1]}" });
			hechosEstudio.push({label:"${muestrasEstudio[0]}", data:"${muestrasEstudio[2]}" });
			faltantesEstudio.push({label:"${muestrasEstudio[0]}", data:"${muestrasEstudio[3]}"});
			</c:forEach>
		    $.plot($("#pie-chart"), totalEstudio,
		    {
		        series: {
		            pie: {
		                show: true,
		                radius: 95/100,
		                label: {
		                    show: true,
		                    radius: 3/4,
		                    formatter: function(label, series){
		                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+Math.round(series.percent)+'%<br/>('+series.data[0][1]+')</div>';
		                    },
		                    background: { opacity: 0.1 }
		                }
		            }
		        },
		        grid: {hoverable: true}
		    }); 

		    $.plot($("#pie-chart2"), hechosEstudio,
		    {
		        series: {
		            pie: {
		                show: true,
		                radius: 95/100,
		                label: {
		                    show: true,
		                    radius: 3/4,
		                    formatter: function(label, series){
		                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+Math.round(series.percent)+'%<br/>('+series.data[0][1]+')</div>';
		                    },
		                    background: { opacity: 0.1 }
		                }
		            }
		        },
		        grid: {hoverable: true}
		    });


		    $.plot($("#pie-chart3"), faltantesEstudio,
		    {
		        series: {
		            pie: {
		                show: true,
		                radius: 95/100,
		                label: {
		                    show: true,
		                    radius: 3/4,
		                    formatter: function(label, series){
		                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+Math.round(series.percent)+'%<br/>('+series.data[0][1]+')</div>';
		                    },
		                    background: { opacity: 0.1 }
		                }
		            }
		        },
		        grid: {hoverable: true}
		    });   

		/* Pie chart ends */

		});

	</script>
</body>
</html>