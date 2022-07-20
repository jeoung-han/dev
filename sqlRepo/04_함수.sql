-- �Լ�
/*
    <�Լ�>
        Į������ �о ��� ����� ��ȯ
        - ������ �Լ� : N���� ���� �а� N���� ��� ���� (�� �ึ��, �Լ� ���� -> �����ȯ)
        - �׷�   �Լ� : N���� ���� �а� 1���� ��� ���� (�ϳ��� �׷캰��, �Լ� ���� -> �����ȯ)
        
        SELECT ���� ������ �Լ��� �׷� �Լ��� �Բ� ����� �� ���� (������� ������ �޶�)
        �Լ��� ����� �� �ִ� ��ġ�� SELECT, WHERE, ORDER BY, HAVING ��
*/

-----------------------------���� �� �Լ� ---------------------------------------

/*
    <���� ���� �Լ�>
    1. LENGTH / LENGTHB
    - LENGTH(Į��|'���ڿ�') : ���� �� ��ȯ
    - LENGTHB(Į��|'���ڿ�') : ������ ����Ʈ �� ��ȯ
        �ѱ� : 3BYTE
        ����, ����, Ư������ : 1BYTE

    *DUAL ���̺�
    - SYS ����ڰ� �����ϴ� ���̺�
    - ��� ����ڰ� ���� ����
    - �� ��, �� Į���� ������ �ִ� DUMMY ���̺�
    - ����ڰ� �Լ��� ����� �� �ӽ÷� ���
*/

SELECT * FROM DUAL;

SELECT LENGTH('�ȳ�'), LENGTHB('�ȳ�')
FROM DUAL;

SELECT LENGTH(EMPNO), LENGTH(ENAME)
FROM EMP;

/*
    2. INSTR
     - INSTR(Į��|'���ڿ�', ã���� [, POSITION(���۹�ȣ),OCCURENCE(���° ����)])
     - ������ ��ġ���� ������ ���� ��°�� ��Ÿ���� ������ ���� ��ġ�� ��ȯ
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1 , 2) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;

/*
    3. LPAD / RPAD
        - LPAD|RPAD (Į��|���ڿ�, ����(����Ʈ)[, ����])
        - ���õ� Į��|���ڰ��� ������ ���ڸ� ���� �����ʿ� ���ٿ� ���� N�� ���� ��ŭ�� ���ڿ� ��ȯ
        - ������ ���ϰ� ǥ��
*/

-- 10 ��ŭ ���� �� ENAME ���� ������ ���� , ������ �������� ä���
SELECT LPAD(ENAME, 10)
FROM EMP;

SELECT LPAD(ENAME, 10, '#')
FROM EMP;

SELECT RPAD(ENAME, 10, '@')
FROM EMP;

/*
    4. LTRIM / RTRIM
        - LTRIM / RTRIM(Į��|���ڰ�[, ���Ź���])
        - ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ��� �ϴ� ���ڵ��� ã�Ƽ� ������ ��� ��ȯ
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ���� ����
*/

SELECT '          HELLO' FROM DUAL;
SELECT RTRIM('          HELLO             123') FROM DUAL;
SELECT LTRIM('          HELLO             ') FROM DUAL;

SELECT LTRIM('000000000001230000000000', 0) FROM DUAL;
SELECT RTRIM('000000000001230000000000', 0) FROM DUAL;

SELECT LTRIM('12345', 3) FROM DUAL;
SELECT LTRIM('12345', 12) FROM DUAL;
SELECT RTRIM('12345', 45) FROM DUAL;

/*
    5. TRIM
        - TRIM([LEADING|TRAILING|BOTH] ���Ź��� FROM Į��|����)
        - ���ڰ� ��/��/���� ������ ���ڸ� �����ϰ� ������ ��ȯ
        - �����ϰ��� �ϴ� ���� ���� ��, ������ ����
*/

SELECT '      �ȳ�      ' FROM DUAL;
SELECT TRIM('      �ȳ�      ') FROM DUAL;

