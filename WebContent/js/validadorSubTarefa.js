function validar() {
	let submeter = true;
	let descricao = frmEdit.descricao.value;
	console.log(descricao)
	if(descricao === ""){
		document.getElementById('msgEditDescricao').style.display = "block";
		frmEdit.descricao.focus();
		submeter = false;
	}else{
		document.getElementById('msgEditDescricao').style.display = "none";
	}
	
	if(submeter){
		document.forms["frmEdit"].submit();
	}
}

function deletar() {
		document.forms["frm"].submit();
}