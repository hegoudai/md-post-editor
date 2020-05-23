# md-post-editor
>一个帮助你写博客的小应用，使用阿里云oss存储博客图片，后端基于 Spring boot, 前端基于 Vue.js

## 使用方法
>在 release 页面下载最新的 zip 包
>解压， 在conf目录下添加你的aliyun配置，命名为application.yml，参考格式如下
```
aliyun:
  oss:
    endpoint: <yourEndPoint>
    accessKeyId: <yourOssKeyId>
    accessKeySecret: <yourOssKeySecret>
    bucket: <yourBucket>

```
>启动
```
在bin目录下找到对应系统的启动脚本，运行即可
```
>浏览器访问 http://localhost:4001