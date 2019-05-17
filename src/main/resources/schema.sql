create table achievements (id bigint not null auto_increment, created datetime(6), updated datetime(6), description varchar(255) not null, text varchar(255) not null, value integer not null, primary key (id));
create table achievements_user_list (achievement_id bigint not null, user_list_id bigint not null);
create table games_history (id bigint not null auto_increment, created datetime(6), updated datetime(6), attempts integer not null, difficulty varchar(255) not null, duration bigint not null, encrypted varchar(255), game_name varchar(255) not null, user_id bigint, primary key (id));
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
create table mastermind_attempts (id bigint not null, created datetime(6), decription_attempt varchar(5) not null, feedback varchar(255) not null, user_id bigint, primary key (id));
create table users (id bigint not null auto_increment, created datetime(6), updated datetime(6), password varchar(255) not null, user_name varchar(20) not null, primary key (id));

INSERT INTO users (created, password, user_name)
    VALUES (now(), '{noop}Password1', 'Maniac');