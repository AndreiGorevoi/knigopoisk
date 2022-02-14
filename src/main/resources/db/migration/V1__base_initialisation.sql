CREATE TABLE USERS
(
    ID            uuid primary key DEFAULT gen_random_uuid(),
    LOGIN         varchar(50)  not null unique,
    PASSWORD      varchar(50)  not null,
    EMAIL         varchar(255) not null unique,
    DATE_CREATION date        default now(),
    DATE_UPDATING date        default now(),
    STATUS        varchar(30) default 'ACTIVE' not null
);
CREATE TABLE ROLES
(
    ID            uuid primary key default gen_random_uuid(),
    NAME          varchar(50) unique,
    DATE_CREATION date        default now(),
    DATE_UPDATING date        default now(),
    STATUS        varchar(30) default 'ACTIVE' not null
);
create table USER_ROLES
(
    user_id uuid not null,
    role_id uuid not null,
    primary key (user_id, role_id),
    foreign key (user_id) references USERS(id) on update cascade,
    foreign key (role_id) references ROLES(id) on update cascade
)
