create table IF NOT EXISTS students(
    id bigserial primary key,
    name varchar(50),
    age int
);

insert into students(name, age) values ('John', 15);