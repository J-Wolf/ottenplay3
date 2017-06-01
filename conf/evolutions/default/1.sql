# --- !Ups

create table worker (
  worker_id                     bigint auto_increment not null,
  prename                       varchar(255),
  lastname                      varchar(255),
  constraint pk_worker primary key (worker_id)
);

create table customer (
  customer_id                   bigint auto_increment not null,
  prename                       varchar(255),
  lastname                      varchar(255),
  address                       varchar(255),
  email                         varchar(255),
  constraint pk_customer primary key (customer_id)
);

create table project (
  project_id                    bigint auto_increment not null,
  name                          varchar(255),
  duration                      bigint,
  constraint pk_project primary key (project_id)
);

create table task (
  task_id                       bigint auto_increment not null,
  name                          varchar(255),
  duration                      bigint,
  constraint pk_task primary key (task_id)
);

create table project_task (
  project_task_id               bigint auto_increment not null,
  project_project_id            bigint,
  task_task_id                  bigint,
  constraint pk_project_task primary key (project_task_id)
);

create table otte (
  otte_id                       bigint auto_increment not null,
  name                          varchar(255),
  rasse                         varchar(255),
  imagepath                     varchar(255),
  image                         varbinary(255),

  constraint pk_otte primary key (otte_id)
);

create table user (
  user_id                       bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (user_id)
);

alter table task add constraint fk_task_worker foreign key (task_id) references worker (worker_id) on delete restrict on update restrict;
create index ix_task_worker on task (task_id);

alter table task add constraint fk_task_otte foreign key (task_id) references otte (otte_id)  on delete restrict on update restrict;
create index ix_task_otte on task (task_id);

alter table project add constraint fk_project_customer foreign key (project_id) references customer (customer_id) on delete restrict on update restrict;
create index ix_project_customer on project (project_id);

alter table project_task add constraint fk_project_task_project_project foreign key (project_project_id) references project (project_id) on delete restrict on update restrict;
create index ix_project_task_project_project on project_task (project_task_id);

alter table project_task add constraint fk_project_task_task_task foreign key (task_task_id) references project (task_id) on delete restrict on update restrict;
create index ix_project_task_task_task on project_task (project_task_id);





