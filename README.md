# bank_system
项目最好用IDEA打开。
Sql 文件夹下的 bank.sql 是建表的sql语句，在自己的MySQL中新建一个 bank 数据库，在里面执行 bank.sql 就会生成表。
文件夹 /src/main/resource/ 中的 application.yml 是配置文件，以下几行是数据库配置，根据自己的数据库配置好就行。
    url: jdbc:mysql://127.0.0.1:3306/bank?serverTimezone=GMT%2B8
    username: root
    password: 123456
    
