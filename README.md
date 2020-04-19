# md-post-editor
>一个帮助你写博客的小应用，使用阿里云oss存储博客图片，后端基于 Spring boot, 前端基于 Vue.js

## 使用方法
>在 release 页面下载最新的 jar 包
>在下载的 jar 包的文件夹下新建文本 application.yml， 添加如下配置
```
aliyun:
  oss:
    endpoint: <yourEndPoint>
    accessKeyId: <yourOssKeyId>
    accessKeySecret: <yourOssKeySecret>
    bucket: <yourBucket>

```
>命令行启动
```
java -jar md-post-editor.jar
```
>浏览器访问 http://localhost:4001