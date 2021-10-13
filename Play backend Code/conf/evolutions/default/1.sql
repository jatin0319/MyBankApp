# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- init script create procs
-- Inital script to create stored procedures etc for mysql platform
DROP PROCEDURE IF EXISTS usp_ebean_drop_foreign_keys;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_foreign_keys TABLE, COLUMN
-- deletes all constraints and foreign keys referring to TABLE.COLUMN
--
CREATE PROCEDURE usp_ebean_drop_foreign_keys(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE c_fk_name CHAR(255);
  DECLARE curs CURSOR FOR SELECT CONSTRAINT_NAME from information_schema.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE() and TABLE_NAME = p_table_name and COLUMN_NAME = p_column_name
      AND REFERENCED_TABLE_NAME IS NOT NULL;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN curs;

  read_loop: LOOP
    FETCH curs INTO c_fk_name;
    IF done THEN
      LEAVE read_loop;
    END IF;
    SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP FOREIGN KEY ', c_fk_name);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
  END LOOP;

  CLOSE curs;
END
$$

DROP PROCEDURE IF EXISTS usp_ebean_drop_column;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_column TABLE, COLUMN
-- deletes the column and ensures that all indices and constraints are dropped first
--
CREATE PROCEDURE usp_ebean_drop_column(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  CALL usp_ebean_drop_foreign_keys(p_table_name, p_column_name);
  SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP COLUMN ', p_column_name);
  PREPARE stmt FROM @sql;
  EXECUTE stmt;
END
$$
create table acc_status (
  status_id                     integer auto_increment not null,
  status_name                   varchar(255),
  constraint pk_acc_status primary key (status_id)
);

create table send_money (
  trans_id                      integer,
  acc_no                        varchar(255),
  ifsc                          varchar(255),
  amount                        varchar(255),
  constraint uq_send_money_trans_id unique (trans_id)
);

create table transaction_hist (
  trans_id                      integer auto_increment not null,
  user_id                       integer,
  trans_desc                    varchar(255),
  date_time                     datetime(6),
  amount                        varchar(255),
  trans_type                    integer,
  constraint uq_transaction_hist_trans_type unique (trans_type),
  constraint pk_transaction_hist primary key (trans_id)
);

create table transaction_type (
  trans_id                      integer auto_increment not null,
  trans_name                    varchar(255),
  constraint pk_transaction_type primary key (trans_id)
);

create table user_details (
  user_id                       integer auto_increment not null,
  fname                         varchar(255),
  lname                         varchar(255),
  role_id                       integer,
  dob                           datetime(6),
  pan_no                        varchar(255),
  adhaar_no                     varchar(255),
  address                       varchar(255),
  email                         varchar(255),
  mobile_no                     varchar(255),
  status_id                     integer,
  balance                       varchar(255),
  constraint pk_user_details primary key (user_id)
);

create table user_password (
  user_id                       integer,
  passwrd                       varchar(255),
  created_on                    datetime(6)
);

create table user_role (
  role_id                       integer auto_increment not null,
  role_name                     varchar(255),
  constraint pk_user_role primary key (role_id)
);

alter table send_money add constraint fk_send_money_trans_id foreign key (trans_id) references transaction_hist (trans_id) on delete restrict on update restrict;

create index ix_transaction_hist_user_id on transaction_hist (user_id);
alter table transaction_hist add constraint fk_transaction_hist_user_id foreign key (user_id) references user_details (user_id) on delete restrict on update restrict;

alter table transaction_hist add constraint fk_transaction_hist_trans_type foreign key (trans_type) references transaction_type (trans_id) on delete restrict on update restrict;

create index ix_user_details_role_id on user_details (role_id);
alter table user_details add constraint fk_user_details_role_id foreign key (role_id) references user_role (role_id) on delete restrict on update restrict;

create index ix_user_details_status_id on user_details (status_id);
alter table user_details add constraint fk_user_details_status_id foreign key (status_id) references acc_status (status_id) on delete restrict on update restrict;

create index ix_user_password_user_id on user_password (user_id);
alter table user_password add constraint fk_user_password_user_id foreign key (user_id) references user_details (user_id) on delete restrict on update restrict;


# --- !Downs

alter table send_money drop foreign key fk_send_money_trans_id;

alter table transaction_hist drop foreign key fk_transaction_hist_user_id;
drop index ix_transaction_hist_user_id on transaction_hist;

alter table transaction_hist drop foreign key fk_transaction_hist_trans_type;

alter table user_details drop foreign key fk_user_details_role_id;
drop index ix_user_details_role_id on user_details;

alter table user_details drop foreign key fk_user_details_status_id;
drop index ix_user_details_status_id on user_details;

alter table user_password drop foreign key fk_user_password_user_id;
drop index ix_user_password_user_id on user_password;

drop table if exists acc_status;

drop table if exists send_money;

drop table if exists transaction_hist;

drop table if exists transaction_type;

drop table if exists user_details;

drop table if exists user_password;

drop table if exists user_role;

