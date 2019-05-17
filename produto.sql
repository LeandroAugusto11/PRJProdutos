create database dbproduto;
use dbproduto;
create table tbcadastrarproduto(
id int auto_increment primary key,
nome varchar(50) not null,
descricao varchar(150) not null,
fabricantePr varchar(100) not null,
quantidade int(4) not null,
preco decimal(10,2) not null
);
insert into tbcadastrarproduto(nome,descricao,fabricantePr,quantidade,preco)
values('Nescau','Chocolate','Nescau',2,'10');

select * from tbcadastrarproduto;