create sequence SEQ_BARCLASSIFY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence SEQ_BARCLASSIFYURL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create table
create table BAR_CLASSIFY
(
  id            NUMBER(19) not null,
  classify_name VARCHAR2(50),
  date_created  TIMESTAMP(6)
);
-- Add comments to the table 
comment on table BAR_CLASSIFY
  is '导航分类';
-- Add comments to the columns 
comment on column BAR_CLASSIFY.id
  is '主键';
comment on column BAR_CLASSIFY.classify_name
  is '分类名称';
comment on column BAR_CLASSIFY.date_created
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table BAR_CLASSIFY
  add constraint KEY_BAR_CLASSIFY primary key (ID)
  using index;


-- Create table
create table BAR_CLASSIFY_URL
(
  id              NUMBER(19) not null,
  bar_classify_id NUMBER(19),
  bar_url_name    VARCHAR2(50),
  bar_url_address VARCHAR2(1000),
  date_created    TIMESTAMP(6)
);
-- Add comments to the table 
comment on table BAR_CLASSIFY_URL
  is '导航分类url';
-- Add comments to the columns 
comment on column BAR_CLASSIFY_URL.id
  is '主键';
comment on column BAR_CLASSIFY_URL.bar_classify_id
  is '导航类别';
comment on column BAR_CLASSIFY_URL.bar_url_name
  is '地址名称';
comment on column BAR_CLASSIFY_URL.bar_url_address
  is '地址url';
comment on column BAR_CLASSIFY_URL.date_created
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table BAR_CLASSIFY_URL
  add constraint KEY_BAR_CLASSIFY_URL primary key (ID)
  using index ;




create table TBUG
(
  id             VARCHAR2(36) not null,
  createdatetime DATE,
  name           VARCHAR2(100),
  note           CLOB
);
alter table TBUG
  add primary key (ID)
  using index ;


create table TMENU
(
  id      VARCHAR2(36) not null,
  iconcls VARCHAR2(100),
  seq     NUMBER(22),
  text    VARCHAR2(100),
  url     VARCHAR2(200),
  pid     VARCHAR2(36)
);
alter table TMENU
  add primary key (ID)
  using index ;
alter table TMENU
  add foreign key (ID)
  references TMENU (ID) on delete set null;

create table TONLINE
(
  id            VARCHAR2(36) not null,
  ip            VARCHAR2(50),
  logindatetime DATE,
  loginname     VARCHAR2(255)
);
alter table TONLINE
  add primary key (ID)
  using index ;


create table TRESOURCE
(
  id   VARCHAR2(36) not null,
  seq  NUMBER(22),
  text VARCHAR2(100),
  url  VARCHAR2(200),
  pid  VARCHAR2(36)
);
alter table TRESOURCE
  add primary key (ID)
  using index ;
alter table TRESOURCE
  add foreign key (ID)
  references TRESOURCE (ID) on delete set null;


create table TROLE
(
  id   VARCHAR2(36) not null,
  text VARCHAR2(100)
);
alter table TROLE
  add primary key (ID)
  using index ;


create table TROLE_TRESOURCE
(
  id          VARCHAR2(36) not null,
  resource_id VARCHAR2(36),
  role_id     VARCHAR2(36)
)
;
alter table TROLE_TRESOURCE
  add primary key (ID)
  using index ;
alter table TROLE_TRESOURCE
  add foreign key (ID)
  references TROLE (ID) on delete set null;
alter table TROLE_TRESOURCE
  add foreign key (ID)
  references TRESOURCE (ID) on delete set null;


create table TUSER
(
  id          VARCHAR2(36) not null,
  login_name VARCHAR2(100),
  name        VARCHAR2(100),
  pwd         VARCHAR2(50),
  create_time TIMESTAMP(6),
  update_time TIMESTAMP(6)
);
alter table TUSER
  add primary key (ID)
  using index ;


create table TUSER_TROLE
(
  id      VARCHAR2(36) not null,
  role_id VARCHAR2(36),
  user_id VARCHAR2(36)
);
alter table TUSER_TROLE
  add primary key (ID)
  using index ;
alter table TUSER_TROLE
  add foreign key (USER_ID)
  references TUSER (ID) on delete set null;
alter table TUSER_TROLE
  add foreign key (ROLE_ID)
  references TROLE (ID) on delete set null;

-- Create sequence
create sequence seq_tuser
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence seq_tusertrole
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence seq_trole
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence seq_tmenu
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence seq_tbug
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

create sequence seq_tonline
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


create sequence seq_tresource
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

