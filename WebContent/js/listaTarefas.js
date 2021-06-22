/**
 * 
 */


  var modal = document.getElementById('editarTarefa');
  modal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget;
  // Extract info from data-bs-* attributes
  var nome = button.getAttribute('data-nome');
  var dataLimite = button.getAttribute('data-dataLimite');
  var id = button.getAttribute('data-id');
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
	var data = new Date(dataLimite);
	var dia = String(data.getDate()).padStart(2, '0');
	var mes = String(data.getMonth() + 1).padStart(2, '0');
	var ano = data.getFullYear();
	var hora = String(data.getHours()).padStart(2, '0');
	var min = String(data.getMinutes()).padStart(2, '0');
	var dataAtual = dia + '/' + mes + '/' + ano + ' ' + hora + ':' + min;

  var modalTitle = modal.querySelector('.modal-title');
  var modalBodyNome = modal.querySelector('.nome');
  var modalBodyDataLimite = modal.querySelector('.dataLimite');
  var modalBodyid = modal.querySelector('.id');

  modalBodyNome.value = nome;
  if(dataLimite != null && dataLimite != ''){
	  modalBodyDataLimite.value = dataAtual;
  }
  modalBodyid.value = id;
})



 var modalDelete = document.getElementById('deletarTarefa');
  modalDelete.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget;
  // Extract info from data-bs-* attributes
  var modalmsg = modalDelete.querySelector('.msgDeletar');
  var nomeDeletar = button.getAttribute('data-nome');
  var idDeletar = button.getAttribute('data-id');
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
	modalmsg.textContent = "Deseja mesmo deletar " + nomeDeletar + "?";
  var modalBodyid = modalDelete.querySelector('.id');
  modalBodyid.value = idDeletar;
});
