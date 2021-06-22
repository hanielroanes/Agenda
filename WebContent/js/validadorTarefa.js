/**
 *  Validador de formularios
 */

function validar() {
	let submeter = true;
	let nome = frmEditar.nome.value;
	let dataLimite = frmEditar.dataLimite.value;
	
	if(nome === ""){
		document.getElementById('msgNome').style.display = "block";
		frmEditar.nome.focus();
		submeter = false;
	}else{
		document.getElementById('msgNome').style.display = "none";
	}
	
	if(submeter){
		document.forms["frmEditar"].submit();
	}
}

function validaData(){
	var data = new Date();
	var dia = String(data.getDate()).padStart(2, '0');
	var mes = String(data.getMonth() + 1).padStart(2, '0');
	var ano = data.getFullYear();
	var hora = data.getHours();
	var min = data.getMinutes();
	var dataAtual = dia + '/' + mes + '/' + ano + ' ' + hora + ':' + min;
	return data;
}

function deletar() {
	document.forms["frm"].submit();
}

function mascaraData( campo, e )
{
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var data = campo.value;
	
	if( kC!=8 && kC!=46 )
	{
		if( data.length==2 )
		{
			campo.value = data += '/';
		}
		else if( data.length==5 )
		{
			campo.value = data += '/';
		}
		else if(data.length==10){
			campo.value = data += ' ';
		}
		else if(data.length==13){
			campo.value = data += ':';
		}
		else
			campo.value = data;
	}
}