# Write your MySQL query statement below
select e.student_id,e.student_name,sub.subject_name,count(x.subject_name) as attended_exams from students e cross join subjects sub 
left join examinations x on e.student_id = x.student_id
and sub.subject_name = x.subject_name 
group by e.student_id,e.student_name,sub.subject_name
order by e.student_id,sub.subject_name;
