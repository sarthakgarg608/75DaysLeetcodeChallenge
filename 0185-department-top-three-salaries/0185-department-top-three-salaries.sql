with cte as
(select
e.name as Employee,
e.salary,
d.name as Department,
dense_rank() over(partition by d.name order by e.salary desc) as drnk
from employee e
left join department d
on e.departmentId = d.id)

select Department,Employee ,salary
from cte 
where drnk <= 3;

