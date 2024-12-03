create table users (
    user_id serial primary key,
    name varchar(50) not null,
    login varchar(20) not null,
    password varchar(80) not null,
    email varchar(80) not null,
    created date not null
);

create table roles (
    role_id serial primary key,
    name varchar(50) not null
);

create table users_roles (
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id)
);

insert into roles (name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (name, login, password, email, created)
values
('Ivan', 'user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com', now()),
('Egor', 'admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com', now());

insert into users_roles (user_id, role_id)
values (1, 1), (2, 2);


