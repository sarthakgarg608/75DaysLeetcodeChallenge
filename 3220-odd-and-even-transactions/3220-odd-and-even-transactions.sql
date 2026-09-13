# Write your MySQL query statement below
with cte as (select amount, transaction_date,
row_number() over(partition by transaction_date  order by amount desc) as rnk
from transactions)
select transaction_date , 
sum( case when amount%2 != 0 then amount else 0 end) as odd_sum,
sum(case when amount%2 = 0 then amount else 0 end) as even_sum
from cte
group by transaction_date
order by transaction_date;

