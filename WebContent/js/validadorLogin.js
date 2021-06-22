
function validar() {
	let submeter = true;
	let email = frm.email.value;
	let senha = frm.senha.value;
	
	if(email === ""){
		document.getElementById('msgEmail').style.display = "block";
		frm.email.focus();
		submeter = false;
	}else{
		document.getElementById('msgEmail').style.display = "none";
	}
	
	if(senha === ""){
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