CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      with cte as 
      (select *,
      dense_rank() over (order by salary desc) as drnk
      from Employee)
      select distinct max(salary) 
      from cte
      where drnk = N

  );
END