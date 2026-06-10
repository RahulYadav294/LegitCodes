# Write your MySQL query statement below
select max(salary) As SecondHighestSalary from employee
where salary < (
    select max(salary) from employee
);