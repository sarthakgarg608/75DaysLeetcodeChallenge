# Write your MySQL query statement below
with salary as(select 
case 
when income < 20000 then 'Low Salary'
when income > 50000 then 'High Salary'
else 'Average Salary'
end as category
from Accounts),
categories as (
    select 'Low Salary' as category
    union all
    select 'High Salary'
    union all
    select 'Average Salary'
)
select c.category , count(s.category) as accounts_count
from categories c
left join salary s 
on c.category = s.category
group by c.category;