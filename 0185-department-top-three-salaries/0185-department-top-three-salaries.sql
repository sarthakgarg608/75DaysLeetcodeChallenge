with cte as(select e.name as Employee ,e.salary,e.departmentId , d.name as Department,
dense_rank() over(partition by d.name order by salary desc) as drnk
from employee e
left join department d
on e.departmentId = d.id)
select Department , Employee ,salary
from cte 
where drnk <= 3;

