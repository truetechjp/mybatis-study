create table if not exists account (
  id   number(10) auto_increment,
  name char(50),
  birthday date,
  insert_time timestamp,
  update_time timestamp,
  primary key (id)
);
