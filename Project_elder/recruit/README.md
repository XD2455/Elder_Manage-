# Elder_Manager



### p.s  由于时间关系，系统还有些不足的地方需要完善：

### 后期更改代码时由于担心改一些细小的地方会牵一发而动全身，需要改前后端文件名、查找的表、变量名、数据库等等，把时间都浪费在修bug上，所以可能会出现后台中部分表单的业务逻辑和变量名不对应的情况；另外职位推荐部分算法代码需要写成接口给系统调用，数据可视化由于有bug所以部分代码后期删掉了，展示界面目前是将生成的一些图片写死在前端。



### 配置环境：

> 凭记忆写的，可能会有细微出入，具体的自己根据报错信息搜索相关帖子进行配置

1. Java环境
2. MySQL8.0以上
3. 配置maven
4. 配置npm相关
5. 安装redis



### 启动步骤：

1. 连接mysql服务，执行sql文件导入数据
2. 启动redis.server（一定要先启动redis）
3. 启动后端：src/main/java/com/ruoyi/RuoYiApplication.java
4. 启动前端：npm run dev

### 账号密码：
1. 所有账号密码在sys_user表里，大部分账号密码为123456，由于密码经过加密，修改密码不能直接操作数据库，需要登录这个账号在个人中心里修改。
2. 测试账号：
- 求职者 账号：17670548459 密码：123456
- 企业HR 账号：18788914889 密码：123456
- 管理员 账号：admin       密码：admin123