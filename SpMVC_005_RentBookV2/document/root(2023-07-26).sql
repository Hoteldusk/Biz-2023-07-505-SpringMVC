use rentbookdb;

-- 도서정보.csv import
select * from tbl_books;
select count(*) from tbl_books;
select * from tbl_books limit 10;

-- 회원정보.csv import
select * from tbl_members;
select count(*) from tbl_members;
select * from tbl_members limit 10;