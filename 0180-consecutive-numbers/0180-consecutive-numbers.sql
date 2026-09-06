# Write your MySQL query statement below
with cte as (
    select * ,
    lag(num,1) over (order by id) as prev1,
    lag(num,2) over (order by id) as prev2
    from Logs
)
select distinct num as ConsecutiveNums
from cte
where num = prev1 and num = prev2;