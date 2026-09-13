# Write your MySQL query statement below
select b.name
from employee e 
join employee b
on e.managerid = b.id
group by b.id
having count(*) >= 5;