<<<<<<< HEAD
--
=======
--JOIN
/*
    <JOIN>
        �� �� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ���
        
        ����
            - 1. ORACLE
                SELECT Į��, Į��..
                FROM ���̺�1, ���̺� 2, 
                WHERE ���̺�1.Į�� = ���̺�2.Į��;
                
                FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� ,�� ����
                WHERE ���� ��Ī ��ų Į���� ���� ���� ����
                
            - 2. ANSI ǥ�� ����
                SELERCT Į��, Į��
                FROM ���̺�
                JOIN ���̺� 2
                ON ���̺�.Į�� = ���̺�2.Į��
                
                FROM ���� ������ �Ǵ� ���̺� ���
                JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺� ���
                ���ῡ ����Ϸ��� Į������ ������� ON��� USING(Į��) ��밡��

*/

SELECT *
FROM EMP E, DEPT D
WHERE 
    E.DEPTNO = D.DEPTNO
AND E.ENAME = 'SMITH';

SELECT *
FROM EMP E
JOIN DEPT D
--ON E.DEPTNO = D.DEPTNO
USING(DEPTNO)
WHERE E.ENAME = 'SMITH';

/*
    2. ���� JOIN
        �������� ���̺� �����ϴ� ���
*/

CREATE TABLE LOCATION(
    LOCNO NUMBER,
    LOCNAME VARCHAR2(1000),
    LOCNAMEKOR VARCHAR2(1000)
);

INSERT INTO LOCATION VALUES(1, 'NEW YORK', '����');
INSERT INTO LOCATION VALUES(1, 'DALLAS', '�޶�');
INSERT INTO LOCATION VALUES(1, 'CHICAGO', '��ī��');
INSERT INTO LOCATION VALUES(1, 'BOSTON', '������');

SELECT * FROM LOCATION;
COMMIT;

--EMP, DEPT, LOCATION ���̺� Ȱ���Ͽ� �����ȣ, ��, �μ��ڵ�, �μ��̸�, �μ���ġ , �μ���ġ �ѱ�
--SELECT EMPNO, ENAME, DEPTNO, DNAME, LOCNAME, LOCNAMEKOR
SELECT *
FROM EMP E
RIGHT JOIN DEPT D USING(DEPTNO)
--LEFT JOIN LOCATION L ON D.LOC = L.LOCNAME
;

/*
    <�ܺ� JOIN>
        ���̺��� JOIN�� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ����
        ��, �ݵ�� �����̵Ǵ� ���̺��� �����ؾ���.
*/

SELECT *
FROM EMP;

INSERT INTO EMP VALUES(9999, 'SWY', 'KING', NULL, '2022-07-11', 1000, NULL, NULL);
COMMIT;

--EMP, DEPT, LOCATION ���̺� Ȱ���Ͽ� �����ȣ, ��, �μ��ڵ�, �μ��̸�, �μ���ġ , �μ���ġ �ѱ�
--SELECT EMPNO, ENAME, DEPTNO, DNAME, LOCNAME, LOCNAMEKOR
SELECT *
FROM EMP E
RIGHT JOIN DEPT D USING(DEPTNO)
--LEFT JOIN LOCATION L ON D.LOC = L.LOCNAME
;

--����Ŭ
SELECT * 
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO(+);
--FULL ���� ����Ŭ ������ ���� x
SELECT *
FROM EMP E
FULL JOIN DEPT D USING(DEPTNO);

/*
    <��������> CROSS JOIN
        ���εǴ� ��� ���̺��� �� ����� ���� ��������..
        
*/

SELECT *
FROM EMP A
CROSS JOIN DEPT B;

/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ�� ������� �ʴ� ���ι��� �� �����̶��Ѵ�.
        ������ Į������ ��ġ�����ʴ°�찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ���
        ANSI �������δ� JOIN ON�� ��� ����
*/

SELECT *
FROM salgrade;

SELECT *
FROM EMP A
JOIN salgrade B ON A.SAL BETWEEN B.LOSAL AND B.HISAL
ORDER BY ENAME;

/*
    6. ��������
        ���� ���̺��� �ٽ��ѹ� �����ϴ� ���
*/

SELECT A.EMPNO, A.ENAME �����, A.MGR, B.ENAME �����
FROM EMP A
JOIN EMP B ON A.MGR = B.EMPNO;



>>>>>>> a63b09823faf7a541fe2a225e6f76c3d2f06ea72
