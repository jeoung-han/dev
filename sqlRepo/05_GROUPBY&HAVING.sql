-- �׷�

/*
    GROUP BY
        �׷� ������ ������ �� �ִ� ����
        �������� ������ �ϳ��� �׷����� ��� ó���� �������� ����Ѵ�.
*/

-- ��ü ����� �׷����� ��� ������ ���� ���
SELECT SUM(SAL), DEPTNO
FROM EMP
WHERE SAL > 2000
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- EMP ���̺� �� ������ �޿� �հ� ��ȸ
SELECT JOB, SUM(SAL) AS �޿��հ�
FROM EMP
GROUP BY JOB
ORDER BY �޿��հ�;

-- �� �μ��� COMM�� �޴� ����� �� (0�� �޴°����� ó��)
SELECT DEPTNO, COUNT(NULLIF(COMM,0)) AS ����Ǽ�
FROM EMP
GROUP BY DEPTNO
ORDER BY ����Ǽ�;


/*
    HAVING
         �׷쿡 ���� ������ ������ �� ���
*/

SELECT DEPTNO, SUM(SAL), COUNT(COMM)
FROM EMP
WHERE JOB = 'SALESMAN'
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000
ORDER BY DEPTNO
;

--�� �μ��� ��� �޿� ��ȸ (��, ��� �޿��� 2000�̻��� ��츸)
SELECT DEPTNO, FLOOR(AVG(NVL(SAL,0))) ��ձ޿�
FROM EMP
GROUP BY DEPTNO
HAVING AVG(NVL(SAL,0)) >= 2000
ORDER BY DEPTNO
;

--EMP ���̺��� �޿��� 1000�̻� �� ����鿡 ���Ͽ� �μ��� �޿��հ踦 ��ȸ
SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO;

-- �� �μ���, ���ʽ��� �޴� ����� �� ��ȸ
SELECT DEPTNO, COUNT(NULLIF(COMM,0))
FROM EMP
GROUP BY DEPTNO;


-----------0708------------

SELECT ENAME, 777
FROM EMP;

SELECT 
    EMPNO
    , ENAME
    , NVL(MGR, -1) --MGR�� NULL�̸� -1�� �ٲ�
FROM EMP;



-- DECODE�� CASE�� ����
-- DECODE ����
SELECT 
    EMPNO
    , ENAME
    , DECODE(DEPTNO, 10, 1) --DEPTNO�� 10�̸� 1�� �ٲ�
FROM EMP;

-- CASE ����
SELECT 
    EMPNO
    , ENAME
    , CASE
    WHEN DEPTNO = 10 THEN 1 --������ ���� ��
    WHEN DEPTNO BETWEEN 5 AND 15 THEN 2
    WHEN DEPTNO = 30 THEN 3
    --������ ������� ���� �� �ִ�, ���ǽ��� ��� T���� THEN ����
    ELSE -1 --ELSE ��� ����
    END
FROM EMP;

-- EMP ���̺��� �����, SAL+COMM AS �޿� ��ȸ (COMM�� ������ 0, ������ 100)
SELECT 
    ENAME,
    COMM,
    SAL,
    (SAL+NVL2(NULLIF(COMM,0), 100, 0)) AS �޿�
    --COMM�� 0�̸� NULL ���, �ƴϸ� COMM�״�� ���
    --SAL+NVL2(NULLIF(NULL, 100, 0)
    --SAL + (NULL�̸� 100 OR 100)
    --SAL+NVL2(NULLIF(COMM, 100, 0)
FROM EMP;





















