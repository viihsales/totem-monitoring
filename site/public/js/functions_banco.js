function verificarAutenticacao() {
  if (sessionStorage.usuario != undefined) {
    if (sessionStorage.ativo == true){
      if (sessionStorage.administrador == true){
        window.location.href = 'cadastro.html';
      } else{
        window.location.href = 'dashboard.html' // criar dashboard
      }
    }
    else{
      alert('SE E UM MERDA E SUA CONTA FOI INATIVADA')
    }
  }
}

function logar() {

  wait();

  var formulario = new URLSearchParams(new FormData(form_login));

  fetch('/usuarios/login', {
    method: "POST",
    body: formulario
  }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        sessionStorage.usuario = resposta.email;
        sessionStorage.id_usuario = resposta.id;
        sessionStorage.admin = resposta.administrador
        sessionStorage.ativo = resposta.ativo
        verificarAutenticacao();
      });
    } else {
      console.log('Erro de login!');
      alert('Login ou senha inválido.')
      end_wait();
    }
  });

  return false;
}

function cadastrarUsuario() {

  wait();

  var formulario = new URLSearchParams(new FormData(form_cadastro));

  fetch('/usuarios/cadastro_usuario', {
    method: "POST",
    body: formulario
  }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        if (resposta == true){
          window.location.href = 'index.html';
        } else {
          alert('Desculpe, Algo deu errado');
          end_wait();
        }
      });
    } else {
      console.log('Erro de cadastro!');
      end_wait();
    }
  });

  return false;
}

function wait() {
  sendMessageButton.disabled = true;
}

function end_wait() {
  sendMessageButton.disabled = false;
}
