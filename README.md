# api-design-demo
1.介绍

- api-design-demo是我对之前所学框架的一个整合，基于SpringBoot整合Mybatis,Redis,Shiro，融合Swagger做接口文档，运用JSR303做数据校验,利用MybatisPlus简化数据访问层的操作，利用AutoGenerator自动代码生成器，减少代码的编写，更加专注业务逻辑的实现，从而提高开发效率。
- 自定义全局异常处理器，使controller层始终能返回给前端标准响应状态

2.项目结构

api-design-demo ----src --- 
	    config
	    enums		
	    handler
	    exception
	    handler
	    shiro
	    util
	    vo
	resources
	test

3.使用方式

- 在resources的sql下找到数据库文件users.sql，导入数据库
- 在resources的application-dev.properties下配置Mysql和Redis
- 配置scr下的util里的DevGenerator类中的数据源参数，运行该类即可自动生成实体类，数据访问层，服务层，服务实现层，控制器层
- config包下配置了跨域，Druid，全局异常处理，MybatisPlus，Redis，响应状态处理，Shrio，Swagger，可以根据业务需求，开启是否使用他们

4. 测试
5.总结

自此整个后端接口基本体系就构建完毕了

- 通过Validator + 自动抛出异常来完成了方便的参数校验
- 通过全局异常处理 + 自定义异常完成了异常操作的规范
- 通过数据统一响应完成了响应数据的规范
- 多个方面组装非常优雅的完成了后端接口的协调，让开发人员有更多的经历注重业务逻辑代码，轻松构建后端接口
- 整合Mybatis，Redis，Shiro，帮你快速搭建开发环境

项目体系该怎么构建、后端接口该怎么写都没有一个绝对统一的标准，不是说一定要按照本文的来才是最好的，你怎样都可以。

详情可见本人博客：
https://luffy997.github.io 搜索api-design-demo即可
