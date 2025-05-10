-- Tabela USUARIO
CREATE TABLE IF NOT EXISTS usuario (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    permissao TEXT NOT NULL,
    status TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    ultimo_login TIMESTAMP,
    senha_hash TEXT NOT NULL
);

-- Tabela PRODUTO
CREATE TABLE IF NOT EXISTS produto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo INTEGER UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    descricao TEXT,
    preco REAL NOT NULL,
    quantidade_estoque INTEGER NOT NULL DEFAULT 0
);

-- Tabela VENDA
CREATE TABLE IF NOT EXISTS venda (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    data_venda TIMESTAMP NOT NULL,
    valor_total REAL NOT NULL,
    forma_pagamento TEXT NOT NULL,
    observacao TEXT,
    usuario_id INTEGER,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Tabela ITEM_VENDA
CREATE TABLE IF NOT EXISTS item_venda (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    quantidade INTEGER NOT NULL,
    preco_unitario REAL NOT NULL,
    preco_total REAL NOT NULL,
    venda_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES venda(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);