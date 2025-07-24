# 1. 데이터베이스 생성
drop database if exists mydb0724;		# 만약에 'mydb0724' 데이터베이스가 존재하면 삭제
create database mydb0724;				# 'mydb0724' 데이터베이스 생성
use mydb0724;							# 'mydb0724' 데이터베이스 사용

# 2. 테이블 생성
create table table1(					# 'table1' 테이블 생성
	num_pk int,							# 'num_pk' 속성을 int 타입으로 선언
    constraint primary key( num_pk )	# 'num_pk' 속성을 기본키로 설정	
);										# primary key : 기본키, 중복/NULL 불가능, 고유한 값

create table table2(					# 'table2' 테이블 생성
	no_pk int,							# 'no_pk' 속성을 int 타입으로 선언
    constraint primary key( no_pk ),	# 'no_pk' 속성을 기본키로 설정
    num_pk int,							# 'num_pk' 속성을 int 타입으로 선언
    constraint foreign key( num_pk )	# 'num_pk' 속성을 외래키로 설정
		references table1( num_pk )		# 'table1'의 'num_pk' 속성을 참조하여
       #on [delete / update] [(restrict) / cascade / set null]
        on delete cascade				# 참조중인 속성이 삭제되면, 같이 삭제
	   #on delete set null				  참조중인 속성이 삭제되면, NULL로 변경한다.
       #on delete restrict				  참조중인 속성을 삭제 불가능 상태로 설정한다.(생략 시, 기본값)
        on update cascade				# 참조중인 속성값이 변경되면, 같이 변경
       #on update set null				  참조중인 속성값이 변경되면, NULL로 변경한다.
       #on update restrict				  참조중인 속성값을 수정 불가능 상태로 설정한다.(생략 시, 기본값)
);										# foreign key : 외래키, 중복/NULL 가능, 참조하는 값

# 3. 서로 다른 테이블 합치기 = JOIN
# 샘플 데이터
insert into table1 values (1), (2), (3), (4), (5);
insert into table2 values ( 1 , 1 ), ( 2 , 2 ), ( 3 , 1 ), ( 4 , 1 ), ( 5 , 2 );
# 레코드 조회
select * from table1;
select * from table2;
# 1) 두 개 이상의 테이블 조회하기 -> 거의 사용 X
# select * from 테이블명1, 테이블명2;
# 주의할 점 : 두 테이블간의 곱으로 표현된다.
select * from table1, table2;

# 2) 두 테이블간의 공통된 값 기준으로 조회하기(교집합)
# 2-1) where절 -> 일반 조건과 join 조건의 구분이 어렵기 때문에, 실무에서 사용 X
select * from table1, table2 where table1.num_pk = table2.num_pk;

# 2-2) INNER JOIN ON절 -> 주로 사용 -> 왜? 가독성이 좋고, 원하는 결과를 제대로 얻을 수 있음.
# 테이블1 inner join 테이블2 on 테이블1_PK = 테이블2_FK;
select * from table1 inner join table2 on table1.num_pk = table2.num_pk;

# where : 일반조건, having : 그룹조건, on : 집합조건

# 2-3) inner 생략 가능, 테이블 별칭 부여 가능, 속성명 별칭 부여 가능
select * from table1 join table2 on table1.num_pk = table2.num_pk;
select * from table1 t1 join table2 t2 on t1.num_pk = t2.num_pk;
select t1.num_pk 식별키, t2.num_pk 참조키
	from table1 t1 join table2 t2 on t1.num_pk = t2.num_pk;

# 2-4) natural join -> 의도와 다르게, 동일한 속성명이 존재할 수 있어서 비권장
# 기본키와 외래키의 이름이 일치할 때만 가능하다.
select * from table1 natural join table2;

# 2-5) join using
# 기본키와 외래키의 이름이 일치할 때만 가능하다.
select * from table1 join table2 using( num_pk );

# 3) OUTER JOIN
# 3-1) 왼쪽 테이블(table1)의 모든 레코드와 오른쪽 테이블(table2)의 교집합인 레코드를 조회하고, 없으면 NULL로 반환
# 왼쪽 테이블 전체 조회 + 오른쪽 테이블과 교집합 레코드 표시 + 교집합 안되면 NULL
select * from table1 t1 left outer join table2 t2 on t1.num_pk = t2.num_pk;

# 3-2) 오른쪽 테이블(table2)의 모든 레코드와 왼쪽 테이블(table1)의 교집합인 레코드를 조회하고, 없으면 NULL로 반환
# 오른쪽 테이블 전체 조회 + 왼쪽 테이블과 교집합 레코드 표시 + 교집합 안되면 NULL
select * from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_pk;

# 3-3) outer 생략가능
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk;

# 4) 합집합 -> MYSQL : UNION, ORACLE : FULL OUTER JOIN
# 4-1) union : 2개 이상의 select를 하나로 합치기 -> left + union + right
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk union
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_pk;

# 5) 차집합 : left join에서 교집합 제외 -> 교집합이 아닌 것은 NULL로 표현되므로 IS NULL을 where절
# 5-1) 왼쪽 테이블의 차집합
select t1.* from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk where t2.num_pk is null;
# 5-2) 오른쪽 테이블의 차집합
select t2.* from table1 t1 right join table2 t2 on t1.num_pk = t2.num_pk where t1.num_pk is null;

/*
교집합 : 두 테이블 간의 기본키와 외래키 값이 동일한 레코드를 하나의 테이블로 조회
	1. where
    2. (inner) join on
    3. natural join
    4. join ~ using
차집합 : 두 테이블 간의 동일한 레코드를 제외한 하나의 테이블 조회
	1. A-B : 
		select 테이블A.* from 테이블A left (outer) join 테이블B 
			on 테이블A.PK = 테이블B.FK where 테이블B.FK IS NULL;
합집합 : 두 테이블의 모든 레코드를 하나의 테이블로 조회
	1. ORACLE : FULL OUTER JOIN
    2. MYSQL  : LEFT JOIN UNION RIGHT JOIN
*/