SELECT TRIM('Z' FROM 'ZZZHELLOZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZHELLOZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZHELLOZZZ') FROM DUAL;

/*
    6. SUBSTR
        - SUBSTR(Į��|���ڰ�, POSITION [,LENGTH])
        - ���� �����Ϳ��� ������ ��ġ���� ������ ������ŭ�� ���ڿ� ���� ��ȯ
*/

SELECT 'HELLO WORLD' FROM DUAL;
SELECT SUBSTR('HELLO WORLD', 3) FROM DUAL;
SELECT SUBSTR('HELLO WORLD', 3, 5) FROM DUAL;
SELECT SUBSTR('HELLO WORLD', -5, 3) FROM DUAL;

/*
    7. LOWER / UPPER / INITCAP(���ܾ��� ù���� ����/������ ��,�� �̿�)
*/

SELECT LOWER('HELLO WORLD') FROM DUAL;
SELECT UPPER('HELLO WORLD') FROM DUAL;
SELECT INITCAP('hello world') FROM DUAL;

/*
    8.CONCAT
        - CONCAT(Į��|���ڰ�, Į��|���ڰ�)
        ||
*/

SELECT CONCAT('AAA', 'BBB')
FROM DUAL;

/*
    9. REPLACE
        - REPLACE(Į��|���ڰ�, TARGET, ������ ����)
        - Į�� �Ǵ� ���ڰ����� TARGET �� STR�� �����Ͽ� ��ȯ
*/

SELECT REPLACE('����� ������ ���ﵿ', '������', '���ϱ�')
FROM DUAL;

SELECT REPLACE('����� ������ ���ﵿ', ' ', '')
FROM DUAL;

SELECT '�ȳ��ϼ��� �ȳ���������' FROM DUAL;
SELECT REPLACE ('�ȳ��ϼ��� �ȳ���������','�ȳ�','') FROM DUAL;

-------------------------------------------------------------------------------
/*
    ����

    1. ABS
        - ABS(NUMBER)
        - ���밪
*/

SELECT ABS(-7) FROM DUAL;

SELECT 10/3 FROM DUAL;

/*
     2. MOD
        MOD(NUMBER, NUMBER)
*/
SELECT MOD(10, 3) FROM DUAL;

/*
    3. ROUND
        - ROUNT(NUMBER[, ��ġ])
        - �ݿø�
        - ��ġ �⺻ ���� 0 
*/
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 4) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;
SELECT ROUND(123.456, -3) FROM DUAL;
SELECT ROUND(789.456, -3) FROM DUAL;

/*
    4. CEIL
        - CEIL(NUMBER)
        - �Ҽ��� �Ʒ� �ø�
*/

SELECT CEIL(123.456) FROM DUAL;

/*
    5. FLOOR
        -FLOOR(NUMBER)
        - �Ҽ��� �Ʒ� ����
*/

SELECT FLOOR(123.456) FROM DUAL;

/*
    6. TRUNC
        - ��ġ �����Ͽ� ����
*/

SELECT TRUNC(123.456) FROM D
UAL;
SELECT TRUNC(123.456, 1) FROM DUAL;

------------------------------------------------------------------------------
/*
    ��¥ ����
    
    1. SYSDATE
        -�ý����� ���� ��¥ �� �ð�

*/

/*
    2. MONTHS_BETWEEN
        - �� ��¥ ������ �������� ����
        - ���ϰ��� NUMBER
*/
SELECT ENAME, FLOOR(MONTHS_BETWEEN(SYSDATE , HIREDATE)) �ٹ�������, HIREDATE �Ի���
FROM EMP;

/*
    3. ADD_MONTHS
        - ������ ������
        - ���ϰ� : DATE
*/

SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;
SELECT ADD_MONTHS('2022/12/31', 6) FROM DUAL;

/*
    NEXT_DAY
        ����
            NEXT_DAY(DATE, ����(����|����))
            - DATE ���� ���� ����� �������� ����
*/

SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�ݿ���') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRI') FROM DUAL;

/*
    LAST_DAY
        
*/

