# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customer_id                   bigint auto_increment not null,
  prename                       varchar(255),
  lastname                      varchar(255),
  address                       varchar(255),
  email                         varchar(255),
  constraint pk_customer primary key (customer_id)
);

create table otte (
  otte_id                       bigint auto_increment not null,
  name                          varchar(255),
  rasse                         varchar(255),
  image                         varbinary(255),
  imagepath                     varchar(255),
  constraint pk_otte primary key (otte_id)
);

create table project (
  project_id                    bigint auto_increment not null,
  name                          varchar(255),
  duration                      integer,
  constraint pk_project primary key (project_id)
);

create table project_task (
  projecttask_id                bigint auto_increment not null,
  project_project_id            bigint,
  task_task_id                  bigint,
  constraint pk_project_task primary key (projecttask_id)
);

create table task (
  task_id                       bigint auto_increment not null,
  name                          varchar(255),
  duration                      integer,
  constraint pk_task primary key (task_id)
);

create table user (
  user_id                       bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (user_id)
);

create table worker (
  worker_id                     bigint auto_increment not null,
  prename                       varchar(255),
  lastname                      varchar(255),
  constraint pk_worker primary key (worker_id)
);

alter table project_task add constraint fk_project_task_project_project_id foreign key (project_project_id) references project (project_id) on delete restrict on update restrict;
create index ix_project_task_project_project_id on project_task (project_project_id);

alter table project_task add constraint fk_project_task_task_task_id foreign key (task_task_id) references task (task_id) on delete restrict on update restrict;
create index ix_project_task_task_task_id on project_task (task_task_id);


# --- !Downs

alter table project_task drop foreign key fk_project_task_project_project_id;
drop index ix_project_task_project_project_id on project_task;

alter table project_task drop foreign key fk_project_task_task_task_id;
drop index ix_project_task_task_task_id on project_task;

drop table if exists customer;

drop table if exists otte;

drop table if exists project;

drop table if exists project_task;

drop table if exists task;

drop table if exists user;

drop table if exists worker;

