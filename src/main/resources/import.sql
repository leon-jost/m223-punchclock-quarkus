INSERT INTO CATEGORY(title) VALUES ('Arbeit');
INSERT INTO CATEGORY(title) VALUES ('Ferien');
INSERT INTO CATEGORY(title) VALUES ('Krankheit');
INSERT INTO CATEGORY(title) VALUES ('Berufsschule');
INSERT INTO CATEGORY(title) VALUES ('Mutterschaftsurlaub');
INSERT INTO CATEGORY(title) VALUES ('Militär/Zivilschutz');

INSERT INTO PROJECT(title) VALUES ('A847K');
INSERT INTO PROJECT(title) VALUES ('A850K');
INSERT INTO PROJECT(title) VALUES ('S33K');
INSERT INTO PROJECT(title) VALUES ('M598P');

INSERT INTO ROLE (title, keyword) VALUES ('Administrator', 'Admin');
INSERT INTO ROLE (title, keyword) VALUES ('Benutzer', 'User');

INSERT INTO USER (username, password, role_id) VALUES ('zli', 'secret', 1);

INSERT INTO ENTRY (category_id, checkin, checkout) VALUES (1, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'});
INSERT INTO ENTRY (category_id, checkin, checkout, project_id) VALUES (3, {ts '2015-09-17 18:47:52.69'}, {ts '2015-09-17 18:47:52.69'}, 1);
INSERT INTO ENTRY (category_id, checkin, checkout) VALUES (1, {ts '2013-09-17 19:39:52.69'}, {ts '2013-09-17 18:33:52.69'});
