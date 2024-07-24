select e.*, d.*
from employees e
    left join departments d
        on e.department_id = d.department_id
where d.department_name = 'IT';

select e.*
from employees e
    left join departments d on e.department_id = d.department_id
    left join locations l on d.location_id = l.location_id
where l.city = 'Seattle';

select e.*, c.*
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
    join countries c on l.country_id = c.country_id
where c.country_name = 'Canada';

select e.*, r.*
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
    join countries c on l.country_id = c.country_id
    join regions r on c.region_id = r.region_id
where r.region_name = 'Europe';