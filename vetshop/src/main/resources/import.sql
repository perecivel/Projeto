
-- Criacao das categorias
INSERT INTO categoria (nome) VALUES ('Medicamentos');
INSERT INTO categoria (nome) VALUES ('Suplementos');
INSERT INTO categoria (nome) VALUES ('Curativos');
INSERT INTO categoria (nome) VALUES ('Rações');
INSERT INTO categoria (nome) VALUES ('Acessórios');

-- Produtos para cada categoria criada
INSERT INTO produto (preco, categoria_id, nome) VALUES (1.0, 1,'Vermífugo ABC');
INSERT INTO produto (preco, categoria_id, nome) VALUES (1.0, 1, 'Vermífugo DEF');
INSERT INTO produto (preco, categoria_id, nome) VALUES (1.0, 1, 'Vermífugo GHI');
INSERT INTO produto (preco, categoria_id, nome) VALUES (1.0, 1, 'Vermífugo JKL');
INSERT INTO produto (preco, categoria_id, nome) VALUES (1.0, 1, 'Vermífugo MNO');

INSERT INTO produto (preco, categoria_id, nome) VALUES (2.0, 2, 'Suplemento ABC');
INSERT INTO produto (preco, categoria_id, nome) VALUES (2.0, 2, 'Suplemento DEF');
INSERT INTO produto (preco, categoria_id, nome) VALUES (2.0, 2, 'Suplemento GHI');
INSERT INTO produto (preco, categoria_id, nome) VALUES (2.0, 2, 'Suplemento JKL');
INSERT INTO produto (preco, categoria_id, nome) VALUES (2.0, 2, 'Suplemento MNO');

INSERT INTO produto (preco, categoria_id, nome) VALUES (3.0, 3, 'Curativo ABC');
INSERT INTO produto (preco, categoria_id, nome) VALUES (3.0, 3, 'Curativo DEF');
INSERT INTO produto (preco, categoria_id, nome) VALUES (3.0, 3, 'Curativo GHI');
INSERT INTO produto (preco, categoria_id, nome) VALUES (3.0, 3, 'Curativo JKL');
INSERT INTO produto (preco, categoria_id, nome) VALUES (3.0, 3, 'Curativo MNO');

INSERT INTO produto (preco, categoria_id, nome) VALUES (4.0, 4, 'Ração ABC');
INSERT INTO produto (preco, categoria_id, nome) VALUES (4.0, 4, 'Ração DEF');
INSERT INTO produto (preco, categoria_id, nome) VALUES (4.0, 4, 'Ração GHI');
INSERT INTO produto (preco, categoria_id, nome) VALUES (4.0, 4, 'Ração JKL');
INSERT INTO produto (preco, categoria_id, nome) VALUES (4.0, 4, 'Ração MNO');

INSERT INTO produto (preco, categoria_id, nome) VALUES (5.0, 5, 'Acessório ABC');
INSERT INTO produto (preco, categoria_id, nome) VALUES (5.0, 5, 'Acessório DEF');
INSERT INTO produto (preco, categoria_id, nome) VALUES (5.0, 5, 'Acessório GHI');
INSERT INTO produto (preco, categoria_id, nome) VALUES (5.0, 5, 'Acessório JKL');
INSERT INTO produto (preco, categoria_id, nome) VALUES (5.0, 5, 'Acessório MNO');

-- Adicionando Clientes
INSERT INTO cliente (nome, cpf, email, telefone) VALUES ('Eber', '83301040012', 'ersfj@hotmail.com', '(49) 99136-7352');
INSERT INTO cliente (nome, cpf, email, telefone) VALUES ('Diogo', '81618788035', 'diogo@hotmail.com', '(61) 98084-2653');
INSERT INTO cliente (nome, cpf, email, telefone) VALUES ('Allan', '28421996002', 'allan@hotmail.com', '(79) 99511-2692');
INSERT INTO cliente (nome, cpf, email, telefone) VALUES ('Breno', '49057630028', 'breno@hotmail.com', '(68) 98573-8030');
INSERT INTO cliente (nome, cpf, email, telefone) VALUES ('Luizao', '50741735075', 'luiz@hotmail.com', '(24) 99748-2175');

-- Adicionando Fornecedores
INSERT INTO fornecedor (razao_social, cnpj, email, telefone) VALUES ('Noiza', '01578738000101', 'noiza@hotmail.com', '(93) 98291-1555');
INSERT INTO fornecedor (razao_social, cnpj, email, telefone) VALUES ('Paulo', '00472724000138', 'paulo@hotmail.com', '(24) 99437-3086');
INSERT INTO fornecedor (razao_social, cnpj, email, telefone) VALUES ('Adriane', '25387644000105', 'adriane@hotmail.com', '(68) 97615-5815');
INSERT INTO fornecedor (razao_social, cnpj, email, telefone) VALUES ('Joelson', '21938487000128', 'joelson@hotmail.com', '(79) 98534-6388');
INSERT INTO fornecedor (razao_social, cnpj, email, telefone) VALUES ('Murilo', '23286790000119', 'murilo@hotmail.com', '(61) 99488-3273');

-- Adicionando Pedidos
INSERT INTO pedido (nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES ('Medicamentos Eber', 1, 1, PARSEDATETIME('2024-09-02-00.00.00','yyyy-MM-dd-HH.mm.ss'), NULL);
INSERT INTO pedido (nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES ('Suplementos Diogo', 2, 2, PARSEDATETIME('2024-09-02-00.00.00','yyyy-MM-dd-HH.mm.ss'), NULL);
INSERT INTO pedido (nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES ('Curativos Allan', 3, 3, PARSEDATETIME('2024-09-02-00.00.00','yyyy-MM-dd-HH.mm.ss'), NULL);
INSERT INTO pedido (nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES ('Rações Breno', 4, 4, PARSEDATETIME('2024-09-02-00.00.00','yyyy-MM-dd-HH.mm.ss'), NULL);
INSERT INTO pedido (nome, cliente_id, fornecedor_id, data_de_inclusao, data_de_alteracao) VALUES ('Acessórios Luizao', 5, 5, PARSEDATETIME('2024-09-02-00.00.00','yyyy-MM-dd-HH.mm.ss'), NULL);

-- Relacionando produtos ao pedido no ItemPedido
INSERT INTO item_pedido (pedido_id, produto_id) VALUES (1, 1), (1, 2),(1,3);
INSERT INTO item_pedido (pedido_id, produto_id) VALUES (2, 6), (2, 7),(2,8);
INSERT INTO item_pedido (pedido_id, produto_id) VALUES (3, 11), (3, 12),(3,13);
INSERT INTO item_pedido (pedido_id, produto_id) VALUES (4, 16), (4, 17),(4,18);
INSERT INTO item_pedido (pedido_id, produto_id) VALUES (5, 21), (5, 22),(5,23);

