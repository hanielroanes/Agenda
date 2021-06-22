<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="CadastroCliente.jsp" var="urlCadCliente"/>
<c:url value="/login" var="urlLogin"/>


<!DOCTYPE html>
<html lang="pt_br">
	<head>
		<meta charset="utf-8">
		<title>Gerenciador de tarefas</title>
		<link rel="icon" href="img/lista-de-tarefas.png">
		
		<link rel="stylesheet" href="css/formStyle.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	</head>
	<body class="body">
		<div class="container">
			<div class="d-flex justify-content-center mt-5">
					<h1><b>LOGIN</b></h1>
			</div>
			<div>
				<div class="w-100 text align-self-center">
					<form class="col-8 form" name="frm" action="${urlLogin}" method="post">
					<h6 style="color: green; margin-left: 17%">${menssagemCadastro}</h6>
					<h6 style="color: red; margin-left: 17%">${messageLoginFalied}</h6>
					<div class="mt-2 mb-2 col-8">
						<input class="input form-control" type="text" value="${email}" name="email" placeholder="E-mail:">
						<div style="display:none;color:red" id="msgEmail" ><h6>Email é obrigatorio!</h6></div>
					</div>
					
					<div class="mt-2 mb-2 col-8">
						<input class="input form-control" type="password" id="senha" name="senha" placeholder="Senha:">
						<div style="display:none;color:red" id="msgSenha" ><h6>Senha é obrigatoria!</h6></div>
					</div>
					<h6 style="color: red; margin-left: 17%">${message}</h6>
					<div style="margin-left: 28%">
						<div class="btn btn-primary mt-2 mb-2" onclick="validar()">Entrar</div>
					</div>
					<h5 style="margin-left: 31%"><c:out value="Ou"></c:out></h5>
					<div style="margin-left: 25%">
						<div class="btn btn-primary mt-2 mb-2"><a href="${urlCadCliente}">Cadastrar-se</a></div>			
					</div>
					</form>
				</div>
			</div>
		</div>
		
		<script src="js/validadorLogin.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
	</body>
</html>