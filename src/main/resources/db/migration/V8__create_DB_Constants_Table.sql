CREATE TABLE db_constant (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   name VARCHAR(255) NOT NULL,
   value VARCHAR(255) NULL,
   CONSTRAINT pk_dbconstant PRIMARY KEY (id)
);

ALTER TABLE db_constant ADD CONSTRAINT uc_dbconstant_name UNIQUE (name);