/*
[ 복습 ]
- DML(데이터베이스 조작어)
1. insert
	(1) 기본 형태
		insert into 테이블명(속성명1, 속성명2) values (값1, 값2);
    (2) 모든 속성명을 사용하면, 속성명 생략 가능
		insert into 테이블명 values (값1, 값2);
    (3) 하나의 insert로 여러개의 레코드 추가 -> values를 쉼표로 구분
		insert into 테이블명 values (값1, 값2), (값3, 값4);
2. select
	(1) 전체 속성 레코드 조회
		select * from 테이블명;
	(2) 특정 속성 레코드 조회
		select 속성명1, 속성명2 from 테이블명;
	(3) 특정 조건에 따른 속성 레코드 조회
		select 속성명1 from 테이블명 where 조건절;
3. update
	(1) 전체 레코드 수정
		update 테이블명 set 속성명 = 새로운값;
	(2) 특정 조건에 따른 레코드 수정
		update 테이블명 set 속성명 = 새로운값 where 조건절;
	(3) 특정 조건에 따른 다수 레코드 수정
		update 테이블명 set 속성명1 = 새로운값1, 속성명2 = 새로운값2 where 조건절;
4. delete
	(1) 전체 레코드 삭제
		delete from 테이블명;
	(2) 특정 조건에 따른 레코드 삭제
		delete from 테이블명 where 조건절;
*/

drop database if exists mydb0717;
create database mydb0717;
use mydb0717;

# 1. 회원테이블
create table member(            	# 아이돌 그룹
    mid char(8) not null ,         	# 식별키       최대 8자리
    mname varchar(10) not null ,   	# 그룹명      최대 10자리
    mnumber int not null ,         	# 인원수      정수 +-21억정도
    maddr char(2) not null ,       	# 지역      최대 2자리
    mphone1 char(3) ,            	# 지역번호   최대 2자리
    mphone2 char(8) ,            	# 전화번호    최대 8자리
    mheight smallint ,            	# 평균키       정수 +-3만정도
    mdebut date ,               	# 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )  # 제약조건
);
# 2. 구매테이블
create table buy(
    bnum int auto_increment ,       # 구매번호   정수    자동번호 부여
    mid char(8),                  	# 구매자      FK
    bpname char(6) not null ,       # 제품명      최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,           # 가격       정수
    bamount smallint not null ,     # 구매수량   정수
    constraint primary key(bnum) ,  # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# 샘플 데이터 확인
select * from member;
select * from buy;

# [1] as : 별칭, 조회 결과의 속성명 변경(단, 원래 테이블의 속성명에 영향 없음), 복잡한 조회에서 속성명 단순화 가능
select mid from member;
select mid as 회원아이디 from member;
select mid as 회원아이디, mname 회원명 from member;		# as 생략가능
select mid 회원아이디 from member as m;				# 테이블명도 별칭 가능
select mid 회원아이디 from member m;					# as 생략가능

# [2] distinct : 중복 제거
select maddr 주소 from member;						# 값에 중복 존재
select distinct maddr 주소 from member;				# 중복인 값은 1개만 출력

# [3] 산술연산자
select mnumber       as 기본,
	   mnumber  + 3  as 더하기,
	   mnumber  - 3  as 빼기,
       mnumber  * 3  as 곱하기,
       mnumber  / 3  as 나누기,
       mnumber div 3 as 몫,
       mnumber mod 3 as 나머지
       from member;

# [4] where 조건절 연산자
# 비교연산자 : >(초과), <(미만), >=(이상), <=(이하), =(같다), !=(같지않다)
select * from member where mname = '블랙핑크';		# member 테이블에 mname이 '블랙핑크'인 레코드 조회
select * from member where mnumber = 4;				# member 테이블에 mnumber가 4인 레코드 조회
select * from member where mname != '블랙핑크';		# member 테이블에 mname이 '블랙핑크'가 아닌 레코드 조회
select * from member where mheight <= 162;			# member 테이블에 mheight가 162이하인 레코드 조회

# 논리연산자 : not(부정), and(이면서)
select * from member where not mname = '블랙핑크';	# member 테이블에 mname이 '블랙핑크'와 같지 않은 레코드 조회
select * from member where mheight >= 165 and		# member 테이블에 mheight가 165이상 이면서
						   mheight <= 170;			# mheight가 170이하인 레코드 조회
select * from member where maddr = '경기' or			# member 테이블에 maddr가 '경기' 이거나
						   maddr = '전남' or			# maddr가 '전남' 이거나
                           maddr = '경남';			# maddr가 '경남'인 레코드 조회
                           
# 기타연산자 : between A and B, 속성명 in (값1, 값2, 값3)
select * from member where mheight 					# member 테이블에 mheight가
						   between 165 and 170;		# 165와 170 사이인 레코드 조회
select * from member where maddr					# member 테이블에 maddr이
						   in ('경기', '전남', '경남');	# '경기', '전남', '경남' 안에 있는 레코드 조회
# 비슷한 연산자 : ( and, between A and B ), ( or, in(값1, 값2) )

# null연산자 : is null, is not null
select * from member where mphone1 = ' ';			# 속성값이 비어있으면 -> ' '보다는 null을 사용
select * from member where mphone1 = null;			# 속성값이 null이면 -> 불가능한 문법
select * from member where mphone1 is null;			# 속성값이 null이면 -> 가능
select * from member where mphone1 is not null;		# 속성값이 null이 아니면

# 문자패턴연산자 : like %(문자대응), _(문자대응, 개수일치)
select * from member where mname like '에이%';		# member 테이블에 mname이 '에이'로 시작하는 레코드 조회		-> 글자수 상관 없음
select * from member where mname like '에이_';		# member 테이블에 mname이 '에이'로 시작하는 3글자 레코드 조회 -> 글자수 상관 있음
select * from member where mname like '%핑크';		# member 테이블에 mname이 '핑크'로 끝나는 레코드 조회
select * from member where mname like '%이%';		# member 테이블에 mname에 '이'가 포함된 레코드 조회
select * from member where mname like '_이_';		# member 테이블에 mname에 두번째 글자가 '이'인 3글자 레코드 조회

# [5] order by 속성명 ASC(오름차순, 기본값) | DESC(내림차순) : 정렬
select * from member order by mdebut asc;			# member 테이블을 mdebut를 기준으로 오름차순 정렬
select * from member order by mdebut;				# 생략하면, 기본값 asc 적용
select * from member order by mdebut desc;			# member 테이블을 mdebut를 기준으로 내림차순 정렬
# 2개 이상 정렬은 쉼표로 구분하되, 1차 정렬에서 중복값이 있을 경우, 중복값끼리 2차 정렬
select * from member order by maddr desc, mdebut;	# member 테이블을 maddr를 기준으로 내림차순 정렬하고, 중복값이 있을 경우 2차로 mdebut를 기준으로 오름차순 정렬

# [6] limit 레코드수 : 조회결과 개수 제한 | 페이징처리할때 주로 사용
# limit 시작레코드번호, 개수; : 시작레코드번호부터 개수만큼 조회
select * from member limit 2;						# member 테이블에서 상위 2개만 조회
select * from member limit 0, 2;					# member 테이블에서 0번 레코드부터 2개 조회
select * from member limit 2, 3;					# member 테이블에서 2번 레코드부터 3개 조회
select * from member order by mheight desc limit 3;	# member 테이블을 mheight를 기준으로 내림차순 정렬 후, 상위 3개만 조회
