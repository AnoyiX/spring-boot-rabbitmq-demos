# 使用手册

### 运行示例

1、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management
```

2、运行 `Application` (或者执行 `mvn spring-boot:run`)

### 测试

**1、测试备用交换器**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct-no-queue",
	"routingKey": "direct.queue.alternate",
	"content":" hello AE! ",
	"count": 1
}'
```

`routingKey` 为备用交换器的路由键
