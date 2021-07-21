<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/cadastrarCliente" var="urlCadCliente"/>
<c:url value="login.jsp" var="urlLogin"/>

<!DOCTYPE html>
<html lang="pt_br">
	<head>
		<meta charset="utf-8">
		<title>Gerenciador de tarefas</title>
		<link rel="icon" href="img/lista-de-tarefas.png">
		
		<link rel="stylesheet" href="css/formStyle.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	</head>
	<body>
		<div class="container mt-5">
			<div class="d-flex justify-content-center">
				<h1><b>Cadastro:</b></h1>
			</div>
			<div class="d-flex justify-content-center">
				<form class="w-100 form" name="frm" action="${urlCadCliente}" method="post">
					<div class="mt-2 mb-2 col-8">
						<input class="form-control " type="text" name="nome" placeholder="Nome:">
						<div style="display:none;color:red" id="msgNome" ><h6>nome é obrigatorio!</h6></div>
					</div>
					
					<div class="mt-2 mb-2 col-8">
						<input class="form-control " type="text" name="tel" placeholder="Telefone:" maxlength="15" onkeypress="mascaraTelefone(this, event)">
						<div style="display:none;color:red" id="msgTel" ><h6>telefone é obrigatorio!</h6></div>
					</div>
					
					<div class="mt-2 mb-2 col-8">
						<input class="form-control " type="email" onblur="validacaoEmail(frm.email)" name="email" placeholder="E-mail:">
						<div style="display:none;color:red" id="msgEmail" ><h6>e-mail é obrigatorio!</h6></div>
						<div style="display:none;color:red" id="msgEmailInvalido" ><h6>e-mail esta invalido!</h6></div>
					</div>
					
					<div class="mt-2 mb-2 col-8">
						<input class="form-control " type="password" name="senha" placeholder="Senha:">
						<div style="display:none;color:red" id="msgSenha" ><h6>senha é obrigatoria!</h6></div>
					</div>
					<div class="botoes">
						<div class="btn btn-danger mt-2 mb-2"><a href="${urlLogin}">Cancelar</a></div>
						<div class="btn btn-primary mt-2 mb-2" onclick="validar()" >Cadastrar</div>
					</div>
					
				</form>
			</div>
		</div>
		
		<script src="js/validadorCliente.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
	</body>
</html>