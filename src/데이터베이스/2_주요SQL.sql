/*
[ SQL ]
1. 주의할점
	1) SQL은 대소문자를 구분하지 않는다.
	2) 명령어 문장 끝에 ;(세미콜론)으로 구분한다.
2. 메타데이터 관리어
	1) show
		(1) show databases;						: DB 서버 내 전체 데이터베이스 목록 조회
        (2) show variables like 'datadir';		: DB 서버 내 로컬 경로 조회
	2) use 데이터베이스명;							: DB 서버 내 지정한 데이터베이스 활성화
3. 데이터베이스 정의어(DDL)
	1) create
		(1) create database 데이터베이스명;			: 데이터베이스 생성
    2) drop
		(1) drop database 데이터베이스명;			: 지정한 데이터베이스 삭제
        (2) drop database if exists 데이터베이스명;	: 지정한 데이터베이스가 존재하면, 데이터베이스 삭제
    3) alter
    
[ 데이터 타입 ] : 테이블 내 속성들이 갖는 자료들의 타입
1. 정수
	1) tinyint		: 1byte, -128 ~ +127
    2) smallint		: 2byte, 약 +-3만
    3) mediumint	: 3byte, 약 +-800만
    4) int			: 4byte, 약 +-21억***
    5) bigint		: 8byte, +-21억 이상
		* signed	: 부호가 있다(+ -), 기본값
		* unsigned  : 부호가 없다(절대값) -> 허용범위가 늘어난다.
			-> int unsigned : 약 42억까지
2. 실수
	1) float		: 4byte,  소수점
    2) double		: 8byte,  소수점
    3) decimal 		: 문자타입, 소수점을 문자로 처리 -> 오차 없음***
3. 날짜/시간
	1) date			: 날짜 표현,		2025-07-15
    2) time			: 시간 표현,		10:02:30
    3) datetime		: 날짜/시간 표현,	2025-07-15 10:02:30
4. 문자
	1) char(길이)	: 문자열 표현, 고정길이, 최대 255글자
		char(5) 	"유재석" [유] [재] [석] [ ] [ ]
    2) varchar(길이) : 문자열 표현, 가변길이, 최대 255글자***
		varchar(5)	"유재석" [유] [재] [석] -> 남은 공간 삭제
	3) text			: 문자열 표현, 최대 6만글자
    4) longtext		: 문자열 표현, 최대 42억글자
5. 논리
	1) bool			: true / false, tinyint와 같다.

[ 제약조건 ]
- 목적 : 데이터들 간의 문제와 결함이 되는 입력 방지 및 해결
1. not null			: 해당 속성에 null 값을 저장하지않는다.
2. unique			: 해당 속성에 중복값을 허용하지않는다.(중복방지)
3. default 기본값		: 해당 속성에 값 생략 시, 기본값으로 초기화한다.
	default 0		: 해당 속성에 값 생략 시, 0으로 초기화한다.
    default now()	: 해당 속성에 값 생략 시, 현재 날짜/시간으로 초기화한다.
4. auto_increment	: 해당 속성에 값 생략 시, 순서대로 자동번호 초기화(MySQL에서만)
5. primary key		: 기본키(PK), 식별 가능한 고유 필드키
	-> 학번, 사번, 주민등록번호, 주문번호, 제품번호...
    -> not null + unique가 포함되어있는 속성
    -> constraint primary key(속성)
6. foreign key		: 외래키(FK), 다른 테이블의 기본키를 참조하는 키
	-> null과 중복 가능
    -> constraint foreign key(속성) references 참조테이블명(기본키);
    -> 참조할 기본키의 타입과 같아야한다.
    -> 관례적으로 기본키의 이름과 외래키의 이름을 같게 한다.
*/

# [1] 데이터베이스 생성
create database mydb0715;

# [2] 데이터베이스 활성화
use mydb0715;

# [3] 활성화된 데이터베이스에 테이블(표) 생성
# create table 테이블명( 속성명 타입 );
create table test1( 필드명 int );

# [4] 활성화된 데이터베이스의 테이블 목록 조회
show tables;

# 2개 이상의 속성 정의 : ,(쉼표)로 구분
create table test2( 필드명1 int, 필드명2 double );

# [5] 활성화된 데이터베이스 내 테이블 삭제
drop table test1;
# 만약 테이블이 존재하면, 테이블 삭제
drop table if exists test1;

# [6] 다양한 데이터 타입을 이용한 테이블 생성
create table test3 (
	# 속성명 타입
	정수필드1 tinyint, 정수필드2 smallint,   정수필드3 mediumint,
    정수필드4 int,     정수필드5 bigint,     정수필드6 int unsigned,
	실수필드1 float,   실수필드2 double,     실수필드3 decimal,
    날짜필드1 date,    시간필드2 time,       날짜시간필드3 datetime,
    문자필드1 char(3), 문자필드2 varchar(3),
    문자필드3 text,	 문자필드4 longtext,
    논리필드1 bool
); # 테이블 정의 끝
show tables;
# select * from 테이블명;		: 테이블의 모든 속성 조회
select * from test3;

