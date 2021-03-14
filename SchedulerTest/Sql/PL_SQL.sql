-- 기존 전체 값 구하는 평션 

CREATE OR REPLACE FUNCTION CAL_TOTAL(TES VARCHAR)

    RETURN VARCHAR

IS

    TOTAL VARCHAR(100);
    PLUS NUMBER(5);
    MINU  NUMBER(5);

BEGIN

   SELECT SUM(BALANCE_COIN) INTO PLUS
   FROM BALANCE 
   WHERE BALANCE_TYPE = 1 
   GROUP BY(BALANCE_TYPE) ;

  SELECT SUM(BALANCE_COIN) INTO MINU
  FROM BALANCE 
  WHERE BALANCE_TYPE = 0 
  GROUP BY(BALANCE_TYPE) ;

      RETURN (PLUS-MINU);

END;

-- 아이디 총액 찾는 펑션 
CREATE OR REPLACE FUNCTION GET_TOTAL(IN_ID VARCHAR)

    RETURN VARCHAR

IS

    TOTAL VARCHAR(100);
    PLUS NUMBER(5);
    MINU  NUMBER(5);

BEGIN

   SELECT nvl(SUM(BALANCE_COIN),0) INTO PLUS
   FROM BALANCE 
   WHERE BALANCE_TYPE = 1 AND USER_ID = IN_ID
   GROUP BY(BALANCE_TYPE) ;

  SELECT nvl(SUM(BALANCE_COIN),0) INTO MINU
  FROM BALANCE 
  WHERE BALANCE_TYPE = 0 AND USER_ID = IN_ID
  GROUP BY(BALANCE_TYPE) ;

      RETURN (PLUS-MINU);

END;