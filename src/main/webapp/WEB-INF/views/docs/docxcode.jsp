<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
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
					<i class="icon-file"></i>
					<fmt:message key="docs" />
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
									<div class="pull-left"><fmt:message key="docs.searchcod" /></div>
									<div class="widget-icons pull-right">
										<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
										<a href="#" class="wclose"><i class="icon-remove"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="widget-content">
									<div class="padd">
										<form class="form-horizontal" id="search-code-form">
											<div class="form-group">
												<label class="col-lg-4 control-label" for="username">
													<fmt:message key="docs.codigo" />
												</label>
												<div class="col-lg-6">
													<input id="codigo" name="codigo"
														class="form-control" />
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="widget">
								<div class="widget-head">
									<div class="pull-left"><fmt:message key="docs.results" /></div>
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
												<th><fmt:message key="docs.codigo" /></th>
												<th><fmt:message key="docs.fec" /></th>
												<th><fmt:message key="docs.fec2" /></th>
												<th><fmt:message key="docs.tipo" /></th>
												<th><fmt:message key="docs.usuario" /></th>
												<th></th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Matter ends -->
			</div>
			<!-- Mainbar ends -->
			<div class="clearfix"></div>
			<!-- Content ends -->
		</div>
	</div>
	<!-- Footer starts -->
	<jsp:include page="../fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<spring:url value="/docs/docscode" var="docsUrl"/>
	<spring:url value="/docs/doc" var="docUrl"/>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			var table  =  $('#tabla').dataTable({
				"iDisplayLength" : 10,
				"aaSorting": [[ 1, "asc" ]] ,
				"aLengthMenu" : [ [ 5, 10, 25, 50, 100, -1 ],
						[ 5, 10, 25, 50, 100, "Todos" ] ]
			});
			var form1 = $('#search-code-form');
			form1.validate({
	            ignore: "",
	            rules: {
	            	codigo: {
	                    required: true,
                        min: 1,
                        max: 99999,
	                }
	            },


	            submitHandler: function (form) {
	                table.fnClearTable();
	                searchDocs();
	            }
	        });
			
			function searchDocs()
        	{
            	$.getJSON("${docsUrl}", {
    				codigo : $('#codigo').val(),
    				ajax : 'true'
    			}, function(data) {
    				var len = data.length;
    				for ( var i = 0; i < len; i++) {
    					var d = new Date(data[i].docsId.fechaDocumento);
    					var d2 = new Date(data[i].fechaRecepcion);
    					var docUrl = "${docUrl}" + '?codigo='+data[i].docsId.codigo + '&fecha='+data[i].docsId.fechaDocumento;
    					table.fnAddData(
    							[data[i].docsId.codigo,d.yyyymmdd(),d2.yyyymmdd(),data[i].tipoDoc,data[i].usuario,'<a href='+ docUrl + '>Ver</a>']);
    				}
    			})
    			.fail(function() {
				    alert( "error" );
				});
        	}
			
			Date.prototype.yyyymmdd = function() {         
		        
		        var yyyy = this.getFullYear().toString();                                    
		        var mm = (this.getMonth()+1).toString(); // getMonth() is zero-based         
		        var dd  = this.getDate().toString();       
		        var hh = this.getHours().toString();
		        var min = this.getMinutes().toString();
		                            
		        return yyyy + '-' + (mm[1]?mm:"0"+mm[0]) + '-' + (dd[1]?dd:"0"+dd[0])+ ' ' + (hh[1]?hh:"0"+hh[0]) + ':' + (min[1]?min:"0"+min[0]);
		   };
		});
	</script>
</body>
</html>