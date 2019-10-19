var express = require('express');
var router = express.Router();
var banco = require('../app-banco');

router.post('/login', function (req, res, next) {

  banco.conectar().then(() => {
    console.log(`Chegou p/ login: ${JSON.stringify(req.body)}`);

    var cpf = req.body.cpf;
    var senha = req.body.senha;

    if (cpf == undefined || senha == undefined) {
      throw new Error(`Algo de errado não está certo: ${cpf} / ${senha}`);
    }
    else {
      return banco.sql.query(`select * from tb_user where cpf_user='${cpf}' and senha_user='${senha}'`);
    }
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

router.post('/cadastro_usuario', function (req, res, next) {

  banco.conectar().then(() => {
    console.log(`Chegou p/ Cadastro: ${JSON.stringify(req.body)}`);

    var nome = req.body.nome;
    var email = req.body.email;
    var cpf = req.body.cpf;
    var senha = req.body.password;
    var fk = req.body.fk;

    if (nome == undefined || email == undefined || cpf == undefined || senha == undefined || fk == undefined) {
      throw new Error(`Algo de errado não está certo: ${nome} / ${email} / ${cpf} / ${senha} / ${fk}`);
    }
    else {
      return banco.sql.query(`insert into tb_user (nome, email_user, cpf_user, senha_user, adm, fk_aeroporto) values ('${nome}', '${email}', '${cpf}', '${senha}', 0, ${fk} )`);
    }
  }).then(consulta => {

    if (consulta.recordset.length == 1) {
      res.send(consulta.recordset[0]);
    } else {
      res.sendStatus(404);
    }

  }).catch(err => {

    var erro = `Erro no cadastro: ${err}`;
    console.error(erro);
    res.status(500).send(erro);

  }).finally(() => {
    banco.sql.close();
  });

});

router.post('/inativar_user', function (req, res, next) {

  banco.conectar().then(() => {
    console.log(`Chegou p/ Cadastro: ${JSON.stringify(req.body)}`);

    if (nome == undefined || email == undefined || cpf == undefined || senha == undefined) {
      throw new Error(`Algo de errado não está certo: ${nome} / ${email} / ${cpf} / ${senha}`);
    }
    return banco.sql.query(`select * tb_user`)
  }).then(consulta => {

    console.log('Usuário cadastrado');

  }).catch(err => {

    var erro = `Erro no cadastro: ${err}`;
    console.error(erro);
    res.status(500).send(erro);

  }).finally(() => {
    banco.sql.close();
  });

});

router.post('/users', function (req, res, next) {

  banco.conectar().then(() => {

    if (nome == undefined || email == undefined || cpf == undefined || senha == undefined) {
      throw new Error(`Algo de errado não está certo: ${nome} / ${email} / ${cpf} / ${senha}`);
    }
    return banco.sql.query(`select * tb_user where fk_funcionario = ${id}`)
  }).then(consulta => {

    if (consulta.recordset.length == 1) {
      res.send(consulta.recordset[0]);
    } else {
      res.sendStatus(404);
    }

  }).catch(err => {

    var erro = `Erro no cadastro: ${err}`;
    console.error(erro);
    res.status(500).send(erro);

  }).finally(() => {
    banco.sql.close();
  });

});

module.exports = router;
