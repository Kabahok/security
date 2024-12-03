create table messages(
    message_id serial primary key,
    message_text text,
    author VARCHAR(255),
    recipient VARCHAR(255),
    email VARCHAR(255)

);