# zyn_coder
编写测试Java相关技术demo

### CentOS7.0 nantian01
### redis相关
redis.conf路径：  cd /usr/local/redis/bin

启动   ./redis-server redis.conf

ps aux | grep redis 

./redis-cli shutdown

./redis-cli -h 192.168.12.131 -p 6379


update a set a.bil_no=(select b.bil_no from b where a.src_itm=b.itm) where a.src_itm in (select itm from b)






获取所有部门中当前(dept_emp.to_date = '9999-01-01')员工当前(salaries.to_date='9999-01-01')薪水最高的相关信息，
给出dept_no, emp_no以及其对应的salary，按照部门编号升序排列。
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
如插入：
INSERT INTO dept_emp VALUES(10001,'d001','1986-06-26','9999-01-01');
INSERT INTO dept_emp VALUES(10002,'d001','1996-08-03','9999-01-01');
INSERT INTO dept_emp VALUES(10003,'d001','1996-08-03','1997-08-03');

INSERT INTO salaries VALUES(10001,90000,'1986-06-26','1987-06-26');
INSERT INTO salaries VALUES(10001,88958,'2002-06-22','9999-01-01');
INSERT INTO salaries VALUES(10002,72527,'1996-08-03','1997-08-03');
INSERT INTO salaries VALUES(10002,72527,'2000-08-02','2001-08-02');
INSERT INTO salaries VALUES(10002,72527,'2001-08-02','9999-01-01');
INSERT INTO salaries VALUES(10003,90000,'1996-08-03','1997-08-03');

dept_no emp_no salary

select d.dept_no ,d.emp_no , max(s.salary) salary from dept_emp d left join salaries s 
on d.emp_no = s.emp_no
where d.emp_no = '10001' and d.to_date = '9999-01-01' and s.to_date='9999-01-01' group by d.dept_no order by d.dept_no asc
