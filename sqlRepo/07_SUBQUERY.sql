-- ��������
/*
    <SUBQUERY>
        �ϳ��� SQL �� �ȿ� ���Ե� �� �ٸ� SQL ��
        ���� ����(���� ����)�� ����


*/
-- �������� ����

-- ���ö ����� �μ��ڵ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE 
WHERE EMP_NAME = '���ö';

-- ���ö ����� �μ��ڵ尡 ���� ������� ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE 
    DEPT_CODE = (
        SELECT DEPT_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '���ö'
    );

/*
    <���� ���� ����>
        ���� ������ ���� ������ ������ ����� ��� ���� ������ ���� �з�
        
        1) ������ ���� ���� : ���� ������ ��ȸ��� ���� ��� ���� �ϳ�
        2) ������ ���� ���� : ���� ������ ��ȸ��� ���� ���� ������ �������� �� (���� �ϳ�)
        3) ���߿� ���� ���� : ���� ������ ��ȸ��� ���� ���� ������ �������� �� (���� �ϳ�)
        4) ������, ���߿� ���� ���� : �������� ��
        
        * ���� ������ ������ ���� �������� �տ� �ٴ� �����ڰ� �޶�����.
*/

/*
    <������ ��������>
        ���������� ��ȸ ��� ���� ��� ���� ������ 1�� �� ��
        �� ������ ��� ����
*/

-- 1) �� ������ ��� �޿����� �޿��� ���� �޴� �������� �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(NVL(SALARY, 0)) FROM EMPLOYEE);


-- 2) ���� �޿��� �޴� ������ ���, �̸�, �����ڵ� , �޿�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 3) ���ö ����� �޿����� �� ���� �޿��� �޴� ������� ���, �����, �μ���, �����ڵ�, �޿� ��ȸ
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_TITLE
    , JOB_CODE
    , SALARY
FROM EMPLOYEE A
JOIN DEPARTMENT B ON A.DEPT_CODE = B.DEPT_ID
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '���ö');

--4) �μ��� �޿��� ���� ���� ū �μ��� �μ��ڵ�, �޿��� �� ��ȸ
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

--5) ������ ����� �����ִ� �μ������� ��ȸ (������ ��� ����)
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME, DEPT_TITLE, HIRE_DATE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE 
    DEPT_CODE = (
        SELECT DEPT_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '������'
    )
AND EMP_NAME != '������';
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
--WHERE EMP_NAME = '������';

/*
    <������ ���� ����>
        ���� ������ ��ȸ������� ���� ������ ���� �� �� ��
        
        IN / NOT IN (��������) : �������� ��� �� �߿� �Ѱ��� ��ġ�Ѵٸ� TRUE����
        ANY : �������� ���� �� �Ѱ��� �����ϸ� TRUE, IN�� �ٸ����� �񱳿����� ���
            ANY(100, 200, 300)
            SALARY = ANY(...) : IN�� ����
            SALARY != ANY(...) : NOT IN�� ���� ���
            SALARY > ANY(...) : �ּҰ� ���� ũ�� 
            SALARY < ANY(...) : �ִ밪 ���� ������ 
        ALL : �������� ���� ��ο� ���Ͽ� �����ؾ� TRUE, IN�� �ٸ����� �񱳿����� ���
            ALL(100, 200, 300)
            SALARY > ALL() : �ִ밪 ���� ũ��
            SALACY < ALL() : �ּҰ� ���� ������
*/
-- 1 �� �μ��� �ְ� �޿��� �޴� ������ �̸�, ���� �ڵ�, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (
    SELECT MAX(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
);


-- 2 �� �����鿡 ���� ���, �̸�, �μ��ڵ�, ����(���/���)

-- ����� �ش��ϴ� ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '���' ����
FROM EMPLOYEE
WHERE EMP_ID IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '���' ����
FROM EMPLOYEE
WHERE EMP_ID NOT IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
ORDER BY EMP_ID;

--SELECT ���� �������� ���
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
        ) THEN '���'
        ELSE '���'
      END AS ����
FROM EMPLOYEE;

-- ���� �����ӿ��� ���� ������ �ִ� �޿����� �� ���� �޴� ������ ���, �̸�, ���޸�, �޿�
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����'
AND SALARY > ALL(
    SELECT SALARY
    FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    WHERE JOB_NAME = '����'
) ;

/*
    <���� �� ��������>
        ��ȸ �ᱫ ���� �� ��������, ������ Į�� ���� ������
*/

--1 ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ����� ��ȸ

SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '������';

--���ǿ� �´� ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
AND JOB_CODE = 'J5';

-- ���� ������ ���������� �ۼ�
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '������'
)
AND JOB_CODE = (
    SELECT JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '������'
);

-- ���߿� ��������
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
        WHERE EMP_NAME = '������'
    )
);

-- 2 �ڳ��� ����� ���� �ڵ尡 ��ġ�ϸ鼭 ���� ����� ������ �ִ� �����
--      ���, �̸�, �����ڵ� ������ ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (DEPT_CODE, MANAGER_ID) = 
(
    SELECT DEPT_CODE, MANAGER_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '�ڳ���'
);

/*
    <������ ���߿� ���� ����>
*/

-- 1. �� ���޺��� �ּ� �޿��� �޴� ������� ���, �̸�, ���� �ڵ�, �޿� ��ȸ

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
    <�ζ��� ��( % ���̺�)>
        FROM  ���� ���������� �����ϰ� , ���������� ������ ����� ���̺� ��� ���
*/

SELECT EMP_NAME
FROM 
(
    SELECT *
    FROM EMPLOYEE
);

SELECT *
FROM EMPLOYEE;

--�޿��� ���� ���� 5�� ��ȸ
SELECT ROWNUM, �����, �޿�
FROM
(
    SELECT EMP_NAME �����, SALARY �޿�
    FROM EMPLOYEE E
    ORDER BY SALARY DESC
) E
WHERE ROWNUM < 6;

--6����� 10�� ��ȸ
SELECT ����, �����, �޿�
FROM
(
    SELECT ROWNUM ����, �����, �޿�
    FROM
    (
        SELECT EMP_NAME �����, SALARY �޿�
        FROM EMPLOYEE
        ORDER BY SALARY DESC
    ) 
)
WHERE ���� BETWEEN 6 AND 10;

/*
    <RANK �Լ�>
        RANK() OVER(���ı���) / DENSE_RANK() OVER(���ı���) / 
*/

SELECT 
    EMP_NAME
    , SALARY
    , DENSE_RANK() OVER(ORDER BY SALARY DESC) ����
FROM EMPLOYEE;
--WHERE DENSE_RANK() OVER(ORDER BY SALARY DESC) <= 5; /�ȴ�















    
