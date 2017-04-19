
CREATE TABLE estado
(
    id                      SERIAL NOT NULL,
    nome                    VARCHAR(40) NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id)
);

CREATE TABLE municipio
(
    id                      SERIAL NOT NULL,
    nome                    VARCHAR(60) NOT NULL,
    estado_id               INTEGER NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pkmunicipio PRIMARY KEY (id),
    CONSTRAINT fk_municipio_estado FOREIGN KEY (estado_id) REFERENCES estado (id)
);

CREATE TABLE endereco
(
    id                      SERIAL NOT NULL,
    cep                     VARCHAR(8) NULL,
    logradouro              VARCHAR(60) NULL,
    numero                  VARCHAR(6) NULL,
    ponto_referencia        VARCHAR(6) NULL,
    bairro                  VARCHAR(40) NULL,
    municipio_id            INTEGER NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_endereco PRIMARY KEY (id),
    CONSTRAINT fk_endereco_municipio FOREIGN KEY (municipio_id) REFERENCES municipio (id)
);

CREATE TABLE pessoa
(
    id                      SERIAL NOT NULL,
    nome                    VARCHAR(60) NOT NULL,
    rg                      VARCHAR(14) NULL,
    profissao               VARCHAR(30) NULL,
    telefone                VARCHAR(11) NULL,
    celular                 VARCHAR(11) NULL,
    email                   VARCHAR(60) NULL,
    endereco_id             INTEGER NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pkpessoa PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_municipio FOREIGN KEY (endereco_id) REFERENCES endereco (id)
);

CREATE TABLE acompanhante
(
    id                      INTEGER NOT NULL,
    grau_parentesco         INTEGER NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_acompanhante PRIMARY KEY (id),
    CONSTRAINT fk_acompanhate_pessoa FOREIGN KEY (id) REFERENCES pessoa(id)
);

CREATE TABLE clinica
(
    id                      SERIAL NOT NULL,
    nome                    VARCHAR(60) NOT NULL,
    telefone                VARCHAR(11) NULL,
    contato                 VARCHAR(60) NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_clinica PRIMARY KEY (id)
);

CREATE TABLE tipo_cancer
(
    id                      SERIAL NOT NULL,
    descricao               VARCHAR(60) NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pktipo_cancer PRIMARY KEY (id)
);

CREATE TABLE tratamento
(
    id                  SERIAL NOT NULL,
    quimioterapio       BOOL DEFAULT false NOT NULL,
    radioterapio        BOOL DEFAULT false NOT NULL,
    data_diagnostico    DATE NOT NULL,
    data_fim_tratamento DATE NULL,
    tipo_finalizacao    INTEGER NULL,
    tipo_cancer_id      INTEGER NULL,
    clinica_id          INTEGER NULL,
    paciente_id         INTEGER NULL,
    data_criacao        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_tratamento PRIMARY KEY (id),
    CONSTRAINT fk_tipo_cancer_clinica FOREIGN KEY (tipo_cancer_id) REFERENCES tipo_cancer (id),
    CONSTRAINT fk_tratamento_clinica FOREIGN KEY (clinica_id) REFERENCES clinica (id)
);
/* Add Comments */
COMMENT ON COLUMN tratamento.tipo_finalizacao IS '1 - Cura
2 - Óbito';


CREATE TABLE paciente
(
    id                      SERIAL NOT NULL,
    data_nacimento          DATE NOT NULL,
    escolaridade            INTEGER NOT NULL,
    estado_civil            INTEGER NULL,
    quantidade_filho        INTEGER DEFAULT 0 NOT NULL,
    conjuge                 VARCHAR(60) NULL,
    tipo_moradia            INTEGER DEFAULT 1 NOT NULL,
    recebe_renda            BOOL DEFAULT false NOT NULL,
    observacao              VARCHAR(100) NULL,
    acompanhante_id          INTEGER NULL,
    tratamento_id           INTEGER NULL,
    pessoa_id               INTEGER NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_paciente PRIMARY KEY (id),
    CONSTRAINT fk_paciente_acompanhate FOREIGN KEY (acompanhante_id) REFERENCES acompanhante (id),
    CONSTRAINT fk_paciente_pessoa FOREIGN KEY (id) REFERENCES pessoa (id)
);


