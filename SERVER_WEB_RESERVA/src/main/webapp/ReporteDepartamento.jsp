<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reporte de Departamentos Más Reservados</title>
<style>
		h1 {
			text-align: center;
		}
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
</style>
</head>
<body>
	<h1>Reporte de Departamentos Más Reservados</h1>
    <table>
        <thead>
            <tr>
                <th>ID Departamento</th>
                <th>Nombre</th>
                <th>Veces Reservado</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <!-- Si la lista contiene datos -->
                <c:when test="${not empty reporteDepartamentos}">
                    <c:forEach var="departamento" items="${reporteDepartamentos}">
                        <tr>
                            <td>${departamento.idDepartamento}</td>
                            <td>${departamento.nombre}</td>
                            <td>${departamento.vecesReservado}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <!-- Si la lista está vacía -->
                <c:otherwise>
                    <tr>
                        <td colspan="3">No hay datos disponibles.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>