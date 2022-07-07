-- 함수
/*
    <함수>
        칼럼값을 읽어서 계산 결과를 반환
        - 단일행 함수 : N개의 값을 읽고 N개의 결과 리턴 (매 행마다, 함수 실행 -> 결과반환)
        - 그룹   함수 : N개의 값을 읽고 1개의 결과 리턴 (하나의 그룹별로, 함수 실행 -> 결과반환)
        
        SELECT 절에 단일행 함수와 그룹 함수를 함께 사용할 수 없음 (결과행의 갯수가 달라서)
        함수를 기술할 수 있는 위치는 SELECT, WHERE, ORDER BY, HAVING 절
*/

-----------------------------단일 행 함수 ---------------------------------------

/*
    <문자 관련 함수>
    1. LENGTH / LENGTHB
    - LENGTH(칼럼|'문자열') : 글자 수 반환
    - LENGTHB(칼럼|'문자열') : 글자의 바이트 수 반환
        한글 : 3BYTE
        영어, 숫자, 특수문자 : 1BYTE

    *DUAL 테이블
    - SYS 사용자가 소유하는 테이블
    - 모든 사용자가 접근 가능
    - 한 행, 한 칼럼을 가지고 있는 DUMMY 테이블
    - 사용자가 함수를 사용할 때 임시로 사용
*/

SELECT * FROM DUAL;

SELECT LENGTH('안녕'), LENGTHB('안녕')
FROM DUAL;

SELECT LENGTH(EMPNO), LENGTH(ENAME)
FROM EMP;

/*
    2. INSTR
     - INSTR(칼럼|'문자열', 찾을값 [, POSITION(시작번호),OCCURENCE(몇번째 등장)])
     - 지정한 위치부터 지정된 숫자 번째로 나타나는 문자의 시작 위치를 반환
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1 , 2) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;

/*
    3. LPAD / RPAD
        - LPAD|RPAD (칼럼|문자열, 길이(바이트)[, 문자])
        - 제시된 칼럼|문자값에 임의의 문자를 왼쪽 오른쪽에 덧붙여 최종 N의 길이 만큼의 문자열 반환
        - 문자의 통일감 표현
*/

-- 10 만큼 길이 중 ENAME 값은 오른쪽 정렬 , 왼쪽은 공백으로 채우기
SELECT LPAD(ENAME, 10)
FROM EMP;

SELECT LPAD(ENAME, 10, '#')
FROM EMP;

SELECT RPAD(ENAME, 10, '@')
FROM EMP;

/*
    4. LTRIM / RTRIM
        - LTRIM / RTRIM(칼럼|문자값[, 제거문자])
        - 문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 결과 반환
        - 제거하고자 하는 문자값을 생략 시 기본값으로 공백 제거
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
        - TRIM([LEADING|TRAILING|BOTH] 제거문자 FROM 칼럼|문자)
        - 문자값 앞/뒤/양쪽 지정한 문자를 제거하고 나머지 반환
        - 제거하고자 하는 문자 생략 시, 공백을 제거
*/

SELECT '      안녕      ' FROM DUAL;
SELECT TRIM('      안녕      ') FROM DUAL;

SELECT TRIM('Z' FROM 'ZZZHELLOZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZHELLOZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZHELLOZZZ') FROM DUAL;

/*
    6. SUBSTR
        - SUBSTR(칼럼|문자값, POSITION [,LENGTH])
        - 문자 데이터에서 지정한 위치부터 지정한 갯수만큼의 문자열 추출 반환
*/

SELECT 'HELLO WORLD' FROM DUAL;
SELECT SUBSTR('HELLO WORLD', 3) FROM DUAL;
SELECT SUBSTR('HELLO WORLD', 3, 5) FROM DUAL;
SELECT SUBSTR('HELLO WORLD', -5, 3) FROM DUAL;

/*
    7. LOWER / UPPER / INITCAP(영단어의 첫글자 전부/구분은 영,숫 이외)
*/

