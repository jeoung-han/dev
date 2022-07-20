-- 서브쿼리
/*
    <SUBQUERY>
        하나의 SQL 문 안에 포함된 또 다른 SQL 문
        메인 쿼리(기존 쿼리)를 보조


*/
-- 서브쿼리 예시

-- 노옹철 사원의 부서코드 조회
SELECT DEPT_CODE
FROM EMPLOYEE 
WHERE EMP_NAME = '노옹철';

-- 노옹철 사원과 부서코드가 같은 사원들을 조회
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE 
    DEPT_CODE = (
        SELECT DEPT_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '노옹철'
    );

/*
    <서브 쿼리 구분>
        서브 쿼리는 서브 쿼리를 수행한 결과의 행과 열의 갯수에 따라서 분류
        
        1) 단일행 서브 쿼리 : 서브 쿼리의 조회결과 값이 행과 열이 하나
        2) 다중행 서브 쿼리 : 서브 쿼리의 조회결과 값이 행의 갯수가 여러행일 때 (열은 하나)
        3) 다중열 서브 쿼리 : 서브 쿼리의 조회결과 값이 열의 갯수가 여러개일 때 (행은 하나)
        4) 다중행, 다중열 서브 쿼리 : 여러개일 때
        
        * 서브 쿼리의 유형에 따라서 서브쿼리 앞에 붙는 연산자가 달라진다.
*/

/*
    <단일행 서브쿼리>
        서브쿼리의 조회 결과 값의 행과 열의 갯수가 1개 일 때
        비교 연산자 사용 가능
*/

-- 1) 전 직원의 평균 급여보다 급여를 적게 받는 직원들의 이름, 직급코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(NVL(SALARY, 0)) FROM EMPLOYEE);


-- 2) 최저 급여를 받는 직원의 사번, 이름, 직급코드 , 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 3) 노옹철 사원의 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 부서명, 직급코드, 급여 조회
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_TITLE
    , JOB_CODE
    , SALARY
FROM EMPLOYEE A
JOIN DEPARTMENT B ON A.DEPT_CODE = B.DEPT_ID
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

--4) 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여의 합 조회
SELECT 
    DEPT_CODE
    , SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING 
    SUM(SALARY) = (
        SELECT MAX(SUM(SALARY)) 
        FROM EMPLOYEE 
        GROUP BY DEPT_CODE
    );

--5) 전지연 사원이 속해있는 부서원들을 조회 (전지연 사원 제외)
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME, DEPT_TITLE, HIRE_DATE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE 
    DEPT_CODE = (
        SELECT DEPT_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '전지연'
    )
AND EMP_NAME != '전지연';
--MINUS
--SELECT 
--    EMP_ID
--    , EMP_NAME
--    , PHONE
--    , JOB_NAME
--    , DEPT_TITLE
--    , HIRE_DATE
--FROM EMPLOYEE A
--JOIN JOB B USING(JOB_CODE)
--JOIN DEPARTMENT C  ON A.DEPT_CODE = C.DEPT_ID
--WHERE EMP_NAME = '전지연';

/*
    <다중행 서브 쿼리>
        서브 쿼리의 조회결과값의 행의 갯수가 여러 행 일 때
        
        IN / NOT IN (서브쿼리) : 여러개의 결과 값 중에 한개라도 일치한다면 TRUE리턴
        ANY : 여러개의 값들 중 한개라도 만족하면 TRUE, IN과 다른점은 비교연산자 사용
            ANY(100, 200, 300)
            SALARY = ANY(...) : IN과 동일
            SALARY != ANY(...) : NOT IN과 같은 결과
            SALARY > ANY(...) : 최소값 보다 크면 
            SALARY < ANY(...) : 최대값 보다 작으면 
        ALL : 여러개의 값들 모두와 비교하여 만족해야 TRUE, IN과 다른점은 비교연산자 사용
            ALL(100, 200, 300)
            SALARY > ALL() : 최대값 보다 크면
            SALACY < ALL() : 최소값 보다 작으면
*/
-- 1 각 부서별 최고 급여를 받는 직원의 이름, 직급 코드, 부서 코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (
    SELECT MAX(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
);


-- 2 전 직원들에 대해 사번, 이름, 부서코드, 구분(사수/사원)

-- 사수에 해당하는 사번 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사수' 구분
FROM EMPLOYEE
WHERE EMP_ID IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사원' 구분
FROM EMPLOYEE
WHERE EMP_ID NOT IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
ORDER BY EMP_ID;

--SELECT 절에 서브쿼리 사용
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_CODE
    , CASE
        WHEN EMP_ID IN
        (
            SELECT DISTINCT MANAGER_ID
            FROM EMPLOYEE
            WHERE MANAGER_ID IS NOT NULL
        ) THEN '사수'
        ELSE '사원'
      END AS 구분
FROM EMPLOYEE;

-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들 사번, 이름, 직급명, 급여
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
AND SALARY > ALL(
    SELECT SALARY
    FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    WHERE JOB_NAME = '차장'
) ;

/*
    <다중 열 서브쿼리>
        조회 결괴 값은 한 행이지만, 나열된 칼럼 수가 여러개
*/

--1 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회

SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유';

--조건에 맞는 사원들 조회
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
AND JOB_CODE = 'J5';

-- 각각 단일행 서브쿼리로 작성
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
)
AND JOB_CODE = (
    SELECT JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
);

-- 다중열 서브쿼리
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (('D5', 'J5'));


SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = 
(
    (
        SELECT DEPT_CODE, JOB_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '하이유'
    )
);

-- 2 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의
--      사번, 이름, 직급코드 사수사번 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (DEPT_CODE, MANAGER_ID) = 
(
    SELECT DEPT_CODE, MANAGER_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '박나라'
);

/*
    <다중행 다중열 서브 쿼리>
*/

-- 1. 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급 코드, 급여 조회

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN 
(
    SELECT JOB_CODE, MIN(SALARY)
    FROM EMPLOYEE
    GROUP BY JOB_CODE
);

-------------------------------------------------------------------------------
/*
    <인라인 뷰( % 테이블)>
        FROM  절에 서브쿼리를 제시하고 , 서브쿼리를 수행한 결과를 테이블 대신 사용
*/

SELECT EMP_NAME
FROM 
(
    SELECT *
    FROM EMPLOYEE
);

SELECT *
FROM EMPLOYEE;

--급여가 높은 상위 5명 조회
SELECT ROWNUM, 사원명, 급여
FROM
(
    SELECT EMP_NAME 사원명, SALARY 급여
    FROM EMPLOYEE E
    ORDER BY SALARY DESC
) E
WHERE ROWNUM < 6;

--6등부터 10등 조회
SELECT 순위, 사원명, 급여
FROM
(
    SELECT ROWNUM 순위, 사원명, 급여
    FROM
    (
        SELECT EMP_NAME 사원명, SALARY 급여
        FROM EMPLOYEE
        ORDER BY SALARY DESC
    ) 
)
WHERE 순위 BETWEEN 6 AND 10;

/*
    <RANK 함수>
        RANK() OVER(정렬기준) / DENSE_RANK() OVER(정렬기준) / 
*/

SELECT 
    EMP_NAME
    , SALARY
    , DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;
--WHERE DENSE_RANK() OVER(ORDER BY SALARY DESC) <= 5; /안댕















    
