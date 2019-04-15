# 使用手册

### 运行示例

1、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management
```

2、运行 `Application` (或者执行 `mvn spring-boot:run`)


### 测试

**1、测试消费者否认消息**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.reject",
	"content":" hello reject queue! ",
	"count": 1
}'
```

**2、测试消息超出队列最大长度**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.max.length",
	"content":" hello max length queue! ",
	"count": 30
}'
```

> 提示：消息队列遵循先进先出的策略，假设队列最大长度设置为 10，发送 30 条消息到该队列，若无消费者，前 20 条消息会被转发到指定的其他队列，后 10 条会保存在该队列中，除非有新的消息入队，这 10 条消息才会被转发

**3、测试消息超时**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.ttl",
	"content":" hello ttl queue! ",
	"count": 10
}'
```
