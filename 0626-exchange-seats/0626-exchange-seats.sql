# Write your MySQL query statement below
-- select *,
-- lag(student) over() as prev
-- from seat;

with cte as (select id,
lead(student,1,student) over() as next,
lag(student,1,student) over() as prev
from seat)
select id,
(case 
when id %2 != 0 then next
else prev
end)
as student
from cte;

