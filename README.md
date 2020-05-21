
#### 介绍

本来做的是个图床管理的项目，结果撸成了一个工具箱，不定期追加新的功能。

#### 基础环境

JDK1.8、Maven、Mysql、Redis、IntelliJ IDEA、minio、fastdfs

#### 相关组件

- [ok-admin](https://gitee.com/bobi1234/ok-admin)
- [vue](https://cn.vuejs.org/)
- [iView](http://v1.iviewui.com/)
- [echarts](https://echarts.apache.org/zh/index.html)
- clipboard
- cropperjs
- lightbox
- nprogress
- webuploader
- ztree

#### 内置功能

- 组织机构：机构管理、用户管理、角色管理、行政区域。

- 系统监控：系统日志、在线用户，后期会慢慢追加完善。

- 应用管理：任务调度、邮件管理、图片管理、文章管理、人工智能，每个模块只需要你稍作修改就可以打造成一个项目了。

- 系统管理：敏捷开发、系统菜单、全局配置、在线代码编辑器，小伙伴们只需要设计好表结构，三秒中就能撸出一个增删查改的模块。


#### 推荐阅读


- [深夜吐血训练了100万小黄图撸了一个鉴黄接口](https://blog.52itstyle.vip/archives/4863/)

- [UCloud 云服务内容鉴黄 Java 版本实现](https://blog.52itstyle.vip/archives/4935/)

- [分享一款炒鸡好用的网盘+文件服务器](https://blog.52itstyle.vip/archives/5275/)

- [SpringBoot 2.x 开发案例之妹子图接入 Redis 缓存](https://blog.52itstyle.vip/archives/5177/)

- [SpringBoot 2.x 开发案例之 Shiro 整合 Redis](https://blog.52itstyle.vip/archives/5092/)

- [SpringBoot 2.x 开发案例之优雅的处理异常](https://blog.52itstyle.vip/archives/5069/)

- [SpringBoot 2.0 开发案例之整合FastDFS分布式文件系统](https://blog.52itstyle.vip/archives/4837/)



#### 安装教程

- 启动前请配置 `application-dev.properties` 中相关`mysql`、`redis`以及非启动强依赖配置邮件、鉴黄、阿里云存储、分布式文件存储。

- 数据库脚本位于 `src/main/resource/sql` 下面，启动前请自行导入。

- 请自行启动 `redis`，见基础环境目录，里面有配置教程。

- 配置完成，运行`Application`中的 `main `方法。

- 测试账号：admin 密码：111111

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


#### 炒鸡工具箱交流群

企鹅群：933593697

![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/174508_3fc74b80_87650.png "超级工具箱群二维码.png")

#### 推荐


- 秒杀案例：https://gitee.com/52itstyle/spring-boot-seckill

- 任务调度：https://gitee.com/52itstyle/spring-boot-quartz

- 邮件服务：https://gitee.com/52itstyle/spring-boot-mail

- 搜索服务：https://gitee.com/52itstyle/spring-boot-elasticsearch

- 三大支付：https://gitee.com/52itstyle/spring-boot-pay


作者： 小柒2012

欢迎关注： https://blog.52itstyle.vip
