/*
[ 복습 ]
1. 별칭 : as
	select 속성명 as 별칭 from 테이블명 as 별칭;
    select 속성명 별칭 from 테이블명 별칭;
2. 중복제거 : distinct
	select distinct from 테이블명;
3. 산술연산자 : +, -, *, /, div, mod
4. 비교연산자 : >, <, >=, <=, =, !=
5. 논리연산자 : and, or, not
6. 기타연산자
	1) between A and B
    2) in( 값1, 값2 )
    3) is null, is not null
7. 문자패턴 : %(문자대응), _(문자대응, 개수일치)
	1) select * from 테이블명 where 이름 like '김%';		: 성이 '김'씨인 사람 찾기
    2) select * from 테이블명 where 이름 like '김_';		: 성이 '김'씨면서 외자인 사람 찾기
8. 정렬 : order by 속성명 ASC(오름차순, 기본값) | DESC(내림차순);
9. 조회결과 개수 제한 : limit 시작레코드번호, 개수;
10 작성순서
	select 속성명 from 테이블명 where 조건절 order by 속성명 asc/desc limit 개수;
*/

drop database if exists mydb0718;
create database mydb0718;
use mydb0718;

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
    mid char(8),                  	# 구매자     FK
    bpname char(6) not null ,       # 제품명     최대 6자리
    bgname char(4) ,                # 분류명     최대   4자리
    bprice int not null ,           # 가격      정수
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



# [1] 그룹함수 : group by 속성명
select * from buy;								# buy 테이블의 모든 레코드 조회
select bpname from buy group by bpname;			# buy 테이블의 bpname을 기준으로 그룹화하여 조회
select bpname, bprice from buy group by bpname;
# 오류 발생 -> bpname이 동일하더라도 bprice가 다를 수 있기 때문에

# [2] 집계함수 : 그룹함수와 같이 사용
select bamount from buy;
select sum(bamount) from buy;	# sum(속성명)   : 속성값의 합계
select avg(bamount) from buy;	# avg(속성명)   : 속성값의 평균
select min(bamount) from buy;	# min(속성명)   : 속성값의 최솟값
select max(bamount) from buy;	# max(속성명)   : 속성값의 최댓값
select count(bamount) from buy;	# count(속성명) : 레코드 개수, null 제외
select count(*) from buy;		# count(*)    : 레코드 개수, null 포함

# 회원아이디별 구매수량 총합계 조회
select mid 회원아이디, bamount 총구매수량 from buy group by mid; 		# 오류 발생
select mid 회원아이디, sum(bamount) 총구매수량 from buy;				# 오류 발생 
select mid 회원아이디, sum(bamount) 총구매수량 from buy group by mid; 
# 회원아이디별 총구매금액(수량 * 가격) 조회
select mid 회원아이디, sum( bamount * bprice ) from buy group by mid;
# 회원아이디별 구매가격 평균 조회
select mid 회원아이디, avg( bprice ) from buy group by mid;
# 총 구매횟수 조회
select count(*) from buy;
# 회원아이디별 구매횟수 조회
select mid 회원아이디, count(*) from buy group by mid;













