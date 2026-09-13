WITH inner_combination AS 
(
    SELECT 
        d.name as department,
        e.name,
        e.salary
    FROM employee e 
    JOIN department d
        ON e.departmentid = d.id
),
cte AS 
(
    SELECT *,
           DENSE_RANK() OVER(
               PARTITION BY department
               ORDER BY salary DESC
           ) AS drnk
    FROM inner_combination
)
SELECT 
    department,
    name AS Employee,
    salary
FROM cte
WHERE drnk = 1;