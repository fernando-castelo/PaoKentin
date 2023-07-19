CREATE TABLE Pao (
                     id INT PRIMARY KEY,
                     tipo_pao VARCHAR(255),
                     descricao VARCHAR(255),
                     tempo_preparo INT
);

CREATE TABLE Fornada (
                         id INT PRIMARY KEY,
                         pao_id INT,
                         inicio_fornada TIME,
                         final_fornada TIME,
                         tempo_restante BIGINT,
                         FOREIGN KEY (pao_id) REFERENCES Pao(id)
);