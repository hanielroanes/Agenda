<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/CadastroTarefa.jsp" var="urlCadTarefa" />
<c:url value="/subTarefas" var="urlSubTarefas" />
<c:url value="/editarTarefa" var="urlEditaTarefa" />
<c:url value="/deletarTarefa" var="urlDelTarefa" />
<c:url value="/editarCliente" var="urlEditarCliente" />

<!DOCTYPE html>
<html lang="pt_br">
<head>
<meta charset="utf-8">
<title>Gerenciador de tarefas</title>
<link rel="icon" href="img/lista-de-tarefas.png">

<link rel="stylesheet" href="css/tableStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<div class="bg-light w-100">
			<div class="container">
				<nav class="navbar navbar-light bg-light">
					<div class="container-fluid">
						<h4>
							<a class="navbar-brand" href="${urlEditarCliente}"> <img
								src="img/lista-de-tarefas.png" alt="" width="30" height="24"
								class="d-inline-block align-text-top"> ${cliente.nome}
							</a>
						</h4>
					</div>
				</nav>
			</div>
		</div>
	</header>

	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1 class="col-md-4">Lista de tarefas</h1>
			<div class="btn btn-warning col-md-2 m-2">
				<a class="link" href="${urlCadTarefa}">Cadastrar Tarefa</a>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty tarefas }">
				<h1>Você ainda não possui tarefas cadastradas</h1>
			</c:when>
			<c:otherwise>
				<table
					class="table table-striped table-hover table-light align-middle caption-top"
					style="margin-bottom: 80px">
					<caption></caption>
					<thead>
						<tr>
							<th class="col-5">Nome:</th>
							<th class="col-2">Data de criação:</th>
							<th class="col-2">Data do prazo:</th>
							<th class="col-1"style="text-align:center;">Status:</th>
							<th class="col-2"style="text-align:center;">Ações:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tarefas}" var="tarefa">
							<tr>
								<td>
									<div data-bs-toggle="modal" data-bs-target="#editarTarefa"
										data-id="${tarefa.id}" data-nome="${tarefa.nome}"
										data-dataLimite="${tarefa.dataLimite}">${tarefa.nome}
									</div>
								</td>
								<td><fmt:formatDate value="${tarefa.dataInicio}"
										pattern="dd/MM/yyyy H:mm" /></td>
								<c:choose>
									<c:when test="${not empty tarefa.dataLimite}">
										<td><fmt:formatDate value="${tarefa.dataLimite}"
												pattern="dd/MM/yyyy H:mm" /></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="Não há data limite"></c:out></td>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${tarefa.concluida == 'S'}">
										<td>
											<div class="d-flex justify-content-around">
												<img alt="Concluida" src="img/checked.png">
											</div>
										</td>
									</c:when>
									<c:otherwise>
										<td>
											<div class="d-flex justify-content-center">
												<img alt="Nao concluida" src="img/rejected.png">
											</div>
										</td>
									</c:otherwise>
								</c:choose>

								<td>
									<div class="d-flex justify-content-around">
										<div class="btn btn-success">
											<a
												href="${urlSubTarefas}?idTarefa=${tarefa.id}&nomeTarefa=${tarefa.nome}"><img
												alt="subTarefas" src="img/clipboard.png"></a>
										</div>
										<div class="btn btn-danger" 
										data-bs-toggle="modal" 
										data-bs-target="#deletarTarefa"
										data-id="${tarefa.id}"
										data-nome="${tarefa.nome}">
											<img alt="deletar" src="img/trash.png">
										</div>
									</div>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="modal fade" id="deletarTarefa" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-delete-title" id="labelModal">Deletar tarefa</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="col-8 form" name="frm" action="${urlDelTarefa}"
						method="post">
						<div>
							<h5 class="msgDeletar"></h5>
							<input class="id" style="display: none" id="idTarefa" name="idTarefa">	
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancelar</button>
					<div class="btn btn-primary mt-2 mb-2" onclick="deletar()">Confirmar</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="editarTarefa" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="labelModal">Editar tarefa</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="col-8 form" name="frmEditar" action="${urlEditaTarefa}"
						method="post">
						<div>
							<input class="id" style="display: none" id="id" name="idTarefa">
						</div>
						<div class="mt-2 mb-2 col-8">
							<input class="input form-control nome" type="text" name="nome"
								placeholder="Nome da terefa:">
							<div style="display: none; color: red" id="msgNome">
								<h6>nome é obrigatorio!</h6>
							</div>
						</div>

						<div class="mt-2 mb-2 col-8 ">
							<input class="input form-control dataLimite" type="datetime"
								id="dataLimite" name="dataLimite" maxlength="16"
								placeholder="Data Limite:" onkeypress="mascaraData(this, event)">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancelar</button>
					<div class="btn btn-primary mt-2 mb-2" onclick="validar()">Editar</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
	<script src="js/validadorTarefa.js"></script>
	<script src="js/listaTarefas.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>