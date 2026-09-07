# Write your MySQL query statement below
with cte as (select * ,
case
when income < 20000 then 'Low Salary'
when income >= 20000 and income <= 50000 then 'Average Salary'
else 'High Salary'
end
as category
from Accounts)

select category , count(*) as accounts_count
from cte
group by category

union

select 'High Salary' as category , 0 as account_count
from cte 
where 'High Salary' not in (
    select distinct category
    from cte
)

union

select 'Low Salary' as category , 0 as account_count
from cte 
where 'Low Salary' not in (
    select distinct category
    from cte
)

union

select 'Average Salary' as category , 0 as account_count
from cte 
where 'Average Salary' not in (
    select distinct category
    from cte
)



