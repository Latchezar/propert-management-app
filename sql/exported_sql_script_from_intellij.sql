create table messagetypes
(
  MessageType int auto_increment
    primary key,
  TypeName    varchar(45) default 'NULL' null
);

create table requesttype
(
  RequestType int auto_increment
    primary key,
  ReqeustName varchar(45) default 'NULL' null
);

create table usertypes
(
  UserType int auto_increment
    primary key,
  TypeName varchar(45) default 'NULL' null
);

create table users
(
  UserID    int auto_increment
    primary key,
  FirstName varchar(65) default 'NULL'  null,
  LastName  varchar(65) default 'NULL'  null,
  Password  varchar(255) default 'NULL' null,
  UserType  int default 'NULL'          null,
  Email     varchar(255) default 'NULL' null,
  constraint Email
  unique (Email),
  constraint users_ibfk_1
  foreign key (UserType) references usertypes (UserType)
);

create table properties
(
  PropertyID    int auto_increment
    primary key,
  PropertyName  varchar(255) default 'NULL' null,
  Address       varchar(255) default 'NULL' null,
  PropertyPrice int default 'NULL'          null,
  LandlordID    int default 'NULL'          null,
  TenantID      int default 'NULL'          null,
  constraint PropertyID
  unique (PropertyID),
  constraint properties_ibfk_1
  foreign key (LandlordID) references users (UserID),
  constraint properties_ibfk_2
  foreign key (TenantID) references users (UserID)
);

create table chat
(
  MessageID   timestamp default current_timestamp() not null
    primary key,
  MessageType int                                   not null,
  PropertyID  int                                   not null,
  SenderID    int                                   not null,
  MessageText text default 'NULL'                   null,
  constraint chat_ibfk_1
  foreign key (MessageType) references messagetypes (MessageType),
  constraint chat_ibfk_2
  foreign key (PropertyID) references properties (PropertyID),
  constraint chat_ibfk_3
  foreign key (SenderID) references users (UserID)
);

create index MessageType
  on chat (MessageType);

create index PropertyID
  on chat (PropertyID);

create index SenderID
  on chat (SenderID);

create index LandlordID
  on properties (LandlordID);

create index TenantID
  on properties (TenantID);

create table requests
(
  RequestTime timestamp default current_timestamp() not null
    primary key,
  PropertID   int default 'NULL'                    null,
  fromUser    int default 'NULL'                    null,
  toUser      int default 'NULL'                    null,
  RequestType int default 'NULL'                    null,
  Message     text default 'NULL'                   null,
  Amount      int default 'NULL'                    null,
  constraint requests_ibfk_1
  foreign key (PropertID) references properties (PropertyID),
  constraint requests_ibfk_2
  foreign key (fromUser) references users (UserID),
  constraint requests_ibfk_3
  foreign key (toUser) references users (UserID),
  constraint requests_ibfk_4
  foreign key (RequestType) references requesttype (RequestType)
);

create index PropertID
  on requests (PropertID);

create index RequestType
  on requests (RequestType);

create index fromUser
  on requests (fromUser);

create index toUser
  on requests (toUser);

create index UserType
  on users (UserType);

