create table users(
    id bigserial primary key,
    first_name varchar(15),
    last_name varchar(30),
    email varchar(50),
    password varchar(20)
);

insert into users(first_name, last_name, email, password) VALUES
('Jack', 'Grey', 'ttjo@gg.com', 'abracadabra'),
('John', 'Smith', 'ttja@gg.com', 'babracadabra'),
('Dora', 'Explorer', 'ttdo@gg.com', 'cabracadabra'),
('Kate', 'Williams', 'ttka@gg.com', 'dabracadabra');


