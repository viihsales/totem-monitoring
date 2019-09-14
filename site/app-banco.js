var desenvolvimento = false;

var configuracoes = {
    producao: {
        server: "servidor01191050.database.windows.net",
        user: "GF01191050",
        password: "#Gf47652050880",
        database: "Banco_Projeto",
        options: {
            encrypt: true
        },
        pool: {
            max: 4,
            min: 1,
            idleTimeoutMillis: 30000
        }
    },
    desenvolvimento: {
        server: "servidor01191050.database.windows.net",
        user: "GF01191050",
        password: "#Gf47652050880",
        database: "Banco_Projeto",
        options: {
            encrypt: true
        }
    }
}

var sql = require('mssql');
sql.on('error', err => {
    console.error(`Erro de Conexão: ${err}`);
});

var perfil = desenvolvimento ? 'desenvolvimento' : 'producao';

function conectar() {
  return sql.connect(configuracoes[perfil])
}

module.exports = {
    conectar: conectar,
    sql: sql
}
