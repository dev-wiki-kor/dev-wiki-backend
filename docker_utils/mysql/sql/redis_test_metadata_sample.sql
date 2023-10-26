create table redis_test_metadata(
	id BIGINT NOT NULL,
    title VARCHAR(255),
    team VARCHAR(255),
    primary key(id)
) ENGINE=InnoDB;

INSERT INTO redis_test_metadata (id, title, team) VALUES
(1,'Title 1', '313233');

INSERT INTO redis_test_metadata (id, title, team) VALUES
(2,'Title 2', '59595');

INSERT INTO redis_test_metadata (id, title, team) VALUES
(3,'Title 3', '35575');