SELECT LAST_DAY(SYSDATE) FROM DUAL;
SELECT LAST_DAY('20220501') FROM DUAL;

/*
    EXTRACT
        - EXTRACT (YEAR | MONTH | DAY FROM DATE)
        - ���� Ÿ���� NUMBER
*/

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;

-- ��¥ ���� ����
SELECT SYSDATE FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS AM';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';


-------------------------------------------------------------------------------
/*
    �� ��ȯ �Լ�
    
    1. TO_CHAR
*/
-- ���� -> ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '999999') FROM DUAL; -- 6ĭ�� ����Ȯ��, ��ĭ�� ����
SELECT TO_CHAR(1234, '000000') FROM DUAL; -- -��ĭ�� 0
SELECT TO_CHAR(1234, 'L999999') FROM DUAL; -- ������ ����ȭ��
SELECT TO_CHAR(1234, '$999999') FROM DUAL; -- �޶�
SELECT TO_CHAR(1234, 'L999,999') FROM DUAL;
SELECT TO_CHAR(1234, 'L999,999,999') FROM DUAL;

SELECT EMPNO, ENAME, TO_CHAR(SAL,'L999,999')
FROM EMP;

/*
 ��¥ -> ����
*/
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS AM') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DAY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD (DY)') FROM DUAL;

/*
    2. TO_DATE
*/
-- ���� -> ��¥
SELECT TO_DATE(20220706) FROM DUAL;
SELECT TO_DATE(20220706) FROM DUAL;
-- ���� -> ��¥
SELECT TO_DATE('20220706') FROM DUAL;
SELECT '20220706' FROM DUAL;
SELECT 20220706 FROM DUAL;

/*
    3. TO_NUMBER
*/
SELECT TO_NUMBER('123456789') FROM DUAL;
--SELECT TO_NUMBER('����') FROM DUAL;--�ȉ�
SELECT '123' + '456' FROM DUAL; --�ڵ� �� ��ȯ
--SELECT '123' + '456A' FROM DUAL;--���� �ȴ�
--SELECT TO_NUMBER('456A') FROM DUAL;
--SELECT '10,000' + '2,000' FROM DUAL;
--SELECT TO_NUMBER('10,000') + TO_NUMBER('2,000') FROM DUAL;
SELECT TO_NUMBER('10,000', '99,999,999') + TO_NUMBER('2,000', '99,999,999') FROM DUAL;

--------------------------------------------------------------------------------

/*
    NULL ó�� �Լ�
        [����]
            NVL(Į��, NULL��ü��)
            
        - NULL�� �Ǿ��ִ� Į���� ���� ���ڷ� ������ ������ ��ȯ
        
            NVL2(Į��, ��ü�� 1, ��ü�� 2)
        - Į�� ���� NULL�� �ƴϸ� ������ �� 1, NULL�̸� 2 ��ȯ
        
            NULLIF(�񱳴�� 1, �񱳴�� 2)
        - �ΰ��� ���� �����ϸ� NULL ��ȯ
        - �ΰ��� ���� �������� ������ �񱳴�� 1 ��ȯ
            
*/

SELECT * FROM EMP;

-- EMP ���̺��� �����, COMM ��ȸ (COMM�� NULL �̸� 0�� ���) 

SELECT ENAME, NVL(COMM, 0)
FROM EMP;

-- EMP ���̺��� �����, (�޿�+COMM)*12 ��ȸ (NULL ���� 0���� ó���Ͽ� ���)

--SELECT ENAME, NVL((SAL+COMM)*12, 0)
--FROM EMP;

SELECT ENAME, (SAL + NVL(COMM, 0))*12
FROM EMP;

-- EMP ���̺��� �����, JOB, MGR ��ȸ (MGR NULL �ΰ�� 0)

SELECT ENAME, JOB, NVL(MGR,0)
FROM EMP;

-- EMP ���̺��� �����, SAL+COMM AS �޿� ��ȸ (COMM�� ������ 0, ������ 100)
SELECT ENAME, (SAL+NVL2(COMM, 100, 0)) AS �޿�
FROM EMP;

