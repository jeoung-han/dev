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

