SELECT LOWER('HELLO WORLD') FROM DUAL;
SELECT UPPER('HELLO WORLD') FROM DUAL;
SELECT INITCAP('hello world') FROM DUAL;

/*
    8.CONCAT
        - CONCAT(칼럼|문자값, 칼럼|문자값)
        ||
*/

SELECT CONCAT('AAA', 'BBB')
FROM DUAL;

/*
    9. REPLACE
        - REPLACE(칼럼|문자값, TARGET, 변경할 문자)
        - 칼럼 또는 문자값에서 TARGET 을 STR로 변경하여 반환
*/

SELECT REPLACE('서울시 강남구 역삼동', '강남구', '강북구')
FROM DUAL;

SELECT REPLACE('서울시 강남구 역삼동', ' ', '')
FROM DUAL;

SELECT '안녕하세요 안녕히가세요' FROM DUAL;
SELECT REPLACE ('안녕하세요 안녕히가세요','안녕','') FROM DUAL;

-------------------------------------------------------------------------------
/*
    숫자

    1. ABS
        - ABS(NUMBER)
        - 절대값
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
        - ROUNT(NUMBER[, 위치])
        - 반올림
        - 위치 기본 값은 0 
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
        - 소수점 아래 올림
*/

SELECT CEIL(123.456) FROM DUAL;

/*
    5. FLOOR
        -FLOOR(NUMBER)
        - 소수점 아래 내림
*/

SELECT FLOOR(123.456) FROM DUAL;

/*
    6. TRUNC
        - 위치 지정하여 버림
*/

SELECT TRUNC(123.456) FROM D
UAL;
SELECT TRUNC(123.456, 1) FROM DUAL;

------------------------------------------------------------------------------
/*
    날짜 관련
    
    1. SYSDATE
        -시스템의 현재 날짜 및 시간

*/

/*
    2. MONTHS_BETWEEN
        - 두 날짜 사이의 개월수를 리턴
        - 리턴값은 NUMBER
*/
SELECT ENAME, FLOOR(MONTHS_BETWEEN(SYSDATE , HIREDATE)) 근무개월수, HIREDATE 입사일
FROM EMP;

/*
    3. ADD_MONTHS
        - 개월수 더해줌
        - 리턴값 : DATE
*/

SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;
SELECT ADD_MONTHS('2022/12/31', 6) FROM DUAL;

/*
    NEXT_DAY
        문법
            NEXT_DAY(DATE, 요일(문자|숫자))
            - DATE 기준 가장 가까운 다음요일 리턴
*/

SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') FROM DUAL;
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
        - 리턴 타입은 NUMBER
*/

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;

-- 날짜 포맷 변경
SELECT SYSDATE FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS AM';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';


-------------------------------------------------------------------------------
/*
    형 변환 함수
    
    1. TO_CHAR
*/
-- 숫자 -> 문자
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '999999') FROM DUAL; -- 6칸의 공간확보, 빈칸은 공백
SELECT TO_CHAR(1234, '000000') FROM DUAL; -- -빈칸은 0
SELECT TO_CHAR(1234, 'L999999') FROM DUAL; -- 설정된 나라화폐
SELECT TO_CHAR(1234, '$999999') FROM DUAL; -- 달라
SELECT TO_CHAR(1234, 'L999,999') FROM DUAL;
SELECT TO_CHAR(1234, 'L999,999,999') FROM DUAL;

SELECT EMPNO, ENAME, TO_CHAR(SAL,'L999,999')
FROM EMP;

/*
 날짜 -> 문자
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
-- 숫자 -> 날짜
SELECT TO_DATE(20220706) FROM DUAL;
SELECT TO_DATE(20220706) FROM DUAL;
-- 문자 -> 날짜
SELECT TO_DATE('20220706') FROM DUAL;
SELECT '20220706' FROM DUAL;
SELECT 20220706 FROM DUAL;

/*
    3. TO_NUMBER
*/
SELECT TO_NUMBER('123456789') FROM DUAL;
SELECT TO_NUMBER('힝굴') FROM DUAL;--안됌
SELECT '123' + '456' FROM DUAL; --자동 형 변환






