# 项目脚手架
基于[若依](https://gitee.com/y_project/RuoYi-Vue)进一步调整为符合自身快速开发的脚手架

## 基础环境
- JDK17
- Spring Boot 3.0
- MySQL
- Redis（整合嵌入式Redis方便本地测试启动）
- NodeJs

## MySQL始化
导入项目目录下的 [sql](sql) 文件夹的脚本至数据库即可

## 启动后端项目
运行 [AdminApplication](mysys-admin%2Fsrc%2Fmain%2Fjava%2Fcom%2Fmysys%2FAdminApplication.java)

API文档地址：IP:PORT/swagger-ui/index.html

## 启动前端项目([mysys-ui](mysys-ui))
1. 安装NodeJs
2. 执行以下命令
```shell
# 移动到前端项目目录 
cd mysys-ui 
# 下载依赖
npm install
# 运行项目
npm run dev
```
