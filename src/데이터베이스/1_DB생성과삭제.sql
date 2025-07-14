# 한줄주석
-- 한줄주석
/*
여러줄 주석
*/

-- [1] SQL 명령어 작성 방법
-- 1. SQL 문법을 작성한다.
-- 2. 끝에 ;(세미콜론)으로 마친다.
show databases;
-- [2] SQL 명령어 실행 방법
-- 1. 단위 실행 : ;단위로 실행 가능 -> 실행할 명령문에 커서를 두고 Ctrl + Enter
-- 2. 전체 실행 : 위에서 아래로 실행 -> Ctrl + Shift + Enter
-- [3] 실행 결과 : [ Result Grid ], [ Output ]에서 결과 확인

-- [4] 데이터베이스 주요 명령어
# 1. 데이터베이스가 저장된 로컬 경로 확인 방법
show variables like 'datadir';	# 세미콜론 필수

# 2. DB 서버 내 데이터베이스 생성
# create database 데이터베이스명;
create database mydb0714;

# 3. DB 서버 내 데이터베이스 삭제
# drop database 데이터베이스명;
drop database mydb0714;				# 여러번 실행하면 오류 발생 o

# 4. DB 서버 내 데이터베이스가 존재하면 삭제
drop database if exists mydb0714;	# 여러번 실행해도 오류 발생 x

# 5. DB 서버 내 데이터베이스 목록 보기
show databases;

# 6. DB 서버 내 사용할 데이터베이스 활성화하기
# 여러 DB 중에서 사용할 DB를 꼭 활성화해야한다.(진하게 표시된 DB가 활성화된 DB)
# use 데이터베이스명;
use mydb0714;


# 예제 1 -> DB 기본 세팅(관례적인)
drop database if exists test0714; # 'test0714'라는 DB가 존재하면 삭제
create database test0714;         # 'test0714'라는 이름으로 DB 생성
show databases;				      # DB 서버 내 모든 DB 목록 보기
use test0714;					  # 'test0714'라는 DB 활성화하기

# 현재 파일 저장 방법 : Ctrl + S, 자바 백엔드 폴더 내 '데이터베이스'에 함께 저장