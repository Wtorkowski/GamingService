
INSERT INTO users (created,password,user_name) VALUES (NOW(),'{noop}pass','user');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'{noop}pass','user1');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'{noop}pass','user2');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'{noop}pass','user3');
INSERT INTO users (created,password,user_name) VALUES (NOW(),'{noop}pass','user4');

INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),7,'easy',23453464,'mastermind',2);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),17,'medium',353453,'mastermind',3);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),5,'hard',23464,'mastermind',1);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),12,'easy',23131,'mastermind',1);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),11,'hard',42342,'mastermind',4);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),23,'easy',5474777,'mastermind',2);
INSERT INTO games_history (created,attempts,difficulty,duration,game_name,user_id) VALUES (NOW(),4,'medium',435345345345,'mastermind',1);

