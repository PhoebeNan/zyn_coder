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



