create database rentbookDB;
use rentbookDB;
create table tbl_members (
	m_code	varchar(6) 		not null	 primary key,
    m_name 	varchar(125)	not null,
    m_tel	varchar(15)		not null,
    m_addr 	varchar(125)	not null
);

select * from tbl_members;

select * from tbl_members where m_code = '00001';

create table tbl_rent_book (
	RENT_SEQ			BIGINT		NOT NULL	PRIMARY KEY		auto_increment,
	RENT_DATE			VARCHAR(10)	NOT NULL,	
	RENT_RETURN_DATE	VARCHAR(10)	NOT NULL,	
	RENT_BCODE			VARCHAR(13)	NOT NULL,	
	RENT_MCODE			VARCHAR(6)	NOT NULL,	
	RENT_RETURN_YN		VARCHAR(1),		
	RENT_POINT			INT,		
	RENT_PRICE			INT		
);
desc tbl_rent_book;

insert into tbl_rent_book(
RENT_DATE,
RENT_RETURN_DATE,
RENT_BCODE,
RENT_MCODE,
RENT_RETURN_YN,
RENT_POINT,
RENT_PRICE
) VALUES (
'20230707',
'20230708',
'000001',
'0002',
'Y',
'10000',
'2000'
);

use rentbookdb;
select count(*) from tbl_books; 
select * from tbl_books limit 10;

select count(*) from tbl_members;

select * from tbl_members where m_name like concat('%', '강이', '%') order by m_name;

select * from tbl_rent_book R
left join tbl_members M
	on R.rent_mcode = M.m_code
left join tbl_books B 
	on R.rent_bcode = B.b_code;

-- 전체 데이터 중에서 5페이지에서 10개를 보고 싶다   
-- 전체 데이터 중에서 1페이지에서 10개 : 0 ~ 9번 까지
-- 1페이지 일경우 시작값이 1이 될려면 (Page - 1) * 10 : OFFSET ( PAGE * 10) : LIMIT

-- 전체 데이터 중에서 2페이지에서 10개 : 11 ~ 20번 까지
-- 2페이지 일경우 시작값이 10이 될려면 (Page - 1) * 10 : OFFSET 

-- 처음 시작에서 10개를 건너뛰고 : OFFSET 10
-- 그 위치부터 10개를 SELECT 하라
SELECT * FROM tbl_books
ORDER BY B_CODE
LIMIT 10 OFFSET 0;