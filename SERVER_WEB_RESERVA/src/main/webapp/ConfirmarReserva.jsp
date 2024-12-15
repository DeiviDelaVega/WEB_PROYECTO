<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>





<!DOCTYPE html>
<html lang="es">



<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva de Departamento</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript"> 
    
    console.log(document.getElementById("idDepartamento").value);
       
     function CalcularPrecioTotal(PrecioPorNoche){
    	 
    	 console.log("InicioCalcular" + PrecioPorNoche);
    	 
    	 var fechaInicio = document.getElementById("fechaInicio").value;
    	 var fechaFin = document.getElementById("fechaFin").value;
    	 
    	 console.log("fechaInicio : " +  fechaInicio);
    	 console.log("fechaFin : " + fechaFin);
    	 
    	 if (fechaInicio && fechaFin) {
    		 
    		 var startDate = new Date(fechaInicio);
             var endDate = new Date(fechaFin);
             
             console.log("StarDate : " +  startDate);
        	 console.log("EndDate : " + endDate);
        	 
             if (endDate >= startDate) {
                 var diferencia = (endDate - startDate) / (1000 * 3600 * 24); // Diferencia en días
                 var total = diferencia * PrecioPorNoche;

                 // Mostrar el precio total en el HTML
                 document.getElementById('totalPago').value = total.toFixed(2) + " SOL";
             } else {
                 document.getElementById('totalPago').value = "0.00 SOL";
             }
		}
    	 
      	 console.log("FinCalcular" + PrecioPorNoche);
     }
    
    </script>
</head>
<body>

<% 
    // Obtener ID del cliente desde la sesión
    Integer idCliente = (Integer) session.getAttribute("clienteId");
    
    // Obtener ID del departamento desde los atributos del request
%>

<% 
    // Obtener ID del departamento desde el request o cualquier otra fuente
    Integer idDepartamento = (Integer) request.getAttribute("idDepartamento"); 


%>

<% System.out.println("Valor de idDepartamento recibido: " + request.getParameter("idDepartamento"));
 %>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Detalles de la Reserva</h1>

        <div class="card mb-4">
            <div class="card-header">
                <h2>Información del Departamento</h2>
            </div>
            <div class="card-body">
                <p><strong>Nombre:</strong> ${departamento.getNombre()}</p>
                <p><strong>Descripción:</strong> ${departamento.getDescripcion()}</p>
                <p><strong>Precio por noche:</strong> ${departamento.getPrecioPorNoche()}</p>
            </div>
        </div>

        <h2 class="mb-3">Detalles de la Reserva</h2>
        <form action="ReservaServlet" method="POST">
        
         <input type="hidden" name="opcion" value="registrar">
         
             
             <input type="hidden" id="idCliente" name="idCliente" value="idCliente" class="form-control">
    
    <!-- Campo oculto para el ID del departamento -->
               <input type="hidden" id="idDepartamento" name="idDepartamento" value="${departamento.getIdDepartamento()}" class="form-control">
                
         
            
            <div class="form-group">
                <label for="fechaInicio">Fecha de Inicio:</label>
                <input type="date" id="fechaInicio" name="fechaInicio" class="form-control" onchange="CalcularPrecioTotal(${departamento.getPrecioPorNoche()})" required>
                
            </div>
            
            <div class="form-group">
                <label for="fechaFin">Fecha de Fin:</label>
                <input type="date" id="fechaFin" name="fechaFin" class="form-control"   onchange="CalcularPrecioTotal(${departamento.getPrecioPorNoche()})" required>
            </div>

            <div class="form-group">
                <label for="metodoPago">Método de Pago:</label>
                <select id="metodoPago" name="metodoPago" class="form-control" required>
                    <option value="Cheque">Cheque</option>
                    <option value="Efectivo">Efectivo</option>
                    <option value="Transferencia">Transferencia</option>
                </select>
            </div>

            <div class="form-group">
                <p><strong>Total Estimado:</strong></p>
                <input type="text" id="totalPago" name="totalPago" readonly> 
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Confirmar Reserva</button>
            </div>

            <input type="hidden" name="departamentoId" value="${departamento.getIdDepartamento()}">
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
