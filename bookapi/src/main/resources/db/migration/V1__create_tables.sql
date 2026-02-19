
-- Tabela Autor
CREATE TABLE autor (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    ano_nascimento DATE,
    ano_falecimento DATE,
    CONSTRAINT uk_autor_nome UNIQUE (nome)
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela Livro
CREATE TABLE livro (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    numero_downloads BIGINT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela intermediaria livro_autor
CREATE TABLE livro_autor (
    livro_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,

    PRIMARY KEY (livro_id, autor_id),

    CONSTRAINT fk_livro_autor_livro
        FOREIGN KEY (livro_id)
        REFERENCES livro(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_livro_autor_autor
        FOREIGN KEY (autor_id)
        REFERENCES autor(id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela idiomas
CREATE TABLE livro_idiomas (
    livro_id BIGINT NOT NULL,
    idioma VARCHAR(10) NOT NULL,

    CONSTRAINT fk_livro_idiomas_livro
        FOREIGN KEY (livro_id)
        REFERENCES livro(id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
