CREATE TABLE evento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    identificador VARCHAR(255) UNIQUE NOT NULL,
    tipo_evento VARCHAR(255),
    local_evento VARCHAR(255),
    organizador VARCHAR(255),
    capacidade INTEGER NOT NULL
);

