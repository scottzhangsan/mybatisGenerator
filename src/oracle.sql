--ORACLE中实现递归查询。
--创建表
create table menu{  
    menu_Id  varchar(31),  
    menu_name varchar(31),  
    menu_level char(1)，  
    parent_Id varchar(31)  
}  
--查询递归语句。
select t.id AS menuid,t.menu_name AS menuName,t.Parent_Id AS paterId from aut_menu_t t   
where 1=1 START WITH  t.menu_id='root'  connect by  t.Parent_Id=  PRIOR t.menu_id 

 SELECT MENU_ID,
                               SUBSTR (SYS_CONNECT_BY_PATH (MENU_NAME, '/'), 2)
                                  MENU_NAME
                          FROM OWFOL.TS_FOL_MENU
                         WHERE MENU_TYPE = 1 AND MENU_STATUS = 1
                    START WITH PARENT_ID = 0
                    CONNECT BY PRIOR MENU_ID = PARENT_ID


--其中条件start with 条件1 是根节点的限制语句，当然可以放宽限定的条件，以取得多个根节点，实际
--就是多棵树。
--条件2是连接的条件，其中PRIOR表示上一条的记录，比如CONNECT BY PRIOR ORG_ID = PARENT_ID就是
--说上一条记录的ORG_id 是本条记录的parent_id 既本记录的父亲是上一条的记录。

--SYS_CONNECT_BY_PATH函数的运用主要是可以把一个父节点下的所有的子节点通过某个字符进行区分
--然后连接在一个列中显示。第二个参数表示从第几个字符开始分割。
--SUBSTR分割字符串，第一个参数要分割的字符，




