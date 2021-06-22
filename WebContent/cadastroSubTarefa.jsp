<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/cadastrarSubTarefa" var="urlCadSubTarefa" />
<c:url value="/subTarefas" var="urlListSubTarefas" />



<!DOCTYPE html>
<html lang="pt_br">
<head>
<meta charset="utf-8">
<title>Gerenciador de tarefas</title>
<link rel="icon" href="img/lista-de-tarefas.png">

<link rel="stylesheet" href="css/formStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center">
			<h1>
				<b>Cadastro:</b>
			</h1>
		</div>
		<div>
			<div class="w-100 text align-self-center">
				<form class="col-8 form" name="frmEdit" action="${urlCadSubTarefa}"
					method="post">
					<div class="mt-2 mb-2 col-8">
						<input style="display: none" value="${idTarefa}" name="idTarefa">
						<input style="display: none" value="${nomeTarefa}" name="nomeTarefa">
						<input class="input form-control" type="text" name="descricao"
							placeholder="Descrição:">
						<div style="display: none; color: red" id="msgEditDescricao">
							<h6>descrição é obrigatoria!</h6>
						</div>
					</div>

					<div class="botoes">
						<div class="btn btn-danger mt-2 mb-2">
							<a href="${urlListSubTarefas}?idTarefa=${idTarefa}&nomeTarefa=${nomeTarefa}">Cancelar</a>
						</div>
						<div class="btn btn-primary mt-2 mb-2" onclick="validar()">Cadastrar</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
	<script src="js/validadorSubTarefa.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>