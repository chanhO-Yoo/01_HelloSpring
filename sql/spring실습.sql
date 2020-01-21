--==================================================
--관리자계정
--==================================================
--spring/spring 계정 생성
create user spring identified by spring
default tablespace users;

grant connect, resource to spring;

--==================================================
--spring계정
--==================================================
--dev 테이블 생성
create table dev(
    dev_no number,
    dev_name varchar2(50) not null,
    dev_career number,
    dev_email varchar2(256) not null,
    dev_gender char(1),
    dev_lang varchar2(100) not null,
    constraint pk_dev_no primary key(dev_no),
    constraint ck_dev_gender check(dev_gender in ('M','F'))
);

create sequence seq_dev_no;
