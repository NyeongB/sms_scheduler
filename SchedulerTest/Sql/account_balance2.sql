-- 회원정보 조회
SELECT T.*, (SELECT NVL(GET_TOTAL("ID"),'0') "total" FROM DUAL) "TOTAL" FROM 
(SELECT ROWNUM "NUM", TBL.USER_ID "ID", TBL.USER_NAME "NAME", TBL.USER_CONTENT "CONTENT"
, TBL.USER_ONOFF "ONOFF", TBL.USER_DATE "DATE"
, '010-' || SUBSTR(TBL.USER_PHONE,4,4 ) || '-****' "PHONE", TBL.USER_PHONE "RP"
FROM TBL_USER TBL
ORDER BY "DATE" ) T;

commit;

-- 전체 잔액 조회
select * from balance order by BALANCE_NO;

delete from balance where BALANCE_NO= '134';

-- 아이디 별 총액 펑션
SELECT nvl(GET_TOTAL('ccn_01'),'0') "total" FROM DUAL;
SELECT nvl(GET_TOTAL('kbj_01'),'0') "total" FROM DUAL;
SELECT nvl(GET_TOTAL('kbh_01'),'0') "total" FROM DUAL;
SELECT nvl(GET_TOTAL('cdi_01'),'0') "total" FROM DUAL;
