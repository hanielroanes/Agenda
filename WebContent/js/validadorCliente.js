/**
 *  Validador de formularios do cliente
 */

function mascaraTelefone( campo, e )
{
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var numero = campo.value;
	
	if( kC!=8 && kC!=46 )
	{
		if( numero.length==0 )
		{
			campo.value = numero += '(';
		}
		else if( numero.length==3 )
		{
			campo.value = numero += ') ';
		}
		else if(numero.length==10){
			campo.value = numero += '-';
		}
		else
			campo.value = numero;
	}
}

function validacaoEmail(field) {
usuario = field.value.substring(0, field.value.indexOf("@"));
dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);

if ((usuario.length >=1) &&
    (dominio.length >=3) &&
    (usuario.search("@")==-1) &&
    (dominio.search("@")==-1) &&
    (usuario.search(" ")==-1) &&
    (dominio.search(" ")==-1) &&
    (dominio.search(".")!=-1) &&
    (dominio.indexOf(".") >=1)&&
    (dominio.lastIndexOf(".") < dominio.length - 1)) {
document.getElementById("msgEmailInvalido").style.display = "none";
}
else{
document.getElementById("msgEmailInvalido").style.display = "block";
}
}


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