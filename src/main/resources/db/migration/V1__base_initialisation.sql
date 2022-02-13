CREATE TABLE USERS
(
    ID            uuid primary key,
    USERNAME      varchar(50)  not null unique,
    PASSWORD      varchar(50)  not null unique,
    EMAIL         varchar(255) not null unique,
    DATE_CREATION date        default now(),
    DATE_UPDATING date        default now(),
    STATUS        varchar(30) default 'ACTIVE'
);
CREATE TABLE ROLES
(
    ID            uuid primary key,
    NAME          varchar(50) unique,
    DATE_CREATION date        default now(),
    DATE_UPDATING date        default now(),
    STATUS        varchar(30) default 'ACTIVE'
);
create table USER_ROLES
(
    user_id uuid references USERS(id),
    role_id uuid references ROLES(id)
)
