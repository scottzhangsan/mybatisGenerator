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




