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

























