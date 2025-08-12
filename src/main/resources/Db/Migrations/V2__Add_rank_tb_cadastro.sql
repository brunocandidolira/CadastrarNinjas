-- Migrations para add a coluna de Rank na tabela d ecadastro
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);