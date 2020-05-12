
#### 介绍

本来做的是个图床管理的项目，结果撸成了一个工具箱，不定期追加新的功能。

#### 基础环境

JDK1.8、Maven、Mysql、Redis、IntelliJ IDEA、minio、fastdfs

#### 内置功能

- 组织机构：机构管理、用户管理、角色管理、行政区域。

- 系统监控：系统日志、在线用户，后期会慢慢追加完善。

- 应用管理：任务调度、邮件管理、图片管理、文章管理，每个模块只需要你稍作修改就可以打造成一个项目了。

- 系统管理：敏捷开发、系统菜单、全局配置，小伙伴们只需要设计好表结构，三秒中就能撸出一个增删查改的模块。


#### 安装教程

- 启动前请配置 `application-dev.properties` 中相关`mysql`、`redis`以及非启动强依赖配置邮件、鉴黄、阿里云存储、分布式文件存储。

- 数据库脚本位于 `src/main/resource/sql` 下面，启动前请自行导入。

- 配置完成，运行`Application`中的 `main `方法。

## 演示图



<table>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/191648_a6db8c4c_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/191848_edcafb7e_87650.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192547_af73469b_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192604_82b4bed9_87650.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192620_83bf77d3_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192631_b52f7018_87650.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192646_28fc8ad8_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192659_f344d433_87650.png"/></td>
    </tr>	 
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192712_f1276903_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192732_ae0d76b2_87650.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192745_4e6354f7_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192800_eefa1344_87650.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192813_f7600d93_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192824_75b4bb38_87650.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192839_205e772d_87650.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2020/0512/192851_30924c45_87650.png"/></td>
    </tr>
</table>


#### 爪哇交流群

<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=eba7a5d6f672c67cf942e08486e5102f0a0a6268206f873fef48a9d74f248de8"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="JAVA爱好者" title="JAVA爱好者"></a>

#### 推荐


- 秒杀案例：https://gitee.com/52itstyle/spring-boot-seckill

- 任务调度：https://gitee.com/52itstyle/spring-boot-quartz

- 邮件服务：https://gitee.com/52itstyle/spring-boot-mail

- 搜索服务：https://gitee.com/52itstyle/spring-boot-elasticsearch

- 三大支付：https://gitee.com/52itstyle/spring-boot-pay


作者： 小柒2012

欢迎关注： https://blog.52itstyle.vip
