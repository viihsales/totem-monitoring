var express = require('express');
var router = express.Router();
var banco = require('../app-banco');

router.post('/login', function (req, res, next) {

  banco.conectar().then(() => {
    console.log(`Chegou p/ login: ${JSON.stringify(req.body)}`);

    var email = req.body.email;
    var senha = req.body.senha;

    if (email == undefined || senha == undefined) {
      throw new Error(`Algo de errado não está certo: ${email} / ${senha}`);
    }
    return banco.sql.query(`select * from user_admin where email_admin='${email}' and senha_admin='${senha}'`);
  }).then(consulta => {

    console.log(`Usuários encontrados: ${JSON.stringify(consulta.recordset)}`);

    if (consulta.recordset.length == 1) {
      res.send(consulta.recordset[0]);
    } else {
      res.sendStatus(404);
    }

  }).catch(err => {

    var erro = `Erro no login: ${err}`;
    console.error(erro);
    res.status(500).send(erro);

  }).finally(() => {
    banco.sql.close();
  });

});

module.exports = router;
