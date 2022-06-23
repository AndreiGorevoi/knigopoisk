CREATE TABLE authors(
    id uuid primary key,
    first_name VARCHAR(30),
    second_name VARCHAR(30),
    DATE_CREATION date default now(),
    DATE_UPDATING date default now(),
    STATUS varchar(30) default 'ACTIVE' not null
);

CREATE TABLE books(
    id uuid primary key,
    title VARCHAR(255),
    genre VARCHAR(30),
    DATE_CREATION date default now(),
    DATE_UPDATING date default now(),
    STATUS varchar(30) default 'ACTIVE' not null
);

CREATE TABLE books_authors(
    book_id uuid references books(id),
    author_id uuid references authors(id)
)