# 1. 데이터베이스 생성
drop database if exists mydb0716;
create database mydb0716;
use mydb0716;
# 2. 테이블 생성
create table test(
	mno int auto_increment,				# 속성명 타입 제약조건
    mname varchar(30) not null unique,	# 속성명 타입 제약조건1 제약조건2
    mcount int default 2,				# 속성명 타입 제약조건
    constraint primary key(mno)			# constraint primary key(속성명)
);
# DML : 데이터베이스 조작어
# insert select update delete
# [C:저장][R:조회][U:수정][D:삭제]

# [1] insert : 레코드 삽입 기능, 테이블 내 행(가로) 단위의 데이터들
# 주의할점 : 테이블내 데이터 삽입 시, 레코드 단위로 삽입
# (1) insert into 테이블명( 속성명1, 속성명2 ) values ( 값1, 값2 );
insert into test( mno, mname, mcount ) values ( 1, "유재석", 30 );
insert into test( mcount, mno, mname ) values ( 40, 2, "강호동" );
select * from test;
# (2) auto_increment : 값을 생략할 경우, 자동번호 할당	-> 기본키에서 주로 사용
insert into test( mcount, mname ) values ( 50, "신동엽" );
# (3) default : 값을 생략할 경우, 미리 정의한 기본값 할당
insert into test( mname ) values ( "서장훈" );
# (4) not null : 값이 무조건 삽입되어있어야한다.
insert into test( mno, mcount ) values ( 5, 40 );
# (5) unique : 중복값일 경우, 오류 발생
insert into test( mname ) values ( "유재석" );
# (6) 모든 속성명을 사용할 경우, 속성명을 생략할 수 있다.
insert into test values ( 5, "하하", 50 );
# (7) 하나의 insert에서 여러개 레코드 삽입할 경우 -> values (), (), ();
insert into test values ( 6, "박명수", 60 ) , ( 7, "김희철", 30 ) ;





