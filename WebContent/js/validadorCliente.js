/**
 *  Validador de formularios do cliente
 */

function validar() {
	let submeter = true;
	let nome = frm.nome.value;
	let tel = frm.tel.value;
	let email = frm.email.value;
	let senha = frm.senha.value;
	
	if(nome === ""){
		document.getElementById('msgNome').style.display = "block";
		frm.nome.focus();
		submeter = false;
	}else{
		document.getElementById('msgNome').style.display = "none";
	}
	
	if(tel === ""){
		document.getElementById('msgTel').style.display = "block";
		frm.tel.focus();
		submeter = false;
	}else{
		document.getElementById('msgTel').style.display = "none";
	}
	
	if(email === "") {
		document.getElementById('msgEmail').style.display = "block";
		frm.email.focus();
		submeter = false;
	}else{
		document.getElementById('msgEmail').style.display = "none";
	}
	
	if(senha === "") {
		document.getElementById('msgSenha').style.display = "block";
		frm.senha.focus();
		submeter = false;
	}else{
		document.getElementById('msgSenha').style.display = "none";
	}
	
	if(submeter){
		document.forms["frm"].submit();
	}
}


function validarEdicao(){
	let submeter = true;
	let nome = frm.nome.value;
	let tel = frm.tel.value;
	let email = frm.email.value;
	let senha = frm.senha.value;
	let confirmaSenha = frm.confirmaSenha.value;
	
	if(nome === ""){
		document.getElementById('msgNome').style.display = "block";
		frm.nome.focus();
		submeter = false;
	}else{
		document.getElementById('msgNome').style.display = "none";
	}
	
	if(tel === ""){
		document.getElementById('msgTel').style.display = "block";
		frm.tel.focus();
		submeter = false;
	}else{
		document.getElementById('msgTel').style.display = "none";
	}
	
	if(email === "") {
		document.getElementById('msgEmail').style.display = "block";
		frm.email.focus();
		submeter = false;
	}else{
		document.getElementById('msgEmail').style.display = "none";
	}
	
	if(senha !== "") {
		if(confirmaSenha === "") {
		document.getElementById('msgConfirmaSenha').style.display = "block";
		frm.confirmaSenha.focus();
		submeter = false;
		}else{
			document.getElementById('msgConfirmaSenha').style.display = "none";
		}
	}else{
		if(confirmaSenha !== "") {
			document.getElementById('msgSenha').style.display = "block";
			frm.senha.focus();
			submeter = false;
		}
	}
	
	if(submeter){
		document.forms["frm"].submit();
	}	
}