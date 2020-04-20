
drop table UserDevice if exists;

create table UserDevice(

    id bigint not null auto_increment,

    userId varchar(255),

    carrierId  varchar(255),

    deviceId varchar(255),

    deviceToken varchar(255),

    isActive  bigint,

    deviceOs varchar(255),

    deviceOsVersion varchar(255),

    primary key (id));


