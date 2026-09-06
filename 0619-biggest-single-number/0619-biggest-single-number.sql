with cte as (SELECT num
FROM MyNumbers
GROUP BY num
having count(*) = 1)
select max(num) as num 
from cte;

