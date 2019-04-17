CREATE TABLE games_history (id bigint not null auto_increment, created datetime(6), updated datetime(6), attempts integer not null, difficulty varchar(255) not null, duration bigint not null, game_name varchar(255) not null, user_id bigint, primary key (id)) engine=InnoDB;
CREATE TABLE mastermind_attempts (id bigint not null auto_increment, created datetime(6), updated datetime(6), decription_attempt varchar(5) not null, difficulty_level varchar(9), encrypted varchar(5) not null, feedback varchar(12) not null, primary key (id)) engine=InnoDB;
CREATE TABLE users (id bigint not null auto_increment, created datetime(6), updated datetime(6), password varchar(255) not null, user_name varchar(20) not null, primary key (id)) engine=InnoDB;
CREATE TABLE users_games_history (user_id bigint not null, game_records_id bigint not null) engine=InnoDB;

INSERT INTO users (created,password,user_name) VALUES (NOW(),'pass','user');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'pass1','user1');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'pass2','user2');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'pass3','user3');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'pass4','user4');

INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),7,'easy',23453464,'mastermind',2);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),17,'medium',353453,'mastermind',3);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),5,'hard',23464,'mastermind',1);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),12,'easy',23131,'mastermind',1);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),11,'hard',42342,'mastermind',4);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),23,'easy',5474777,'mastermind',2);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),4,'medium',435345345345,'mastermind',1);

