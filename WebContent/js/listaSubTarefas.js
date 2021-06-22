/**
 * 
 */
  var modal = document.getElementById('editarSubTarefa');
  modal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget;
  // Extract info from data-bs-* attributes
  var descricao = button.getAttribute('data-descricao');
  var id = button.getAttribute('data-id');
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
  var modalBodyDesc = modal.querySelector('.descricao');
  var modalBodyid = modal.querySelector('.id');
  modalBodyDesc.value = descricao;
  modalBodyid.value = id;
});

  var modalDelete = document.getElementById('deletarSubTarefa');
  modalDelete.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget;
  // Extract info from data-bs-* attributes
  var modalmsg = modalDelete.querySelector('.msgDeletar');
  var descricaoDeleter = button.getAttribute('data-descricao');
  var idDeletar = button.getAttribute('data-id');
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
	modalmsg.textContent = "Deseja mesmo deletar " + descricaoDeleter + "?";
  var modalBodyid = modalDelete.querySelector('.id-deletar');
  modalBodyid.value = idDeletar;
});