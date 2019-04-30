CREATE TABLE games_history (id bigint not null auto_increment, created datetime(6), updated datetime(6), attempts integer not null, difficulty varchar(255) not null, duration bigint not null, game_name varchar(255) not null, user_id bigint, primary key (id)) engine=InnoDB;
CREATE TABLE mastermind_attempts (id bigint not null auto_increment, created datetime(6), updated datetime(6), decription_attempt varchar(5) not null, difficulty_level varchar(9), encrypted varchar(5) not null, feedback varchar(12) not null, primary key (id)) engine=InnoDB;
CREATE TABLE users (id bigint not null auto_increment, created datetime(6), updated datetime(6), password varchar(255) not null, user_name varchar(20) not null, primary key (id)) engine=InnoDB;
CREATE TABLE users_games_history (user_id bigint not null, game_records_id bigint not null) engine=InnoDB;