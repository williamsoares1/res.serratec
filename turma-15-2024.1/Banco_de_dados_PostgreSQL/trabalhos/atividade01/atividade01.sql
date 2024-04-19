CREATE TABLE IF NOT EXISTS meu_schema.produtos
(
    codigo integer NOT NULL DEFAULT nextval('meu_schema.produtos_codigo_seq'::regclass),
    descricao character varying(100) COLLATE pg_catalog."default",
    preco_venda double precision,
    ean numeric(13,0),
    valor_desconto double precision,
    valor_custo double precision,
    categoria character varying(30) COLLATE pg_catalog."default",
    data_cad timestamp without time zone,
    data_val timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS meu_schema.produtos
    OWNER to postgres;

insert into meu_schema.produtos
(descricao, preco_venda, ean, valor_desconto, valor_custo, categoria, data_cad, data_val)
values
('Uma excelente pizza', 19.90, 12345678910, 0, 8.00, 'Alimentos congelados', now(), '25/09/2030'),
('Uma excelente lasanha', 12.90, 12345678911, 1.00, 3.00, 'Alimentos congelados', now(), '26/10/2028'),
('Um otimo suco', 4.50, 12345678912, 0, 1.00, 'Bebidas', now(), '01/05/2026'),
('Recomendado pelos expecialistas', 25.00, 12345678913, 0, 12.00, 'Medicamentos', now(), '12/12/2030'),
('99% dos dentistas aprovam', 5.00, 12345678914, 1.00, 2.00, 'Higiene', now(), '31/10/2025');

select * from meu_schema.produtos;

select preco_venda, valor_custo, categoria, codigo from meu_schema.produtos;