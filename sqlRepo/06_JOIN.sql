<<<<<<< HEAD
--
=======
--JOIN
/*
    <JOIN>
        두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용
        
        문법
            - 1. ORACLE
                SELECT 칼럼, 칼럼..
                FROM 테이블1, 테이블 2, 
                WHERE 테이블1.칼럼 = 테이블2.칼럼;
                
                FROM 절에 저회하고자 하는 테이블들을 ,로 구분
                WHERE 절에 매칭 시킬 칼럼명에 대한 조건 제시
                
            - 2. ANSI 표준 구문
                SELERCT 칼럼, 칼럼
                FROM 테이블
                JOIN 테이블 2
                ON 테이블.칼럼 = 테이블2.칼럼
                
                FROM 절에 기준이 되는 테이블 기술
                JOIN 절에 같이 조회하고자 하는 테이블 기술
                연결에 사용하려는 칼럼명이 같은경우 ON대신 USING(칼럼) 사용가능

*/

SELECT *
FROM EMP E, DEPT D
WHERE 
    E.DEPTNO = D.DEPTNO
AND E.ENAME = 'SMITH';

SELECT *
FROM EMP E
JOIN DEPT D
--ON E.DEPTNO = D.DEPTNO
USING(DEPTNO)
WHERE E.ENAME = 'SMITH';

/*
    2. 다중 JOIN
        여러개의 테이블 조인하는 경우
*/

CREATE TABLE LOCATION(
    LOCNO NUMBER,
    LOCNAME VARCHAR2(1000),
    LOCNAMEKOR VARCHAR2(1000)
);

INSERT INTO LOCATION VALUES(1, 'NEW YORK', '뉴욕');
INSERT INTO LOCATION VALUES(1, 'DALLAS', '달라스');
INSERT INTO LOCATION VALUES(1, 'CHICAGO', '시카고');
INSERT INTO LOCATION VALUES(1, 'BOSTON', '보스턴');

SELECT * FROM LOCATION;
COMMIT;

--EMP, DEPT, LOCATION 테이블 활용하여 사원번호, 명, 부서코드, 부서이름, 부서위치 , 부서위치 한글
--SELECT EMPNO, ENAME, DEPTNO, DNAME, LOCNAME, LOCNAMEKOR
SELECT *
FROM EMP E
RIGHT JOIN DEPT D USING(DEPTNO)
--LEFT JOIN LOCATION L ON D.LOC = L.LOCNAME
;

/*
    <외부 JOIN>
        테이블간의 JOIN시 일치하지 않는 행도 포함시켜서 조회가능
        단, 반드시 기준이되는 테이블을 지정해야함.
*/

SELECT *
FROM EMP;

INSERT INTO EMP VALUES(9999, 'SWY', 'KING', NULL, '2022-07-11', 1000, NULL, NULL);
COMMIT;

--EMP, DEPT, LOCATION 테이블 활용하여 사원번호, 명, 부서코드, 부서이름, 부서위치 , 부서위치 한글
--SELECT EMPNO, ENAME, DEPTNO, DNAME, LOCNAME, LOCNAMEKOR
SELECT *
FROM EMP E
RIGHT JOIN DEPT D USING(DEPTNO)
--LEFT JOIN LOCATION L ON D.LOC = L.LOCNAME
;

--오라클
SELECT * 
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO(+);
--FULL 조인 오라클 구문은 지원 x
SELECT *
FROM EMP E
FULL JOIN DEPT D USING(DEPTNO);

/*
    <교차조인> CROSS JOIN
        조인되는 모든 테이블의 각 행들이 서로 곱해진다..
        
*/

SELECT *
FROM EMP A
CROSS JOIN DEPT B;

/*
    5. 비등가 조인(NON EQUAL JOIN)
        조인 조건에 등호를 사용하지 않는 조인문을 비등가 조인이라한다.
        지정한 칼럼값이 일치하지않는경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식
        ANSI 구문으로는 JOIN ON만 사용 가능
*/

SELECT *
FROM salgrade;

SELECT *
FROM EMP A
JOIN salgrade B ON A.SAL BETWEEN B.LOSAL AND B.HISAL
ORDER BY ENAME;

/*
    6. 셀프조인
        같은 테이블을 다시한번 조인하는 경우
*/

SELECT A.EMPNO, A.ENAME 사원명, A.MGR, B.ENAME 팀장명
FROM EMP A
JOIN EMP B ON A.MGR = B.EMPNO;



>>>>>>> a63b09823faf7a541fe2a225e6f76c3d2f06ea72
