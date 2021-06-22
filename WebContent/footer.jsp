<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/login" var="urlLogin"/>

<!DOCTYPE html>
<html lang="pt_br">
	<head>
		<meta charset="utf-8">
		<title>Gerenciador de tarefas</title>
		<link rel="icon" href="img/lista-de-tarefas.png">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	</head>
	<body>
		<footer>
			<div class="bg-dark w-100 fixed-bottom" style="height: 58px !important;margin-top: 10px">
				<div class="container fixed-bottom">
					<div class="d-flex justify-content-between">
						<h5 class="mt-1" style="color: #f2f2f2">Haniel© Todos os direitos reservados.</h5>
						<a  class="btn btn-success mb-2" href="${urlLogin}">Sair</a>
					</div>
					
				</div>
			</div>
		</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>