ALTER TABLE tratamento ADD CONSTRAINT fk_tratamento_paciente FOREIGN KEY (paciente_id) REFERENCES paciente (id);

ALTER TABLE paciente ADD CONSTRAINT fk_paciente_tratamento FOREIGN KEY (tratamento_id) REFERENCES tratamento (id);


CREATE TABLE tipo_servico
(
    id                      SERIAL NOT NULL,
    descricao               VARCHAR(60) NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_tipo_servico PRIMARY KEY (id)
);

CREATE TABLE servico
(
    id                      SERIAL NOT NULL,
    descricao               VARCHAR(60) NULL,
    tipo_servico_id         INTEGER NOT NULL,
    paciente_id             INTEGER NOT NULL,
    quantidade              NUMERIC(9, 2) DEFAULT 0 NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pkservico PRIMARY KEY (id),
    CONSTRAINT fk_servico_paciente FOREIGN KEY (paciente_id) REFERENCES paciente (id),
    CONSTRAINT fk_servico_tipo_servico FOREIGN KEY (tipo_servico_id) REFERENCES tipo_servico (id)
);

CREATE TABLE tipo_doacao
(
    id                      SERIAL NOT NULL,
    descricao               VARCHAR(60) NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_tipo_doacao PRIMARY KEY (id)
);

CREATE TABLE doador
(
    id                      SERIAL NOT NULL,
    nome                    VARCHAR(60) NOT NULL,
    endereco                VARCHAR(60) NULL,
    telefone                VARCHAR(11) NULL,
    cpf                     VARCHAR(11) NULL,
    municipio_id            INTEGER NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_doador PRIMARY KEY (id),
    CONSTRAINT fk_doador_municipio FOREIGN KEY (municipio_id) REFERENCES municipio (id)
);

CREATE TABLE doacao
(
    id                      SERIAL NOT NULL,
    doador_id               INTEGER NOT NULL,
    tipo_doacao_id          INTEGER NOT NULL,
    quantidade              NUMERIC(11, 2) DEFAULT 0 NOT NULL,
    observacao              VARCHAR(100) NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_doacao  PRIMARY KEY (id),
    CONSTRAINT fk_doacao_doador FOREIGN KEY (doador_id) REFERENCES doador (id),
    CONSTRAINT fk_doacao_tipo_doacao FOREIGN KEY (tipo_doacao_id) REFERENCES tipo_doacao (id)
);

CREATE TABLE utilizacao_doacao
(
    id                      SERIAL NOT NULL,
    doacao_id               INTEGER NOT NULL,
    tipo_servico_id         INTEGER NOT NULL,
    quantidade              NUMERIC(11, 2) DEFAULT 0 NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_utilizacao_doacao  PRIMARY KEY (id),
    CONSTRAINT fk_utilizacao_doacao_doacao FOREIGN KEY (doacao_id) REFERENCES doacao (id),
    CONSTRAINT fk_utilizacao_doacao_tipo_servico FOREIGN KEY (tipo_servico_id) REFERENCES tipo_servico (id)

);

CREATE TABLE usuario
(
    id                      SERIAL NOT NULL,
    tipo                    INTEGER NOT NULL DEFAULT 3,
    nome                    VARCHAR(60) NOT NULL,
    login                   VARCHAR(60) NOT NULL,
    senha                   VARCHAR NOT NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id),
    CONSTRAINT un_login unique (login)
);
--1 - ADM, 2 - FINANCEIRO 3-ATENDIMENTO

CREATE TABLE auditoria
(
    id                      SERIAL NOT NULL,
    rotina                  INTEGER NOT NULL,
    usuario_id              INTEGER NOT NULL,
    tipo_operacao           INTEGER NOT NULL,
    identificacao_registro  INTEGER NULL,
    data_criacao            TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT pk_auditoria PRIMARY KEY (id),
    CONSTRAINT fk_auditoria_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);

/* Add Comments */
COMMENT ON COLUMN auditoria.tipo_operacao IS '1 - INSERT
2 - UPDATE
3 - DELETE';
COMMENT ON COLUMN auditoria.identificacao_registro IS 'id do registro alterado, não será fk';