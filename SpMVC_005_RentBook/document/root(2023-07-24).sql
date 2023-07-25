-- RentBook root 접속
create database rentBookDB;
use rentbookdb;

create table tbl_books (
	B_CODE	VARCHAR(13) not null	PRIMARY KEY,
	B_NAME	VARCHAR(125)	NOT NULL,
	B_AUTHER	VARCHAR(125)	NOT NULL,
	B_COMP	VARCHAR(125),
	B_YEAR	INT	NOT NULL,
	B_IPRICE	INT,
	B_RPRICE	INT	NOT NULL
);

desc tbl_books;

drop table tbl_books;

show tables;

insert into tbl_books
(B_CODE, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, B_RPRICE)
values('001', '테스트도서명', '테스트저자명', '테스트출판사', 2023, 17000, 700);

select * from tbl_books;