function verificarAutenticacao() {
  if (sessionStorage.usuario == undefined) {
    window.location.href = '/login.html';
    alert('Você deve estar autenticado');
  }else{
    if (sessionStorage.ativo == 'true') {
      window.location.href = '/dashs/production/index.html';
    }
    else {
      alert('Conta inativada, por favor contate seu superior')
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
        sessionStorage.usuario = resposta.email_user;
        sessionStorage.id_usuario = resposta.id_user;
        sessionStorage.admin = resposta.adm;
        sessionStorage.ativo = resposta.ativo;
        sessionStorage.aeroporto = resposta.fk_aeroporto;
        sessionStorage.nome = resposta.nome;

        verificarAutenticacao();
      });
    } else {
      console.log('Erro de login!');
      alert('Login ou senha inválido.');
      end_wait();
    }
  });

  return false;
}

function cadastrarUsuario() {

  wait();
  fk.value = sessionStorage.aeroporto;
  var formulario = new URLSearchParams(new FormData(formulario_cadastro));

  fetch('../../usuarios/cadastro_usuario', {
    method: "POST",
    body: formulario
  }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        if (resposta == true) {
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
