function verificarAutenticacao() {
  if (sessionStorage.usuario_bandtec != undefined) {
    window.location.href = '#';
  }
}

function logar() {
  console.log('EFETUANDO LOGIN...');

  wait();

  var formulario = new URLSearchParams(new FormData(form_login));

  fetch('/usuarios/login', {
    method: "POST",
    body: formulario
  }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        console.log(responde.email)
        sessionStorage.usuario_bandtec = resposta.email;
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
