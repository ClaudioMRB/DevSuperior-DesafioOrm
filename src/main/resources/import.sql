INSERT INTO tb_categoria (descricao) VALUES ('Curso');
INSERT INTO tb_categoria (descricao) VALUES ('Oficina');
INSERT INTO tb_atividade (nome, descricao, preco, categoria_id) VALUES  ('Curso d HTML', 'Aprenda HTML de forma prática', 80.0, 1);
INSERT INTO tb_atividade (nome, descricao, preco, categoria_id) VALUES  ('Oficina de Github', 'Controle versões de seus projetos', 50.0, 2);
INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES ('2017-09-25T08:00:00Z', '2017-09-25T11:00:00Z', 1);
INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES ('2017-09-25T14:00:00Z', '2017-09-25T18:00:00Z', 2);
INSERT INTO tb_bloco (inicio, fim, atividade_id) VALUES ('2017-09-26T08:00:00Z', '2017-09-26T11:00:00Z', 2);
INSERT INTO tb_participante (name, email) VALUES ('José da Silva', 'jose@gmail.com');
INSERT INTO tb_participante (name, email) VALUES ('Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante (name, email) VALUES ('MAria do Rosário', 'maria@gmail.com');
INSERT INTO tb_participante (name, email) VALUES ('Teresa Silva', 'teresa@gma1il.com');
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (1,1);
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (1,2);
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (2,1);
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (3,1);
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (3,2);
INSERT INTO tb_atividade_participante (participante_id, atividades_id) VALUES (4,2);