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

# [2] select : 레코드 조회
# 주의할점 : 조회 결과는 기존 테이블과 상관이 없다. / 조회 결과는 항상 테이블로 표시된다.
# (1) select * from 테이블명; 				: 전체 속성의 모든 레코드 조회
select * from test;
# (2) select 속성명1, 속성명2 from 테이블명; 		: 특정 속성의 모든 레코드 조회
select mname from test;						# mname 조회
select mname, mcount from test;				# mname, mcount 조회
# (3) select 속성명 from 테이블명 where 조건절;	: 특정 속성을 조건에 따라 모든 레코드 조회
# 'test'테이블에서 'mname'의 값이 '유재석'인 레코드를 조회
select * from test where mname = '유재석';	# = : 대입이 아닌 '같다'의 의미
# 'test'테이블에서 'mno'의 값이 '3'인 레코드를 조회
select * from test where mno = 3;

# [3] update : 레코드 수정
# MySQL Workbench 에서는 safe mode여서 수정/삭제가 불가능
# safemode 해제 방법 : set SQL_SAFE_UPDATES = 0; vs 1;(설정 방법)
set SQL_SAFE_UPDATES = 0;		# safemode 끄기
set SQL_SAFE_UPDATES = 1;		# safemode 켜기
# (1) update 테이블명 set 속성명 = 새로운값;				: 전체 레코드의 속성값 수정
update test set mcount = 0;
# (2) update 테이블명 set 속성명 = 새로운값 where 조건절;	: 조건을 충족하는 레코드의 속성값 수정
# 'test' 테이블에서 mname이 '유재석'인 레코드의 mcount를 10으로 수정한다.
update test set mcount = 10 where mname = '유재석';
# (3) update 테이블명 set 속성명1 = 값1, 속성명2 = 값2;	: 전체 레코드의 다수의 속성값 수정
# 'test' 테이블에서 mno가 2인 레코드의 mcount를 20으로, mname을 '강호동2'로 수정한다.
update test set mcount = 20, mname = '강호동2' where mno = 2;

# [4] delete : 레코드 삭제
# (1) delete from 테이블명;					: 전체 레코드 삭제
delete from test;
# (2) delete from 테이블명 where 조건절;		: 조건을 충족하는 레코드 삭제
# 'test' 테이블에서 mno가 2인 레코드 삭제
delete from test where mno = 2;