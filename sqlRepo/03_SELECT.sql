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
SELECT ename, floor(sysdate - hiredate)--�Ҽ��� ���� floor�Լ�
FROM emp;

--Į���� ��Ī ����
SELECT ename, floor(sysdate - hiredate) AS "�ٹ��Ⱓ" --AS�� "��������
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

/*
    <��������>
        AND, OR
*/

-- EMP ���̺���, �μ��ڵ� 30 �̸鼭 �޿��� 1000�̻��� ��� ��ȸ
SELECT ENAME
FROM EMP
WHERE DEPTNO = 30 AND SAL >= 1000;

-- EMP ���̺���, �޿��� 2000�̻��̸鼭, JOB�� MANAGER�� ����� ��� Į��
SELECT *
FROM EMP
WHERE SAL >= 2000 AND JOB = 'MANAGER';

--EMP ���̺��� �޿��� 2000�̻��̸鼭 4000������ ����� ���, �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >= 2000 AND SAL <= 4000;

/*
    <BETWEEN AND>
        ����
            WHERE �񱳴��Į�� BETWEEN ���Ѱ� AND ���Ѱ�
        - WHERE ������ ���Ǵ� �������� ������ ���� ��������
        - �񱳴��Į�� ���� ���Ѱ� �̻��̰�, ���Ѱ� ������ ��� TRUE�� ����
*/

--EMP ���̺��� �޿��� 2000�̻��̸鼭 4000������ ����� ���, �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL BETWEEN 2000 AND 4000;

--EMP ���̺��� �޿��� 2000�̻��̸鼭 4000���ϰ� �ƴ� ����� ���, �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 4000;

-- EMP ���̺���, �Ի����� 81/01/01 ~ 81/12/31 �� �ƴ� ����� ���Į��
SELECT *
FROM EMP
WHERE HIREDATE NOT BETWEEN '81/01/01' AND '81/12/31'
ORDER BY HIREDATE ASC;--ASC/DESC

--OR
SELECT *
FROM EMP
WHERE SAL < 1000
OR NOT SAL > 4000;

/*
    <LIKE>
        ����
            WHERE ��Į�� LIKE '����';
        - ���Ϸ��� Į���� ������ Ư�� ���Ͽ� ������ ��� TRUE ����
        - Ư�� ���Ͽ��� '%', '_'�� ���ϵ� ī��� ��� ����
            % : 0���� �̻� / 
                EX) ��Į�� LIKE '�ȳ�%' => ��Į���� '�ȳ�'���� �����ϴ� ��� ���� ��ȸ
                EX) ��Į�� LIKE '%�ȳ�' => ��Į���� '�ȳ�'���� ������ ��� ���� ��ȸ
                EX) ��Į�� LIKE '%�ȳ�%' => ��Į���� '�ȳ�'�� �����ϴ� ��� ���� ��ȸ
            _ : 1����
                EX) ��Į�� LIKE '_�ȳ�' => ��Į�� �� '�ȳ�' �տ� �ѱ��ڰ� ���� ���� ��ȸ
                EX) ��Į�� LIKE '�ȳ�_' => ��Į�� �� '�ȳ�' �ڿ� �ѱ��ڰ� ���� ���� ��ȸ
                EX) ��Į�� LIKE '�ȳ�__' => ��Į�� �� '�ȳ�' �ڿ� �α��ڰ� ���� ���� ��ȸ
*/

-- EMP ���̺��� �̸��� J�� �����ϴ� ����� ���, ����� �μ��ڵ� ��ȸ
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE ENAME LIKE 'J%';

SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE ENAME LIKE '%N';

SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE ENAME LIKE '%E%';

SELECT ENAME, EMPNO, DEPTNO
FROM EMP
WHERE ENAME LIKE '_____';

SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO LIKE '_5%';

--����--
--EMP ���̺� �̸� ù ���ڰ� S�� �ƴ� ����� ��� �̸�
SELECT EMPNO, ENAME
FROM EMP
WHERE NOT ENAME LIKE 'S%';

/*
    <IS NULL / IS NOT NULL>
        ����
            WHERE ��Į�� IS [NOT] NULL;
            
        - Į�� ���� NULL �� ������� NULL�񱳿� ����
        
*/

SELECT *
FROM EMP
WHERE COMM IS NULL;

SELECT *
FROM EMP
WHERE COMM IS NOT NULL;

/*
    <IN>
        ����
            WHERE ��Į�� IN (��, ��, ��...);
         
        ��� �� ��ġ�ϴ� ���� ���� ���
*/

SELECT *
FROM EMP
WHERE JOB IN ('SALESMAN','MANAGER');

/*
    <������ �켱����>
        0. ()
        1. ��� ������
        2. ���� ������
        3. �� ������
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. NOT
        7. AND
        8. OR
*/

/*
    <ORDER BY>
        SQL�������� ���ı�� �߰�
        ASC, DESC�� �������� �������� ���� �⺻ ASC
*/

SELECT *
FROM EMP
--ORDER BY COMM ASC
--ORDER BY COMM DESC
--ORDER BY COMM ASC NULLS FIRST
--ORDER BY COMM ASC NULLS LAST
ORDER BY DEPTNO, SAL
;

SELECT EMPNO ���, ENAME �����, HIREDATE �Ի���
FROM EMP
ORDER BY �Ի���;
















