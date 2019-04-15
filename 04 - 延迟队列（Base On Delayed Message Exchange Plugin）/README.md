# 使用手册

### 运行示例

1、RabbitMQ 安装插件

- 参考文档：[构建带社区插件的 RabbitMQ Docker 镜像](https://www.jianshu.com/p/743ff70f6413)

2、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management-plugins
```

3、运行 `Application` (或者执行 `mvn spring-boot:run`)


### 测试

**1、测试延迟队列**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-delayed-message",
	"routingKey": "direct.queue.delayed.message",
	"content":" hello delay delay! ",
	"count": 1,
	"delayTime": 10000
}'
```

参数 `delayTime` 单位为 `ms`， `10000` 代表 `10s`
