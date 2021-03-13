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