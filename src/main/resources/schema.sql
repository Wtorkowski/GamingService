create table achievements (id bigint not null auto_increment, created datetime(6), updated datetime(6), description varchar(255) not null, text varchar(255) not null, value integer not null, primary key (id));
create table achievements_user_list (achievement_id bigint not null, user_list_id bigint not null);
create table games_history (id bigint not null auto_increment, created datetime(6), updated datetime(6), attempts integer not null, difficulty varchar(255) not null, duration bigint not null, encrypted varchar(255), game_name varchar(255) not null, user_id bigint, primary key (id));
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
create table mastermind_attempts (id bigint not null, created datetime(6), decription_attempt varchar(5) not null, feedback varchar(255) not null, user_id bigint, primary key (id));
create table users (id bigint not null auto_increment, created datetime(6), updated datetime(6), password varchar(255) not null, user_name varchar(20) not null, primary key (id));

INSERT INTO users (created, password, user_name)
    VALUES (now(), '{noop}Password1', 'newbie');
INSERT INTO users (created, password, user_name)
    VALUES (now(), '{noop}Password1', 'veteran'); 

INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),9,'medium',235,2345,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),11,'hard',467,12313,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),8,'medium',199,2345,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),9,'easy',310,1221,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),12,'medium',123,6663,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),10,'medium',304,2266,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),8,'easy',230,1122,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),7,'easy',120,4423,'mastermind',2);
INSERT INTO games_history (created, updated, attempts, difficulty, duration, encrypted, game_name, user_id)
    VALUES (now(), now(),9,'easy',213,1212,'mastermind',2);
