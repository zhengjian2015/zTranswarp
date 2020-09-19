CREATE TABLE categories (
  id BIGINT NOT NULL,
  created_at BIGINT NOT NULL,
  display_order BIGINT NOT NULL,
  updated_at BIGINT NOT NULL,
  version BIGINT NOT NULL,
  tag VARCHAR(32) NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categories (name, tag, description, display_order, id, created_at, updated_at, version) VALUES ('Sample', 'sample', 'Java Series', 0, 1279976691204512, 1557025248747, 1557025248747, 0);
