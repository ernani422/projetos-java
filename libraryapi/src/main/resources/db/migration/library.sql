CREATE TABLE livro
(
    id              UUID         NOT NULL,
    isbn            VARCHAR(20)  NOT NULL,
    titulo          VARCHAR(150) NOT NULL,
    data_publicacao date,
    genero          VARCHAR(30)  NOT NULL,
    preco           DECIMAL(18, 2),
    id_autor        UUID,
    CONSTRAINT pk_livro PRIMARY KEY (id)
);

CREATE TABLE autor
(
    id              UUID         NOT NULL,
    nome            VARCHAR(100) NOT NULL,
    data_nascimento date         NOT NULL,
    nacionalidade   VARCHAR(50)  NOT NULL,
    CONSTRAINT pk_autor PRIMARY KEY (id)
);

ALTER TABLE livro
    ADD CONSTRAINT FK_LIVRO_ON_ID_AUTOR FOREIGN KEY (id_autor) REFERENCES autor (id);