# 예제1] 방문록을 기록하는 테이블 설계
create table board(
	content longtext,	# 게시물 내용		private String content
    writer varchar(30)	# 게시물 작성자		private String writer
);
select * from board;

# 예제2] 대기번호 기록하는 테이블 설계
create table waiting(
	phone char(13),		# 휴대폰 번호, 고정길이 13글자	private String phone
    count tinyint		# 대기인원수,  최대 100명 제한	private int count
);
select * from waiting;

# [7] 제약조건을 이용한 테이블 설계
create table test4 (
	# 속성명 타입 제약조건
    필드명1 tinyint not null,			# 지정한 속성에 null값을 저장할 수 없음
    필드명2 smallint unique,			# 지정한 속성에 중복값을 저장할 수 없음
    필드명3 int default 10,			# 지정한 속성에 값이 생략될 때, 자동으로 기본값 10을 설정
    필드명4 bigint auto_increment,	# 지정한 속성에 값이 생략될 때, 자동으로 순서번호 설정
    constraint primary key(필드명4)	# 지정한 속성을 기본키로 설정
);
select * from test4;

create table test5 (
	필드명1 bigint,
    constraint foreign key(필드명1) references test4(필드명4)
  # test5의 필드명1을 외래키로 설정하고, test4의 필드명4를 참조한다.
);

# 예제3] 회원제 게시판 DB 설계
drop database if exists boardService0715;		# boardService0715가 존재하면 삭제
create database boardService0715;				# boardService0715 생성
use boardService0715;							# boardService0715 활성화

create table member(							# 회원 테이블 설계
	mNo int auto_increment,						# 회원번호 : 정수, 자동번호, 기본키로 설정할 예정
    mId varchar(30) not null unique,			# 회원아이디 : 문자 최대 30, null값 x, 중복 x
    mPwd varchar(30) not null,					# 회원비밀번호 : 문자 최대 30, null값 x, 중복 o
    mName varchar(10) not null,					# 회원닉네임 : 문자 최대 10, null값 x
    constraint primary key(mNo)					# 회원번호를 기본키로 설정
);
select * from member;							# 회원 테이블 조회

create table board(								# 게시물 테이블 설계	
	bNo int auto_increment,						# 게시물번호 : 정수, 자동번호, 기본키로 설정할 예정
    bTitle varchar(100) not null,				# 게시물제목 : 문자 최대 100, null값 x
    bContent longtext,							# 게시물내용 : 대용량 문자(사진 첨부 가능)
    bDate datetime default now(),				# 게시물작성일 : 날짜/시간, 기본값으로 now() -> 현재 날짜/시간 반환 함수
    bView int default 0,						# 게시물조회수 : 정수, 기본값 0 설정
    mNo int,									# 게시물작성자 : 정수, 외래키로 설정할 예정 -> 참조할 속성의 타입과 일치해야한다.
    constraint primary key(bNo),				# 게시물번호를 기본키로 설정
    constraint foreign key(mNo)					# 게시물작성자를 외래키로 설정하고
			references member(mNo)				# member 테이블의 mNo를 참조한다.
);
select * from board;
# 테이블 간의 관계 확인 : [database] -> [Reverse Engineer] -> [Stored Connection] -> [database 선택]

/*
1. 프로토타입을 구현하기 위한 주요 기능 판단
	1) 회원가입
    2) 로그인
    3) 도서등록
    4) 도서대출
    5) 도서반납
    6) 사용자별 대출 현황
    7) 도서목록 반환
    8) 로그아웃
2. 주요 기능에 따른 데이터 메모리 설계
	1) member table		- 회원 목록
		(1) 회원코드
        (2) 회원아이디
        (3) 회원비밀번호
        (4) 회원이름
        (5) 회원연락처
	2) admin talbe		- 관리자 목록
		(1) 관리자아이디
        (2) 관리자비밀번호
    3) book table		- 도서 목록
		(1) 도서코드
        (2) 도서이름
    4) loanList table	- 대출 목록
		(1) 대출코드
        (2) 도서코드
3. 메모리 설계에 따른 SQL 작성
	1) member table		- 회원 목록
	2) admin talbe		- 관리자 목록
    3) book table		- 도서 목록
    4) loanList table	- 대출 목록
4. SQL 다이어그램 표현
*/
drop database if exists library;
create database library;
use library;

create table member(
	mCode smallint auto_increment,
	mId varchar(20) not null unique,
	mPwd varchar(20) not null,
	mName varchar(10) not null,
	mPhone varchar(13) not null unique,
	constraint primary key(mCode)
);

create table book( 
	bCode mediumint auto_increment, 
	bName varchar(50) not null, 
	bAuthor varchar(50) not null,
	constraint primary key(bCode)
);

create table loan(
    lCode mediumint auto_increment ,
    bCode mediumint,
    mCode smallint,
    loanDate datetime default now(),
    returnDate datetime default now(),
	constraint primary key( lCode ),
	constraint foreign key( bCode ) references book( bCode), 
	constraint foreign key( mCode ) references member( mCode)
);