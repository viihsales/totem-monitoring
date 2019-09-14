function verificarAutenticacao() {
  if (sessionStorage.usuario != undefined) {
    window.location.href = 'cadastro.html';
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
        sessionStorage.usuario = resposta.email_admin;
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

function wait() {
  sendMessageButton.disabled = true;
}

function end_wait() {
  sendMessageButton.disabled = false;
}
