# zyn_coder
编写测试Java相关技术demo



### CentOS7.0 nantian01
mysql root  1234
CentOS7.0 nantian01 root  123456
ums_admin表 zyn 123456
### redis相关
redis.conf路径：  cd /usr/local/redis/bin

启动   ./redis-server redis.conf

ps aux | grep redis 

./redis-cli shutdown

./redis-cli -h 192.168.12.131 -p 6379

### elasticsearch
切换到非root用户 su es
cd /home/es/bin/elasticsearch/elasticsearch-6.3.0/bin
./elasticsearch -d
http://192.168.12.131:9200/



### Kibana
cd /root/bin/kibana/kibana/bin
nohup ./kibana &
http://192.168.12.131:5601/
ps -ef | grep node
netstat -nlutp |grep 5601

chown -R es /home/es/bin/elasticsearch/

### nginx
ps -ef|grep nginx
systemctl start nginx
service start nginx
http://192.168.12.131/
guest
guest


### rabbitMq
D:\a-WorkSpace\rabbitMq\rabbit\file\rabbitmq_server-3.7.14\sbin
set RABBITMQ_BASE=D:\a-WorkSpace\rabbitMq\rabbit\data
http://localhost:15672/




javac InstallCert.java 
java InstallCert maven.aliyun.com
jssecacerts
D:\a-WorkSpace\JDK\JDK1.8\jre\lib\security





upstream kibana_server {
    server 192.168.12.131:5601 weight=1 max_fails=3 fail_timeout=60;
}

server {
    listen 80;
    server_name 192.168.12.131;
    auth_basic "Restricted Access";
    auth_basic_user_file /etc/nginx/conf.d/htpasswd.users;
    location / {
        proxy_pass http://kibana_server;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection 'upgrade';
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
    }
}





```text

	    //反例：
        try{
            //代码省略
        } catch (Exception e) {
		    //调用者对异常没有任何感知。而且日志输出只可以使用log框架，不要用sout
            System.out.println("插入异常");
        }

        try{
            //代码省略
        } catch (UnknownHostException  e) {
		//调用者对异常无法定位和判断
            throw new RuntimeException("500");
        }
```


```text

         通常会把返回值封装成result, 类似这样的：
         {
           "status": 200,
           "errorCode": "OK",
           "errorMsg": "OK",
         }

         200 成功
         400 参数错误
         403 无权限
         500 服务器异常
         501数据获取失败
         ......



```











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