SELECT NULLIF(123, 123)
FROM DUAL;

-- EMP ���̺��� �����, SAL+COMM AS �޿� ��ȸ (COMM�� ������ 0, ������ 100)
SELECT 
    ENAME,
    COMM,
    SAL,
    (SAL+NVL2(NULLIF(COMM,0), 100, 0)) AS �޿�
FROM EMP;

/*
    �����Լ�
        �������� ��� ������ �� �� �ִ� ����� ����
        
    DECODE(Į��|����, ���ǰ�1, ����� 1, ���ǰ�2, ����� 2....)
    - ���ϰ��� �ϴ� ���� ���ǰ��� ��ġ�� ��� �׿� �ش��ϴ� ����� ��ȯ
    - ��� ���ǿ� �ش����� ������ NULL
    
*/

SELECT
    EMPNO,
    ENAME,
    JOB,
    DECODE(JOB, 'MANAGER', '�޴���', 'SALESMAN', '����', JOB, JOB)
FROM
    EMP;

/*
    CASE
        ����
        CASE WHEN ���ǽ� 1 THEN ����� 1
             WHEN ���ǽ� 2 THEN ����� 2
             ...
             ELSE �����
        END
*/

-- EMP �����, �޿�, ����(�޿��� 1000�Ʒ��� �ʱ�, 1000~3000 �߱� , ������ ���) ��ȸ 
SELECT
    ENAME,
    SAL,
    CASE WHEN SAL < 1000 THEN '�ʱ�'
--         WHEN SAL BETWEEN 1000 AND 3000 THEN '�߱�'
         WHEN SAL < 3000 THEN '�߱�'
         ELSE '���'
    END AS ����
FROM
    EMP;
-------------------------------------------------------------------------------
--�׷��Լ�

/*
    �뷮�� �����͵�� ���質 ��� ���� �۾��� ó���ϴ� ��� ���
    ��� �׷� �Լ��� NULL���� �ڵ����� �����ϰ� �����ִ� �͵鸸 ���
    ���� ������ ���� AVG �Լ� ���� �ݵ�� NVL�Լ��� ����ϴ°��� ����
*/

/*SUM*/
SELECT 1, SUM(COMM)
FROM EMP;

--SELECT ENAME, SUM(COMM)
--FROM EMP; �׷��Լ� �Ѱ��� ���� �����������°Ŷ� ���� ��� �Ұ���

-- EMP ���̺��� �μ��ڵ尡 30�� ������� �޿� �հ� ��ȸ
SELECT SUM(SAL)
FROM EMP
WHERE DEPTNO = 30;

--COMM �� NULL �� �ƴ� ������� COMM �հ� ��ȸ
SELECT SUM(COMM)
FROM EMP;
--WHERE COMM IS NOT NULL;

--EMP ���̺� ������� S�� �����ϴ� ����� SAL �հ�
SELECT SUM(SAL)
FROM EMP
WHERE ENAME LIKE('S%');

/*AVG()*/

--EMP �� ��� �޿� ���
SELECT AVG(SAL)
FROM EMP;

--EMP �μ��ڵ� 10 �޿����
SELECT ROUND(AVG(NVL(COMM,0)))
FROM EMP
WHERE DEPTNO = 30;

--EMP �Ի����ڰ� 81�⵵ ������ �޿��� ��� ��ȸ
SELECT AVG(SAL)
FROM EMP
WHERE HIREDATE >= '1982.01.01';

SELECT EXTRACT(YEAR FROM HIREDATE)
FROM EMP;

/*MIN MAX*/

-- EMP ���̺� ���� ���� �޿�
SELECT MIN(SAL)
FROM EMP;

-- ���� ���� �޿�
SELECT MAX(SAL)
FROM EMP;

/*COUNT ���� ����*/
SELECT 
--    *
    COUNT(*)
FROM EMP
WHERE DEPTNO = 30
;

SELECT COUNT(DISTINCT DEPTNO)
FROM EMP;

SELECT 
--    COMM 14�� 
    COUNT(COMM)--6��
FROM EMP;











