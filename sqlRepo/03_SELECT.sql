--SELECT
/*
    <SELECT ��> 
        ����
        SELECT Į��1, Į��2, Į��... FROM ���̺��;
        - �����͸� ��ȸ�ϰ��� �� �� ���
        - SELECT�� ���ؼ� ��ȸ�� ����� RESULT SET�̶�� �Ѵ�.(��ȸ�� ����� ����)
        - ��ȸ�ϰ��� �ϴ� Į������ �ݵ�� FROM���� ����� ���̺� �����ϴ� Į���̿��� �Ѵ�.
        

*/
--EMP ���̺� ��ȸ
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


--EMP���̺��� �����ȣ ����̸� ���� ��ȸ�ϱ�
SELECT empno, ename, sal
FROM emp;

SELECT *
FROM emp;

--�Ʒ��� ���� ��ҹ��� ���� ���� (���ʻ�, �빮�ڷ� ��)
SELECT empno, ename
FROM emp;

--�������
-- emp ���̺��� �����̸�, �������� ��ȸ�ϱ�
SELECT ename, sal * 12
FROM emp;

--NULL �� �����ص� NULL
SELECT ename, comm * 12
FROM emp;

--���� �� NULL�� �ϳ��� �ִٸ� NULL
SELECT ename, ( sal + comm ) * 12
FROM emp;

--DATE ����
SELECT ename, floor(sysdate - hiredate)
FROM emp;

--Į���� ��Ī ����
SELECT ename, floor(sysdate - hiredate) AS "�ٹ��Ⱓ"
FROM emp;
    
-- ��ü ������, 1��ġ (�޿� +COMM) ��ȸ
SELECT ENAME, (SAL + COMM) * 12 AS ���ҵ�
FROM EMP;
    
--
/*
    <���ͷ�>
        SELECT ���� ���ͷ��� ����ϸ� ���̺� �����ϴ� ������ó�� ��ȸ����
        ���ͷ��� RESULT SET�� ��� �࿡ �ݺ� ��µȴ�.
*/
-- EMP ���̺��� ���, �̸�, �޿�(��) ��ȸ
SELECT EMPNO, ENAME,  SAL, '�� �Դϴ�.' AS "����(����"
FROM EMP;
    
/*
    <DISTINCT>
        Į���� �ߺ����� �ѹ����� ǥ���ϰ��� �� �� ����Ѵ�.
        SELECT ���� �ѹ��� ��� ����
        Į���� �������̸� Į�� ������ ��� �����ؾ� �ߺ� ������ �ǴܵǾ� �ߺ��� ���ŵȴ�.
*/
--EMP ���̺��� ���� ��ȸ
SELECT DISTINCT JOB
FROM EMP;

SELECT DISTINCT JOB, DEPTNO
FROM EMP;

/*
    <���� ������>
        ���� Į�� ���� �ϳ��� Į���ΰ�ó�� ���� �ϰų� �÷��� ���ͷ��� ������ �� �ֵ�.
*/
--EMP ���̺���, ���, �����, �޿��� �����ؼ� ��ȸ
SELECT EMPNO || ENAME || SAL
FROM EMP;

--EMP ���̺���, ����� , �޿��� ���ͷ��� �����Ͽ� ��ȸ
SELECT ENAME || '�� ������' || SAL || ' �Դϴ�' AS �޿�
FROM EMP;

/*
    <WHERE ��>
        ����
            SELECT Į��,,,
            FORM ���̺��
            WHERE ���ǽ�;
            
        - ��ȸ�ϰ��� �ϴ� ���̺��� �ش� ���ǿ� �����ϴ� ������� ��ȸ�ϰ��� �� ��
        - ���ǽĿ��� �پ��� ������ ��밡��
        
    <�񱳿�����>
        < > <= >=
        =
        != ^= <>
*/

--EMP ���̺��� �μ��ڵ尡 30�� ����� ��� Į�� ��ȸ
SELECT * 
FROM EMP
WHERE DEPTNO = 30;

--EMP ���̺��� �μ��ڵ尡 20�� �ƴ� ������� ���, �����, �μ��ڵ� ��ȸ
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO != 20;

--EMP ���̺���, �޿��� 1000 �̻��� �������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >= 1000;

-- �ǽ�����
-- 1. EMP ���̺��� COMM �� NULL �� ����� �̸�, �Ի���, �μ��ڵ� ��ȸ
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE COMM IS NULL;

-- 1. EMP ���̺��� COMM �� 0 �ʰ��� ����� �̸�, �Ի���, �μ��ڵ� ��ȸ
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE COMM > 0;

-- 2. EMP ���̺��� �޿��� 1500������ ����� �̸�, �޿�, �μ��ڵ� ��ȸ
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL <= 1500;

