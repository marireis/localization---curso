create table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);
insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1,'Teresina',100000),
    (2,'Recife',1200000),
    (3,'Sao Paulo',1300000),
    (4,'Rio',1400000),
    (5,'Pernambuco',1500000),
    (6,'Fortaleza', 2000),
    (7,'Joao Pessoa',null),
    (8,'Tianguá',null)
;
select * from tb_cidade where nome like '%s%'