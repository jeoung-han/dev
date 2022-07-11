-- 그룹

/*
    GROUP BY
        그룹 기준을 제시할 수 있는 구문
        여러개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/

-- 전체 사원을 그룹으로 묶어서 총합을 구한 결과
SELECT SUM(SAL), DEPTNO
FROM EMP
WHERE SAL > 2000
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- EMP 테이블 중 직무별 급여 합계 조회
SELECT JOB, SUM(SAL) AS 급여합계
FROM EMP
GROUP BY JOB
ORDER BY 급여합계;

-- 각 부서별 COMM을 받는 사원의 수 (0도 받는것으로 처리)
SELECT DEPTNO, COUNT(NULLIF(COMM,0)) AS 사원의수
FROM EMP
GROUP BY DEPTNO
ORDER BY 사원의수;


/*
    HAVING
         그룹에 대한 조건을 제시할 때 사용
*/

SELECT DEPTNO, SUM(SAL), COUNT(COMM)
FROM EMP
WHERE JOB = 'SALESMAN'
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000
ORDER BY DEPTNO
;

--각 부서별 평균 급여 조회 (단, 평균 급여가 2000이상인 경우만)
SELECT DEPTNO, FLOOR(AVG(NVL(SAL,0))) 평균급여
FROM EMP
GROUP BY DEPTNO
HAVING AVG(NVL(SAL,0)) >= 2000
ORDER BY DEPTNO
;

--EMP 테이블에서 급여가 1000이상 인 사람들에 대하여 부서별 급여합계를 조회
SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO;

-- 각 부서별, 보너스를 받는 사원의 수 조회
SELECT DEPTNO, COUNT(NULLIF(COMM,0))
FROM EMP
GROUP BY DEPTNO;


-----------0708------------

SELECT ENAME, 777
FROM EMP;

SELECT 
    EMPNO
    , ENAME
    , NVL(MGR, -1) --MGR이 NULL이면 -1로 바꿈
FROM EMP;



-- DECODE와 CASE의 차이
-- DECODE 예시
SELECT 
    EMPNO
    , ENAME
    , DECODE(DEPTNO, 10, 1) --DEPTNO가 10이면 1로 바꿈
FROM EMP;

-- CASE 예시
SELECT 
    EMPNO
    , ENAME
    , CASE
    WHEN DEPTNO = 10 THEN 1 --위에랑 같은 식
    WHEN DEPTNO BETWEEN 5 AND 15 THEN 2
    WHEN DEPTNO = 30 THEN 3
    --조건을 마음대로 넣을 수 있다, 조건식이 모두 T여야 THEN 실행
    ELSE -1 --ELSE 사용 가능
    END
FROM EMP;

-- EMP 테이블에서 사원명, SAL+COMM AS 급여 조회 (COMM이 없으면 0, 있으면 100)
SELECT 
    ENAME,
    COMM,
    SAL,
    (SAL+NVL2(NULLIF(COMM,0), 100, 0)) AS 급여
    --COMM이 0이면 NULL 출력, 아니면 COMM그대로 출력
    --SAL+NVL2(NULLIF(NULL, 100, 0)
    --SAL + (NULL이면 100 OR 100)
    --SAL+NVL2(NULLIF(COMM, 100, 0)
FROM EMP;





















