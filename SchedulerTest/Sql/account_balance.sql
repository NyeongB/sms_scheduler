-- 잔액 테이블 생성
CREATE TABLE BALANCE(
BALANCE_NO              NUMBER(5) PRIMARY KEY,
BALANCE_TYPE           NUMBER(1),
BALANCE_DATE           DATE,
BALANCE_COIN            NUMBER(5),
BALANCE_CONTENTS  VARCHAR2(500) 
);

-- 잔액 테이블 시퀀스 생성
CREATE SEQUENCE BALANCE_SEQ
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;
  
-- insert 테스트
  
INSERT INTO BALANCE(BALANCE_NO, BALANCE_TYPE, BALANCE_DATE, BALANCE_COIN, BALANCE_CONTENTS)
VALUES(BALANCE_SEQ.NEXTVAL, 0, SYSDATE, 20, '문자 발송으로 인한 차감');

INSERT INTO BALANCE(BALANCE_NO, BALANCE_TYPE, BALANCE_DATE, BALANCE_COIN, BALANCE_CONTENTS)
VALUES(BALANCE_SEQ.NEXTVAL, 1, SYSDATE, 1340, '충전으로 인한 증감');

-- 확인
SELECT BALANCE_NO AS NO, BALANCE_TYPE AS TYPE, BALANCE_COIN AS COIN, BALANCE_CONTENTS AS CONTENTS, to_char(BALANCE_DATE,'yyyy/mm/dd hh24:mi:ss') AS "DATE"
FROM BALANCE;

-- 잔액 확인
SELECT SUM(BALANCE_COIN) FROM BALANCE WHERE BALANCE_TYPE = 1 GROUP BY(BALANCE_TYPE) ;

SELECT SUM(BALANCE_COIN) FROM BALANCE WHERE BALANCE_TYPE = 0 GROUP BY(BALANCE_TYPE) ;

commit;

delete  from balance;
