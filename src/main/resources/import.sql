INSERT INTO CATEGORY(title) VALUES ('Arbeit');
INSERT INTO CATEGORY(title) VALUES ('Ferien');
INSERT INTO CATEGORY(title) VALUES ('Krankheit');
INSERT INTO CATEGORY(title) VALUES ('Berufsschule');
INSERT INTO CATEGORY(title) VALUES ('Mutterschaftsurlaub');
INSERT INTO CATEGORY(title) VALUES ('Militär/Zivilschutz');

INSERT INTO USER (username, password) VALUES ('zli', 'secret');

INSERT INTO ENTRY (category_id, checkin, checkout) VALUES (1, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'});
INSERT INTO ENTRY (category_id, checkin, checkout) VALUES (1, {ts '2015-09-17 18:47:52.69'}, {ts '2015-09-17 18:47:52.69'});
INSERT INTO ENTRY (category_id, checkin, checkout) VALUES (1, {ts '2013-09-17 19:39:52.69'}, {ts '2013-09-17 18:33:52.69'});
