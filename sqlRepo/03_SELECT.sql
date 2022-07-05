--SELECT
/*
    <SELECT 절> 
        문법
        SELECT 칼럼1, 칼럼2, 칼럼... FROM 테이블명;
        - 데이터를 조회하고자 할 때 사용
        - SELECT를 통해서 조회된 결과를 RESULT SET이라고 한다.(조회된 행들의 집합)
        - 조회하고자 하는 칼럼들은 반드시 FROM절에 기술한 테이블에 존재하는 칼럼이여야 한다.
        

*/
--EMP 테이블 조회
SELECT *
FROM emp;

SELECT empno, ename, job, sal
FROM emp;
    
SELECT *
FROM salgrade;

SELECT *
FROM bonus;

SELECT *
FROM dept;


--EMP테이블에서 사원번호 사원이름 월급 조회하기
SELECT empno, ename, sal
FROM emp;

SELECT *
FROM emp;

--아래와 같이 대소문자 구분 없음 (관례상, 대문자로 씀)
SELECT empno, ename
FROM emp;

--산술연산
-- emp 테이블에서 직원이름, 직원연봉 조회하기
SELECT ename, sal * 12
FROM emp;

--NULL 은 연산해도 NULL
SELECT ename, comm * 12
FROM emp;

--연산 중 NULL이 하나라도 있다면 NULL
SELECT ename, ( sal + comm ) * 12
FROM emp;

--DATE 연산
SELECT ename, floor(sysdate - hiredate)
FROM emp;

--칼럼명 별칭 지정
SELECT ename, floor(sysdate - hiredate) AS "근무기간"
FROM emp;
    
-- 전체 직원의, 1년치 (급여 +COMM) 조회
SELECT ENAME, (SAL + COMM) * 12 AS 연소득
FROM EMP;
    
--
/*
    <리터럴>
        SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회가능
        리터럴은 RESULT SET의 모든 행에 반복 출력된다.
*/
-- EMP 테이블에서 사번, 이름, 급여(원) 조회
SELECT EMPNO, ENAME,  SAL, '원 입니다.' AS "단위(만원"
FROM EMP;
    
/*
    <DISTINCT>
        칼럼에 중복값을 한번씩만 표시하고자 할 때 사용한다.
        SELECT 절에 한번만 기술 가능
        칼럼이 여러개이면 칼럼 값들이 모두 동일해야 중복 값으로 판단되어 중복이 제거된다.
*/
--EMP 테이블에서 직업 조회
SELECT DISTINCT JOB
FROM EMP;

SELECT DISTINCT JOB, DEPTNO
FROM EMP;

/*
    <연결 연산자>
        여러 칼럼 값을 하나의 칼럼인거처럼 연결 하거나 컬럼과 리터럴을 연결할 수 있따.
*/
--EMP 테이블에서, 사번, 사원명, 급여를 연결해서 조회
SELECT EMPNO || ENAME || SAL
FROM EMP;

--EMP 테이블에서, 사원명 , 급여를 리터럴로 연결하여 조회
SELECT ENAME || '의 월급은' || SAL || ' 입니다' AS 급여
FROM EMP;

/*
    <WHERE 절>
        문법
            SELECT 칼럼,,,
            FORM 테이블명
            WHERE 조건식;
            
        - 조회하고자 하는 테이블에서 해당 조건에 만족하는 결과만을 조회하고자 할 때
        - 조건식에는 다양한 연산자 사용가능
        
    <비교연산자>
        < > <= >=
        =
        != ^= <>
*/

--EMP 테이블에서 부서코드가 30인 사원들 모든 칼럼 조회
SELECT * 
FROM EMP
WHERE DEPTNO = 30;

--EMP 테이블에서 부서코드가 20이 아닌 사원들의 사번, 사원명, 부서코드 조회
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO != 20;

--EMP 테이블에서, 급여가 1000 이상인 직원들의 이름, 부서코드, 급여 조회
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >= 1000;

-- 실습문제
-- 1. EMP 테이블에서 COMM 이 NULL 인 사원의 이름, 입사일, 부서코드 조회
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE COMM IS NULL;

-- 1. EMP 테이블에서 COMM 이 0 초과인 사원의 이름, 입사일, 부서코드 조회
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE COMM > 0;

-- 2. EMP 테이블에서 급여가 1500이하인 사원의 이름, 급여, 부서코드 조회
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL <= 1500;

