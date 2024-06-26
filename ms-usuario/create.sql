create table tb_role (id int8 generated by default as identity, role_name varchar(255), primary key (id));
create table tb_usuario (id int8 generated by default as identity, email varchar(255), nome varchar(255), senha varchar(255), primary key (id));
create table tb_usuario_role (usuario_id int8 not null, role_id int8 not null, primary key (usuario_id, role_id));
alter table if exists tb_usuario add constraint UK_spmnyb4dsul95fjmr5kmdmvub unique (email);
alter table if exists tb_usuario_role add constraint FKkix4nwaehqjwnk40e2e36903j foreign key (role_id) references tb_role;
alter table if exists tb_usuario_role add constraint FKj4syki71kai6syrfuly9xfcq foreign key (usuario_id) references tb_usuario;
