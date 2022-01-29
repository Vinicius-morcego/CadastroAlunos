create table aluno (id bigint not null auto_increment, endereco_cep varchar(255) not null, endereco_complemento varchar(255), endereco_logradouro varchar(255) not null, endereco_numero varchar(255) not null, idade integer not null, nome varchar(255) not null, endereco_cidade_id bigint not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, nome varchar(255), cidade_estado_id bigint, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, sigla varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table cidade add constraint FK8guahfg4my7o4ms3sctltsadp foreign key (cidade_estado_id) references estado (id)
create table aluno (id bigint not null auto_increment, endereco_cep varchar(255) not null, endereco_complemento varchar(255), endereco_logradouro varchar(255) not null, endereco_numero varchar(255) not null, idade integer not null, nome varchar(255) not null, endereco_cidade_id bigint not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, nome varchar(255), cidade_estado_id bigint, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, sigla varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table cidade add constraint FK8guahfg4my7o4ms3sctltsadp foreign key (cidade_estado_id) references estado (id)
create table aluno (id bigint not null auto_increment, endereco_cep varchar(255) not null, endereco_complemento varchar(255), endereco_logradouro varchar(255) not null, endereco_numero varchar(255) not null, idade integer not null, nome varchar(255) not null, endereco_cidade_id bigint not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, nome varchar(255), cidade_estado_id bigint, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, sigla varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table cidade add constraint FK8guahfg4my7o4ms3sctltsadp foreign key (cidade_estado_id) references estado (id)
