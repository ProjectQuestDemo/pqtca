

DROP DATABASE IF EXISTS test;
create DATABASE test;
use test;


CREATE TABLE test_table (
  id INT NOT NULL AUTO_INCREMENT,
  gender VARCHAR(30) NOT NULL,
  race VARCHAR(30) not null,
  PRIMARY KEY (id)
);

INSERT INTO test_table (gender, race) VALUES
  ('male','white'), ('female', 'hispanic'), ('male', 'black'), ('female', 'asian');