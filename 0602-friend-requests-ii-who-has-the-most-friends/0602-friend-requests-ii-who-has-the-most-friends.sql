# Write your MySQL query statement below
with cte as(select *
from requestaccepted

union all 
select accepter_id , requester_id , accept_date
from requestaccepted),
cte2 as (
select requester_id , count(*) as num
from cte
group by requester_id),
cte3 as (
    select *,
    row_number() over(order by num desc) as rnk
    from cte2
)
select requester_id as id , num 
from cte3
where rnk = 1;