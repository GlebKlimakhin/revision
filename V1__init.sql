create table if not exists films (
                       id int not null unique primary key,
                       name text not null,
                       duration int not null
);

create table if not exists schedule (
                          id int not null primary key,
                          film_id int,
                          start_time time not null,
                          end_time text not null,
                          price int not null
);

create table if not exists tickets (
                         id int not null unique primary key,
                         schedule_id int not null,
                         client_name text
);

alter table only schedule
    add constraint begin_time unique (film_id, start_time);

create index film_name on films using btree(name);

alter table only schedule
    add constraint film_id foreign key (film_id) references films(id);

alter table only tickets
    add constraint schedule_id foreign key (schedule_id) references schedule(id);

insert into films(id, name, duration) values

(1, 'Black Rock Shooter', 60),
(2, 'Terminator 2', 120),
(3, 'Die Hard', 90),
(4, 'Seven', 120),
(5, 'Gone girl', 120),
(6, 'Orphan Brooklyn', 90),
(7, 'Friends', 60),
(8, 'Braveheart', 120);

insert into schedule (id, film_id, start_time, end_time, price) values

(1, 1, '10:00', '11:00:00', 100),
(2, 1, '11:00', '12:00:00', 200),
(3, 2, '21:30', '23:30:00', 320),
(4, 5, '8:00', '10:00:00', 110),
(5, 6, '15:00', '16:30:00', 200),
(6, 8, '17:00', '19:00:00', 350);


insert into tickets (id, schedule_id, client_name)
values
(1, 2, null),
(2, 2, null),
(3, 4, 'Oleg'),
(2, 4, null);

select r1.film_name 'film1_name',
r1.start_time 'start_time2',
r2.filmname 'film_name',
r2.duration 'duration1',
r2.start_time 'start_time2',
r2.film_name 'film2_name',
r2.duration 'duration2'

from

    (select schedule.id, f.name film_name, schedule.start_time start_time, f.duration duration from schedule inner join films f on schedule.film_id = f.id) r1,
    (select schedule.id, f.name film_name, schedule.start_time start_time, f.duration duration from schedule inner join films f ON schedule.film_id = f.id) r2

where

r1.id<>r2.id

and

    (
        (
                    r2.start_time > r1.start_time and
                    ((r2.start_time - make_time(r1.duration::int/60, r1.duration::int - r1.duration::int/60 * 60, 00.0)) < r1.start_time)
            )
    or
    (
                    r1.start_time > r2.start_time and
                    (r1.start_time - make_time(r2.duration::int/60, r2.duration::int - r2.duration::int/60 * 60, 00.0)) < r2.start_time
            )
    )

order by r1.start_time;


