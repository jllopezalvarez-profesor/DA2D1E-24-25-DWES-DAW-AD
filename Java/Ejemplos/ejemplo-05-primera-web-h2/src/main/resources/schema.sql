create table rooms
(    room_id BIGINT       not null auto_increment,
    name    VARCHAR(100) not null,
    constraint pk_rooms primary key (room_id)
);