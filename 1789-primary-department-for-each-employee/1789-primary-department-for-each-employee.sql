with cte as (select * ,
row_number() over (partition by employee_id order by primary_flag) as row_num
from Employee)
select employee_id , department_id 
from cte
where row_num = 1;
