var Sms = function () {

    return {
        //main function to initiate the module
        init: function (parametros) {
        	var table1 = $('#tabla').dataTable({
				"iDisplayLength": 5,
				"aLengthMenu": [[5,10, 25, 50, 100, -1], [5,10, 25, 50, 100, "Todos"]]
			});
        	
        	
            var form = $('#search_form');
            
                   
            form.validate({
                rules: {
                    //Datos generales
                	cmbBarrio: {
                        required: true
                    },
                    cmbTubo: {
                        required: true
                    },
                    cmbEstudio: {
                        required: true
                    },
                    cmbMensaje: {
                        required: true
                    },
                    cmbEdad: {
                        required: true
                    }
                },

                submitHandler: function (form) {
                    table1.fnClearTable();
                    //add here some ajax code to submit your form or just call form.submit() if you want to submit the form without ajax
                    getParticipantes();
                }
            });
            
            $('#cmbBarrio').change(
            		function() {
            			$('#sendSmd').prop('disabled', true);
                    });
           
            $('#cmbTubo').change(
            		function() {
            			$('#sendSmd').prop('disabled', true);
                    });
            
            $('#cmbEstudio').change(
            		function() {
            			$('#sendSmd').prop('disabled', true);
                    });
            
            $('#cmbMensaje').change(
            		function() {
            			$('#sendSmd').prop('disabled', true);
                    });
           
            $('#cmbEdad').change(
            		function() {
            			$('#sendSmd').prop('disabled', true);
                    });
            
            $('#sendSmd').click(function() {
            	if (form.valid()){
            		$('#sendSmd').prop('disabled', true);
            		$.post(parametros.smsSendUrl, {
        				barrio : $('#cmbBarrio').val(),
        				tubo : $('#cmbTubo').val(),
        				estudio : $('#cmbEstudio').val(),
        				mensaje : $('#cmbMensaje').val(),
        				edad : $('#cmbEdad').val(),
        				ajax : 'true'
        			}, function(data) {
        				noty({text:'<strong>'+ data +'</strong>',layout:'topRight',type:'information',timeout:5000});
        			})
        			.fail(function() {
        				noty({text:'<strong>Error!!!</strong>',layout:'topRight',type:'information',timeout:5000});
    				});
            	}
    	    });
            
            function getParticipantes() {
    			$.getJSON(parametros.smsUrl, {
    				barrio : $('#cmbBarrio').val(),
    				tubo : $('#cmbTubo').val(),
    				estudio : $('#cmbEstudio').val(),
    				mensaje : $('#cmbMensaje').val(),
    				edad : $('#cmbEdad').val(),
    				ajax : 'true'
    			}, function(data) {
    				var len = data.length;
    				for ( var i = 0; i < len; i++) {
    					table1.fnAddData(
    							[data[i].codigo, data[i].nombre1, data[i].apellido1, data[i].edad, data[i].telefono, data[i].estudio]);
    				}
    				if(data.length>0){
    					$('#sendSmd').prop('disabled', false);
    				}
    				else{
    					$('#sendSmd').prop('disabled', true);
    				}
    			})
    			.fail(function() {
				    alert( "error" );
				});
            };
        }
    };

}();