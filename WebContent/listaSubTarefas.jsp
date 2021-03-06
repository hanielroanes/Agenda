<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/cadastrarSubTarefa" var="urlCadSubTarefa" />
<c:url value="/editarSubTarefa" var="urlEditaSubTarefa"/>
<c:url value="/deletarSubTarefa" var="urlDelSubTarefa" />
<c:url value="/tarefas" var="urlListaTarefas"></c:url>

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
							<a class="navbar-brand" href="#"> <img
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
		<div class="d-flex"><a class="btn btn-info" style="margin-right: 5px" href="${urlListaTarefas}">Voltar</a><h3>para lista de tarefas</h3></div>
		<div class="d-flex justify-content-between">
			<h1 class="col-md-4">Lista de sub tarefas</h1>
			<div class="btn btn-warning col-md-2 m-2">
				<a class="link" href="${urlCadSubTarefa}?idTarefa=${idTarefa}&nomeTarefa=${nomeTarefa}">Cadastrar Sub Tarefa</a>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty subTarefas }">
				<h1>Tarefa ainda n?o possui sub tarefas cadastradas</h1>
			</c:when>
			<c:otherwise>
				<table
					class="table table-striped table-hover table-light align-middle caption-top"
					style="margin-bottom: 80px">
					<caption></caption>
					<thead>
						<tr>
							<th class="col-5">Descricao:</th>
							<th class="col-1" style="text-align:center;">Status:</th>
							<th class="col-2" style="text-align:center;">A??es:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${subTarefas}" var="subTarefa">
							<tr>
								<td>
									<div data-bs-toggle="modal" data-bs-target="#editarSubTarefa"
										data-id="${subTarefa.id}"
										data-descricao="${subTarefa.descricao}">${subTarefa.descricao}
									</div>
								</td>

								<c:choose>
									<c:when test="${subTarefa.concluida == 'S'}">
										<td>
											<div class="d-flex justify-content-center">
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
											<a href="${urlEditaSubTarefa}?idSubTarefa=${subTarefa.id}
													&concluida=${subTarefa.concluida}&nomeTarefa=${nomeTarefa}
													&idTarefa=${idTarefa}">
													<img alt="subTarefas" src="img/reload.png">
											</a>
										</div>
										<div class="btn btn-danger" 
										data-bs-toggle="modal" 
										data-bs-target="#deletarSubTarefa"
										data-id="${subTarefa.id}"
										data-descricao="${subTarefa.descricao}">
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


	<div class="modal fade" id="deletarSubTarefa" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-delete-title" id="labelModal">Deletar sub tarefa</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="col-8 form" name="frm" action="${urlDelSubTarefa}"
						method="post">
						<div>
							<h5 class="msgDeletar"></h5>
							<input style="display:none" value="${idTarefa}" id="idTarefa" name="idTarefa">	
							<input style="display:none" value="${nomeTarefa}" id="nomeTarefa" name="nomeTarefa">
							<input class="id-deletar" style="display:none" name="idSubTarefa">
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
	

	<div class="modal fade" id="editarSubTarefa" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="labelModal">Editar sub tarefa</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="col-8 form" name="frmEdit" action="${urlEditaSubTarefa}"
						method="post">
						<div>
							<input style="display:none" value="${idTarefa}" id="idTarefa" name="idTarefa">	
							<input style="display:none" value="${nomeTarefa}" id="nomeTarefa" name="nomeTarefa">
							<input class="id" style="display:none" id="id" name="idSubTarefa">
						</div>
						<div class="mt-2 mb-2 col-8">
							<input class="input form-control descricao" type="text" name="descricao"
								placeholder="Descricao:">
							<div style="display: none; color: red" id="msgEditDescricao">
								<h6>Descricao ? obrigatoria!</h6>
							</div>
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
	<script src="js/listaSubTarefas.js"></script>
	<script src="js/validadorSubTarefa.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>